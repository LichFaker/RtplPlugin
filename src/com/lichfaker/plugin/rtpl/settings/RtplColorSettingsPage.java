package com.lichfaker.plugin.rtpl.settings;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.lichfaker.plugin.rtpl.highlighter.RtplSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * @author lichfaker
 * @email lichfaker@gmail.com
 * @time 16/5/30
 */
public class RtplColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Tag", RtplSyntaxHighlighter.RTPL_XML_TAG),
            new AttributesDescriptor("Attribute", RtplSyntaxHighlighter.RTPL_XML_ATTRIBUTE),
            new AttributesDescriptor("String", RtplSyntaxHighlighter.RTPL_XML_STRING),
            new AttributesDescriptor("Js Keywords", RtplSyntaxHighlighter.RTPL_JS_KEYWORDS),
            new AttributesDescriptor("Js Variable", RtplSyntaxHighlighter.RTPL_JS_GLOBAL_VARIABLE),
    };

    private static final String text = "<Input type=\"hidden\" name=\"curPage\" ref=\"curPage\" value={curPage} />\n" +
            "<Template name=\"lastColumn\">\n" +
            "    <Action \n" +
            "      confirm={var content='viewContent';$getTemplate(content)}\n" +
            "      data={ {record:record} }>查看</Action>\n" +
            "</Template>";


    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new RtplSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return text;
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Rtpl";
    }
}
