package com.lminaiev.markdown.parser;

import java.util.function.Function;

/**
 * Abstract line parser
 *
 * @author Leonid Minaiev
 */
public abstract class Parser implements Function<String, String> {
    public abstract String apply(String s);
}
