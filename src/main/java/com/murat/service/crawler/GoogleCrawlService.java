package com.murat.service.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleCrawlService implements CrawlService {

    public String performQuery(String query) {
        if (query != null && query.length() > 0) {
            query = query.replaceAll("[ ]+", "+");
        }

        String url = "https://www.google.com/search?q=" + query + "&num" + "20";
        String rawHtml = "";

        Document document;
        try {
            document = Jsoup.connect(url).userAgent("Mozilla").timeout(5000).get();
            rawHtml = document.html();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rawHtml;
    }
}
