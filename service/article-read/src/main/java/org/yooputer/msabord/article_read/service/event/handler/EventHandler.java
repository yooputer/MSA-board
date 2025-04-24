package org.yooputer.msabord.article_read.service.event.handler;


import org.yooputer.msabord.common.event.Event;
import org.yooputer.msabord.common.event.EventPayload;

public interface EventHandler<T extends EventPayload> {
    void handle(Event<T> event);
    boolean supports(Event<T> event);
}