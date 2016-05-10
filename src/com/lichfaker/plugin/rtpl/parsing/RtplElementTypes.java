package com.lichfaker.plugin.rtpl.parsing;

import com.intellij.psi.tree.IElementType;

/**
 * Created by lichfaker on 16/5/10.
 */
public interface RtplElementTypes {

    IElementType BLOCK_DECLARATION = new RtplElementType("BLOCK_DECLARATION");
    IElementType INSTRUCTION = new RtplElementType("INSTRUCTION");
    IElementType COMMENT = new RtplElementType("COMMENT");
    IElementType CONSTANT = new RtplElementType("CONSTANT");
    IElementType IDENTIFIER = new RtplElementType("IDENTIFIER");
    IElementType KEYWORD = new RtplElementType("KEYWORD");
    IElementType NEWLINE = new RtplElementType("NEWLINE");
    IElementType NUMBER = new RtplElementType("NUMBER");
    IElementType SPECIAL_SYMBOL = new RtplElementType("SPECIAL_SYMBOL");
    IElementType PLUGIN_CALL = new RtplElementType("PLUGIN_CALL");
    IElementType STRING = new RtplElementType("STRING");
    IElementType VALUE = new RtplElementType("VALUE");
    IElementType VARIABLE = new RtplElementType("VARIABLE");
    IElementType BAD_CHARACTER = new RtplElementType("BAD_CHARACTER");

}
