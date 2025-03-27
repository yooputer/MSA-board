package org.yooputer.msabord.article.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.yooputer.msabord.article.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
