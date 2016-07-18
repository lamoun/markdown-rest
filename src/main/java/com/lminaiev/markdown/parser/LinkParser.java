package com.lminaiev.markdown.parser;

import com.lminaiev.markdown.model.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for links
 *
 * @author Leonid Minaiev
 */
public class LinkParser extends Parser {
    private static final Logger LOG = LoggerFactory.getLogger(LinkParser.class);
    private static Pattern LINK_PATTERN = Pattern.compile("\\[([^\\]]+)\\]\\s*\\(([^)]+)\\)");

    @Override
    public String apply(String line) {
        LOG.debug("Line applied: {}", line);
        Matcher matcher = LINK_PATTERN.matcher(line);
        List<Link> links = new ArrayList<>();

        while (matcher.find()) {
            String fullLink = matcher.group();
            String text = matcher.group(1);
            String href = matcher.group(2);

            LOG.debug("Link found: {}", fullLink);
            links.add(new Link(text, href, fullLink));
        }

        for (Link link : links) {
            line = line.replace(link.getSource(), link.toString());
        }
        LOG.debug("Line after parser applied: {}", line);
        return line;
    }
}
