package com.lminaiev.markdown.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Controller for pages
 */
@Controller
public class PageController {
    private static Logger LOG = Logger.getLogger(PageController.class);

    @RequestMapping(value = {"/login", "/"}, method = {RequestMethod.GET})
    public String loginPage(Model model) {
        model.addAttribute("title", "Login Page");
        return "login";
    }

    @RequestMapping(value = {"/test-rest"}, method = {RequestMethod.GET})
    public String welcomePage(Model model) {
        model.addAttribute("title", "REST Application Test Page");
        return "main";
    }
}
