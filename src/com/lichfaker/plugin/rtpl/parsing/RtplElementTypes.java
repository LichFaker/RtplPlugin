package com.lichfaker.plugin.rtpl.parsing;

import com.intellij.psi.tree.IElementType;

/**
 * Created by lichfaker on 16/5/10.
 */
public interface RtplElementTypes {

    IElementType COMMENT = new RtplElementType("COMMENT");
    IElementType NEWLINE = new RtplElementType("NEWLINE");
    IElementType ATTRIBUTATE = new RtplElementType("ATTRIBUTATE");
    IElementType STRING = new RtplElementType("STRING");
    IElementType SYMBOL = new RtplElementType("SYMBOL");
    IElementType CONSTANT = new RtplElementType("CONSTANT");
    IElementType KEYWORD = new RtplElementType("KEYWORD");
    IElementType NUMBER = new RtplElementType("NUMBER");
    IElementType SPECIAL_SYMBOL = new RtplElementType("SPECIAL_SYMBOL");
    IElementType VALUE = new RtplElementType("VALUE");
    IElementType VARIABLE = new RtplElementType("VARIABLE");
    IElementType BAD_CHARACTER = new RtplElementType("BAD_CHARACTER");

}
