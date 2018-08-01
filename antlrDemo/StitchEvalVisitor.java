import java.util.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.HashMap;
import java.util.Map;

public class StitchEvalVisitor extends StitchBaseVisitor<Integer> {

	Map<String, Integer> memory = new HashMap<String, Integer>();

	Model model;
	ParseTree tacticTree;

	StitchEvalVisitor(Model m, ParseTree tacticTreeInput) {
		model = m;
		tacticTree = tacticTreeInput;
	}

	/*
	 * Currently only considering variable assignment, no type check
	 */
	@Override
	public Integer visitVar(StitchParser.VarContext ctx) {
		String id = ctx.IDENTIFIER().getText();
		int value = visit(ctx.expression());
		System.out.println("visitVar putting ("+id+", "+value+")");
		memory.put(id, value);
		return value;
	}

	/*
	 * Only handles boolean values
	 * 1 is true; 0 is false
	 */
	@Override
	public Integer visitIdExpression(StitchParser.IdExpressionContext ctx) {
		System.out.println("visitIdExpression called");
		if(ctx.FALSE() != null) {
			String id = ctx.FALSE().getText();
			System.out.println("(FALSE) id is "+id);
			return 0;
		}
		if(ctx.TRUE() != null) {
			String id = ctx.TRUE().getText();
			System.out.println("(TRUE) id is "+id);
			return 1;
		}
		if(ctx.IDENTIFIER() != null) {
			String id = ctx.IDENTIFIER().getText();
			System.out.println("(IDENTIFIER) id is "+id);
			// CASE 1: variable found in model
			if (model.machine.containsKey(id)) {
				System.out.println("variable \'"+id+"\' found in model");
				return model.machine.get(id);
			}
			// CASE 2: variable defined earlier
			int ret = memory.getOrDefault(id, -1);
			if (ret == -1) {
				throw new RuntimeException("identifier not defined");
			} else {
				System.out.println("variable defined earlier, returning "+ret);
				return ret;
			}
			// TODO: CASE 3: variable refers to a probe in System Under Test
		}
		return visitChildren(ctx);
	}

	/*
	 * Ignores "functions"
	 */
	@Override
	public Integer visitStrategy(StitchParser.StrategyContext ctx) {
		int expVal = visit(ctx.expression());
		if (expVal == 1) { // only process the strategy when true
			for (int i = 0; i < ctx.strategyNode().size(); i++) { // traverse the list
				System.out.println("visitStrategy: traverse list, statement "+i);
				visit(ctx.strategyNode(i));
			}
			return 1;
		}
		System.out.println("strategy not invoked");
		return 0;
	}

	/*
	 * Only handles LOGICAL_NOT
	 * Only handles boolean
	 */
	@Override
	public Integer visitUnaryExpression(StitchParser.UnaryExpressionContext ctx) {
		if (ctx.LOGICAL_NOT() != null) {
			System.out.println("LOGICAL_NOT");
			int beforeInverse = visit(ctx.unaryExpression());
			return (beforeInverse == 0)?1:0;
		}
		return visitChildren(ctx);
	}

	/*
	 * Complete?
	 */
	@Override
	public Integer visitStrategyNode(StitchParser.StrategyNodeContext ctx) {
		int condition = visit(ctx.strategyCond());
		if (condition == 1) {
			System.out.println("visitStrategyNode: condition true, visiting tacticRef");
			return visit(ctx.tacticRef());
		}
		return 0;
	}

	/*
	 * Only consider 'expression' case
	 */
	@Override
	public Integer visitStrategyCond(StitchParser.StrategyCondContext ctx) {
		if (ctx.expression() != null && ctx.expression().size() != 0) {
			System.out.println("visitStrategyCond: traversing expression list");
			int ret = 1;
			// whenever a condition in the list is found false, return 0 (false), if all true, return 1 (true)
			for (int i = 0; i < ctx.expression().size(); i++) {
				int result = visit(ctx.expression(i));
				System.out.println("visitStrategyCond: list["+i+"]: "+ result);
				if (result == 0) {
					return 0;
				}
			}
			return ret;
		}
		return 0;
	}

	/*
	 * Only consider "filterEmail"
	 * Now also consider earlier scanned tactics
	 */
	@Override
	public Integer visitTacticRef(StitchParser.TacticRefContext ctx) {
		if (ctx.IDENTIFIER() != null && ctx.IDENTIFIER().size() != 0) {
			for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
				String id = ctx.IDENTIFIER().get(i).getText();
				System.out.println("visitTacticRef: id is "+id);
				if (id.equals("filterEmail")) {
					System.out.println("visitTacticRef: filterEmail invoked");
					// https://blog.art-of-coding.eu/executing-operating-system-commands-from-java/
					try {
						//java.lang.Runtime rt = java.lang.Runtime.getRuntime();
						// java.lang.Process p = rt.exec("python testPython.py");
						System.out.println("!!ssh");
						boolean connSuccess = ConnectionSSH.connect("ubuntu", "34.200.226.46", "python test.py");
						if (!connSuccess) {
							System.out.println("session connection timeout, wrong IP address?");
							return 0;
						}
						// TODO: need to handle the "answering yes" condition
						// TODO: need to handle more failure conditions
						//int waitForRet = p.waitFor();
						//int exitValRet = p.exitValue();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else { // the new case where "lookup and run" is used
					System.out.println("visitTacticRef: lookup and run tactic "+id);
					if (model.tactics.containsKey(id)) {
						System.out.println("found tactic! id: "+id);
						int success = execTactic(id);
					} else {
						System.out.println("tactic not found! id: "+id);
					}
				}
			}
		}
		if (ctx.DONE() == null) {
			System.out.println("visitTacticRef: visiting strategyBranch");
			return visit(ctx.strategyBranch());
		}
		System.out.println("visitTacticRef: strategyBranch is 'done'");
		return 1; // return 1 when strategyBranch is DONE
		
	}

	/*
	 * Execute the selected tactic
	 */
	private Integer execTactic(String name) {
		StitchParser.TacticContext ctx = model.tactics.get(name);
		String tacticName = ctx.IDENTIFIER().getText();
		System.out.println("execTactic: tacticName is "+tacticName);
		if (visit(ctx.condition()) == 1) { // only continue when the condition is met
			System.out.println("execTactic: condition is true");
			visit(ctx.action());
		} else {
			System.out.println("execTactic: condition not met");
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 1;
	}

	/*
	 * Examine the condition(s) of a tactic
	 */
	@Override // TODO: need to implement visitQuantifiedExpression for complex conditions
	public Integer visitCondition(StitchParser.ConditionContext ctx) {
		for (int i = 0; i < ctx.expression().size(); i++) {
			int res = visit(ctx.expression(i));
			if (res == 0) {
				return 0;
			}
		}
		return 1;
	}

	/*
	 * execute the action part of a tactic
	 */
	@Override
	public Integer visitAction(StitchParser.ActionContext ctx) {
		for (int i = 0; i < ctx.statement().size(); i++) {
			System.out.println("visitAction: visiting statement("+i+")");
			visit(ctx.statement(i));
		}
		return 1;
	}

	/*
	 * execute the special type of statement: methodCall
	 */
	@Override
	public Integer visitMethodCall(StitchParser.MethodCallContext ctx) {
		String id = ctx.IDENTIFIER().getText();
		System.out.println("visitMethodCall: id is "+id);
		// TODO: the method is hard coded, it should be from a list in the model
		if (id.equals("tacOneAction")) { // TODO: not considering argument
			try {
				System.out.println("!!ssh");
				boolean connSuccess = ConnectionSSH.connect("ubuntu", "34.200.226.46", "python tacOneAction.py");
				if (!connSuccess) {
					System.out.println("session connection timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}