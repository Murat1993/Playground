package com.murat.controller.home;

import com.murat.controller.BaseController;
import com.murat.service.crawler.CrawlService;
import com.murat.service.parser.PageProcessService;
import com.murat.utils.AppInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
public class HomeController extends BaseController {
    private final static Logger LOG = LogManager.getLogger(HomeController.class);


    private PageProcessService pageProcessService;
    private CrawlService crawlService;

    @Autowired
    public HomeController(PageProcessService pageProcessService, CrawlService crawlService) {
        this.pageProcessService = pageProcessService;
        this.crawlService = crawlService;
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("panel/welcome/welcome");
        modelAndView.addObject("appName", AppInfo.APP_NAME)
                .addObject("appVersion", AppInfo.APP_VERSION);
        return modelAndView;
    }

    @RequestMapping(value = "/crawler", method = RequestMethod.GET)
    public ModelAndView crawler() {
        return new ModelAndView("content");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam String query) {
        ModelAndView modelAndView = new ModelAndView("result");

        String html = crawlService.performQuery(query);
        Map<String, String> result = pageProcessService.process(html);

        modelAndView.addObject("result", result);

        return new ModelAndView("result");
    }

}

