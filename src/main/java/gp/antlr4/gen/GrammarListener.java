// Generated from D:/source.agh/GPProject/src/main/java/gp/antlr4\Grammar.g4 by ANTLR 4.10.1
package gp.antlr4.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(GrammarParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(GrammarParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#single_statement}.
	 * @param ctx the parse tree
	 */
	void enterSingle_statement(GrammarParser.Single_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#single_statement}.
	 * @param ctx the parse tree
	 */
	void exitSingle_statement(GrammarParser.Single_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(GrammarParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(GrammarParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#io_functions}.
	 * @param ctx the parse tree
	 */
	void enterIo_functions(GrammarParser.Io_functionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#io_functions}.
	 * @param ctx the parse tree
	 */
	void exitIo_functions(GrammarParser.Io_functionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(GrammarParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(GrammarParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#conditional_statement}.
	 * @param ctx the parse tree
	 */
	void enterConditional_statement(GrammarParser.Conditional_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#conditional_statement}.
	 * @param ctx the parse tree
	 */
	void exitConditional_statement(GrammarParser.Conditional_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement(GrammarParser.Iteration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement(GrammarParser.Iteration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(GrammarParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(GrammarParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(GrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(GrammarParser.FactorContext ctx);
}