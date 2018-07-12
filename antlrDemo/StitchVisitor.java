// Generated from Stitch.g4 by ANTLR 4.7.1

import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StitchParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StitchVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StitchParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(StitchParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#importSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSt(StitchParser.ImportStContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#importRename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportRename(StitchParser.ImportRenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(StitchParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#tactic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTactic(StitchParser.TacticContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#tacticParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTacticParams(StitchParser.TacticParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#tacticParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTacticParam(StitchParser.TacticParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(StitchParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(StitchParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(StitchParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(StitchParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#effect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffect(StitchParser.EffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#strategy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategy(StitchParser.StrategyContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#strategyNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategyNode(StitchParser.StrategyNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#strategyCond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategyCond(StitchParser.StrategyCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#tacticRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTacticRef(StitchParser.TacticRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#strategyBranch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategyBranch(StitchParser.StrategyBranchContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(StitchParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#errorHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorHandler(StitchParser.ErrorHandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(StitchParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(StitchParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(StitchParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(StitchParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#forCond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCond(StitchParser.ForCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#forIter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForIter(StitchParser.ForIterContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(StitchParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(StitchParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(StitchParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(StitchParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#impliesExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpression(StitchParser.ImpliesExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#iffExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIffExpression(StitchParser.IffExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(StitchParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(StitchParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(StitchParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(StitchParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(StitchParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(StitchParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(StitchParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(StitchParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#idExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpression(StitchParser.IdExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#postIdExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIdExpression(StitchParser.PostIdExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(StitchParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(StitchParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(StitchParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#quantifiedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedExpression(StitchParser.QuantifiedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#nonLiteralIdExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonLiteralIdExpression(StitchParser.NonLiteralIdExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#setExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExpression(StitchParser.SetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#pathExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathExpression(StitchParser.PathExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#pathExpressionContinuation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathExpressionContinuation(StitchParser.PathExpressionContinuationContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#literalSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralSet(StitchParser.LiteralSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link StitchParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(StitchParser.DataTypeContext ctx);
}