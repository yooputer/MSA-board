package org.yooputer.msabord.hot_article.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yooputer.msabord.hot_article.service.HotArticleService;
import org.yooputer.msabord.hot_article.service.response.HotArticleResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotArticleController {
    private final HotArticleService hotArticleService;

    @GetMapping("/v1/hot-articles/articles/date/{dateStr}")
    public List<HotArticleResponse> readAll(
            @PathVariable("dateStr") String dateStr
    ) {
        return hotArticleService.readAll(dateStr);
    }
}