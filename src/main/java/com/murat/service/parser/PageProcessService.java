package com.murat.service.parser;

import java.util.Map;

public interface PageProcessService {
    Map<String, String> process(String rawHtml);
}
