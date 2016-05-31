package com.lichfaker.plugin.rtpl.parsing;

import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.lichfaker.plugin.rtpl.file.RtplFileType;
import com.lichfaker.plugin.rtpl.impl.RtplPsiFileImpl;
import com.lichfaker.plugin.rtpl.lang.RtplLanguage;
import com.lichfaker.plugin.rtpl.lexer.RtplLexer;
import com.lichfaker.plugin.rtpl.lexer.RtplLexerAdapter;
import org.intellij.lang.plist.PListLanguage;
import org.jetbrains.annotations.NotNull;
import static com.intellij.psi.tree.TokenSet.create;

import java.io.Reader;

/**
 * @author lichfaker
 * @email lichfaker@gmail.com
 * @time 16/5/31
 */
public class RtplParserDefinition implements ParserDefinition {
    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new RtplLexerAdapter(new RtplLexer((Reader) null));
    }

    @Override
    public PsiParser createParser(Project project) {
        return new RtplParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return new IFileElementType(RtplLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return create(RtplTokenType.XML_WHITE_SPACE);
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return create(RtplTokenType.XML_COMMENT_CHARACTERS);
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return create(RtplTokenType.XML_ATTRIBUTE_VALUE_TOKEN);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        return null;
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new RtplPsiFileImpl(fileViewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        final Lexer lexer = createLexer(astNode.getPsi().getProject());
        return LanguageUtil.canStickTokensTogetherByLexer(astNode, astNode1, lexer);
    }
}
