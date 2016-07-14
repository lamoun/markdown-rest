package com.lminaiev.markdown.controller;

import com.lminaiev.markdown.entity.StatisticsRecord;
import com.lminaiev.markdown.repository.StatisticsRepository;
import com.lminaiev.markdown.service.ParserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * Rest controller for markdown to html convert and statistics
 *
 * @author Leonid Minaiev
 */
@RestController
public class MarkupController {

    private ParserService parcerService;
    private StatisticsRepository statisticsRepository;

    @Autowired
    public MarkupController(ParserService parserService, StatisticsRepository statisticsRepository) {
        this.parcerService = parserService;
        this.statisticsRepository = statisticsRepository;
    }

    @GetMapping(value = "/stats", produces = "application/json")
    @ResponseBody
    public List<StatisticsRecord> stats(){
        return statisticsRepository.getAllRecords();
    }

    @RequestMapping(value = "/convert", produces = "text/html;charset=UTF-8")
    public String convert(@RequestBody(required = false) String body) {
        String username = getAurhorizedUserName();
        String html = StringUtils.EMPTY;
        if (body != null) {
            html = parcerService.parseLines(body.split("\\r?\\n"));
        }
        html = wrapWithBody(html);
        StatisticsRecord record = new StatisticsRecord(username, new Date(), body, html);
        statisticsRepository.save(record);
        return html;
    }

    private String wrapWithBody(String html) {
        return String.format("<html>\r<body>\r%s\r</body>\r</html", html);
    }

    private String getAurhorizedUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
