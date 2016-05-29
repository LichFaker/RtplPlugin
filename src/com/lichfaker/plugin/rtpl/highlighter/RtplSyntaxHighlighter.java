package com.lichfaker.plugin.rtpl.highlighter;

import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.XmlHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.lichfaker.plugin.rtpl.lexer.RtplLexer;
import com.lichfaker.plugin.rtpl.lexer.RtplLexerAdapter;
import com.lichfaker.plugin.rtpl.parsing.RtplTokenType;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.util.*;

/**
 * Created by lichfaker on 16/5/4.
 */
public class RtplSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<IElementType, TextAttributesKey> keys1;
    private static final RtplLexerAdapter lexer = new RtplLexerAdapter(new RtplLexer((Reader) null));

    static {
        keys1 = new HashMap<IElementType, TextAttributesKey>();
        keys1.put(RtplTokenType.XML_COMMENT_START, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_COMMENT_END, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_COMMENT_CHARACTERS, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_CONDITIONAL_COMMENT_END, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_CONDITIONAL_COMMENT_END_START, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_CONDITIONAL_COMMENT_START, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_CONDITIONAL_COMMENT_START_END, XmlHighlighterColors.HTML_COMMENT);

        keys1.put(RtplTokenType.XML_START_TAG_START, XmlHighlighterColors.HTML_TAG);
        keys1.put(RtplTokenType.XML_END_TAG_START, XmlHighlighterColors.HTML_TAG);
        keys1.put(RtplTokenType.XML_TAG_END, XmlHighlighterColors.HTML_TAG);
        keys1.put(RtplTokenType.XML_EMPTY_ELEMENT_END, XmlHighlighterColors.HTML_TAG);
        keys1.put(RtplTokenType.XML_TAG_NAME, XmlHighlighterColors.HTML_TAG);
        keys1.put(RtplTokenType.TAG_WHITE_SPACE, XmlHighlighterColors.HTML_TAG);

        keys1.put(RtplTokenType.XML_NAME, DefaultLanguageHighlighterColors.NUMBER);

        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_TOKEN, DefaultLanguageHighlighterColors.STRING);
        keys1.put(RtplTokenType.XML_TAG_CHARACTERS, XmlHighlighterColors.HTML_TAG);
        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER, DefaultLanguageHighlighterColors.STRING);
        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER, DefaultLanguageHighlighterColors.STRING);
        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_JS_START, DefaultLanguageHighlighterColors.OPERATION_SIGN);
        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_JS_END, DefaultLanguageHighlighterColors.OPERATION_SIGN);
        keys1.put(RtplTokenType.JS_KEYWORDS, JavaHighlightingColors.KEYWORD);
        keys1.put(RtplTokenType.JS_GLOBAL_VARIABLE, DefaultLanguageHighlighterColors.INSTANCE_FIELD);
        keys1.put(RtplTokenType.XML_EQ, DefaultLanguageHighlighterColors.OPERATION_SIGN);

        keys1.put(RtplTokenType.XML_BAD_CHARACTER, HighlighterColors.BAD_CHARACTER);
    }

    @Override
    @NotNull
    public Lexer getHighlightingLexer() {
        return lexer;
    }

    @Override
    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return SyntaxHighlighterBase.pack(XmlHighlighterColors.HTML_CODE, keys1.get(tokenType));
    }

    // ['area', 'base', 'br', 'col', 'embed', 'hr', 'img', 'input', 'keygen', 'link', 'menuitem', 'meta', 'param', 'source', 'track', 'wbr']
    private static final LinkedList<String> singleTags = new LinkedList<>();

    static {
        singleTags.addLast("area");
        singleTags.addLast("base");
        singleTags.addLast("br");
        singleTags.addLast("col");
        singleTags.addLast("embed");
        singleTags.addLast("hr");
        singleTags.addLast("img");
        singleTags.addLast("input");
        singleTags.addLast("keygen");
        singleTags.addLast("link");
        singleTags.addLast("menuitem");
        singleTags.addLast("meta");
        singleTags.addLast("param");
        singleTags.addLast("source");
        singleTags.addLast("track");
        singleTags.addLast("wbr");
    }

    private static final ArrayList<String> jsKeywords = new ArrayList<>();

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
        jsKeywords.add("Math");
        jsKeywords.add("Date");
        jsKeywords.add("this");
        jsKeywords.add("true");
        jsKeywords.add("false");
        jsKeywords.add("null");
        jsKeywords.add("undefined");
        jsKeywords.add("Infinity");
        jsKeywords.add("NaN");
        jsKeywords.add("JSON");
        jsKeywords.add("Object");
        jsKeywords.add("isNaN");
        jsKeywords.add("isFinite");
        jsKeywords.add("decodeURI");
        jsKeywords.add("decodeURIComponent");
        jsKeywords.add("encodeURI");
        jsKeywords.add("Array");
        jsKeywords.add("Number");
        jsKeywords.add("String");
        jsKeywords.add("encodeURIComponent");
        jsKeywords.add("parseInt");
        jsKeywords.add("parseFloat");
        jsKeywords.add("console");
    }

//
//    private boolean isSingleTag(String tag) {
//        return singleTags.contains(tag);
//    }
//
//    Stack<Map.Entry<String, Boolean>> mCurTag = new Stack<>();
//
//    private boolean addTag(String tag) {
//        boolean flag = true;
//        if (!mCurTag.isEmpty()) {
//            Map.Entry<String, Boolean> last = mCurTag.peek();
//            flag = last.getValue();
//        }
//        Map.Entry<String, Boolean> entry = new AbstractMap.SimpleEntry<String, Boolean>(tag, false);
//        mCurTag.push(entry);
//        return flag;
//    }
//
//    private void closeTag() {
//        if (!mCurTag.isEmpty()) {
//            Map.Entry<String, Boolean> last = mCurTag.peek();
//            last.setValue(true);
//        }
//    }
//
//    private boolean removeTag(String tag) {
//        if (mCurTag.isEmpty()) {
//            return false;
//        }
//        Map.Entry<String, Boolean> entry = mCurTag.peek();
//        String key = entry.getKey();
//        boolean val = entry.getValue();
//        if (tag == null) {
//            if (isSingleTag(key)) {
//                mCurTag.pop();
//            } else if (val) {
//                return false;
//            } else {
//                entry.setValue(true);
//            }
//        } else {
//            if (key.equals(tag)) {
//                if (val) {
//                    mCurTag.pop();
//                } else {
//                    return false;
//                }
//            } else {
//                mCurTag.pop();
//                return false;
//            }
//        }
//        return true;
//    }
}
