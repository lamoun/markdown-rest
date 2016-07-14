package com.lminaiev.markdown.parser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link HeadersAndParagraphsParser}
 */
public class HeadersAndParagraphsParserTest {
    private Parser parser = new HeadersAndParagraphsParser();

    @Test
    public void shouldWrapIntoParagraph() throws Exception {
        String source = "asd";
        String expected = "<p>asd</p>";

        assertEquals(expected, parser.apply(source));
    }

    @Test
    public void shouldNotWrapIntoParagraph_isStringIsEmpty() throws Exception {
        String source = "";
        String expected = "";

        assertEquals(expected, parser.apply(source));
    }

    @Test
    public void shouldWrapIntoHeaders() throws Exception {
        String source = "### asd";
        String expected = "<h3>asd</h3>";

        assertEquals(expected, parser.apply(source));
        source = "###### asd";
        expected = "<h6>asd</h6>";

        assertEquals(expected, parser.apply(source));
    }

}