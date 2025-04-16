package org.yooputer.msabord.hot_article.service.eventhandler;


import org.yooputer.msabord.common.event.Event;
import org.yooputer.msabord.common.event.EventPayload;

public interface EventHandler<T extends EventPayload> {
    void handle(Event<T> event);
    boolean supports(Event<T> event);
    Long findArticleId(Event<T> event);
}
