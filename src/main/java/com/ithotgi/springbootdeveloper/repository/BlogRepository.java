package com.ithotgi.springbootdeveloper.repository;

import com.ithotgi.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
