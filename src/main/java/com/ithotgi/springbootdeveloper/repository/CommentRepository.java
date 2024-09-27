package com.ithotgi.springbootdeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ithotgi.springbootdeveloper.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
