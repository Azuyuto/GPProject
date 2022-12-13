// Generated from C:/Users/User/IdeaProjects/MyGPProject/src/main/antlr4/gp/project\Grammar.g4 by ANTLR 4.10.1
package gp.antlr4;

import gp.antlr4.gen.GrammarBaseVisitor;
import gp.antlr4.gen.GrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.*;

public class GrammarCustomVisitor<T> extends GrammarBaseVisitor<Integer>{

	Map<String, Integer> memory;
	LinkedList<Integer> inputs;
	List<Integer> outputs;

	private int operationsCounter = 0;
	private final int MAX_OPERATIONS = 1000;

	public GrammarCustomVisitor(List<Integer> inputs) {
		this.memory = new HashMap<>();
		this.inputs = new LinkedList<>(inputs);
		this.outputs = new ArrayList<>();
	}

	public void printOutputs() {
		outputs.forEach(System.out::println);
	}

	@Override
	public Integer visit(ParseTree tree) {
		if(operationsCounter++ < MAX_OPERATIONS) {
			super.visit(tree);
		}
		return 0;
	}

	@Override
	public Integer visitChildren(RuleNode node) {
		if(operationsCounter++ < MAX_OPERATIONS) {
			super.visitChildren(node);
		}
		return 0;
	}

	@Override public Integer visitInit(GrammarParser.InitContext ctx) {
		return visitChildren(ctx);
	}
	@Override public Integer visitStatement(GrammarParser.StatementContext ctx) {
		return visitChildren(ctx);
	}
	@Override public Integer visitSingle_statement(GrammarParser.Single_statementContext ctx) {
		return visitChildren(ctx);
	}
	@Override public Integer visitVariable_declaration(GrammarParser.Variable_declarationContext ctx) {
		String variableName = ctx.ID().getText();
		Integer variableValue = visit(ctx.equation());

		memory.put(variableName, variableValue);
		return memory.get(variableName);
	}
	@Override public Integer visitIo_functions(GrammarParser.Io_functionsContext ctx) {

		if (ctx.IN() != null) {
			String variableName = ctx.ID().getText();
			Integer variableValue = inputs.pop();

			memory.put(variableName, variableValue);
		}
		else {
			outputs.add(visit(ctx.factor()));
		}
		return 0;
	}
	@Override public Integer visitBlock_statement(GrammarParser.Block_statementContext ctx) {
		return visitChildren(ctx);
	}
	@Override public Integer visitConditional_statement(GrammarParser.Conditional_statementContext ctx) {
		if (visit(ctx.expression()) > 0)
		{
			visit(ctx.statement(0));
		}
		else if(ctx.ELSE() != null)
		{
			if(ctx.statement(1) != null)
			{
				visit(ctx.statement(1));
			}
			if (ctx.conditional_statement() != null)
			{
				visit(ctx.conditional_statement());
			}
		}
		return 0;
	}
	@Override public Integer visitIteration_statement(GrammarParser.Iteration_statementContext ctx) {
		visit(ctx.variable_declaration(0));
		while (visit(ctx.expression()) > 0)
		{
			visit(ctx.statement());
			visit(ctx.variable_declaration(1));
		}
		return 0;
	}
	@Override
	public Integer visitExpression(GrammarParser.ExpressionContext ctx) {
		if(ctx.LEFT_PAREN() != null) {
			return visit(ctx.expression(0));
		} else if (ctx.NOT() != null) {
			return visit(ctx.expression(0)) > 0 ? 0 : 1;
		} else if (ctx.equation() != null) {
			return visit(ctx.equation());
		} else
		{
			Integer exp1 = visit(ctx.expression(0));
			Integer exp2 = visit(ctx.expression(1));

			if (ctx.OR() != null) {
				return ((exp1 > 0) || (exp2 > 0)) ? 1 : 0;
			} else if (ctx.AND() != null) {
				return ((exp1 > 0) && (exp2 > 0)) ? 1 : 0;
			} else if (ctx.GREATER_THEN() != null) {
				return (exp1 > exp2) ? 1 : 0;
			} else if (ctx.LESS_THEN() != null) {
				return (exp1 < exp2) ? 1 : 0;
			} else if (ctx.GREATER_EQUAL_THEN() != null) {
				return (exp1 >= exp2) ? 1 : 0;
			} else if (ctx.LESS_EQUAL_THEN() != null) {
				return (exp1 <= exp2) ? 1 : 0;
			} else if (ctx.EQUAL() != null) {
				return (Objects.equals(exp1, exp2)) ? 1 : 0;
			} else if (ctx.NOT_EQUAL() != null) {
				return (!Objects.equals(exp1, exp2)) ? 1 : 0;
			}
		}
		return visit(ctx.expression(0));
	}
	@Override public Integer visitEquation(GrammarParser.EquationContext ctx) {
		if(ctx.LEFT_PAREN() != null) {
			return visit(ctx.equation(0));
		}
		if (ctx.TIMES() != null) {
			return visit(ctx.equation(0)) * visit(ctx.equation(1));
		}
		if (ctx.DIV() != null) {
			return visit(ctx.equation(0)) / visit(ctx.equation(1));
		}
		if (ctx.PLUS(0) != null) {
			return visit(ctx.equation(0)) + visit(ctx.equation(1));
		}
		if (ctx.MINUS(0) != null) {
			return visit(ctx.equation(0)) - visit(ctx.equation(1));
		}
		if (ctx.factor() != null) {
			return visit(ctx.factor());
		}
		return visit(ctx.equation(0));
	}
	@Override public Integer visitFactor(GrammarParser.FactorContext ctx) {
		if (ctx.ID() != null)
		{
			return memory.get(ctx.ID().getText());
		}
		else
		{
			return Integer.parseInt(ctx.getText());
		}
	}
}