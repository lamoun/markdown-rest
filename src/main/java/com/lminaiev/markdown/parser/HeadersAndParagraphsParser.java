package com.lminaiev.markdown.parser;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for header and paragraph lines
 *
 * @author Leonid Minaiev
 */
@Component
public class HeadersAndParagraphsParser extends Parser {
    private static Pattern HEADERS_PATTERN = Pattern.compile("^(#{1,6}[^#]).*$");

    @Override
    public String apply(String line) {
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
        return String.format("<h%d>%s</h%d>", depth, line.trim(), depth);
    }

    private String wrapWithParagrapf(String line) {
        return String.format("<p>%s</p>", line.trim());
    }

}
