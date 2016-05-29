package com.lichfaker.plugin.rtpl.parsing;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

/**
 * Created by lichfaker on 16/5/10.
 */
public interface RtplTokenType {

    IElementType XML_START_TAG_START = new RtplElementType("XML_START_TAG_START");
    IElementType XML_END_TAG_START = new RtplElementType("XML_END_TAG_START");
    IElementType XML_TAG_END = new RtplElementType("XML_TAG_END");
    IElementType XML_EMPTY_ELEMENT_END = new RtplElementType("XML_EMPTY_ELEMENT_END");
    IElementType XML_TAG_NAME = new RtplElementType("XML_TAG_NAME");
    IElementType XML_NAME = new RtplElementType("XML_NAME");
    IElementType XML_ATTRIBUTE_VALUE_TOKEN = new RtplElementType("XML_ATTRIBUTE_VALUE_TOKEN");
    IElementType XML_ATTRIBUTE_VALUE_START_DELIMITER = new RtplElementType("XML_ATTRIBUTE_VALUE_START_DELIMITER");
    IElementType XML_ATTRIBUTE_VALUE_END_DELIMITER = new RtplElementType("XML_ATTRIBUTE_VALUE_END_DELIMITER");
    IElementType XML_ATTRIBUTE_VALUE_JS_START = new RtplElementType("XML_ATTRIBUTE_VALUE_JS_START");
    IElementType XML_ATTRIBUTE_VALUE_JS_END = new RtplElementType("XML_ATTRIBUTE_VALUE_JS_END");
    IElementType XML_ATTRIBUTE_VALUE_JS_CONTENT = new RtplElementType("XML_ATTRIBUTE_VALUE_JS_CONTENT");
    IElementType JS_KEYWORDS = new RtplElementType("JS_KEYWORDS");
    IElementType JS_GLOBAL_VARIABLE = new RtplElementType("JS_GLOBAL_VARIABLE");

    IElementType XML_EQ = new RtplElementType("XML_EQ");
    IElementType XML_DATA_CHARACTERS = new RtplElementType("XML_DATA_CHARACTERS");
    IElementType XML_TAG_CHARACTERS = new RtplElementType("XML_TAG_CHARACTERS");
    IElementType XML_WHITE_SPACE = TokenType.WHITE_SPACE;

    IElementType XML_REAL_WHITE_SPACE = new RtplElementType("XML_WHITE_SPACE");

    IElementType XML_COMMENT_START = new RtplElementType("XML_COMMENT_START");
    IElementType XML_COMMENT_END = new RtplElementType("XML_COMMENT_END");
    IElementType XML_COMMENT_CHARACTERS = new RtplElementType("XML_COMMENT_CHARACTERS");
    IElementType XML_ENTITY_REF_TOKEN = new RtplElementType("XML_ENTITY_REF_TOKEN");
    IElementType TAG_WHITE_SPACE = new RtplElementType("TAG_WHITE_SPACE");
    IElementType XML_CHAR_ENTITY_REF = new RtplElementType("XML_CHAR_ENTITY_REF");
    IElementType XML_BAD_CHARACTER = new RtplElementType("XML_BAD_CHARACTER");
    IElementType XML_CONDITIONAL_COMMENT_START = new RtplElementType("CONDITIONAL_COMMENT_START");
    IElementType XML_CONDITIONAL_COMMENT_START_END = new RtplElementType("CONDITIONAL_COMMENT_START_END");
    IElementType XML_CONDITIONAL_COMMENT_END_START = new RtplElementType("CONDITIONAL_COMMENT_END_START");
    IElementType XML_CONDITIONAL_COMMENT_END = new RtplElementType("CONDITIONAL_COMMENT_END");

}
