package com.lminaiev.markdown.parser;

import com.lminaiev.markdown.model.Link;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for links
 *
 * @author Leonid Minaiev
 */
@Component
public class LinkParser extends Parser {
    private static Pattern LINK_PATTERN = Pattern.compile("\\[([^\\]]+)\\]\\s*\\(([^)]+)\\)");

    @Override
    public String apply(String line) {

        Matcher matcher = LINK_PATTERN.matcher(line);
        List<Link> links = new ArrayList<>();

        while (matcher.find()) {
            String fullLink = matcher.group();
            String text = matcher.group(1);
            String href = matcher.group(2);
            links.add(new Link(text, href, fullLink));
        }

        for (Link link : links) {
            line = line.replace(link.getSource(), link.toString());
        }
        return line;
    }
}
