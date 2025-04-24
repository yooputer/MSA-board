package org.yooputer.msabord.article_read.service.event.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yooputer.msabord.article_read.repository.ArticleIdListRepository;
import org.yooputer.msabord.article_read.repository.ArticleQueryModelRepository;
import org.yooputer.msabord.article_read.repository.BoardArticleCountRepository;
import org.yooputer.msabord.common.event.Event;
import org.yooputer.msabord.common.event.EventType;
import org.yooputer.msabord.common.event.payload.ArticleDeletedEventPayload;

@Component
@RequiredArgsConstructor
public class ArticleDeletedEventHandler implements EventHandler<ArticleDeletedEventPayload> {
    private final ArticleIdListRepository articleIdListRepository;
    private final ArticleQueryModelRepository articleQueryModelRepository;
    private final BoardArticleCountRepository boardArticleCountRepository;

    @Override
    public void handle(Event<ArticleDeletedEventPayload> event) {
        ArticleDeletedEventPayload payload = event.getPayload();
        articleIdListRepository.delete(payload.getBoardId(), payload.getArticleId());
        articleQueryModelRepository.delete(payload.getArticleId());
        boardArticleCountRepository.createOrUpdate(payload.getBoardId(), payload.getBoardArticleCount());
    }

    @Override
    public boolean supports(Event<ArticleDeletedEventPayload> event) {
        return EventType.ARTICLE_DELETED == event.getType();
    }
}