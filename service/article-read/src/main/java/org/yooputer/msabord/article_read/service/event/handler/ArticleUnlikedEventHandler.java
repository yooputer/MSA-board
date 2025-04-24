package org.yooputer.msabord.article_read.service.event.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yooputer.msabord.article_read.repository.ArticleQueryModelRepository;
import org.yooputer.msabord.common.event.Event;
import org.yooputer.msabord.common.event.EventType;
import org.yooputer.msabord.common.event.payload.ArticleUnlikedEventPayload;

@Component
@RequiredArgsConstructor
public class ArticleUnlikedEventHandler implements EventHandler<ArticleUnlikedEventPayload> {
    private final ArticleQueryModelRepository articleQueryModelRepository;

    @Override
    public void handle(Event<ArticleUnlikedEventPayload> event) {
        articleQueryModelRepository.read(event.getPayload().getArticleId())
                .ifPresent(articleQueryModel -> {
                    articleQueryModel.updateBy(event.getPayload());
                    articleQueryModelRepository.update(articleQueryModel);
                });
    }

    @Override
    public boolean supports(Event<ArticleUnlikedEventPayload> event) {
        return EventType.ARTICLE_UNLIKED == event.getType();
    }
}