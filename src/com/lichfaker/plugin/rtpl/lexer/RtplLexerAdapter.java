package com.lichfaker.plugin.rtpl.lexer;

import com.intellij.lexer.FlexAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

/**
 * Created by lichfaker on 16/5/10.
 */
public class RtplLexerAdapter extends FlexAdapter {

    private static final int STATE_SHIFT = 5;
    private static final int STATE_MASK = (1 << STATE_SHIFT) - 1;
    static {
        assert (STATE_MASK << 1) <= BaseHtmlLexer.BASE_STATE_MASK;
    }

    private int myState = RtplLexer.YYINITIAL;

    public RtplLexerAdapter(final RtplLexer flexLexer) {
        this(flexLexer, false);
    }

    public RtplLexerAdapter(final RtplLexer flexLexer, final boolean conditionalCommentsSupport) {
        super(flexLexer);
        flexLexer.setConditionalCommentsSupport(conditionalCommentsSupport);
    }

    private void packState() {
        final RtplLexer flex = (RtplLexer)getFlex();
        myState = ((flex.yyprevstate() & STATE_MASK) << STATE_SHIFT) | (flex.yystate() & STATE_MASK);
    }

    private void handleState(final int initialState) {
        RtplLexer flex = (RtplLexer)getFlex();
        flex.yybegin(initialState & STATE_MASK);
        flex.pushState((initialState >> STATE_SHIFT) & STATE_MASK);
        packState();
    }

    public void start(@NotNull final CharSequence buffer, final int startOffset, final int endOffset, final int initialState) {
        super.start(buffer, startOffset, endOffset, initialState);
        handleState(initialState);
    }

    public int getState() {
        return myState;
    }

    public void advance() {
        super.advance();
        packState();
    }

}
