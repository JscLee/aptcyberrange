import java.util.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.HashMap;
import java.util.Map;

public class StitchEvalVisitor extends StitchBaseVisitor<Integer> {

	Map<String, Integer> memory = new HashMap<String, Integer>();

	Model model;
	String tacticFileName;
	// ParseTree tacticTree;

	StitchEvalVisitor(Model m, String inputTactic) {
		model = m;
		tacticFileName = inputTactic;
	}

	/*
	 * Only checks that the imported library <tactic_file> specified in the strategy is the same as
	 * the filename specified in the main function
	 */
	@Override
	public Integer visitImportSt(StitchParser.ImportStContext ctx) {
		// System.out.println("input Tactic is: "+tacticFileName);
		if (ctx.LIB() == null || ctx.OP() != null || ctx.MODEL() != null) {
			System.err.println("visitImportSt: Only support import lib in strategies.");
			return 0;
		}
		String libName = ctx.STRING_LIT().getText();
		String cleanLibName = libName.substring(1, libName.length()-1);
		// System.out.println("specified Tactic is: "+cleanLibName);
		if (cleanLibName.equals(tacticFileName)) {
			System.out.println("EvalVisitor: visitImportSt: verified tactic library");
			return 1;
		}
		System.err.println("EvalVisitor: visitImportSt: tacticFile mismatch: " + cleanLibName + ", " + tacticFileName);
		return 0;
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
	 * only useful for a List of Mail (type) objects
	 */
	@Override
	public Integer visitQuantifiedExpression(StitchParser.QuantifiedExpressionContext ctx) {
		if (ctx.FORALL() != null) { // FORALL
			System.out.println("forall expression, not implemeneted");
		} else if (ctx.EXISTS() != null) {
			System.out.println("exists expression, not implemeneted");
			// visit(ctx.param()) // we don't use visit here
			// String receivedParam = getParams(ctx.param())
		} else if (ctx.SELECT() != null) {
			System.out.println("select expression, not implemeneted");
		} else {
			System.err.println("visitQuantifiedExpression: sentence not supported");
		}
		return visitChildren(ctx);
	}

	// private String getParams()

	/*
	 * Handles boolean values: 1 is true; 0 is false
	 * 
	 * Handles system hooks' returns
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
			// CASE 1: variable found in model.checkHooks(), a probe in System Under Test
			if (model.checkHooks().contains(id)) {
				System.out.println("variable \'"+id+"\' found in model.checkHooks()");
				return model.execHook(id);
			}
			// CASE 2: variable defined earlier
			int ret = memory.getOrDefault(id, -1);
			if (ret == -1) {
				throw new RuntimeException("identifier not defined");
			}
			// CASE 3: variable is a number (if the first char of the String is a number)
			if (Character.isDigit(id.charAt(0))) {
				return Integer.valueOf(id);
			} else {
				System.out.println("variable defined earlier, returning "+ret);
				return ret;
			}
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
	 * TODO: success, default
	 */
	@Override
	public Integer visitTacticRef(StitchParser.TacticRefContext ctx) {
		if (ctx.IDENTIFIER() != null && ctx.IDENTIFIER().size() != 0) {
			for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
				String id = ctx.IDENTIFIER().get(i).getText();
				System.out.println("visitTacticRef: id is "+id);
				System.out.println("visitTacticRef: lookup and run tactic "+id);
				if (model.getTactics().containsKey(id)) {
					System.out.println("found tactic! id: "+id);
					int success = execTactic(id);
				} else {
					System.out.println("tactic not found! id: "+id);
				}
			}
		}
		if (ctx.DONE() == null && ctx.NULLTACTIC() == null) {
			System.out.println("visitTacticRef: visiting strategyBranch");
			return visit(ctx.strategyBranch());
		}
		System.out.println("visitTacticRef: strategyBranch is 'done' or 'TNULL");
		return 1; // return 1 when strategyBranch is DONE
		
	}

	/*
	 * Execute the selected tactic
	 * TODO: add loop on effect for time defined in tactic ref
	 */
	private Integer execTactic(String name) {
		StitchParser.TacticContext ctx = model.getTactics().get(name);
		String tacticName = ctx.IDENTIFIER().getText();
		System.out.println("execTactic: tacticName is "+tacticName);
		if (visit(ctx.condition()) == 1) { // only continue when the condition is met
			System.out.println("execTactic: condition is true");
			visit(ctx.action());
			// TODO: loop on ctx.effect(), implement visitEffect()
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
	 * !! ignore the parameter to the method called
	 */
	@Override
	public Integer visitMethodCall(StitchParser.MethodCallContext ctx) {
		String id = ctx.IDENTIFIER().getText();
		System.out.println("visitMethodCall: id is "+id);
		// TODO: the method is hard coded, it should be from a list in the model
		// return model.executeOperations(id); // Integer

		return model.executeOperations(id);
	}

	/*
	 * logical AND &&; Strange though, why are the two expressions "equality" and "logicalAnd"?
	 * quote from Stitch.g4:
	 * logicalAndExpression
  	 * : equalityExpression (LOGICAL_AND logicalAndExpression)?
  	 * ;
	 */
	@Override
	public Integer visitLogicalAndExpression(StitchParser.LogicalAndExpressionContext ctx) {
		int equalityVal = visit(ctx.equalityExpression());
		int logicalAndVal = visit(ctx.logicalAndExpression());
		if (equalityVal == logicalAndVal) {
			System.out.println("LogicalAndExpression: returning 1 (true)");
			return 1;
		} else {
			System.out.println("LogicalAndExpression: returning 0 (false)");
			return 0;
		}
	}
}
