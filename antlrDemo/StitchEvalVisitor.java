import java.util.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.HashMap;
import java.util.Map;

public class StitchEvalVisitor extends StitchBaseVisitor<Integer> {

	Map<String, Integer> memory = new HashMap<String, Integer>();

	Model model;

	StitchEvalVisitor(Model m) {
		model = m;
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
				System.out.println("variable found in model");
				return model.machine.get(id);
			}
			// CASE 2: variable defined earlier
			int ret = memory.getOrDefault(id, -1);
			if (ret == -1) {
				throw new RuntimeException("identifier not defined");
			} else {
				System.out.println("returning "+ret);
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
				System.out.println("visitStrategy: traverse list");
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
			for (int i = 0; i < ctx.expression().size(); i++) {
				int result = visit(ctx.expression(i));
				System.out.println("list["+i+"]: "+ result);
				if (result == 0) {
					return 0;
				}
			}
			System.out.println("returning "+ret);
			return ret;
		}
		return 0;
	}

	/*
	 * Only consider "filterEmail"
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
						ConnectionSSH.connect("ubuntu", "34.205.39.152", "python test.py");
						// TODO: need to handle the "answering yes" condition
						// TODO: need to handle more failure conditions
						//int waitForRet = p.waitFor();
						//int exitValRet = p.exitValue();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return visit(ctx.strategyBranch());
	}
}
