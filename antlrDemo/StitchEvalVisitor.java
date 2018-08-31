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
			// System.out.println("EvalVisitor: visitImportSt: verified tactic library");
			System.out.println("Verified tactic library");
			return 1;
		}
		System.err.println("EvalVisitor: visitImportSt: tacticFile mismatch: " + cleanLibName + ", " + tacticFileName);
		return 0;
	}

	/*
	 * Currently only considering variable assignment, ignores datatypes
	 */
	@Override
	public Integer visitVar(StitchParser.VarContext ctx) { 
		String id = ctx.IDENTIFIER().getText();
		// System.out.println("visitVar: the expression is "+ctx.expression().getText());
		int value = visit(ctx.expression());
		// System.out.println("visitVar putting ("+id+", "+value+")");
		memory.put(id, value);
		return value;
	}

	/*
	 * (additiveExpression) > < (relationalExpression)
	 * LT <; LE <=; GE >=; GT >;
	 */
	/*@Override
	public Integer visitRelationalExpression(StitchParser.RelationalExpressionContext ctx) {
		System.out.println("relational start");
		if (ctx.additiveExpression() != null && ctx.relationalExpression() != null) {
			int left = visit(ctx.additiveExpression());
			int right = visit(ctx.relationalExpression());
			System.out.println("visitRelationalExpression: left: "+left + " right: "+right);
			if (ctx.LT() != null) {
				System.out.println("<");
				if (left < right) {
					return 1;
				} else {
					return 0;
				}
			} else if (ctx.LE() != null) {
				System.out.println("<=");
				if (left <= right) {
					return 1;
				} else {
					return 0;
				}
			} else if (ctx.GE() != null) {
				System.out.println(">=");
				if (left >= right) {
					return 1;
				} else {
					return 0;
				}
			} else if (ctx.GT() != null) {
				System.out.println(">");
				if (left > right) {
					System.out.println("returning 1");
					return 1;
				} else {
					System.out.println("returning 0");
					return 0;
				}
			}
		}
		System.out.println("relational: visitChildren");
		Integer retVal = visitChildren(ctx);
		if (retVal == null) {
			System.out.println("visitRelationalExpression: return NULL");
		} else {
			System.out.println("visitRelationalExpression: the retVal is: "+ retVal);
		}
		return retVal;
	}*/

	/*
	 * currently not used and not implemented, used as a space holder and reminder
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
		Integer retVal = visitChildren(ctx);
		if (retVal == null) {
			System.out.println("visitQuantifiedExpression: return NULL");
		} else {
			// System.out.println("visitQuantifiedExpression: retVal is: "+ retVal);
		}
		return retVal;
	}

	// private String getParams()

	/*
	 * Handles boolean values: 1 is true; 0 is false
	 * 
	 * Handles system hooks' returns
	 */
	@Override
	public Integer visitIdExpression(StitchParser.IdExpressionContext ctx) {
		// System.out.println("visitIdExpression called");
		if(ctx.FALSE() != null) {
			String id = ctx.FALSE().getText();
			// System.out.println("(FALSE) id is "+id);
			return 0;
		}
		if(ctx.TRUE() != null) {
			String id = ctx.TRUE().getText();
			// System.out.println("(TRUE) id is "+id);
			return 1;
		}
		if(ctx.IDENTIFIER() != null) {
			String id = ctx.IDENTIFIER().getText();
			// System.out.println("(IDENTIFIER) id is "+id);
			// CASE 1: variable found in model.checkHooks(), a probe in System Under Test
			if (model.checkHooks().contains(id)) {
				// System.out.println("variable \'"+id+"\' found in model.checkHooks()");
				return model.execHook(id);
			}
			// CASE 2: variable defined earlier
			int ret = memory.getOrDefault(id, -1);
			if (ret == -1) {
				throw new RuntimeException("visitIDExpression: identifier not defined");
			} else {
				// System.out.println("variable defined earlier, returning "+ret);
				return ret;
			}
		}
		if (ctx.INTEGER_LIT() != null) {
			String id = ctx.INTEGER_LIT().getText();
			// System.out.println("(INTEGER_LIT) id is "+id);
			return Integer.valueOf(id);
		}
		Integer retVal = visitChildren(ctx);
		if (retVal == null) {
			System.out.println("visitIdExpression: return NULL");
		} else {
			// System.out.println("visitIdExpression: retVal is: "+retVal);
		}
		return retVal;
	}

	/*
	 * Ignores "functions"
	 */
	@Override
	public Integer visitStrategy(StitchParser.StrategyContext ctx) {
		System.out.println("Now running strategy: " + ctx.IDENTIFIER().getText());
		int expVal = visit(ctx.expression());
		if (expVal == 1) { // only process the strategy when true
			for (int i = 0; i < ctx.strategyNode().size(); i++) { // traverse the list
				// System.out.println("visitStrategy: traverse list, statement "+i);
				// System.out.println("visitStrategy: "+ctx.strategyNode(i).getText());
				return visit(ctx.strategyNode(i));
			}
			return 1;
		}
		System.out.println("  Condition not met: strategy not invoked"); // 2-space
		return 0;
	}

	/*
	 * Only handles LOGICAL_NOT
	 * Only handles boolean
	 */
	@Override
	public Integer visitUnaryExpression(StitchParser.UnaryExpressionContext ctx) {
		if (ctx.LOGICAL_NOT() != null) {
			// System.out.println("LOGICAL_NOT");
			int beforeInverse = visit(ctx.unaryExpression());
			return (beforeInverse == 0)?1:0;
		}
		Integer retVal = visitChildren(ctx);
		if (retVal == null) {
			System.out.println("visitUnaryExpression: return NULL");
		} else {
			// System.out.println("visitUnaryExpression: retVal: "+retVal);
		}
		return retVal;
	}

	/*
	 * Complete?
	 */
	@Override
	public Integer visitStrategyNode(StitchParser.StrategyNodeContext ctx) {
		int condition = visit(ctx.strategyCond());
		if (condition == 1) {
			//System.out.println("visitStrategyNode: condition true, visiting tacticRef");
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
			// System.out.println("visitStrategyCond: traversing expression list");
			int ret = 1;
			// whenever a condition in the list is found false, return 0 (false), if all true, return 1 (true)
			for (int i = 0; i < ctx.expression().size(); i++) {
				int result = visit(ctx.expression(i));
				// System.out.println("visitStrategyCond: list["+i+"]: "+ result);
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
				Integer waitTime = 0;
				// System.out.println("visitTacticRef: before, waitTime is "+waitTime);
				if (ctx.expression() != null && ctx.expression().size() != 0) {
					// We are only considering the first expression in the brackets @[]
					// System.out.println("whoami: "+ctx.expression(0).getText());
					waitTime = visit(ctx.expression(0));
				}
				// System.out.println("visitTacticRef: waitTime is "+waitTime);
				System.out.println("  Running tactic: "+id); // 2-space
				// System.out.println("visitTacticRef: lookup and run tactic "+id);
				if (model.getTactics().containsKey(id)) {
					// System.out.println("found tactic! id: "+id);
					int success = execTactic(id, waitTime);
				} else {
					System.out.println("visitTacticRef: tactic not found! id: "+id);
				}
			}
		}
		if (ctx.DONE() == null && ctx.NULLTACTIC() == null) {
			// System.out.println("visitTacticRef: visiting strategyBranch");
			return visit(ctx.strategyBranch());
		}
		// System.out.println("visitTacticRef: strategyBranch is 'done' or 'TNULL");
		return 1; // return 1 when strategyBranch is DONE
		
	}

	/*
	 * Helper function to execute the selected tactic
	 * TODO: add loop on effect for time defined in tactic ref
	 */
	private Integer execTactic(String name, Integer waitTime) {
		StitchParser.TacticContext ctx = model.getTactics().get(name);
		String tacticName = ctx.IDENTIFIER().getText();
		// System.out.println("execTactic: tacticName is "+tacticName);
		if (visit(ctx.condition()) == 1) { // only continue when the condition is met
			// System.out.println("execTactic: condition is true");
			visit(ctx.action());
			// wait for post condition to become true
			int timer = 0; // in milliseconds
			while (true) {
				int allTrue = visit(ctx.effect());
				// System.out.println("allTrue is "+allTrue);
				if (allTrue == 1 || timer >= waitTime) {
					break;
				}
				System.out.println("waiting for tactic post-condition to become true. Time elapsed: "+timer/1000+"s");
				// wait for the post condition to become true, hard code internal 1 second
				timer += 1000;
				try { // sleep for a while, wait for the magic to happen
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (visit(ctx.effect()) != 1) {
				System.out.println("  execTactic: effect time out! (effect possibly false)"); // 2-space
			} else {
				System.out.println("  execTactic: effect is true"); // 2-space
			}
		} else {
			System.out.println("Condition not met: tactic not invoked");
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
			// System.out.println("visitAction: visiting statement("+i+")");
			visit(ctx.statement(i));
		}
		return 1;
	}

	/*
	 * Examine the post-condition/effect of a tactic
	 * !! important note, the grammar (Stitch.g4) seems to support a @[5000] tag here in
	 * the Effect section of the Stitch tactic.
	 * However, we will ignore all @[<someNumber>] tag in this section, because it seems to
	 * be redundant here.
	 *
	 * return: 1 (true), 0 (false)
	 */
	@Override
	public Integer visitEffect(StitchParser.EffectContext ctx) {
		// System.out.println("visitEffect");
		if (ctx.expression() == null) {
			return 1;
		}
		for (int i = 0; i < ctx.expression().size(); i++) {
			// System.out.println("visitEffect: visiting expression("+i+")");
			Integer singleEffect = visit(ctx.expression(i));
			// System.out.println("visitEffect: got singleEffect:"+singleEffect);
			if (singleEffect == 0) {
				return 0;
			} else if (singleEffect == 1) {
				continue;
			} else {
				// ignore non-boolean expressions, as seen in @[5000] tags
			}
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
		System.out.print("    Running method: "+id+" ... "); // 4-space
		return model.execOperations(id);
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
		if (ctx.equalityExpression() != null && ctx.logicalAndExpression() != null) {
			int equalityVal = visit(ctx.equalityExpression());
			int logicalAndVal = visit(ctx.logicalAndExpression());
			if (equalityVal == logicalAndVal && equalityVal == 1) {
				// System.out.println("LogicalAndExpression: returning 1 (true)");
				return 1;
			} else {
				// System.out.println("LogicalAndExpression: returning 0 (false)");
				return 0;
			}
		}
		Integer retVal = visitChildren(ctx);
		if (retVal == null) {
			System.out.println("visitLogicalAndExpression: return NULL");
		} else {
			// System.out.println("visitLogicalAndExpression: retVal is: "+retVal);
		}
		return retVal;
	}
}
