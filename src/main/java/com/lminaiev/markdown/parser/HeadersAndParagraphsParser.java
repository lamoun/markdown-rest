package com.lminaiev.markdown.parser;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for header and paragraph lines
 *
 * @author Leonid Minaiev
 */
public class HeadersAndParagraphsParser extends Parser {
    private static final Logger LOG = LoggerFactory.getLogger(HeadersAndParagraphsParser.class);
    private static final Pattern HEADERS_PATTERN = Pattern.compile("^(#{1,6}[^#]).*$");

    @Override
    public String apply(String line) {
        LOG.debug("Line applied: {}", line);
        String trimmedLine = line.trim();
        if (trimmedLine.isEmpty()) {
            return line;
        }

        Matcher matcher = HEADERS_PATTERN.matcher(trimmedLine);

        if (matcher.matches()) {
            int depth = 0;
            for (int i = 0; i < 6 || i < trimmedLine.length(); i++) {
                if (trimmedLine.charAt(i) == '#') {
                    depth++;
                } else {
                    break;
                }
            }
            return wrapWithHeader(trimmedLine.substring(depth, trimmedLine.length()), depth);
        } else {
            return wrapWithParagrapf(line);
        }
    }

    private String wrapWithHeader(String line, int depth) {
        String result = String.format("<h%d>%s</h%d>", depth, line.trim(), depth);
        LOG.debug("Wrapping with header, result line: {}", result);
        return result;
    }

    private String wrapWithParagrapf(String line) {
        String result = String.format("<p>%s</p>", line.trim());
        LOG.debug("Wrapping with paragraph, result line: {}", result);
        return result;

    }

}
