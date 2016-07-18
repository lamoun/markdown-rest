package com.lminaiev.markdown.service.impl;

import com.lminaiev.markdown.parser.EmphasizeAndStrongParser;
import com.lminaiev.markdown.parser.HeadersAndParagraphsParser;
import com.lminaiev.markdown.parser.LinkParser;
import com.lminaiev.markdown.service.ParserService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

/**
 * Implementation for {@link ParserService}
 *
 *  @author Leonid Minaiev
 */
@Service
public class ParserServiceImpl implements ParserService {

    @Override
    public String parseLines(String[] lines) {
        Optional<String> parsedLines =  Arrays.stream(lines)
                .map(line -> Jsoup.parse(line.trim()).text()) //remove HTML tags
                .map(new HeadersAndParagraphsParser())
                .map(new LinkParser())
                .map(new EmphasizeAndStrongParser())
                .reduce((s, s2) -> s + "\r\n" + s2);

        return parsedLines.isPresent() ? parsedLines.get() : StringUtils.EMPTY;
    }

}
