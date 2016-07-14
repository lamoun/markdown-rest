package com.lminaiev.markdown.parser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link EmphasizeAndStrongParser}
 */
public class EmphasizeAndStrongParserTest {
    private Parser parser = new EmphasizeAndStrongParser();

    @Test
    public void shouldConvertToStrong() throws Exception {
        String source = "some str **strong**";
        String expected = "some str <strong>strong</strong>";

        assertEquals(expected, parser.apply(source));
    }

}