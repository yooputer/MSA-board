package org.yooputer.msabord.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yooputer.msabord.like.entity.ArticleLike;

import java.util.Optional;

public interface ArticleLikeRepository extends JpaRepository<ArticleLike, Long> {
    Optional<ArticleLike> findByArticleIdAndUserId(Long articleId, Long userId);
}
