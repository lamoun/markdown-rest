package com.lminaiev.markdown.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for emphasized text and bold text fragments
 *
 * @author Leonid Minaiev
 */
public class EmphasizeAndStrongParser extends Parser {
    private static final Logger LOG = LoggerFactory.getLogger(EmphasizeAndStrongParser.class);
    private static final Pattern EM_PATTERN = Pattern.compile("(\\*{1,2})(.*?)\\1");

    @Override
    public String apply(String line) {
        LOG.debug("Line applied: {}", line);
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
        LOG.debug("Line after applying parser: {}", line);
        return line;
    }

    private String wrapEm(String text) {
        String result = String.format("<em>%s</em>", text);
        LOG.debug("Fragment wrapped to emphasized, result: {}", result);
        return result;
    }

    private String wrapStrong(String text) {
        String result = String.format("<strong>%s</strong>", text);
        LOG.debug("Fragment wrapped to strong, result: {}", result);
        return result;
    }
}
