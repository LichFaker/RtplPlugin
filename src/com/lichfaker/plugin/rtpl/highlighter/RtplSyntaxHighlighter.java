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
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;


/**
 * Created by lichfaker on 16/5/4.
 */
public class RtplSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Map<IElementType, TextAttributesKey> keys1;
    private static final RtplLexerAdapter lexer = new RtplLexerAdapter(new RtplLexer((Reader) null));

    // 标签颜色
    public static final TextAttributesKey RTPL_XML_TAG =
            createTextAttributesKey("RTPL_XML_TAG", XmlHighlighterColors.HTML_TAG);
    // 属性颜色
    public static final TextAttributesKey RTPL_XML_ATTRIBUTE =
            createTextAttributesKey("RTPL_XML_ATTRIBUTE", DefaultLanguageHighlighterColors.NUMBER);
    // 字符串颜色
    public static final TextAttributesKey RTPL_XML_STRING =
            createTextAttributesKey("RTPL_XML_STRING", DefaultLanguageHighlighterColors.STRING);
    // JS 关键字
    public static final TextAttributesKey RTPL_JS_KEYWORDS =
            createTextAttributesKey("RTPL_JS_KEYWORDS", DefaultLanguageHighlighterColors.KEYWORD);
    // JS 关键字
    public static final TextAttributesKey RTPL_JS_GLOBAL_VARIABLE =
            createTextAttributesKey("RTPL_JS_GLOBAL_VARIABLE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

    static {
        keys1 = new HashMap<IElementType, TextAttributesKey>();
        keys1.put(RtplTokenType.XML_COMMENT_START, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_COMMENT_END, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_COMMENT_CHARACTERS, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_CONDITIONAL_COMMENT_END, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_CONDITIONAL_COMMENT_END_START, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_CONDITIONAL_COMMENT_START, XmlHighlighterColors.HTML_COMMENT);
        keys1.put(RtplTokenType.XML_CONDITIONAL_COMMENT_START_END, XmlHighlighterColors.HTML_COMMENT);

        keys1.put(RtplTokenType.XML_START_TAG_START, RTPL_XML_TAG);
        keys1.put(RtplTokenType.XML_END_TAG_START, RTPL_XML_TAG);
        keys1.put(RtplTokenType.XML_TAG_END, RTPL_XML_TAG);
        keys1.put(RtplTokenType.XML_EMPTY_ELEMENT_END, RTPL_XML_TAG);
        keys1.put(RtplTokenType.XML_TAG_NAME, RTPL_XML_TAG);
        keys1.put(RtplTokenType.TAG_WHITE_SPACE, RTPL_XML_TAG);

        keys1.put(RtplTokenType.XML_NAME, RTPL_XML_ATTRIBUTE);

        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_TOKEN, RTPL_XML_STRING);
        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER, RTPL_XML_STRING);
        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER, RTPL_XML_STRING);
        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_JS_START, DefaultLanguageHighlighterColors.OPERATION_SIGN);
        keys1.put(RtplTokenType.XML_ATTRIBUTE_VALUE_JS_END, DefaultLanguageHighlighterColors.OPERATION_SIGN);
        keys1.put(RtplTokenType.JS_KEYWORDS, RTPL_JS_KEYWORDS);
        keys1.put(RtplTokenType.JS_GLOBAL_VARIABLE, RTPL_JS_GLOBAL_VARIABLE);
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

}
