package com.murat.service.parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GooglePageProcessService implements PageProcessService {

    private static Pattern patternDomainName;
    private static final String DOMAIN_NAME_PATTERN
            = "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}";
    static {
        patternDomainName = Pattern.compile(DOMAIN_NAME_PATTERN);
    }

    @Override
    public Map<String, String> process(String rawHtml) {
        Document document = Jsoup.parse(rawHtml);
        Elements elements = document.getElementsByClass("r");
        Map<String, String> result = new HashMap<>();

        for (Element element : elements) {
            result.put(element.getElementsByTag("h3").text(),
                    parseDomainName(String.valueOf(element.getElementsByAttribute("href"))));
        }

        return result;
    }

    public String parseDomainName(String url) {
        if (url == null || url.length() == 0) {
            return "";
        }
        Matcher matcher = patternDomainName.matcher(url);
        return matcher.find() ? matcher.group(0).toLowerCase().trim() : "";
    }
}
