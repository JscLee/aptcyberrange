// Generated from Stitch.g4 by ANTLR 4.7.1

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StitchParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MODULE=1, IMPORT=2, LIB=3, MODEL=4, OP=5, AS=6, TACTIC=7, CONDITION=8, 
		ACTION=9, EFFECT=10, ERROR=11, STRATEGY=12, DEFINE=13, FUNCTION=14, SUCCESS=15, 
		FAILURE=16, DEFAULT=17, NULLTACTIC=18, DO=19, DONE=20, IF=21, ELSE=22, 
		FOR=23, WHILE=24, OBJECT=25, INT=26, FLOAT=27, BOOLEAN=28, CHAR=29, STRING=30, 
		SET=31, SEQUENCE=32, RECORD=33, ENUM=34, FORALL=35, EXISTS=36, UNIQUE=37, 
		SELECT=38, AND=39, OR=40, IN=41, TRUE=42, FALSE=43, NULL=44, IDENTIFIER=45, 
		SL_COMMENT=46, ML_COMMENT=47, INTEGER_LIT=48, FLOAT_LIT=49, STRING_LIT=50, 
		CHAR_LIT=51, LPAREN=52, RPAREN=53, LBRACKET=54, RBRACKET=55, LBRACE=56, 
		RBRACE=57, COLON=58, SEMICOLON=59, COMMA=60, DOT=61, DQUOTE=62, SQUOTE=63, 
		BSLASH=64, BAR=65, HASH=66, AT=67, DOLLAR=68, ASSIGN=69, PLUS_ASSIGN=70, 
		MINUS_ASSIGN=71, STAR_ASSIGN=72, DIV_ASSIGN=73, MOD_ASSIGN=74, COLON_BANG=75, 
		LOGICAL_OR=76, LOGICAL_AND=77, EQ=78, NE=79, LT=80, LE=81, GE=82, GT=83, 
		PLUS=84, MINUS=85, STAR=86, SLASH=87, MOD=88, INCR=89, DECR=90, LOGICAL_NOT=91, 
		IMPLIES=92, IFF=93, LETTER=94, DIGIT=95, UNDERSCORE=96, NL=97, WS=98, 
		TYPE=99, EXISTS_UNIQUE=100, UNARY_MINUS=101, UNARY_PLUS=102, POST_INCR=103, 
		POST_DECR=104, DO_UNSPEC=105, EMPTY_STMT=106, STMT_LIST=107, EXRR_LIST=108, 
		STRATEGY_BRANCH=109, METHOD_CALL=110, IMPORT_LIB=111, IMPORT_MODEL=112, 
		IMPORT_OP=113;
	public static final int
		RULE_script = 0, RULE_importSt = 1, RULE_importRename = 2, RULE_functions = 3, 
		RULE_tactic = 4, RULE_tacticParams = 5, RULE_tacticParam = 6, RULE_vars = 7, 
		RULE_var = 8, RULE_condition = 9, RULE_action = 10, RULE_effect = 11, 
		RULE_strategy = 12, RULE_strategyNode = 13, RULE_strategyCond = 14, RULE_tacticRef = 15, 
		RULE_strategyBranch = 16, RULE_statement = 17, RULE_errorHandler = 18, 
		RULE_ifStmt = 19, RULE_whileStmt = 20, RULE_forStmt = 21, RULE_forInit = 22, 
		RULE_forCond = 23, RULE_forIter = 24, RULE_expressions = 25, RULE_expression = 26, 
		RULE_assignmentExpression = 27, RULE_booleanExpression = 28, RULE_impliesExpression = 29, 
		RULE_iffExpression = 30, RULE_logicalOrExpression = 31, RULE_logicalAndExpression = 32, 
		RULE_equalityExpression = 33, RULE_relationalExpression = 34, RULE_additiveExpression = 35, 
		RULE_multiplicativeExpression = 36, RULE_unaryExpression = 37, RULE_primaryExpression = 38, 
		RULE_idExpression = 39, RULE_postIdExpression = 40, RULE_methodCall = 41, 
		RULE_params = 42, RULE_param = 43, RULE_quantifiedExpression = 44, RULE_nonLiteralIdExpression = 45, 
		RULE_setExpression = 46, RULE_pathExpression = 47, RULE_pathExpressionContinuation = 48, 
		RULE_literalSet = 49, RULE_dataType = 50;
	public static final String[] ruleNames = {
		"script", "importSt", "importRename", "functions", "tactic", "tacticParams", 
		"tacticParam", "vars", "var", "condition", "action", "effect", "strategy", 
		"strategyNode", "strategyCond", "tacticRef", "strategyBranch", "statement", 
		"errorHandler", "ifStmt", "whileStmt", "forStmt", "forInit", "forCond", 
		"forIter", "expressions", "expression", "assignmentExpression", "booleanExpression", 
		"impliesExpression", "iffExpression", "logicalOrExpression", "logicalAndExpression", 
		"equalityExpression", "relationalExpression", "additiveExpression", "multiplicativeExpression", 
		"unaryExpression", "primaryExpression", "idExpression", "postIdExpression", 
		"methodCall", "params", "param", "quantifiedExpression", "nonLiteralIdExpression", 
		"setExpression", "pathExpression", "pathExpressionContinuation", "literalSet", 
		"dataType"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'module'", "'import'", "'lib'", "'model'", "'op'", "'as'", "'tactic'", 
		"'condition'", "'action'", "'effect'", "'error'", "'strategy'", "'define'", 
		"'function'", "'success'", "'failure'", "'default'", "'TNULL'", "'do'", 
		"'done'", "'if'", "'else'", "'for'", "'while'", "'object'", "'int'", "'float'", 
		"'boolean'", "'char'", "'string'", "'set'", "'sequence'", "'record'", 
		"'enum'", "'forall'", "'exists'", "'unique'", "'select'", "'and'", "'or'", 
		"'in'", "'true'", "'false'", "'null'", null, null, null, null, null, null, 
		null, "'('", "')'", "'['", "']'", "'{'", "'}'", "':'", "';'", "','", "'.'", 
		"'\"'", "'''", "'\\'", "'|'", "'#'", "'@'", "'$'", "'='", "'+='", "'-='", 
		"'*='", "'/='", "'%='", "':!'", null, null, "'=='", "'!='", "'<'", "'<='", 
		"'>='", "'>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'!'", 
		"'->'", "'<->'", null, null, "'_'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "MODULE", "IMPORT", "LIB", "MODEL", "OP", "AS", "TACTIC", "CONDITION", 
		"ACTION", "EFFECT", "ERROR", "STRATEGY", "DEFINE", "FUNCTION", "SUCCESS", 
		"FAILURE", "DEFAULT", "NULLTACTIC", "DO", "DONE", "IF", "ELSE", "FOR", 
		"WHILE", "OBJECT", "INT", "FLOAT", "BOOLEAN", "CHAR", "STRING", "SET", 
		"SEQUENCE", "RECORD", "ENUM", "FORALL", "EXISTS", "UNIQUE", "SELECT", 
		"AND", "OR", "IN", "TRUE", "FALSE", "NULL", "IDENTIFIER", "SL_COMMENT", 
		"ML_COMMENT", "INTEGER_LIT", "FLOAT_LIT", "STRING_LIT", "CHAR_LIT", "LPAREN", 
		"RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "COLON", "SEMICOLON", 
		"COMMA", "DOT", "DQUOTE", "SQUOTE", "BSLASH", "BAR", "HASH", "AT", "DOLLAR", 
		"ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "STAR_ASSIGN", "DIV_ASSIGN", 
		"MOD_ASSIGN", "COLON_BANG", "LOGICAL_OR", "LOGICAL_AND", "EQ", "NE", "LT", 
		"LE", "GE", "GT", "PLUS", "MINUS", "STAR", "SLASH", "MOD", "INCR", "DECR", 
		"LOGICAL_NOT", "IMPLIES", "IFF", "LETTER", "DIGIT", "UNDERSCORE", "NL", 
		"WS", "TYPE", "EXISTS_UNIQUE", "UNARY_MINUS", "UNARY_PLUS", "POST_INCR", 
		"POST_DECR", "DO_UNSPEC", "EMPTY_STMT", "STMT_LIST", "EXRR_LIST", "STRATEGY_BRANCH", 
		"METHOD_CALL", "IMPORT_LIB", "IMPORT_MODEL", "IMPORT_OP"
	};
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
	public String getGrammarFileName() { return "Stitch.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		//ALI: ADDED stitchProblemHandler to parser
		private ArrayList<String> definedTactics = new ArrayList<String>();

		public ArrayList<String> getDefinedTactics() {
			return definedTactics;
		}

		public void defineTactic (Token id) {
		  definedTactics.add (id.getText ());
		}

	public StitchParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScriptContext extends ParserRuleContext {
		public Token i;
		public TerminalNode MODULE() { return getToken(StitchParser.MODULE, 0); }
		public TerminalNode SEMICOLON() { return getToken(StitchParser.SEMICOLON, 0); }
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(StitchParser.EOF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public List<ImportStContext> importSt() {
			return getRuleContexts(ImportStContext.class);
		}
		public ImportStContext importSt(int i) {
			return getRuleContext(ImportStContext.class,i);
		}
		public List<TacticContext> tactic() {
			return getRuleContexts(TacticContext.class);
		}
		public TacticContext tactic(int i) {
			return getRuleContext(TacticContext.class,i);
		}
		public List<StrategyContext> strategy() {
			return getRuleContexts(StrategyContext.class);
		}
		public StrategyContext strategy(int i) {
			return getRuleContext(StrategyContext.class,i);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(MODULE);
			setState(103);
			((ScriptContext)_localctx).i = match(IDENTIFIER);
			setState(104);
			match(SEMICOLON);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(105);
				importSt();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			functions();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TACTIC) {
				{
				{
				setState(112);
				tactic();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRATEGY) {
				{
				{
				setState(118);
				strategy();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
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

	public static class ImportStContext extends ParserRuleContext {
		public Token i;
		public Token tl;
		public Token tm;
		public Token to;
		public Token s;
		public TerminalNode SEMICOLON() { return getToken(StitchParser.SEMICOLON, 0); }
		public TerminalNode IMPORT() { return getToken(StitchParser.IMPORT, 0); }
		public TerminalNode STRING_LIT() { return getToken(StitchParser.STRING_LIT, 0); }
		public TerminalNode LIB() { return getToken(StitchParser.LIB, 0); }
		public TerminalNode MODEL() { return getToken(StitchParser.MODEL, 0); }
		public TerminalNode OP() { return getToken(StitchParser.OP, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public List<ImportRenameContext> importRename() {
			return getRuleContexts(ImportRenameContext.class);
		}
		public ImportRenameContext importRename(int i) {
			return getRuleContext(ImportRenameContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(StitchParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StitchParser.COMMA, i);
		}
		public ImportStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitImportSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStContext importSt() throws RecognitionException {
		ImportStContext _localctx = new ImportStContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importSt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((ImportStContext)_localctx).i = match(IMPORT);
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LIB:
				{
				setState(127);
				((ImportStContext)_localctx).tl = match(LIB);
				((CommonToken )((ImportStContext)_localctx).i).setType(IMPORT_LIB);
				}
				break;
			case MODEL:
				{
				setState(129);
				((ImportStContext)_localctx).tm = match(MODEL);
				((CommonToken )((ImportStContext)_localctx).i).setType(IMPORT_MODEL);
				}
				break;
			case OP:
				{
				setState(131);
				((ImportStContext)_localctx).to = match(OP);
				((CommonToken )((ImportStContext)_localctx).i).setType(IMPORT_OP); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(135);
			((ImportStContext)_localctx).s = match(STRING_LIT);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(136);
				match(LBRACE);
				setState(137);
				importRename();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(138);
					match(COMMA);
					setState(139);
					importRename();
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145);
				match(RBRACE);
				}
			}

			setState(149);
			match(SEMICOLON);
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

	public static class ImportRenameContext extends ParserRuleContext {
		public Token id1;
		public Token id2;
		public TerminalNode AS() { return getToken(StitchParser.AS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(StitchParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StitchParser.IDENTIFIER, i);
		}
		public ImportRenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importRename; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitImportRename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportRenameContext importRename() throws RecognitionException {
		ImportRenameContext _localctx = new ImportRenameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importRename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			((ImportRenameContext)_localctx).id1 = match(IDENTIFIER);
			setState(152);
			match(AS);
			setState(153);
			((ImportRenameContext)_localctx).id2 = match(IDENTIFIER);
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

	public static class FunctionsContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(StitchParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(StitchParser.SEMICOLON, i);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					var();
					setState(156);
					match(SEMICOLON);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class TacticContext extends ParserRuleContext {
		public Token id;
		public TerminalNode TACTIC() { return getToken(StitchParser.TACTIC, 0); }
		public TerminalNode LPAREN() { return getToken(StitchParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(StitchParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public EffectContext effect() {
			return getRuleContext(EffectContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TacticParamsContext tacticParams() {
			return getRuleContext(TacticParamsContext.class,0);
		}
		public TacticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tactic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitTactic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TacticContext tactic() throws RecognitionException {
		TacticContext _localctx = new TacticContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tactic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(TACTIC);
			setState(164);
			((TacticContext)_localctx).id = match(IDENTIFIER);
			setState(165);
			match(LPAREN);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECT) | (1L << INT) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << STRING) | (1L << SET) | (1L << SEQUENCE) | (1L << RECORD) | (1L << ENUM) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(166);
				tacticParams();
				}
			}

			setState(169);
			match(RPAREN);
			setState(170);
			match(LBRACE);
			setState(171);
			vars();
			setState(172);
			condition();
			setState(173);
			action();
			setState(174);
			effect();
			setState(175);
			match(RBRACE);
			}
			_ctx.stop = _input.LT(-1);
			defineTactic(((TacticContext)_localctx).id);
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

	public static class TacticParamsContext extends ParserRuleContext {
		public List<TacticParamContext> tacticParam() {
			return getRuleContexts(TacticParamContext.class);
		}
		public TacticParamContext tacticParam(int i) {
			return getRuleContext(TacticParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StitchParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StitchParser.COMMA, i);
		}
		public TacticParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tacticParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitTacticParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TacticParamsContext tacticParams() throws RecognitionException {
		TacticParamsContext _localctx = new TacticParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tacticParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			tacticParam();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(178);
				match(COMMA);
				setState(179);
				tacticParam();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TacticParamContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TacticParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tacticParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitTacticParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TacticParamContext tacticParam() throws RecognitionException {
		TacticParamContext _localctx = new TacticParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tacticParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			dataType();
			setState(186);
			match(IDENTIFIER);
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

	public static class VarsContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(StitchParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(StitchParser.SEMICOLON, i);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << FUNCTION) | (1L << OBJECT) | (1L << INT) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << STRING) | (1L << SET) | (1L << SEQUENCE) | (1L << RECORD) | (1L << ENUM) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(188);
				var();
				setState(189);
				match(SEMICOLON);
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class VarContext extends ParserRuleContext {
		public DataTypeContext t;
		public Token i;
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(StitchParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FUNCTION() { return getToken(StitchParser.FUNCTION, 0); }
		public TerminalNode DEFINE() { return getToken(StitchParser.DEFINE, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINE || _la==FUNCTION) {
				{
				setState(196);
				_la = _input.LA(1);
				if ( !(_la==DEFINE || _la==FUNCTION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(199);
			((VarContext)_localctx).t = dataType();
			setState(200);
			((VarContext)_localctx).i = match(IDENTIFIER);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(201);
				match(ASSIGN);
				setState(202);
				expression();
				}
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode CONDITION() { return getToken(StitchParser.CONDITION, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(StitchParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(StitchParser.SEMICOLON, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(CONDITION);
			setState(206);
			match(LBRACE);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (FORALL - 35)) | (1L << (EXISTS - 35)) | (1L << (SELECT - 35)) | (1L << (TRUE - 35)) | (1L << (FALSE - 35)) | (1L << (NULL - 35)) | (1L << (IDENTIFIER - 35)) | (1L << (INTEGER_LIT - 35)) | (1L << (FLOAT_LIT - 35)) | (1L << (STRING_LIT - 35)) | (1L << (CHAR_LIT - 35)) | (1L << (LPAREN - 35)) | (1L << (LBRACE - 35)) | (1L << (PLUS - 35)) | (1L << (MINUS - 35)) | (1L << (SLASH - 35)) | (1L << (INCR - 35)) | (1L << (DECR - 35)) | (1L << (LOGICAL_NOT - 35)))) != 0)) {
				{
				{
				setState(207);
				expression();
				setState(208);
				match(SEMICOLON);
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(RBRACE);
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

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode ACTION() { return getToken(StitchParser.ACTION, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(ACTION);
			setState(218);
			match(LBRACE);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << FUNCTION) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << OBJECT) | (1L << INT) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << STRING) | (1L << SET) | (1L << SEQUENCE) | (1L << RECORD) | (1L << ENUM) | (1L << FORALL) | (1L << EXISTS) | (1L << SELECT) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << IDENTIFIER) | (1L << INTEGER_LIT) | (1L << FLOAT_LIT) | (1L << STRING_LIT) | (1L << CHAR_LIT) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMICOLON))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (PLUS - 84)) | (1L << (MINUS - 84)) | (1L << (SLASH - 84)) | (1L << (INCR - 84)) | (1L << (DECR - 84)) | (1L << (LOGICAL_NOT - 84)))) != 0)) {
				{
				{
				setState(219);
				statement();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			match(RBRACE);
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

	public static class EffectContext extends ParserRuleContext {
		public TerminalNode EFFECT() { return getToken(StitchParser.EFFECT, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public TerminalNode AT() { return getToken(StitchParser.AT, 0); }
		public TerminalNode LBRACKET() { return getToken(StitchParser.LBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(StitchParser.RBRACKET, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(StitchParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(StitchParser.SEMICOLON, i);
		}
		public EffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitEffect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectContext effect() throws RecognitionException {
		EffectContext _localctx = new EffectContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_effect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(EFFECT);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(228);
				match(AT);
				setState(229);
				match(LBRACKET);
				setState(230);
				expression();
				setState(231);
				match(RBRACKET);
				}
			}

			setState(235);
			match(LBRACE);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (FORALL - 35)) | (1L << (EXISTS - 35)) | (1L << (SELECT - 35)) | (1L << (TRUE - 35)) | (1L << (FALSE - 35)) | (1L << (NULL - 35)) | (1L << (IDENTIFIER - 35)) | (1L << (INTEGER_LIT - 35)) | (1L << (FLOAT_LIT - 35)) | (1L << (STRING_LIT - 35)) | (1L << (CHAR_LIT - 35)) | (1L << (LPAREN - 35)) | (1L << (LBRACE - 35)) | (1L << (PLUS - 35)) | (1L << (MINUS - 35)) | (1L << (SLASH - 35)) | (1L << (INCR - 35)) | (1L << (DECR - 35)) | (1L << (LOGICAL_NOT - 35)))) != 0)) {
				{
				{
				setState(236);
				expression();
				setState(237);
				match(SEMICOLON);
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
			match(RBRACE);
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

	public static class StrategyContext extends ParserRuleContext {
		public TerminalNode STRATEGY() { return getToken(StitchParser.STRATEGY, 0); }
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(StitchParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(StitchParser.RBRACKET, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public List<StrategyNodeContext> strategyNode() {
			return getRuleContexts(StrategyNodeContext.class);
		}
		public StrategyNodeContext strategyNode(int i) {
			return getRuleContext(StrategyNodeContext.class,i);
		}
		public StrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyContext strategy() throws RecognitionException {
		StrategyContext _localctx = new StrategyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_strategy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(STRATEGY);
			setState(247);
			match(IDENTIFIER);
			setState(248);
			match(LBRACKET);
			setState(249);
			expression();
			setState(250);
			match(RBRACKET);
			setState(251);
			match(LBRACE);
			setState(252);
			functions();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER || _la==LPAREN) {
				{
				{
				setState(253);
				strategyNode();
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(259);
			match(RBRACE);
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

	public static class StrategyNodeContext extends ParserRuleContext {
		public StrategyCondContext strategyCond() {
			return getRuleContext(StrategyCondContext.class,0);
		}
		public TerminalNode IMPLIES() { return getToken(StitchParser.IMPLIES, 0); }
		public TacticRefContext tacticRef() {
			return getRuleContext(TacticRefContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(StitchParser.COLON, 0); }
		public StrategyNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategyNode; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitStrategyNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyNodeContext strategyNode() throws RecognitionException {
		StrategyNodeContext _localctx = new StrategyNodeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_strategyNode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(261);
				match(IDENTIFIER);
				setState(262);
				match(COLON);
				}
			}

			setState(265);
			strategyCond();
			setState(266);
			match(IMPLIES);
			setState(267);
			tacticRef();
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

	public static class StrategyCondContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(StitchParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(StitchParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SUCCESS() { return getToken(StitchParser.SUCCESS, 0); }
		public TerminalNode FAILURE() { return getToken(StitchParser.FAILURE, 0); }
		public TerminalNode DEFAULT() { return getToken(StitchParser.DEFAULT, 0); }
		public TerminalNode HASH() { return getToken(StitchParser.HASH, 0); }
		public StrategyCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategyCond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitStrategyCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyCondContext strategyCond() throws RecognitionException {
		StrategyCondContext _localctx = new StrategyCondContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_strategyCond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(LPAREN);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(270);
				match(HASH);
				setState(271);
				expression();
				}
			}

			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FORALL:
			case EXISTS:
			case SELECT:
			case TRUE:
			case FALSE:
			case NULL:
			case IDENTIFIER:
			case INTEGER_LIT:
			case FLOAT_LIT:
			case STRING_LIT:
			case CHAR_LIT:
			case LPAREN:
			case LBRACE:
			case PLUS:
			case MINUS:
			case SLASH:
			case INCR:
			case DECR:
			case LOGICAL_NOT:
				{
				setState(274);
				expression();
				}
				break;
			case SUCCESS:
				{
				setState(275);
				match(SUCCESS);
				}
				break;
			case FAILURE:
				{
				setState(276);
				match(FAILURE);
				}
				break;
			case DEFAULT:
				{
				setState(277);
				match(DEFAULT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(280);
			match(RPAREN);
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

	public static class TacticRefContext extends ParserRuleContext {
		public Token t1;
		public Token v;
		public Token i;
		public Token t2;
		public TerminalNode LPAREN() { return getToken(StitchParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(StitchParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(StitchParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StitchParser.IDENTIFIER, i);
		}
		public StrategyBranchContext strategyBranch() {
			return getRuleContext(StrategyBranchContext.class,0);
		}
		public TerminalNode DONE() { return getToken(StitchParser.DONE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AT() { return getToken(StitchParser.AT, 0); }
		public TerminalNode LBRACKET() { return getToken(StitchParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(StitchParser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(StitchParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StitchParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(StitchParser.SEMICOLON, 0); }
		public TerminalNode NULLTACTIC() { return getToken(StitchParser.NULLTACTIC, 0); }
		public TerminalNode DO() { return getToken(StitchParser.DO, 0); }
		public TerminalNode INTEGER_LIT() { return getToken(StitchParser.INTEGER_LIT, 0); }
		public TerminalNode BAR() { return getToken(StitchParser.BAR, 0); }
		public List<StrategyNodeContext> strategyNode() {
			return getRuleContexts(StrategyNodeContext.class);
		}
		public StrategyNodeContext strategyNode(int i) {
			return getRuleContext(StrategyNodeContext.class,i);
		}
		public TacticRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tacticRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitTacticRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TacticRefContext tacticRef() throws RecognitionException {
		TacticRefContext _localctx = new TacticRefContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tacticRef);
		int _la;
		try {
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(282);
				((TacticRefContext)_localctx).t1 = match(IDENTIFIER);
				setState(283);
				match(LPAREN);
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (FORALL - 35)) | (1L << (EXISTS - 35)) | (1L << (SELECT - 35)) | (1L << (TRUE - 35)) | (1L << (FALSE - 35)) | (1L << (NULL - 35)) | (1L << (IDENTIFIER - 35)) | (1L << (INTEGER_LIT - 35)) | (1L << (FLOAT_LIT - 35)) | (1L << (STRING_LIT - 35)) | (1L << (CHAR_LIT - 35)) | (1L << (LPAREN - 35)) | (1L << (LBRACE - 35)) | (1L << (PLUS - 35)) | (1L << (MINUS - 35)) | (1L << (SLASH - 35)) | (1L << (INCR - 35)) | (1L << (DECR - 35)) | (1L << (LOGICAL_NOT - 35)))) != 0)) {
					{
					setState(284);
					expression();
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(285);
						match(COMMA);
						setState(286);
						expression();
						}
						}
						setState(291);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(294);
				match(RPAREN);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(295);
					match(AT);
					setState(296);
					match(LBRACKET);
					setState(297);
					expression();
					setState(298);
					match(RBRACKET);
					}
				}

				setState(302);
				match(LBRACE);
				setState(305);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
				case LPAREN:
					{
					setState(303);
					strategyBranch();
					}
					break;
				case DONE:
					{
					setState(304);
					match(DONE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(307);
				match(RBRACE);
				}
				}
				break;
			case DONE:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				match(DONE);
				setState(309);
				match(SEMICOLON);
				}
				break;
			case NULLTACTIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(310);
				match(NULLTACTIC);
				setState(311);
				match(SEMICOLON);
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				match(DO);
				setState(313);
				match(LBRACKET);
				setState(316);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(314);
					((TacticRefContext)_localctx).v = match(IDENTIFIER);
					}
					break;
				case INTEGER_LIT:
					{
					setState(315);
					((TacticRefContext)_localctx).i = match(INTEGER_LIT);
					}
					break;
				case RBRACKET:
					break;
				default:
					break;
				}
				setState(318);
				match(RBRACKET);
				setState(319);
				((TacticRefContext)_localctx).t2 = match(IDENTIFIER);
				setState(320);
				match(SEMICOLON);
				}
				break;
			case BAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(321);
				match(BAR);
				setState(322);
				match(DONE);
				setState(323);
				match(SEMICOLON);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 6);
				{
				setState(324);
				match(LBRACE);
				setState(326); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(325);
					strategyNode();
					}
					}
					setState(328); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IDENTIFIER || _la==LPAREN );
				setState(330);
				match(RBRACE);
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

	public static class StrategyBranchContext extends ParserRuleContext {
		public List<StrategyNodeContext> strategyNode() {
			return getRuleContexts(StrategyNodeContext.class);
		}
		public StrategyNodeContext strategyNode(int i) {
			return getRuleContext(StrategyNodeContext.class,i);
		}
		public StrategyBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategyBranch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitStrategyBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyBranchContext strategyBranch() throws RecognitionException {
		StrategyBranchContext _localctx = new StrategyBranchContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_strategyBranch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(334);
				strategyNode();
				}
				}
				setState(337); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENTIFIER || _la==LPAREN );
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
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ErrorHandlerContext errorHandler() {
			return getRuleContext(ErrorHandlerContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(StitchParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		int _la;
		try {
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				match(LBRACE);
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << FUNCTION) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << OBJECT) | (1L << INT) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << STRING) | (1L << SET) | (1L << SEQUENCE) | (1L << RECORD) | (1L << ENUM) | (1L << FORALL) | (1L << EXISTS) | (1L << SELECT) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << IDENTIFIER) | (1L << INTEGER_LIT) | (1L << FLOAT_LIT) | (1L << STRING_LIT) | (1L << CHAR_LIT) | (1L << LPAREN) | (1L << LBRACE) | (1L << SEMICOLON))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (PLUS - 84)) | (1L << (MINUS - 84)) | (1L << (SLASH - 84)) | (1L << (INCR - 84)) | (1L << (DECR - 84)) | (1L << (LOGICAL_NOT - 84)))) != 0)) {
					{
					{
					setState(340);
					statement();
					}
					}
					setState(345);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(346);
				match(RBRACE);
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ERROR) {
					{
					setState(347);
					errorHandler();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				var();
				setState(351);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
				expression();
				setState(354);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(356);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(357);
				whileStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(358);
				forStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(359);
				match(SEMICOLON);
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

	public static class ErrorHandlerContext extends ParserRuleContext {
		public TerminalNode ERROR() { return getToken(StitchParser.ERROR, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(StitchParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(StitchParser.LPAREN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(StitchParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(StitchParser.RPAREN, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ErrorHandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorHandler; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitErrorHandler(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorHandlerContext errorHandler() throws RecognitionException {
		ErrorHandlerContext _localctx = new ErrorHandlerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_errorHandler);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(ERROR);
			setState(363);
			match(LBRACE);
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LPAREN) {
				{
				{
				setState(364);
				match(LPAREN);
				setState(365);
				expression();
				setState(366);
				match(RPAREN);
				setState(367);
				statement();
				}
				}
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(374);
			match(RBRACE);
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(StitchParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(StitchParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(StitchParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(StitchParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(IF);
			setState(377);
			match(LPAREN);
			setState(378);
			expression();
			setState(379);
			match(RPAREN);
			setState(380);
			statement();
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(381);
				match(ELSE);
				setState(382);
				statement();
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(StitchParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(StitchParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(StitchParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(WHILE);
			setState(386);
			match(LPAREN);
			setState(387);
			expression();
			setState(388);
			match(RPAREN);
			setState(389);
			statement();
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(StitchParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(StitchParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(StitchParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TacticParamContext tacticParam() {
			return getRuleContext(TacticParamContext.class,0);
		}
		public TerminalNode COLON() { return getToken(StitchParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(StitchParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(StitchParser.SEMICOLON, i);
		}
		public ForCondContext forCond() {
			return getRuleContext(ForCondContext.class,0);
		}
		public ForIterContext forIter() {
			return getRuleContext(ForIterContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(FOR);
			setState(392);
			match(LPAREN);
			setState(403);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(393);
				tacticParam();
				setState(394);
				match(COLON);
				setState(395);
				expression();
				}
				break;
			case 2:
				{
				setState(397);
				forInit();
				setState(398);
				match(SEMICOLON);
				setState(399);
				forCond();
				setState(400);
				match(SEMICOLON);
				setState(401);
				forIter();
				}
				break;
			}
			setState(405);
			match(RPAREN);
			setState(406);
			statement();
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

	public static class ForInitContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_forInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(409); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(408);
					var();
					}
					}
					setState(411); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFINE) | (1L << FUNCTION) | (1L << OBJECT) | (1L << INT) | (1L << FLOAT) | (1L << BOOLEAN) | (1L << CHAR) | (1L << STRING) | (1L << SET) | (1L << SEQUENCE) | (1L << RECORD) | (1L << ENUM) | (1L << IDENTIFIER))) != 0) );
				}
				break;
			case 2:
				{
				setState(413);
				expression();
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

	public static class ForCondContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitForCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForCondContext forCond() throws RecognitionException {
		ForCondContext _localctx = new ForCondContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_forCond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (FORALL - 35)) | (1L << (EXISTS - 35)) | (1L << (SELECT - 35)) | (1L << (TRUE - 35)) | (1L << (FALSE - 35)) | (1L << (NULL - 35)) | (1L << (IDENTIFIER - 35)) | (1L << (INTEGER_LIT - 35)) | (1L << (FLOAT_LIT - 35)) | (1L << (STRING_LIT - 35)) | (1L << (CHAR_LIT - 35)) | (1L << (LPAREN - 35)) | (1L << (LBRACE - 35)) | (1L << (PLUS - 35)) | (1L << (MINUS - 35)) | (1L << (SLASH - 35)) | (1L << (INCR - 35)) | (1L << (DECR - 35)) | (1L << (LOGICAL_NOT - 35)))) != 0)) {
				{
				setState(416);
				expression();
				}
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

	public static class ForIterContext extends ParserRuleContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ForIterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forIter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitForIter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForIterContext forIter() throws RecognitionException {
		ForIterContext _localctx = new ForIterContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_forIter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (FORALL - 35)) | (1L << (EXISTS - 35)) | (1L << (SELECT - 35)) | (1L << (TRUE - 35)) | (1L << (FALSE - 35)) | (1L << (NULL - 35)) | (1L << (IDENTIFIER - 35)) | (1L << (INTEGER_LIT - 35)) | (1L << (FLOAT_LIT - 35)) | (1L << (STRING_LIT - 35)) | (1L << (CHAR_LIT - 35)) | (1L << (LPAREN - 35)) | (1L << (LBRACE - 35)) | (1L << (PLUS - 35)) | (1L << (MINUS - 35)) | (1L << (SLASH - 35)) | (1L << (INCR - 35)) | (1L << (DECR - 35)) | (1L << (LOGICAL_NOT - 35)))) != 0)) {
				{
				setState(419);
				expressions();
				}
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

	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StitchParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StitchParser.COMMA, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			expression();
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(423);
				match(COMMA);
				setState(424);
				expression();
				}
				}
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			assignmentExpression();
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

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(StitchParser.ASSIGN, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(StitchParser.PLUS_ASSIGN, 0); }
		public TerminalNode MINUS_ASSIGN() { return getToken(StitchParser.MINUS_ASSIGN, 0); }
		public TerminalNode STAR_ASSIGN() { return getToken(StitchParser.STAR_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(StitchParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(StitchParser.MOD_ASSIGN, 0); }
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assignmentExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			booleanExpression();
			setState(435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(433);
				_la = _input.LA(1);
				if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ASSIGN - 69)) | (1L << (PLUS_ASSIGN - 69)) | (1L << (MINUS_ASSIGN - 69)) | (1L << (STAR_ASSIGN - 69)) | (1L << (DIV_ASSIGN - 69)) | (1L << (MOD_ASSIGN - 69)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(434);
				assignmentExpression();
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

	public static class BooleanExpressionContext extends ParserRuleContext {
		public ImpliesExpressionContext impliesExpression() {
			return getRuleContext(ImpliesExpressionContext.class,0);
		}
		public QuantifiedExpressionContext quantifiedExpression() {
			return getRuleContext(QuantifiedExpressionContext.class,0);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_booleanExpression);
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				impliesExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				quantifiedExpression();
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

	public static class ImpliesExpressionContext extends ParserRuleContext {
		public IffExpressionContext iffExpression() {
			return getRuleContext(IffExpressionContext.class,0);
		}
		public TerminalNode IMPLIES() { return getToken(StitchParser.IMPLIES, 0); }
		public ImpliesExpressionContext impliesExpression() {
			return getRuleContext(ImpliesExpressionContext.class,0);
		}
		public ImpliesExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impliesExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitImpliesExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImpliesExpressionContext impliesExpression() throws RecognitionException {
		ImpliesExpressionContext _localctx = new ImpliesExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_impliesExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			iffExpression();
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLIES) {
				{
				setState(442);
				match(IMPLIES);
				setState(443);
				impliesExpression();
				}
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

	public static class IffExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public TerminalNode IFF() { return getToken(StitchParser.IFF, 0); }
		public IffExpressionContext iffExpression() {
			return getRuleContext(IffExpressionContext.class,0);
		}
		public IffExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iffExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitIffExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IffExpressionContext iffExpression() throws RecognitionException {
		IffExpressionContext _localctx = new IffExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_iffExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			logicalOrExpression();
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IFF) {
				{
				setState(447);
				match(IFF);
				setState(448);
				iffExpression();
				}
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

	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public TerminalNode LOGICAL_OR() { return getToken(StitchParser.LOGICAL_OR, 0); }
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitLogicalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_logicalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			logicalAndExpression();
			setState(454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOGICAL_OR) {
				{
				setState(452);
				match(LOGICAL_OR);
				setState(453);
				logicalOrExpression();
				}
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

	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public TerminalNode LOGICAL_AND() { return getToken(StitchParser.LOGICAL_AND, 0); }
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitLogicalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_logicalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			equalityExpression();
			setState(459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOGICAL_AND) {
				{
				setState(457);
				match(LOGICAL_AND);
				setState(458);
				logicalAndExpression();
				}
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

	public static class EqualityExpressionContext extends ParserRuleContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public TerminalNode NE() { return getToken(StitchParser.NE, 0); }
		public TerminalNode EQ() { return getToken(StitchParser.EQ, 0); }
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			relationalExpression();
			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ || _la==NE) {
				{
				setState(462);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(463);
				equalityExpression();
				}
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

	public static class RelationalExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode LT() { return getToken(StitchParser.LT, 0); }
		public TerminalNode LE() { return getToken(StitchParser.LE, 0); }
		public TerminalNode GE() { return getToken(StitchParser.GE, 0); }
		public TerminalNode GT() { return getToken(StitchParser.GT, 0); }
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			additiveExpression();
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (LT - 80)) | (1L << (LE - 80)) | (1L << (GE - 80)) | (1L << (GT - 80)))) != 0)) {
				{
				setState(467);
				_la = _input.LA(1);
				if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (LT - 80)) | (1L << (LE - 80)) | (1L << (GE - 80)) | (1L << (GT - 80)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(468);
				relationalExpression();
				}
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(StitchParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(StitchParser.MINUS, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			multiplicativeExpression();
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(472);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(473);
				additiveExpression();
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

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode STAR() { return getToken(StitchParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(StitchParser.SLASH, 0); }
		public TerminalNode MOD() { return getToken(StitchParser.MOD, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			unaryExpression();
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(477);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (STAR - 86)) | (1L << (SLASH - 86)) | (1L << (MOD - 86)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(478);
				multiplicativeExpression();
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

	public static class UnaryExpressionContext extends ParserRuleContext {
		public TerminalNode INCR() { return getToken(StitchParser.INCR, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode DECR() { return getToken(StitchParser.DECR, 0); }
		public TerminalNode MINUS() { return getToken(StitchParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(StitchParser.PLUS, 0); }
		public TerminalNode LOGICAL_NOT() { return getToken(StitchParser.LOGICAL_NOT, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_unaryExpression);
		try {
			setState(492);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCR:
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				match(INCR);
				setState(482);
				unaryExpression();
				}
				break;
			case DECR:
				enterOuterAlt(_localctx, 2);
				{
				setState(483);
				match(DECR);
				setState(484);
				unaryExpression();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(485);
				match(MINUS);
				setState(486);
				unaryExpression();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 4);
				{
				setState(487);
				match(PLUS);
				setState(488);
				unaryExpression();
				}
				break;
			case LOGICAL_NOT:
				enterOuterAlt(_localctx, 5);
				{
				setState(489);
				match(LOGICAL_NOT);
				setState(490);
				unaryExpression();
				}
				break;
			case TRUE:
			case FALSE:
			case NULL:
			case IDENTIFIER:
			case INTEGER_LIT:
			case FLOAT_LIT:
			case STRING_LIT:
			case CHAR_LIT:
			case LPAREN:
			case LBRACE:
			case SLASH:
				enterOuterAlt(_localctx, 6);
				{
				setState(491);
				primaryExpression();
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

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public PostIdExpressionContext postIdExpression() {
			return getRuleContext(PostIdExpressionContext.class,0);
		}
		public SetExpressionContext setExpression() {
			return getRuleContext(SetExpressionContext.class,0);
		}
		public PathExpressionContext pathExpression() {
			return getRuleContext(PathExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(StitchParser.LPAREN, 0); }
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(StitchParser.RPAREN, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_primaryExpression);
		try {
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(494);
				idExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				postIdExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(496);
				setExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(497);
				pathExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(498);
				match(LPAREN);
				setState(499);
				assignmentExpression();
				setState(500);
				match(RPAREN);
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

	public static class IdExpressionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode INTEGER_LIT() { return getToken(StitchParser.INTEGER_LIT, 0); }
		public TerminalNode FLOAT_LIT() { return getToken(StitchParser.FLOAT_LIT, 0); }
		public TerminalNode STRING_LIT() { return getToken(StitchParser.STRING_LIT, 0); }
		public TerminalNode CHAR_LIT() { return getToken(StitchParser.CHAR_LIT, 0); }
		public TerminalNode TRUE() { return getToken(StitchParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(StitchParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(StitchParser.NULL, 0); }
		public IdExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitIdExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdExpressionContext idExpression() throws RecognitionException {
		IdExpressionContext _localctx = new IdExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_idExpression);
		try {
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(504);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(505);
				methodCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(506);
				match(INTEGER_LIT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(507);
				match(FLOAT_LIT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(508);
				match(STRING_LIT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(509);
				match(CHAR_LIT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(510);
				match(TRUE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(511);
				match(FALSE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(512);
				match(NULL);
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

	public static class PostIdExpressionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TerminalNode SQUOTE() { return getToken(StitchParser.SQUOTE, 0); }
		public PostIdExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postIdExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitPostIdExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostIdExpressionContext postIdExpression() throws RecognitionException {
		PostIdExpressionContext _localctx = new PostIdExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_postIdExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(IDENTIFIER);
			setState(516);
			match(SQUOTE);
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

	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(StitchParser.LPAREN, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(StitchParser.RPAREN, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			match(IDENTIFIER);
			setState(519);
			match(LPAREN);
			setState(520);
			expressions();
			setState(521);
			match(RPAREN);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StitchParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StitchParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			param();
			setState(528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(524);
				match(COMMA);
				setState(525);
				param();
				}
				}
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(StitchParser.COLON, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(IDENTIFIER);
			setState(532);
			match(COLON);
			setState(533);
			dataType();
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

	public static class QuantifiedExpressionContext extends ParserRuleContext {
		public Token e;
		public TerminalNode FORALL() { return getToken(StitchParser.FORALL, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode IN() { return getToken(StitchParser.IN, 0); }
		public TerminalNode BAR() { return getToken(StitchParser.BAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SetExpressionContext setExpression() {
			return getRuleContext(SetExpressionContext.class,0);
		}
		public IdExpressionContext idExpression() {
			return getRuleContext(IdExpressionContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(StitchParser.EXISTS, 0); }
		public TerminalNode UNIQUE() { return getToken(StitchParser.UNIQUE, 0); }
		public TerminalNode SELECT() { return getToken(StitchParser.SELECT, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public QuantifiedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifiedExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitQuantifiedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifiedExpressionContext quantifiedExpression() throws RecognitionException {
		QuantifiedExpressionContext _localctx = new QuantifiedExpressionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_quantifiedExpression);
		int _la;
		try {
			setState(574);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FORALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				match(FORALL);
				setState(536);
				params();
				setState(537);
				match(IN);
				setState(540);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(538);
					setExpression();
					}
					break;
				case TRUE:
				case FALSE:
				case NULL:
				case IDENTIFIER:
				case INTEGER_LIT:
				case FLOAT_LIT:
				case STRING_LIT:
				case CHAR_LIT:
					{
					setState(539);
					idExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(542);
				match(BAR);
				setState(543);
				expression();
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
				((QuantifiedExpressionContext)_localctx).e = match(EXISTS);
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNIQUE) {
					{
					setState(546);
					match(UNIQUE);
					((CommonToken )((QuantifiedExpressionContext)_localctx).e).setType(EXISTS_UNIQUE);
					}
				}

				setState(550);
				params();
				setState(551);
				match(IN);
				setState(554);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(552);
					setExpression();
					}
					break;
				case TRUE:
				case FALSE:
				case NULL:
				case IDENTIFIER:
				case INTEGER_LIT:
				case FLOAT_LIT:
				case STRING_LIT:
				case CHAR_LIT:
					{
					setState(553);
					idExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(556);
				match(BAR);
				setState(557);
				expression();
				}
				break;
			case SELECT:
			case LBRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(559);
					match(LBRACE);
					}
				}

				setState(562);
				match(SELECT);
				setState(563);
				params();
				setState(564);
				match(IN);
				setState(567);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(565);
					setExpression();
					}
					break;
				case TRUE:
				case FALSE:
				case NULL:
				case IDENTIFIER:
				case INTEGER_LIT:
				case FLOAT_LIT:
				case STRING_LIT:
				case CHAR_LIT:
					{
					setState(566);
					idExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(569);
				match(BAR);
				setState(570);
				expression();
				setState(572);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(571);
					match(RBRACE);
					}
					break;
				}
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

	public static class NonLiteralIdExpressionContext extends ParserRuleContext {
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public NonLiteralIdExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonLiteralIdExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitNonLiteralIdExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonLiteralIdExpressionContext nonLiteralIdExpression() throws RecognitionException {
		NonLiteralIdExpressionContext _localctx = new NonLiteralIdExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_nonLiteralIdExpression);
		try {
			setState(578);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(576);
				methodCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(577);
				match(IDENTIFIER);
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

	public static class SetExpressionContext extends ParserRuleContext {
		public LiteralSetContext literalSet() {
			return getRuleContext(LiteralSetContext.class,0);
		}
		public SetExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitSetExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetExpressionContext setExpression() throws RecognitionException {
		SetExpressionContext _localctx = new SetExpressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_setExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			literalSet();
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

	public static class PathExpressionContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(StitchParser.SLASH, 0); }
		public NonLiteralIdExpressionContext nonLiteralIdExpression() {
			return getRuleContext(NonLiteralIdExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StitchParser.IDENTIFIER, 0); }
		public TerminalNode LBRACKET() { return getToken(StitchParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(StitchParser.RBRACKET, 0); }
		public PathExpressionContinuationContext pathExpressionContinuation() {
			return getRuleContext(PathExpressionContinuationContext.class,0);
		}
		public TerminalNode COLON() { return getToken(StitchParser.COLON, 0); }
		public TerminalNode COLON_BANG() { return getToken(StitchParser.COLON_BANG, 0); }
		public PathExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitPathExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathExpressionContext pathExpression() throws RecognitionException {
		PathExpressionContext _localctx = new PathExpressionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_pathExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			match(SLASH);
			setState(583);
			nonLiteralIdExpression();
			setState(586);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==COLON_BANG) {
				{
				setState(584);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==COLON_BANG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(585);
				match(IDENTIFIER);
				}
			}

			setState(592);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(588);
				match(LBRACKET);
				setState(589);
				expression();
				setState(590);
				match(RBRACKET);
				}
			}

			setState(595);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(594);
				pathExpressionContinuation();
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

	public static class PathExpressionContinuationContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(StitchParser.SLASH, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(StitchParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StitchParser.IDENTIFIER, i);
		}
		public TerminalNode LBRACKET() { return getToken(StitchParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(StitchParser.RBRACKET, 0); }
		public PathExpressionContinuationContext pathExpressionContinuation() {
			return getRuleContext(PathExpressionContinuationContext.class,0);
		}
		public TerminalNode COLON() { return getToken(StitchParser.COLON, 0); }
		public TerminalNode COLON_BANG() { return getToken(StitchParser.COLON_BANG, 0); }
		public PathExpressionContinuationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathExpressionContinuation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitPathExpressionContinuation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathExpressionContinuationContext pathExpressionContinuation() throws RecognitionException {
		PathExpressionContinuationContext _localctx = new PathExpressionContinuationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_pathExpressionContinuation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			match(SLASH);
			setState(598);
			match(IDENTIFIER);
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==COLON_BANG) {
				{
				setState(599);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==COLON_BANG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(600);
				match(IDENTIFIER);
				}
			}

			setState(607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(603);
				match(LBRACKET);
				setState(604);
				expression();
				setState(605);
				match(RBRACKET);
				}
			}

			setState(610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(609);
				pathExpressionContinuation();
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

	public static class LiteralSetContext extends ParserRuleContext {
		public Token lb;
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StitchParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StitchParser.COMMA, i);
		}
		public LiteralSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitLiteralSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralSetContext literalSet() throws RecognitionException {
		LiteralSetContext _localctx = new LiteralSetContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_literalSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			((LiteralSetContext)_localctx).lb = match(LBRACE);
			((CommonToken )((LiteralSetContext)_localctx).lb).setType(SET);
			setState(622);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (FORALL - 35)) | (1L << (EXISTS - 35)) | (1L << (SELECT - 35)) | (1L << (TRUE - 35)) | (1L << (FALSE - 35)) | (1L << (NULL - 35)) | (1L << (IDENTIFIER - 35)) | (1L << (INTEGER_LIT - 35)) | (1L << (FLOAT_LIT - 35)) | (1L << (STRING_LIT - 35)) | (1L << (CHAR_LIT - 35)) | (1L << (LPAREN - 35)) | (1L << (LBRACE - 35)) | (1L << (PLUS - 35)) | (1L << (MINUS - 35)) | (1L << (SLASH - 35)) | (1L << (INCR - 35)) | (1L << (DECR - 35)) | (1L << (LOGICAL_NOT - 35)))) != 0)) {
				{
				setState(614);
				expression();
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(615);
					match(COMMA);
					setState(616);
					expression();
					}
					}
					setState(621);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(624);
			match(RBRACE);
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

	public static class DataTypeContext extends ParserRuleContext {
		public Token i;
		public TerminalNode OBJECT() { return getToken(StitchParser.OBJECT, 0); }
		public TerminalNode INT() { return getToken(StitchParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(StitchParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(StitchParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(StitchParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(StitchParser.STRING, 0); }
		public TerminalNode SET() { return getToken(StitchParser.SET, 0); }
		public TerminalNode LBRACE() { return getToken(StitchParser.LBRACE, 0); }
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(StitchParser.RBRACE, 0); }
		public TerminalNode SEQUENCE() { return getToken(StitchParser.SEQUENCE, 0); }
		public TerminalNode RECORD() { return getToken(StitchParser.RECORD, 0); }
		public TerminalNode LBRACKET() { return getToken(StitchParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(StitchParser.RBRACKET, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(StitchParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StitchParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COLON() { return getTokens(StitchParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(StitchParser.COLON, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(StitchParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(StitchParser.SEMICOLON, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StitchParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StitchParser.COMMA, i);
		}
		public TerminalNode ENUM() { return getToken(StitchParser.ENUM, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StitchVisitor ) return ((StitchVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_dataType);
		int _la;
		try {
			setState(683);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(626);
				match(OBJECT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(627);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(628);
				match(FLOAT);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(629);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(630);
				match(CHAR);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 6);
				{
				setState(631);
				match(STRING);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 7);
				{
				setState(632);
				match(SET);
				setState(637);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(633);
					match(LBRACE);
					setState(634);
					dataType();
					setState(635);
					match(RBRACE);
					}
				}

				}
				break;
			case SEQUENCE:
				enterOuterAlt(_localctx, 8);
				{
				setState(639);
				match(SEQUENCE);
				{
				setState(640);
				match(LBRACE);
				setState(641);
				dataType();
				setState(642);
				match(RBRACE);
				}
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 9);
				{
				setState(644);
				match(RECORD);
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(645);
					match(LBRACKET);
					setState(660);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==IDENTIFIER) {
						{
						{
						setState(646);
						match(IDENTIFIER);
						setState(651);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(647);
							match(COMMA);
							setState(648);
							match(IDENTIFIER);
							}
							}
							setState(653);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(654);
						match(COLON);
						setState(655);
						dataType();
						setState(656);
						match(SEMICOLON);
						}
						}
						setState(662);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(663);
					match(RBRACKET);
					}
				}

				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 10);
				{
				setState(666);
				match(ENUM);
				setState(679);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(667);
					match(LBRACE);
					setState(676);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIER) {
						{
						setState(668);
						match(IDENTIFIER);
						setState(673);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(669);
							match(COMMA);
							setState(670);
							match(IDENTIFIER);
							}
							}
							setState(675);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(678);
					match(RBRACE);
					}
				}

				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 11);
				{
				setState(681);
				((DataTypeContext)_localctx).i = match(IDENTIFIER);
				((CommonToken)((DataTypeContext)_localctx).i).setType (TYPE);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3s\u02b0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\2\3\2\7\2m\n\2\f\2\16\2p\13\2\3\2\3\2\7\2t\n\2\f\2\16\2"+
		"w\13\2\3\2\7\2z\n\2\f\2\16\2}\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3\u0088\n\3\3\3\3\3\3\3\3\3\3\3\7\3\u008f\n\3\f\3\16\3\u0092\13\3\3"+
		"\3\3\3\5\3\u0096\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5\u00a1\n\5"+
		"\f\5\16\5\u00a4\13\5\3\6\3\6\3\6\3\6\5\6\u00aa\n\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u00b7\n\7\f\7\16\7\u00ba\13\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\7\t\u00c2\n\t\f\t\16\t\u00c5\13\t\3\n\5\n\u00c8\n\n\3\n\3"+
		"\n\3\n\3\n\5\n\u00ce\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u00d5\n\13\f\13"+
		"\16\13\u00d8\13\13\3\13\3\13\3\f\3\f\3\f\7\f\u00df\n\f\f\f\16\f\u00e2"+
		"\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ec\n\r\3\r\3\r\3\r\3\r\7"+
		"\r\u00f2\n\r\f\r\16\r\u00f5\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u0101\n\16\f\16\16\16\u0104\13\16\3\16\3\16\3\17\3\17"+
		"\5\17\u010a\n\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u0113\n\20\3"+
		"\20\3\20\3\20\3\20\5\20\u0119\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u0122\n\21\f\21\16\21\u0125\13\21\5\21\u0127\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u012f\n\21\3\21\3\21\3\21\5\21\u0134\n\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u013f\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\6\21\u0149\n\21\r\21\16\21\u014a\3\21\3\21\5"+
		"\21\u014f\n\21\3\22\6\22\u0152\n\22\r\22\16\22\u0153\3\23\3\23\7\23\u0158"+
		"\n\23\f\23\16\23\u015b\13\23\3\23\3\23\5\23\u015f\n\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u016b\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u0174\n\24\f\24\16\24\u0177\13\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0182\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u0196\n\27\3\27\3\27\3\27\3\30\6\30\u019c\n\30\r\30\16\30\u019d\3\30"+
		"\5\30\u01a1\n\30\3\31\5\31\u01a4\n\31\3\32\5\32\u01a7\n\32\3\33\3\33\3"+
		"\33\7\33\u01ac\n\33\f\33\16\33\u01af\13\33\3\34\3\34\3\35\3\35\3\35\5"+
		"\35\u01b6\n\35\3\36\3\36\5\36\u01ba\n\36\3\37\3\37\3\37\5\37\u01bf\n\37"+
		"\3 \3 \3 \5 \u01c4\n \3!\3!\3!\5!\u01c9\n!\3\"\3\"\3\"\5\"\u01ce\n\"\3"+
		"#\3#\3#\5#\u01d3\n#\3$\3$\3$\5$\u01d8\n$\3%\3%\3%\5%\u01dd\n%\3&\3&\3"+
		"&\5&\u01e2\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01ef\n"+
		"\'\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01f9\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0204"+
		"\n)\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\7,\u0211\n,\f,\16,\u0214\13,\3-\3"+
		"-\3-\3-\3.\3.\3.\3.\3.\5.\u021f\n.\3.\3.\3.\3.\3.\3.\5.\u0227\n.\3.\3"+
		".\3.\3.\5.\u022d\n.\3.\3.\3.\3.\5.\u0233\n.\3.\3.\3.\3.\3.\5.\u023a\n"+
		".\3.\3.\3.\5.\u023f\n.\5.\u0241\n.\3/\3/\5/\u0245\n/\3\60\3\60\3\61\3"+
		"\61\3\61\3\61\5\61\u024d\n\61\3\61\3\61\3\61\3\61\5\61\u0253\n\61\3\61"+
		"\5\61\u0256\n\61\3\62\3\62\3\62\3\62\5\62\u025c\n\62\3\62\3\62\3\62\3"+
		"\62\5\62\u0262\n\62\3\62\5\62\u0265\n\62\3\63\3\63\3\63\3\63\3\63\7\63"+
		"\u026c\n\63\f\63\16\63\u026f\13\63\5\63\u0271\n\63\3\63\3\63\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0280\n\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\7\64\u028c\n\64\f\64\16\64\u028f"+
		"\13\64\3\64\3\64\3\64\3\64\7\64\u0295\n\64\f\64\16\64\u0298\13\64\3\64"+
		"\5\64\u029b\n\64\3\64\3\64\3\64\3\64\3\64\7\64\u02a2\n\64\f\64\16\64\u02a5"+
		"\13\64\5\64\u02a7\n\64\3\64\5\64\u02aa\n\64\3\64\3\64\5\64\u02ae\n\64"+
		"\3\64\2\2\65\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdf\2\t\3\2\17\20\3\2GL\3\2PQ\3\2RU\3\2VW\3\2"+
		"XZ\4\2<<MM\2\u02ef\2h\3\2\2\2\4\u0080\3\2\2\2\6\u0099\3\2\2\2\b\u00a2"+
		"\3\2\2\2\n\u00a5\3\2\2\2\f\u00b3\3\2\2\2\16\u00bb\3\2\2\2\20\u00c3\3\2"+
		"\2\2\22\u00c7\3\2\2\2\24\u00cf\3\2\2\2\26\u00db\3\2\2\2\30\u00e5\3\2\2"+
		"\2\32\u00f8\3\2\2\2\34\u0109\3\2\2\2\36\u010f\3\2\2\2 \u014e\3\2\2\2\""+
		"\u0151\3\2\2\2$\u016a\3\2\2\2&\u016c\3\2\2\2(\u017a\3\2\2\2*\u0183\3\2"+
		"\2\2,\u0189\3\2\2\2.\u01a0\3\2\2\2\60\u01a3\3\2\2\2\62\u01a6\3\2\2\2\64"+
		"\u01a8\3\2\2\2\66\u01b0\3\2\2\28\u01b2\3\2\2\2:\u01b9\3\2\2\2<\u01bb\3"+
		"\2\2\2>\u01c0\3\2\2\2@\u01c5\3\2\2\2B\u01ca\3\2\2\2D\u01cf\3\2\2\2F\u01d4"+
		"\3\2\2\2H\u01d9\3\2\2\2J\u01de\3\2\2\2L\u01ee\3\2\2\2N\u01f8\3\2\2\2P"+
		"\u0203\3\2\2\2R\u0205\3\2\2\2T\u0208\3\2\2\2V\u020d\3\2\2\2X\u0215\3\2"+
		"\2\2Z\u0240\3\2\2\2\\\u0244\3\2\2\2^\u0246\3\2\2\2`\u0248\3\2\2\2b\u0257"+
		"\3\2\2\2d\u0266\3\2\2\2f\u02ad\3\2\2\2hi\7\3\2\2ij\7/\2\2jn\7=\2\2km\5"+
		"\4\3\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qu\5"+
		"\b\5\2rt\5\n\6\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v{\3\2\2\2wu\3"+
		"\2\2\2xz\5\32\16\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}"+
		"{\3\2\2\2~\177\7\2\2\3\177\3\3\2\2\2\u0080\u0087\7\4\2\2\u0081\u0082\7"+
		"\5\2\2\u0082\u0088\b\3\1\2\u0083\u0084\7\6\2\2\u0084\u0088\b\3\1\2\u0085"+
		"\u0086\7\7\2\2\u0086\u0088\b\3\1\2\u0087\u0081\3\2\2\2\u0087\u0083\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0095\7\64\2\2\u008a"+
		"\u008b\7:\2\2\u008b\u0090\5\6\4\2\u008c\u008d\7>\2\2\u008d\u008f\5\6\4"+
		"\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7;\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u008a\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097\u0098\7=\2\2\u0098\5\3\2\2\2\u0099\u009a\7/\2\2\u009a\u009b"+
		"\7\b\2\2\u009b\u009c\7/\2\2\u009c\7\3\2\2\2\u009d\u009e\5\22\n\2\u009e"+
		"\u009f\7=\2\2\u009f\u00a1\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\t\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a6\7\t\2\2\u00a6\u00a7\7/\2\2\u00a7\u00a9\7\66\2\2\u00a8"+
		"\u00aa\5\f\7\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ac\7\67\2\2\u00ac\u00ad\7:\2\2\u00ad\u00ae\5\20\t\2\u00ae"+
		"\u00af\5\24\13\2\u00af\u00b0\5\26\f\2\u00b0\u00b1\5\30\r\2\u00b1\u00b2"+
		"\7;\2\2\u00b2\13\3\2\2\2\u00b3\u00b8\5\16\b\2\u00b4\u00b5\7>\2\2\u00b5"+
		"\u00b7\5\16\b\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3"+
		"\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\r\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc"+
		"\5f\64\2\u00bc\u00bd\7/\2\2\u00bd\17\3\2\2\2\u00be\u00bf\5\22\n\2\u00bf"+
		"\u00c0\7=\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00be\3\2\2\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\21\3\2\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c6\u00c8\t\2\2\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\5f\64\2\u00ca\u00cd\7/\2\2\u00cb\u00cc\7G\2"+
		"\2\u00cc\u00ce\5\66\34\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\23\3\2\2\2\u00cf\u00d0\7\n\2\2\u00d0\u00d6\7:\2\2\u00d1\u00d2\5\66\34"+
		"\2\u00d2\u00d3\7=\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d5\u00d8"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d9\u00da\7;\2\2\u00da\25\3\2\2\2\u00db\u00dc\7\13\2"+
		"\2\u00dc\u00e0\7:\2\2\u00dd\u00df\5$\23\2\u00de\u00dd\3\2\2\2\u00df\u00e2"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3\u00e4\7;\2\2\u00e4\27\3\2\2\2\u00e5\u00eb\7\f\2\2"+
		"\u00e6\u00e7\7E\2\2\u00e7\u00e8\78\2\2\u00e8\u00e9\5\66\34\2\u00e9\u00ea"+
		"\79\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e6\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00f3\7:\2\2\u00ee\u00ef\5\66\34\2\u00ef\u00f0\7"+
		"=\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f6\u00f7\7;\2\2\u00f7\31\3\2\2\2\u00f8\u00f9\7\16\2\2\u00f9\u00fa"+
		"\7/\2\2\u00fa\u00fb\78\2\2\u00fb\u00fc\5\66\34\2\u00fc\u00fd\79\2\2\u00fd"+
		"\u00fe\7:\2\2\u00fe\u0102\5\b\5\2\u00ff\u0101\5\34\17\2\u0100\u00ff\3"+
		"\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7;\2\2\u0106\33\3\2\2\2"+
		"\u0107\u0108\7/\2\2\u0108\u010a\7<\2\2\u0109\u0107\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\5\36\20\2\u010c\u010d\7^\2\2"+
		"\u010d\u010e\5 \21\2\u010e\35\3\2\2\2\u010f\u0112\7\66\2\2\u0110\u0111"+
		"\7D\2\2\u0111\u0113\5\66\34\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2"+
		"\u0113\u0118\3\2\2\2\u0114\u0119\5\66\34\2\u0115\u0119\7\21\2\2\u0116"+
		"\u0119\7\22\2\2\u0117\u0119\7\23\2\2\u0118\u0114\3\2\2\2\u0118\u0115\3"+
		"\2\2\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011b\7\67\2\2\u011b\37\3\2\2\2\u011c\u011d\7/\2\2\u011d\u0126\7\66\2"+
		"\2\u011e\u0123\5\66\34\2\u011f\u0120\7>\2\2\u0120\u0122\5\66\34\2\u0121"+
		"\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u011e\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012e\7\67\2\2\u0129\u012a\7"+
		"E\2\2\u012a\u012b\78\2\2\u012b\u012c\5\66\34\2\u012c\u012d\79\2\2\u012d"+
		"\u012f\3\2\2\2\u012e\u0129\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130\u0133\7:\2\2\u0131\u0134\5\"\22\2\u0132\u0134\7\26\2\2\u0133"+
		"\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u014f\7;"+
		"\2\2\u0136\u0137\7\26\2\2\u0137\u014f\7=\2\2\u0138\u0139\7\24\2\2\u0139"+
		"\u014f\7=\2\2\u013a\u013b\7\25\2\2\u013b\u013e\78\2\2\u013c\u013f\7/\2"+
		"\2\u013d\u013f\7\62\2\2\u013e\u013c\3\2\2\2\u013e\u013d\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\79\2\2\u0141\u0142\7/\2"+
		"\2\u0142\u014f\7=\2\2\u0143\u0144\7C\2\2\u0144\u0145\7\26\2\2\u0145\u014f"+
		"\7=\2\2\u0146\u0148\7:\2\2\u0147\u0149\5\34\17\2\u0148\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014d\7;\2\2\u014d\u014f\3\2\2\2\u014e\u011c\3\2\2\2\u014e"+
		"\u0136\3\2\2\2\u014e\u0138\3\2\2\2\u014e\u013a\3\2\2\2\u014e\u0143\3\2"+
		"\2\2\u014e\u0146\3\2\2\2\u014f!\3\2\2\2\u0150\u0152\5\34\17\2\u0151\u0150"+
		"\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"#\3\2\2\2\u0155\u0159\7:\2\2\u0156\u0158\5$\23\2\u0157\u0156\3\2\2\2\u0158"+
		"\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015c\3\2"+
		"\2\2\u015b\u0159\3\2\2\2\u015c\u015e\7;\2\2\u015d\u015f\5&\24\2\u015e"+
		"\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u016b\3\2\2\2\u0160\u0161\5\22"+
		"\n\2\u0161\u0162\7=\2\2\u0162\u016b\3\2\2\2\u0163\u0164\5\66\34\2\u0164"+
		"\u0165\7=\2\2\u0165\u016b\3\2\2\2\u0166\u016b\5(\25\2\u0167\u016b\5*\26"+
		"\2\u0168\u016b\5,\27\2\u0169\u016b\7=\2\2\u016a\u0155\3\2\2\2\u016a\u0160"+
		"\3\2\2\2\u016a\u0163\3\2\2\2\u016a\u0166\3\2\2\2\u016a\u0167\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b%\3\2\2\2\u016c\u016d\7\r\2\2"+
		"\u016d\u0175\7:\2\2\u016e\u016f\7\66\2\2\u016f\u0170\5\66\34\2\u0170\u0171"+
		"\7\67\2\2\u0171\u0172\5$\23\2\u0172\u0174\3\2\2\2\u0173\u016e\3\2\2\2"+
		"\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178"+
		"\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\7;\2\2\u0179\'\3\2\2\2\u017a"+
		"\u017b\7\27\2\2\u017b\u017c\7\66\2\2\u017c\u017d\5\66\34\2\u017d\u017e"+
		"\7\67\2\2\u017e\u0181\5$\23\2\u017f\u0180\7\30\2\2\u0180\u0182\5$\23\2"+
		"\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182)\3\2\2\2\u0183\u0184\7"+
		"\32\2\2\u0184\u0185\7\66\2\2\u0185\u0186\5\66\34\2\u0186\u0187\7\67\2"+
		"\2\u0187\u0188\5$\23\2\u0188+\3\2\2\2\u0189\u018a\7\31\2\2\u018a\u0195"+
		"\7\66\2\2\u018b\u018c\5\16\b\2\u018c\u018d\7<\2\2\u018d\u018e\5\66\34"+
		"\2\u018e\u0196\3\2\2\2\u018f\u0190\5.\30\2\u0190\u0191\7=\2\2\u0191\u0192"+
		"\5\60\31\2\u0192\u0193\7=\2\2\u0193\u0194\5\62\32\2\u0194\u0196\3\2\2"+
		"\2\u0195\u018b\3\2\2\2\u0195\u018f\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198"+
		"\7\67\2\2\u0198\u0199\5$\23\2\u0199-\3\2\2\2\u019a\u019c\5\22\n\2\u019b"+
		"\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2"+
		"\2\2\u019e\u01a1\3\2\2\2\u019f\u01a1\5\66\34\2\u01a0\u019b\3\2\2\2\u01a0"+
		"\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1/\3\2\2\2\u01a2\u01a4\5\66\34"+
		"\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\61\3\2\2\2\u01a5\u01a7"+
		"\5\64\33\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\63\3\2\2\2\u01a8"+
		"\u01ad\5\66\34\2\u01a9\u01aa\7>\2\2\u01aa\u01ac\5\66\34\2\u01ab\u01a9"+
		"\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\65\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\58\35\2\u01b1\67\3\2\2\2\u01b2"+
		"\u01b5\5:\36\2\u01b3\u01b4\t\3\2\2\u01b4\u01b6\58\35\2\u01b5\u01b3\3\2"+
		"\2\2\u01b5\u01b6\3\2\2\2\u01b69\3\2\2\2\u01b7\u01ba\5<\37\2\u01b8\u01ba"+
		"\5Z.\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01ba;\3\2\2\2\u01bb\u01be"+
		"\5> \2\u01bc\u01bd\7^\2\2\u01bd\u01bf\5<\37\2\u01be\u01bc\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf=\3\2\2\2\u01c0\u01c3\5@!\2\u01c1\u01c2\7_\2\2\u01c2"+
		"\u01c4\5> \2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4?\3\2\2\2\u01c5"+
		"\u01c8\5B\"\2\u01c6\u01c7\7N\2\2\u01c7\u01c9\5@!\2\u01c8\u01c6\3\2\2\2"+
		"\u01c8\u01c9\3\2\2\2\u01c9A\3\2\2\2\u01ca\u01cd\5D#\2\u01cb\u01cc\7O\2"+
		"\2\u01cc\u01ce\5B\"\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ceC\3"+
		"\2\2\2\u01cf\u01d2\5F$\2\u01d0\u01d1\t\4\2\2\u01d1\u01d3\5D#\2\u01d2\u01d0"+
		"\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3E\3\2\2\2\u01d4\u01d7\5H%\2\u01d5\u01d6"+
		"\t\5\2\2\u01d6\u01d8\5F$\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"G\3\2\2\2\u01d9\u01dc\5J&\2\u01da\u01db\t\6\2\2\u01db\u01dd\5H%\2\u01dc"+
		"\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01ddI\3\2\2\2\u01de\u01e1\5L\'\2\u01df"+
		"\u01e0\t\7\2\2\u01e0\u01e2\5J&\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2"+
		"\2\u01e2K\3\2\2\2\u01e3\u01e4\7[\2\2\u01e4\u01ef\5L\'\2\u01e5\u01e6\7"+
		"\\\2\2\u01e6\u01ef\5L\'\2\u01e7\u01e8\7W\2\2\u01e8\u01ef\5L\'\2\u01e9"+
		"\u01ea\7V\2\2\u01ea\u01ef\5L\'\2\u01eb\u01ec\7]\2\2\u01ec\u01ef\5L\'\2"+
		"\u01ed\u01ef\5N(\2\u01ee\u01e3\3\2\2\2\u01ee\u01e5\3\2\2\2\u01ee\u01e7"+
		"\3\2\2\2\u01ee\u01e9\3\2\2\2\u01ee\u01eb\3\2\2\2\u01ee\u01ed\3\2\2\2\u01ef"+
		"M\3\2\2\2\u01f0\u01f9\5P)\2\u01f1\u01f9\5R*\2\u01f2\u01f9\5^\60\2\u01f3"+
		"\u01f9\5`\61\2\u01f4\u01f5\7\66\2\2\u01f5\u01f6\58\35\2\u01f6\u01f7\7"+
		"\67\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f0\3\2\2\2\u01f8\u01f1\3\2\2\2\u01f8"+
		"\u01f2\3\2\2\2\u01f8\u01f3\3\2\2\2\u01f8\u01f4\3\2\2\2\u01f9O\3\2\2\2"+
		"\u01fa\u0204\7/\2\2\u01fb\u0204\5T+\2\u01fc\u0204\7\62\2\2\u01fd\u0204"+
		"\7\63\2\2\u01fe\u0204\7\64\2\2\u01ff\u0204\7\65\2\2\u0200\u0204\7,\2\2"+
		"\u0201\u0204\7-\2\2\u0202\u0204\7.\2\2\u0203\u01fa\3\2\2\2\u0203\u01fb"+
		"\3\2\2\2\u0203\u01fc\3\2\2\2\u0203\u01fd\3\2\2\2\u0203\u01fe\3\2\2\2\u0203"+
		"\u01ff\3\2\2\2\u0203\u0200\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0202\3\2"+
		"\2\2\u0204Q\3\2\2\2\u0205\u0206\7/\2\2\u0206\u0207\7A\2\2\u0207S\3\2\2"+
		"\2\u0208\u0209\7/\2\2\u0209\u020a\7\66\2\2\u020a\u020b\5\64\33\2\u020b"+
		"\u020c\7\67\2\2\u020cU\3\2\2\2\u020d\u0212\5X-\2\u020e\u020f\7>\2\2\u020f"+
		"\u0211\5X-\2\u0210\u020e\3\2\2\2\u0211\u0214\3\2\2\2\u0212\u0210\3\2\2"+
		"\2\u0212\u0213\3\2\2\2\u0213W\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u0216"+
		"\7/\2\2\u0216\u0217\7<\2\2\u0217\u0218\5f\64\2\u0218Y\3\2\2\2\u0219\u021a"+
		"\7%\2\2\u021a\u021b\5V,\2\u021b\u021e\7+\2\2\u021c\u021f\5^\60\2\u021d"+
		"\u021f\5P)\2\u021e\u021c\3\2\2\2\u021e\u021d\3\2\2\2\u021f\u0220\3\2\2"+
		"\2\u0220\u0221\7C\2\2\u0221\u0222\5\66\34\2\u0222\u0241\3\2\2\2\u0223"+
		"\u0226\7&\2\2\u0224\u0225\7\'\2\2\u0225\u0227\b.\1\2\u0226\u0224\3\2\2"+
		"\2\u0226\u0227\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u0229\5V,\2\u0229\u022c"+
		"\7+\2\2\u022a\u022d\5^\60\2\u022b\u022d\5P)\2\u022c\u022a\3\2\2\2\u022c"+
		"\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\7C\2\2\u022f\u0230\5\66"+
		"\34\2\u0230\u0241\3\2\2\2\u0231\u0233\7:\2\2\u0232\u0231\3\2\2\2\u0232"+
		"\u0233\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0235\7(\2\2\u0235\u0236\5V,"+
		"\2\u0236\u0239\7+\2\2\u0237\u023a\5^\60\2\u0238\u023a\5P)\2\u0239\u0237"+
		"\3\2\2\2\u0239\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\7C\2\2\u023c"+
		"\u023e\5\66\34\2\u023d\u023f\7;\2\2\u023e\u023d\3\2\2\2\u023e\u023f\3"+
		"\2\2\2\u023f\u0241\3\2\2\2\u0240\u0219\3\2\2\2\u0240\u0223\3\2\2\2\u0240"+
		"\u0232\3\2\2\2\u0241[\3\2\2\2\u0242\u0245\5T+\2\u0243\u0245\7/\2\2\u0244"+
		"\u0242\3\2\2\2\u0244\u0243\3\2\2\2\u0245]\3\2\2\2\u0246\u0247\5d\63\2"+
		"\u0247_\3\2\2\2\u0248\u0249\7Y\2\2\u0249\u024c\5\\/\2\u024a\u024b\t\b"+
		"\2\2\u024b\u024d\7/\2\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d"+
		"\u0252\3\2\2\2\u024e\u024f\78\2\2\u024f\u0250\5\66\34\2\u0250\u0251\7"+
		"9\2\2\u0251\u0253\3\2\2\2\u0252\u024e\3\2\2\2\u0252\u0253\3\2\2\2\u0253"+
		"\u0255\3\2\2\2\u0254\u0256\5b\62\2\u0255\u0254\3\2\2\2\u0255\u0256\3\2"+
		"\2\2\u0256a\3\2\2\2\u0257\u0258\7Y\2\2\u0258\u025b\7/\2\2\u0259\u025a"+
		"\t\b\2\2\u025a\u025c\7/\2\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u0261\3\2\2\2\u025d\u025e\78\2\2\u025e\u025f\5\66\34\2\u025f\u0260\7"+
		"9\2\2\u0260\u0262\3\2\2\2\u0261\u025d\3\2\2\2\u0261\u0262\3\2\2\2\u0262"+
		"\u0264\3\2\2\2\u0263\u0265\5b\62\2\u0264\u0263\3\2\2\2\u0264\u0265\3\2"+
		"\2\2\u0265c\3\2\2\2\u0266\u0267\7:\2\2\u0267\u0270\b\63\1\2\u0268\u026d"+
		"\5\66\34\2\u0269\u026a\7>\2\2\u026a\u026c\5\66\34\2\u026b\u0269\3\2\2"+
		"\2\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u0271"+
		"\3\2\2\2\u026f\u026d\3\2\2\2\u0270\u0268\3\2\2\2\u0270\u0271\3\2\2\2\u0271"+
		"\u0272\3\2\2\2\u0272\u0273\7;\2\2\u0273e\3\2\2\2\u0274\u02ae\7\33\2\2"+
		"\u0275\u02ae\7\34\2\2\u0276\u02ae\7\35\2\2\u0277\u02ae\7\36\2\2\u0278"+
		"\u02ae\7\37\2\2\u0279\u02ae\7 \2\2\u027a\u027f\7!\2\2\u027b\u027c\7:\2"+
		"\2\u027c\u027d\5f\64\2\u027d\u027e\7;\2\2\u027e\u0280\3\2\2\2\u027f\u027b"+
		"\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u02ae\3\2\2\2\u0281\u0282\7\"\2\2\u0282"+
		"\u0283\7:\2\2\u0283\u0284\5f\64\2\u0284\u0285\7;\2\2\u0285\u02ae\3\2\2"+
		"\2\u0286\u029a\7#\2\2\u0287\u0296\78\2\2\u0288\u028d\7/\2\2\u0289\u028a"+
		"\7>\2\2\u028a\u028c\7/\2\2\u028b\u0289\3\2\2\2\u028c\u028f\3\2\2\2\u028d"+
		"\u028b\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u0290\3\2\2\2\u028f\u028d\3\2"+
		"\2\2\u0290\u0291\7<\2\2\u0291\u0292\5f\64\2\u0292\u0293\7=\2\2\u0293\u0295"+
		"\3\2\2\2\u0294\u0288\3\2\2\2\u0295\u0298\3\2\2\2\u0296\u0294\3\2\2\2\u0296"+
		"\u0297\3\2\2\2\u0297\u0299\3\2\2\2\u0298\u0296\3\2\2\2\u0299\u029b\79"+
		"\2\2\u029a\u0287\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u02ae\3\2\2\2\u029c"+
		"\u02a9\7$\2\2\u029d\u02a6\7:\2\2\u029e\u02a3\7/\2\2\u029f\u02a0\7>\2\2"+
		"\u02a0\u02a2\7/\2\2\u02a1\u029f\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1"+
		"\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a7\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6"+
		"\u029e\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02aa\7;"+
		"\2\2\u02a9\u029d\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ae\3\2\2\2\u02ab"+
		"\u02ac\7/\2\2\u02ac\u02ae\b\64\1\2\u02ad\u0274\3\2\2\2\u02ad\u0275\3\2"+
		"\2\2\u02ad\u0276\3\2\2\2\u02ad\u0277\3\2\2\2\u02ad\u0278\3\2\2\2\u02ad"+
		"\u0279\3\2\2\2\u02ad\u027a\3\2\2\2\u02ad\u0281\3\2\2\2\u02ad\u0286\3\2"+
		"\2\2\u02ad\u029c\3\2\2\2\u02ad\u02ab\3\2\2\2\u02aeg\3\2\2\2Onu{\u0087"+
		"\u0090\u0095\u00a2\u00a9\u00b8\u00c3\u00c7\u00cd\u00d6\u00e0\u00eb\u00f3"+
		"\u0102\u0109\u0112\u0118\u0123\u0126\u012e\u0133\u013e\u014a\u014e\u0153"+
		"\u0159\u015e\u016a\u0175\u0181\u0195\u019d\u01a0\u01a3\u01a6\u01ad\u01b5"+
		"\u01b9\u01be\u01c3\u01c8\u01cd\u01d2\u01d7\u01dc\u01e1\u01ee\u01f8\u0203"+
		"\u0212\u021e\u0226\u022c\u0232\u0239\u023e\u0240\u0244\u024c\u0252\u0255"+
		"\u025b\u0261\u0264\u026d\u0270\u027f\u028d\u0296\u029a\u02a3\u02a6\u02a9"+
		"\u02ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}