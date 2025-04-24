package org.yooputer.msabord.article_read.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.yooputer.msabord.article_read.service.ArticleReadService;
import org.yooputer.msabord.common.event.Event;
import org.yooputer.msabord.common.event.EventPayload;
import org.yooputer.msabord.common.event.EventType;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArticleReadEventConsumer {
    private final ArticleReadService articleReadService;

    @KafkaListener(topics = {
            EventType.Topic.MSA_BOARD_ARTICLE,
            EventType.Topic.MSA_BOARD_COMMENT,
            EventType.Topic.MSA_BOARD_LIKE
    })
    public void listen(String message, Acknowledgment ack) {
        log.info("[ArticleReadEventConsumer.listen] message={}", message);
        Event<EventPayload> event = Event.fromJson(message);
        if (event != null) {
            articleReadService.handleEvent(event);
        }
        ack.acknowledge();
    }
}