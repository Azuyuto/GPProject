// Generated from D:/source.agh/GPProject/src/main/antlr4/gp/project\Grammar.g4 by ANTLR 4.10.1
package gp.project.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, FOR=3, IN=4, OUT=5, INIT=6, SEMI=7, LEFT_PAREN=8, RIGHT_PAREN=9, 
		LEFT_BRACE=10, RIGHT_BRACE=11, PLUS=12, MINUS=13, TIMES=14, DIV=15, ASSIGN=16, 
		GREATER_THEN=17, GREATER_EQUAL_THEN=18, LESS_THEN=19, LESS_EQUAL_THEN=20, 
		AND=21, OR=22, NOT=23, EQUAL=24, NOT_EQUAL=25, ID=26, INT=27, WHITESPACE=28, 
		NEWLINE=29;
	public static final int
		RULE_init = 0, RULE_statement = 1, RULE_single_statement = 2, RULE_variable_declaration = 3, 
		RULE_io_functions = 4, RULE_conditional_statement = 5, RULE_iteration_statement = 6, 
		RULE_expression = 7, RULE_equation = 8, RULE_factor = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "statement", "single_statement", "variable_declaration", "io_functions", 
			"conditional_statement", "iteration_statement", "expression", "equation", 
			"factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'for'", "'in'", "'out'", "'init'", "';'", "'('", 
			"')'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'='", "'>'", "'>='", 
			"'<'", "'<='", "'&&'", "'||'", "'!'", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "FOR", "IN", "OUT", "INIT", "SEMI", "LEFT_PAREN", 
			"RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "PLUS", "MINUS", "TIMES", 
			"DIV", "ASSIGN", "GREATER_THEN", "GREATER_EQUAL_THEN", "LESS_THEN", "LESS_EQUAL_THEN", 
			"AND", "OR", "NOT", "EQUAL", "NOT_EQUAL", "ID", "INT", "WHITESPACE", 
			"NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InitContext extends ParserRuleContext {
		public TerminalNode INIT() { return getToken(GrammarParser.INIT, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(GrammarParser.LEFT_BRACE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GrammarParser.RIGHT_BRACE, 0); }
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(INIT);
			setState(21);
			match(LEFT_BRACE);
			setState(22);
			statement(0);
			setState(23);
			match(RIGHT_BRACE);
			setState(24);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Single_statementContext single_statement() {
			return getRuleContext(Single_statementContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		return statement(0);
	}

	private StatementContext statement(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementContext _localctx = new StatementContext(_ctx, _parentState);
		StatementContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_statement, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(27);
			single_statement();
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statement);
					setState(29);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(30);
					single_statement();
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Single_statementContext extends ParserRuleContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(GrammarParser.SEMI, 0); }
		public Io_functionsContext io_functions() {
			return getRuleContext(Io_functionsContext.class,0);
		}
		public Conditional_statementContext conditional_statement() {
			return getRuleContext(Conditional_statementContext.class,0);
		}
		public Iteration_statementContext iteration_statement() {
			return getRuleContext(Iteration_statementContext.class,0);
		}
		public Single_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSingle_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSingle_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSingle_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_statementContext single_statement() throws RecognitionException {
		Single_statementContext _localctx = new Single_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_single_statement);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(36);
				variable_declaration();
				setState(37);
				match(SEMI);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(39);
				io_functions();
				setState(40);
				match(SEMI);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				conditional_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				iteration_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_declarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVariable_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVariable_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitVariable_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(ID);
			setState(47);
			match(ASSIGN);
			setState(48);
			equation(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Io_functionsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarParser.ASSIGN, 0); }
		public TerminalNode IN() { return getToken(GrammarParser.IN, 0); }
		public TerminalNode OUT() { return getToken(GrammarParser.OUT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Io_functionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_io_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIo_functions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIo_functions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIo_functions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Io_functionsContext io_functions() throws RecognitionException {
		Io_functionsContext _localctx = new Io_functionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_io_functions);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(ID);
				setState(51);
				match(ASSIGN);
				setState(52);
				match(IN);
				}
				break;
			case OUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(OUT);
				setState(54);
				match(ASSIGN);
				setState(55);
				factor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GrammarParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GrammarParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GrammarParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> LEFT_BRACE() { return getTokens(GrammarParser.LEFT_BRACE); }
		public TerminalNode LEFT_BRACE(int i) {
			return getToken(GrammarParser.LEFT_BRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> RIGHT_BRACE() { return getTokens(GrammarParser.RIGHT_BRACE); }
		public TerminalNode RIGHT_BRACE(int i) {
			return getToken(GrammarParser.RIGHT_BRACE, i);
		}
		public TerminalNode ELSE() { return getToken(GrammarParser.ELSE, 0); }
		public Conditional_statementContext conditional_statement() {
			return getRuleContext(Conditional_statementContext.class,0);
		}
		public Conditional_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterConditional_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitConditional_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitConditional_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_statementContext conditional_statement() throws RecognitionException {
		Conditional_statementContext _localctx = new Conditional_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditional_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IF);
			setState(59);
			match(LEFT_PAREN);
			setState(60);
			expression(0);
			setState(61);
			match(RIGHT_PAREN);
			setState(62);
			match(LEFT_BRACE);
			setState(63);
			statement(0);
			setState(64);
			match(RIGHT_BRACE);
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(65);
				match(ELSE);
				setState(71);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LEFT_BRACE:
					{
					setState(66);
					match(LEFT_BRACE);
					setState(67);
					statement(0);
					setState(68);
					match(RIGHT_BRACE);
					}
					break;
				case IF:
					{
					setState(70);
					conditional_statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Iteration_statementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(GrammarParser.FOR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GrammarParser.LEFT_PAREN, 0); }
		public List<Variable_declarationContext> variable_declaration() {
			return getRuleContexts(Variable_declarationContext.class);
		}
		public Variable_declarationContext variable_declaration(int i) {
			return getRuleContext(Variable_declarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(GrammarParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(GrammarParser.SEMI, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GrammarParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(GrammarParser.LEFT_BRACE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GrammarParser.RIGHT_BRACE, 0); }
		public Iteration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIteration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIteration_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIteration_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Iteration_statementContext iteration_statement() throws RecognitionException {
		Iteration_statementContext _localctx = new Iteration_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_iteration_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(FOR);
			setState(76);
			match(LEFT_PAREN);
			setState(77);
			variable_declaration();
			setState(78);
			match(SEMI);
			setState(79);
			expression(0);
			setState(80);
			match(SEMI);
			setState(81);
			variable_declaration();
			setState(82);
			match(RIGHT_PAREN);
			setState(83);
			match(LEFT_BRACE);
			setState(84);
			statement(0);
			setState(85);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(GrammarParser.LEFT_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GrammarParser.RIGHT_PAREN, 0); }
		public TerminalNode NOT() { return getToken(GrammarParser.NOT, 0); }
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public TerminalNode OR() { return getToken(GrammarParser.OR, 0); }
		public TerminalNode AND() { return getToken(GrammarParser.AND, 0); }
		public TerminalNode GREATER_THEN() { return getToken(GrammarParser.GREATER_THEN, 0); }
		public TerminalNode LESS_THEN() { return getToken(GrammarParser.LESS_THEN, 0); }
		public TerminalNode GREATER_EQUAL_THEN() { return getToken(GrammarParser.GREATER_EQUAL_THEN, 0); }
		public TerminalNode LESS_EQUAL_THEN() { return getToken(GrammarParser.LESS_EQUAL_THEN, 0); }
		public TerminalNode EQUAL() { return getToken(GrammarParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(GrammarParser.NOT_EQUAL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(88);
				match(LEFT_PAREN);
				setState(89);
				expression(0);
				setState(90);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(92);
				match(NOT);
				setState(93);
				expression(2);
				}
				break;
			case 3:
				{
				setState(94);
				equation(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(98);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(100);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(101);
						_la = _input.LA(1);
						if ( !(_la==GREATER_THEN || _la==LESS_THEN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(103);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(104);
						_la = _input.LA(1);
						if ( !(_la==GREATER_EQUAL_THEN || _la==LESS_EQUAL_THEN) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(105);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(107);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EquationContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(GrammarParser.LEFT_PAREN, 0); }
		public List<EquationContext> equation() {
			return getRuleContexts(EquationContext.class);
		}
		public EquationContext equation(int i) {
			return getRuleContext(EquationContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GrammarParser.RIGHT_PAREN, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public List<TerminalNode> PLUS() { return getTokens(GrammarParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(GrammarParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(GrammarParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(GrammarParser.MINUS, i);
		}
		public TerminalNode TIMES() { return getToken(GrammarParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(GrammarParser.DIV, 0); }
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEquation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEquation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		return equation(0);
	}

	private EquationContext equation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EquationContext _localctx = new EquationContext(_ctx, _parentState);
		EquationContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_equation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(115);
				match(LEFT_PAREN);
				setState(116);
				equation(0);
				setState(117);
				match(RIGHT_PAREN);
				}
				break;
			case PLUS:
			case MINUS:
			case ID:
			case INT:
				{
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PLUS || _la==MINUS) {
					{
					{
					setState(119);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
				factor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(134);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new EquationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equation);
						setState(128);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(129);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(130);
						equation(5);
						}
						break;
					case 2:
						{
						_localctx = new EquationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equation);
						setState(131);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(132);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(133);
						equation(4);
						}
						break;
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return statement_sempred((StatementContext)_localctx, predIndex);
		case 7:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 8:
			return equation_sempred((EquationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statement_sempred(StatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean equation_sempred(EquationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u008e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u00049\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005H\b"+
		"\u0005\u0003\u0005J\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007`\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007n\b\u0007\n\u0007\f\u0007q\t\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\by\b\b\n\b\f\b|\t\b\u0001\b\u0003\b\u007f"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0087\b\b"+
		"\n\b\f\b\u008a\t\b\u0001\t\u0001\t\u0001\t\u0000\u0003\u0002\u000e\u0010"+
		"\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0007\u0001\u0000"+
		"\u0015\u0016\u0002\u0000\u0011\u0011\u0013\u0013\u0002\u0000\u0012\u0012"+
		"\u0014\u0014\u0001\u0000\u0018\u0019\u0001\u0000\f\r\u0001\u0000\u000e"+
		"\u000f\u0001\u0000\u001a\u001b\u0094\u0000\u0014\u0001\u0000\u0000\u0000"+
		"\u0002\u001a\u0001\u0000\u0000\u0000\u0004,\u0001\u0000\u0000\u0000\u0006"+
		".\u0001\u0000\u0000\u0000\b8\u0001\u0000\u0000\u0000\n:\u0001\u0000\u0000"+
		"\u0000\fK\u0001\u0000\u0000\u0000\u000e_\u0001\u0000\u0000\u0000\u0010"+
		"~\u0001\u0000\u0000\u0000\u0012\u008b\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0005\u0006\u0000\u0000\u0015\u0016\u0005\n\u0000\u0000\u0016\u0017\u0003"+
		"\u0002\u0001\u0000\u0017\u0018\u0005\u000b\u0000\u0000\u0018\u0019\u0005"+
		"\u0000\u0000\u0001\u0019\u0001\u0001\u0000\u0000\u0000\u001a\u001b\u0006"+
		"\u0001\uffff\uffff\u0000\u001b\u001c\u0003\u0004\u0002\u0000\u001c!\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\n\u0002\u0000\u0000\u001e \u0003\u0004"+
		"\u0002\u0000\u001f\u001d\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000"+
		"!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0003\u0001"+
		"\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0003\u0006\u0003\u0000"+
		"%&\u0005\u0007\u0000\u0000&-\u0001\u0000\u0000\u0000\'(\u0003\b\u0004"+
		"\u0000()\u0005\u0007\u0000\u0000)-\u0001\u0000\u0000\u0000*-\u0003\n\u0005"+
		"\u0000+-\u0003\f\u0006\u0000,$\u0001\u0000\u0000\u0000,\'\u0001\u0000"+
		"\u0000\u0000,*\u0001\u0000\u0000\u0000,+\u0001\u0000\u0000\u0000-\u0005"+
		"\u0001\u0000\u0000\u0000./\u0005\u001a\u0000\u0000/0\u0005\u0010\u0000"+
		"\u000001\u0003\u0010\b\u00001\u0007\u0001\u0000\u0000\u000023\u0005\u001a"+
		"\u0000\u000034\u0005\u0010\u0000\u000049\u0005\u0004\u0000\u000056\u0005"+
		"\u0005\u0000\u000067\u0005\u0010\u0000\u000079\u0003\u0012\t\u000082\u0001"+
		"\u0000\u0000\u000085\u0001\u0000\u0000\u00009\t\u0001\u0000\u0000\u0000"+
		":;\u0005\u0001\u0000\u0000;<\u0005\b\u0000\u0000<=\u0003\u000e\u0007\u0000"+
		"=>\u0005\t\u0000\u0000>?\u0005\n\u0000\u0000?@\u0003\u0002\u0001\u0000"+
		"@I\u0005\u000b\u0000\u0000AG\u0005\u0002\u0000\u0000BC\u0005\n\u0000\u0000"+
		"CD\u0003\u0002\u0001\u0000DE\u0005\u000b\u0000\u0000EH\u0001\u0000\u0000"+
		"\u0000FH\u0003\n\u0005\u0000GB\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000"+
		"\u0000HJ\u0001\u0000\u0000\u0000IA\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000J\u000b\u0001\u0000\u0000\u0000KL\u0005\u0003\u0000\u0000"+
		"LM\u0005\b\u0000\u0000MN\u0003\u0006\u0003\u0000NO\u0005\u0007\u0000\u0000"+
		"OP\u0003\u000e\u0007\u0000PQ\u0005\u0007\u0000\u0000QR\u0003\u0006\u0003"+
		"\u0000RS\u0005\t\u0000\u0000ST\u0005\n\u0000\u0000TU\u0003\u0002\u0001"+
		"\u0000UV\u0005\u000b\u0000\u0000V\r\u0001\u0000\u0000\u0000WX\u0006\u0007"+
		"\uffff\uffff\u0000XY\u0005\b\u0000\u0000YZ\u0003\u000e\u0007\u0000Z[\u0005"+
		"\t\u0000\u0000[`\u0001\u0000\u0000\u0000\\]\u0005\u0017\u0000\u0000]`"+
		"\u0003\u000e\u0007\u0002^`\u0003\u0010\b\u0000_W\u0001\u0000\u0000\u0000"+
		"_\\\u0001\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`o\u0001\u0000\u0000"+
		"\u0000ab\n\u0007\u0000\u0000bc\u0007\u0000\u0000\u0000cn\u0003\u000e\u0007"+
		"\bde\n\u0006\u0000\u0000ef\u0007\u0001\u0000\u0000fn\u0003\u000e\u0007"+
		"\u0007gh\n\u0005\u0000\u0000hi\u0007\u0002\u0000\u0000in\u0003\u000e\u0007"+
		"\u0006jk\n\u0004\u0000\u0000kl\u0007\u0003\u0000\u0000ln\u0003\u000e\u0007"+
		"\u0005ma\u0001\u0000\u0000\u0000md\u0001\u0000\u0000\u0000mg\u0001\u0000"+
		"\u0000\u0000mj\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\u000f\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000rs\u0006\b\uffff\uffff\u0000st\u0005\b"+
		"\u0000\u0000tu\u0003\u0010\b\u0000uv\u0005\t\u0000\u0000v\u007f\u0001"+
		"\u0000\u0000\u0000wy\u0007\u0004\u0000\u0000xw\u0001\u0000\u0000\u0000"+
		"y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{}\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}\u007f\u0003"+
		"\u0012\t\u0000~r\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000\u0000\u007f"+
		"\u0088\u0001\u0000\u0000\u0000\u0080\u0081\n\u0004\u0000\u0000\u0081\u0082"+
		"\u0007\u0005\u0000\u0000\u0082\u0087\u0003\u0010\b\u0005\u0083\u0084\n"+
		"\u0003\u0000\u0000\u0084\u0085\u0007\u0004\u0000\u0000\u0085\u0087\u0003"+
		"\u0010\b\u0004\u0086\u0080\u0001\u0000\u0000\u0000\u0086\u0083\u0001\u0000"+
		"\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0011\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008c\u0007\u0006"+
		"\u0000\u0000\u008c\u0013\u0001\u0000\u0000\u0000\f!,8GI_moz~\u0086\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}