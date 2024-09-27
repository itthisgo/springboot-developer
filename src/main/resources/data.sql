INSERT INTO article (title, content, author, created_at, updated_at) VALUES ('제목1', '내용1', '작성자1', NOW(), NOW())
INSERT INTO article (title, content, author, created_at, updated_at) VALUES ('제목2', '내용2', '작성자2', NOW(), NOW())
INSERT INTO article (title, content, author, created_at, updated_at) VALUES ('제목3', '내용3', '작성자3', NOW(), NOW())

INSERT INTO comments (article_id, author, content, created_at) VALUES (1, 'user4', '댓글1', NOW())
INSERT INTO comments (article_id, author, content, created_at) VALUES (1, 'user5', '댓글2', NOW())
INSERT INTO comments (article_id, author, content, created_at) VALUES (2, 'user4', '댓글3', NOW())
