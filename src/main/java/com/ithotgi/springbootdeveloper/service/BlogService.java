package com.ithotgi.springbootdeveloper.service;

import com.ithotgi.springbootdeveloper.config.error.exception.ArticleNotFoundException;
import com.ithotgi.springbootdeveloper.domain.Article;
import com.ithotgi.springbootdeveloper.domain.Comment;
import com.ithotgi.springbootdeveloper.dto.AddArticleRequest;
import com.ithotgi.springbootdeveloper.dto.AddCommentRequest;
import com.ithotgi.springbootdeveloper.dto.UpdateArticleRequest;
import com.ithotgi.springbootdeveloper.repository.BlogRepository;
import com.ithotgi.springbootdeveloper.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    public Article save(AddArticleRequest request, String userName){

        return blogRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
    }

    public void delete(long id) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        authorizeArticleAuthor(article);
        blogRepository.delete(article);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());

        return article;
    }

    public Comment addComment(AddCommentRequest req, String userName){
        Article article = blogRepository.findById(req.getArticleId())
                .orElseThrow(() -> new IllegalArgumentException(("게시글 정보가 없음")));
        return commentRepository.save(req.toEntity(userName, article));
    }

    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!article.getAuthor().equals(userName)) {
            throw new IllegalArgumentException("not authorized");
        }
    }

}
