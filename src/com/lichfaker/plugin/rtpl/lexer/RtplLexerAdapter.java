package com.lichfaker.plugin.rtpl.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by lichfaker on 16/5/10.
 */
public class RtplLexerAdapter extends FlexAdapter {

    public RtplLexerAdapter() {
        super(new RtplLexer((Reader) null));
    }
}
