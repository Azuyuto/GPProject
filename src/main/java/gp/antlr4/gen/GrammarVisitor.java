// Generated from D:/source.agh/GPProject/src/main/java/gp/antlr4\Grammar.g4 by ANTLR 4.10.1
package gp.antlr4.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(GrammarParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#single_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_statement(GrammarParser.Single_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(GrammarParser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#io_functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIo_functions(GrammarParser.Io_functionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_statement(GrammarParser.Block_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#conditional_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_statement(GrammarParser.Conditional_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#iteration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration_statement(GrammarParser.Iteration_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(GrammarParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(GrammarParser.FactorContext ctx);
}