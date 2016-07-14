package com.lminaiev.markdown.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for emphasized text and bold text fragments
 *
 * @author Leonid Minaiev
 */
public class EmphasizeAndStrongParser extends Parser {
    private static Pattern EM_PATTERN = Pattern.compile("(\\*{1,2})(.*?)\\1");

    @Override
    public String apply(String line) {

        Matcher matcher = EM_PATTERN.matcher(line);

        while (matcher.find()) {
            String textWithAsterics = matcher.group();
            String text = matcher.group(2);

            if (textWithAsterics.length() - text.length() == 2) {
                line = line.replace(textWithAsterics, wrapEm(text));
            } else if (textWithAsterics.length() - text.length() == 4) {
                line = line.replace(textWithAsterics, wrapStrong(text));
            }
        }

        return line;
    }

    private String wrapEm(String text) {
        return String.format("<em>%s</em>", text);
    }

    private String wrapStrong(String text) {
        return String.format("<strong>%s</strong>", text);
    }
}
