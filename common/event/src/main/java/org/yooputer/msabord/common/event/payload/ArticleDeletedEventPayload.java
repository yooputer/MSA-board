package org.yooputer.msabord.common.event.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yooputer.msabord.common.event.EventPayload;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDeletedEventPayload implements EventPayload {
    private Long articleId;
    private String title;
    private String content;
    private Long boardId;
    private Long writerId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long boardArticleCount;
}
