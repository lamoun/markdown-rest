package com.lminaiev.markdown.service;

/**
 * Service provides parcing functionality
 *
 * @author Leonid Minaiev
 */
public interface ParserService {

    /**
     * Parses markdown text into HTML
     * @param lines lines of markdown text
     * @return HTML string of the lines
     */
    String parseLines(String[] lines);

}
