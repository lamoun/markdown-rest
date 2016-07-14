package com.lminaiev.markdown.model;

/**
 * Bean for links
 *
 * @author Leonid Minaiev
 */
public class Link {
    private String text;
    private String href;
    private String source;

    public Link(String text, String href, String source) {
        this.text = text;
        this.href = href;
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public String getHref() {
        return href;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return String.format("<a href='%s'>%s</a>", href, text);
    }
}
