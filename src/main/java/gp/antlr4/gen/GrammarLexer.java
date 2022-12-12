// Generated from C:/Users/User/IdeaProjects/MyGPProject/src/main/antlr4/gp/project\Grammar.g4 by ANTLR 4.10.1
package gp.antlr4.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "LETTER", "IF", "ELSE", "FOR", "IN", "OUT", "INIT", "SEMI", 
			"LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "PLUS", "MINUS", 
			"TIMES", "DIV", "ASSIGN", "GREATER_THEN", "GREATER_EQUAL_THEN", "LESS_THEN", 
			"LESS_EQUAL_THEN", "AND", "OR", "NOT", "EQUAL", "NOT_EQUAL", "ID", "INT", 
			"WHITESPACE", "NEWLINE"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001d\u00a3\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u008b\b\u001b\n\u001b\f\u001b\u008e\t\u001b"+
		"\u0001\u001c\u0004\u001c\u0091\b\u001c\u000b\u001c\f\u001c\u0092\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0003\u001e\u009a"+
		"\b\u001e\u0001\u001e\u0001\u001e\u0004\u001e\u009e\b\u001e\u000b\u001e"+
		"\f\u001e\u009f\u0001\u001e\u0001\u001e\u0000\u0000\u001f\u0001\u0000\u0003"+
		"\u0000\u0005\u0001\u0007\u0002\t\u0003\u000b\u0004\r\u0005\u000f\u0006"+
		"\u0011\u0007\u0013\b\u0015\t\u0017\n\u0019\u000b\u001b\f\u001d\r\u001f"+
		"\u000e!\u000f#\u0010%\u0011\'\u0012)\u0013+\u0014-\u0015/\u00161\u0017"+
		"3\u00185\u00197\u001a9\u001b;\u001c=\u001d\u0001\u0000\u0003\u0001\u0000"+
		"09\u0002\u0000AZaz\u0002\u0000\t\t  \u00a6\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0001?"+
		"\u0001\u0000\u0000\u0000\u0003A\u0001\u0000\u0000\u0000\u0005C\u0001\u0000"+
		"\u0000\u0000\u0007F\u0001\u0000\u0000\u0000\tK\u0001\u0000\u0000\u0000"+
		"\u000bO\u0001\u0000\u0000\u0000\rR\u0001\u0000\u0000\u0000\u000fV\u0001"+
		"\u0000\u0000\u0000\u0011[\u0001\u0000\u0000\u0000\u0013]\u0001\u0000\u0000"+
		"\u0000\u0015_\u0001\u0000\u0000\u0000\u0017a\u0001\u0000\u0000\u0000\u0019"+
		"c\u0001\u0000\u0000\u0000\u001be\u0001\u0000\u0000\u0000\u001dg\u0001"+
		"\u0000\u0000\u0000\u001fi\u0001\u0000\u0000\u0000!k\u0001\u0000\u0000"+
		"\u0000#m\u0001\u0000\u0000\u0000%o\u0001\u0000\u0000\u0000\'q\u0001\u0000"+
		"\u0000\u0000)t\u0001\u0000\u0000\u0000+v\u0001\u0000\u0000\u0000-y\u0001"+
		"\u0000\u0000\u0000/|\u0001\u0000\u0000\u00001\u007f\u0001\u0000\u0000"+
		"\u00003\u0081\u0001\u0000\u0000\u00005\u0084\u0001\u0000\u0000\u00007"+
		"\u0087\u0001\u0000\u0000\u00009\u0090\u0001\u0000\u0000\u0000;\u0094\u0001"+
		"\u0000\u0000\u0000=\u009d\u0001\u0000\u0000\u0000?@\u0007\u0000\u0000"+
		"\u0000@\u0002\u0001\u0000\u0000\u0000AB\u0007\u0001\u0000\u0000B\u0004"+
		"\u0001\u0000\u0000\u0000CD\u0005i\u0000\u0000DE\u0005f\u0000\u0000E\u0006"+
		"\u0001\u0000\u0000\u0000FG\u0005e\u0000\u0000GH\u0005l\u0000\u0000HI\u0005"+
		"s\u0000\u0000IJ\u0005e\u0000\u0000J\b\u0001\u0000\u0000\u0000KL\u0005"+
		"f\u0000\u0000LM\u0005o\u0000\u0000MN\u0005r\u0000\u0000N\n\u0001\u0000"+
		"\u0000\u0000OP\u0005i\u0000\u0000PQ\u0005n\u0000\u0000Q\f\u0001\u0000"+
		"\u0000\u0000RS\u0005o\u0000\u0000ST\u0005u\u0000\u0000TU\u0005t\u0000"+
		"\u0000U\u000e\u0001\u0000\u0000\u0000VW\u0005i\u0000\u0000WX\u0005n\u0000"+
		"\u0000XY\u0005i\u0000\u0000YZ\u0005t\u0000\u0000Z\u0010\u0001\u0000\u0000"+
		"\u0000[\\\u0005;\u0000\u0000\\\u0012\u0001\u0000\u0000\u0000]^\u0005("+
		"\u0000\u0000^\u0014\u0001\u0000\u0000\u0000_`\u0005)\u0000\u0000`\u0016"+
		"\u0001\u0000\u0000\u0000ab\u0005{\u0000\u0000b\u0018\u0001\u0000\u0000"+
		"\u0000cd\u0005}\u0000\u0000d\u001a\u0001\u0000\u0000\u0000ef\u0005+\u0000"+
		"\u0000f\u001c\u0001\u0000\u0000\u0000gh\u0005-\u0000\u0000h\u001e\u0001"+
		"\u0000\u0000\u0000ij\u0005*\u0000\u0000j \u0001\u0000\u0000\u0000kl\u0005"+
		"/\u0000\u0000l\"\u0001\u0000\u0000\u0000mn\u0005=\u0000\u0000n$\u0001"+
		"\u0000\u0000\u0000op\u0005>\u0000\u0000p&\u0001\u0000\u0000\u0000qr\u0005"+
		">\u0000\u0000rs\u0005=\u0000\u0000s(\u0001\u0000\u0000\u0000tu\u0005<"+
		"\u0000\u0000u*\u0001\u0000\u0000\u0000vw\u0005<\u0000\u0000wx\u0005=\u0000"+
		"\u0000x,\u0001\u0000\u0000\u0000yz\u0005&\u0000\u0000z{\u0005&\u0000\u0000"+
		"{.\u0001\u0000\u0000\u0000|}\u0005|\u0000\u0000}~\u0005|\u0000\u0000~"+
		"0\u0001\u0000\u0000\u0000\u007f\u0080\u0005!\u0000\u0000\u00802\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0005=\u0000\u0000\u0082\u0083\u0005=\u0000"+
		"\u0000\u00834\u0001\u0000\u0000\u0000\u0084\u0085\u0005!\u0000\u0000\u0085"+
		"\u0086\u0005=\u0000\u0000\u00866\u0001\u0000\u0000\u0000\u0087\u008c\u0003"+
		"\u0003\u0001\u0000\u0088\u008b\u0003\u0003\u0001\u0000\u0089\u008b\u0003"+
		"\u0001\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d8\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0091\u0003\u0001"+
		"\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093:\u0001\u0000\u0000\u0000\u0094\u0095\u0007\u0002\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0006\u001d\u0000"+
		"\u0000\u0097<\u0001\u0000\u0000\u0000\u0098\u009a\u0005\r\u0000\u0000"+
		"\u0099\u0098\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009e\u0005\n\u0000\u0000\u009c"+
		"\u009e\u0005\r\u0000\u0000\u009d\u0099\u0001\u0000\u0000\u0000\u009d\u009c"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u009d"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0006\u001e\u0000\u0000\u00a2>\u0001"+
		"\u0000\u0000\u0000\u0007\u0000\u008a\u008c\u0092\u0099\u009d\u009f\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}