package com.murat.service;

import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Service
public class GooglePageProcessor implements PageProcessor {

    private Site site = Site.me();

    public void process(Page page) {
        page.getHtml();
    }

    public Site getSite() {
        return null;
    }
}
