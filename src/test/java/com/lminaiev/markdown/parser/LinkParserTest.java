package com.lminaiev.markdown.parser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link LinkParser}
 */
public class LinkParserTest {
    private Parser parser = new LinkParser();

    @Test
    public void shoudConvertToLink() throws Exception {
        String source = "aaa [text](href)";
        String expected = "aaa <a href='href'>text</a>";

        assertEquals(expected, parser.apply(source));

        source = "aaa [text]  (href)";
        expected = "aaa <a href='href'>text</a>";

        assertEquals(expected, parser.apply(source));
    }

    @Test
    public void shouldNotConvert() throws Exception {
        String source = "aaa [text] a(href)";
        assertEquals(source, parser.apply(source));

        source = "aaa [text] ahref)";
        assertEquals(source, parser.apply(source));
    }

}