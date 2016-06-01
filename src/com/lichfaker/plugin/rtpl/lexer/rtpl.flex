 /* It's an automatically generated code. Do not modify it. */
package com.lichfaker.plugin.rtpl.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.*;
import com.intellij.psi.xml.*;
import java.util.ArrayList;
import java.util.LinkedList;
import com.lichfaker.plugin.rtpl.parsing.RtplTokenType;

%%

%{
      private int yyline;
      private int yycolumn;

      private IElementType elTokenType = XML_DATA_CHARACTERS;
      private IElementType elTokenType2 = XML_ATTRIBUTE_VALUE_TOKEN;
      private IElementType javaEmbeddedTokenType = XML_ATTRIBUTE_VALUE_TOKEN;
      private boolean myConditionalCommentsSupport;

      public void setConditionalCommentsSupport(final boolean b) {
        myConditionalCommentsSupport = b;
      }

      public void setElTypes(IElementType _elTokenType,IElementType _elTokenType2) {
        elTokenType = _elTokenType;
        elTokenType2 = _elTokenType2;
      }

      public void setJavaEmbeddedType(IElementType _tokenType) {
        javaEmbeddedTokenType = _tokenType;
      }

      private int myPrevState = YYINITIAL;

      public int yyprevstate() {
        return myPrevState;
      }

      private int popState(){
        final int prev = myPrevState;
        myPrevState = YYINITIAL;
        return prev;
      }

      protected void pushState(int state){
        myPrevState = state;
      }

      // This adds support for nested states. I'm no JFlex pro, so maybe this is overkill, but it works quite well.
      private final LinkedList<Integer> states = new LinkedList<Integer>();

      private void yypushstate(int state) {
          states.addFirst(yystate());
          yybegin(state);
      }
      private void yypopstate() {
          final int state = states.removeFirst();
          yybegin(state);
      }

      private static final ArrayList<String> jsKeywords = new ArrayList<>();
      private static final ArrayList<String> jsFields = new ArrayList<>();

      static {
          jsKeywords.add("break");
          jsKeywords.add("case");
          jsKeywords.add("class");
          jsKeywords.add("catch");
          jsKeywords.add("const");
          jsKeywords.add("continue");
          jsKeywords.add("debugger");
          jsKeywords.add("default");
          jsKeywords.add("delete");
          jsKeywords.add("do");
          jsKeywords.add("else");
          jsKeywords.add("export");
          jsKeywords.add("extends");
          jsKeywords.add("finally");
          jsKeywords.add("for");
          jsKeywords.add("function");
          jsKeywords.add("import");
          jsKeywords.add("in");
          jsKeywords.add("instanceof");
          jsKeywords.add("let");
          jsKeywords.add("return");
          jsKeywords.add("super");
          jsKeywords.add("switch");
          jsKeywords.add("throw");
          jsKeywords.add("try");
          jsKeywords.add("typeof");
          jsKeywords.add("var");
          jsKeywords.add("while");
          jsKeywords.add("with");
          jsKeywords.add("yield");
          jsKeywords.add("enum");
          jsKeywords.add("await");
          jsKeywords.add("implements");
          jsKeywords.add("package");
          jsKeywords.add("protected");
          jsKeywords.add("private");
          jsKeywords.add("public");
          jsKeywords.add("static");
          jsKeywords.add("interface");
          jsKeywords.add("new");
          // 全局变量
          jsFields.add("Math");
          jsFields.add("Date");
          jsFields.add("this");
          jsFields.add("true");
          jsFields.add("false");
          jsFields.add("null");
          jsFields.add("undefined");
          jsFields.add("Infinity");
          jsFields.add("NaN");
          jsFields.add("JSON");
          jsFields.add("Object");
          jsFields.add("isNaN");
          jsFields.add("isFinite");
          jsFields.add("decodeURI");
          jsFields.add("decodeURIComponent");
          jsFields.add("encodeURI");
          jsFields.add("Array");
          jsFields.add("Number");
          jsFields.add("String");
          jsFields.add("encodeURIComponent");
          jsFields.add("parseInt");
          jsFields.add("parseFloat");
          jsFields.add("console");
      }

%}

%unicode
%class RtplLexer
%line
%column
%public
%implements FlexLexer, RtplTokenType
%function advance
%type IElementType


%state TAG
%state END_TAG
%xstate COMMENT
%state ATTR_LIST
%state ATTR
%state STATE_ATTR
%state STATE_DECALER_DQ
%state STATE_DECALER_JS
%state ATTR_VALUE_DQ
%state ATTR_VALUE_SQ
%state ATTR_VALUE_JS
%state GLOBAL_VARIABLE
%state C_COMMENT_START
%state C_COMMENT_END

ALPHA=[a-zA-Z]
DIGIT=[0-9]
WS=[\ \n\r\t\f]
S={WS}+

NAME=({ALPHA}|"_")({ALPHA}|{DIGIT}|"_"|".")*(":"({ALPHA}|"_")?({ALPHA}|{DIGIT}|"_"|".")*)?
END_COMMENT="-->"
CONDITIONAL_COMMENT_CONDITION=({ALPHA})({ALPHA}|{S}|{DIGIT}|"."|"("|")"|"|"|"!"|"&")*

%%

"<!--" { yybegin(COMMENT); return XML_COMMENT_START; }
<COMMENT> {END_COMMENT} { yybegin(YYINITIAL); return XML_COMMENT_END; }
<COMMENT> [^\-]|(-[^\-]) { return XML_COMMENT_CHARACTERS; }
<COMMENT> [^] { return XML_BAD_CHARACTER; }

<C_COMMENT_START,C_COMMENT_END> {CONDITIONAL_COMMENT_CONDITION} { return XML_COMMENT_CHARACTERS; }
<C_COMMENT_START> [^] { yybegin(COMMENT); return XML_COMMENT_CHARACTERS; }
<C_COMMENT_START> "]>" { yybegin(COMMENT); return XML_CONDITIONAL_COMMENT_START_END; }
<C_COMMENT_START,C_COMMENT_END> {END_COMMENT} { yybegin(YYINITIAL); return XML_COMMENT_END; }
<C_COMMENT_END> "]" { yybegin(COMMENT); return XML_CONDITIONAL_COMMENT_END; }
<C_COMMENT_END> [^] { yybegin(COMMENT); return XML_COMMENT_CHARACTERS; }

"&lt;" |
"&gt;" |
"&apos;" |
"&quot;" |
"&nbsp;" |
"&amp;" |
"&#"{DIGIT}+";" |
"&#x"({DIGIT}|[a-fA-F])+";" { return XML_CHAR_ENTITY_REF; }
"&"{NAME}";" { return XML_ENTITY_REF_TOKEN; }

<YYINITIAL> "<" { yybegin(TAG); return XML_START_TAG_START; }
<TAG> {NAME} {
yybegin(ATTR_LIST); pushState(TAG);
return XML_TAG_NAME;
 }
<TAG> "/>" { yybegin(YYINITIAL); return XML_EMPTY_ELEMENT_END; }
<TAG> ">" { yybegin(YYINITIAL); return XML_TAG_END; }

<YYINITIAL> "</" { yybegin(END_TAG); return XML_END_TAG_START; }
<END_TAG> {NAME} { return XML_TAG_NAME; }
<END_TAG> ">" { yybegin(YYINITIAL); return XML_TAG_END; }

<ATTR_LIST> {NAME} {
if ("declare".equals(yytext().toString())) {
    yybegin(STATE_ATTR);
}
else {yybegin(ATTR); }
return XML_NAME;
}
<ATTR> "=" { return XML_EQ;}
<ATTR> "'" { yybegin(ATTR_VALUE_SQ); return XML_ATTRIBUTE_VALUE_START_DELIMITER;}
<ATTR> "\"" { yybegin(ATTR_VALUE_DQ); return XML_ATTRIBUTE_VALUE_START_DELIMITER;}
<ATTR> "{" { yypushstate(ATTR_VALUE_JS); return XML_ATTRIBUTE_VALUE_JS_START;}
<ATTR> [^\ \n\r\t\f] {yybegin(ATTR_LIST); yypushback(yylength()); }

<STATE_ATTR> "=" {return XML_EQ;}
<STATE_ATTR> "'" {yybegin(ATTR_VALUE_SQ); return XML_ATTRIBUTE_VALUE_START_DELIMITER;}
<STATE_ATTR> "\"" {yybegin(STATE_DECALER_DQ); return XML_ATTRIBUTE_VALUE_START_DELIMITER;}
<STATE_ATTR> "{" { yybegin(STATE_DECALER_JS); return XML_ATTRIBUTE_VALUE_JS_START;}
<STATE_ATTR> [^\ \n\r\t\f] {yybegin(ATTR_LIST); yypushback(yylength()); }

<ATTR_VALUE_DQ>{
  "\"" { yybegin(ATTR_LIST); return XML_ATTRIBUTE_VALUE_END_DELIMITER;}
  "{" { yypushstate(ATTR_VALUE_JS); return XML_ATTRIBUTE_VALUE_JS_START;}
  [^] { return XML_ATTRIBUTE_VALUE_TOKEN;}
}

<ATTR_VALUE_SQ>{
  "\"" { return XML_BAD_CHARACTER; }
  "'" { yybegin(ATTR_LIST); return XML_ATTRIBUTE_VALUE_END_DELIMITER;}
  [^] { return XML_ATTRIBUTE_VALUE_TOKEN;}
}

<ATTR_VALUE_JS>{
    "{" {yypushstate(ATTR_VALUE_JS); return XML_ATTRIBUTE_VALUE_JS_START;}
    "}" {yypopstate(); return XML_ATTRIBUTE_VALUE_JS_END;}
    "$" {yypushstate(GLOBAL_VARIABLE); return JS_GLOBAL_VARIABLE;}
    {NAME} {
String name = yytext().toString();
if (jsKeywords.contains(name)) {return JS_KEYWORDS;}
else if (jsFields.contains(name)) { return JS_GLOBAL_VARIABLE;}
else { return XML_ATTRIBUTE_VALUE_JS_CONTENT;}
}
    [^] { return XML_ATTRIBUTE_VALUE_JS_CONTENT;}
}

<GLOBAL_VARIABLE> {
    "{" {yypopstate();yypushstate(ATTR_VALUE_JS); return XML_ATTRIBUTE_VALUE_JS_START;}
    "}" {yypopstate(); yypopstate();return XML_ATTRIBUTE_VALUE_JS_END;}
    {NAME} {return JS_GLOBAL_VARIABLE;}
    [^] {yypopstate(); return XML_ATTRIBUTE_VALUE_JS_CONTENT; }
}

<STATE_DECALER_DQ> {
    "\"" {yybegin(ATTR_LIST); return XML_ATTRIBUTE_VALUE_END_DELIMITER;}
    \'([^\\\'\r\n]|\\[^\r\n])*(\')  { return XML_ATTRIBUTE_VALUE_JS_CONTENT;}
    "as" { return JS_KEYWORDS; }
    "from" { return JS_KEYWORDS; }
    [^] { return XML_ATTRIBUTE_VALUE_JS_CONTENT;}
}

<STATE_DECALER_JS> {
    "{"  {yypushstate(STATE_DECALER_JS); return XML_ATTRIBUTE_VALUE_JS_START;}
    "}"  {yypopstate(); return XML_ATTRIBUTE_VALUE_JS_END;}
    "as" { return JS_KEYWORDS; }
    "from" { return JS_KEYWORDS; }
    \'([^\\\'\r\n]|\\[^\r\n])*(\')  { return XML_ATTRIBUTE_VALUE_JS_CONTENT;}
    \"([^\\\"])*(\")  { return XML_ATTRIBUTE_VALUE_JS_CONTENT;}
    [^] { return XML_ATTRIBUTE_VALUE_JS_END;}
}

<YYINITIAL> {S} { return XML_REAL_WHITE_SPACE; }
<ATTR_LIST,ATTR,TAG,END_TAG> {S} { return XML_WHITE_SPACE; }
<YYINITIAL> ([^<&\$# \n\r\t\f]|(\\\$)|(\\#))* { return XML_DATA_CHARACTERS; }
<YYINITIAL> [^<&\ \n\r\t\f]|(\\\$)|(\\#) { return XML_DATA_CHARACTERS; }

<<EOF>> { yyline = 0; yycolumn = 0; return null;}

[^] { if(yystate() == YYINITIAL){
        return XML_BAD_CHARACTER;
      }
      else yybegin(popState()); yypushback(yylength());}