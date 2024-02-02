CREATE SEQUENCE post_seq START 1;
CREATE SEQUENCE post_comment_seq START 1;

CREATE TABLE IF NOT EXISTS post
(
    id    int     NOT NULL PRIMARY KEY,
    title varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS post_comment
(
    id      int     NOT NULL PRIMARY KEY,
    review  varchar NOT NULL,
    post_id int,
    CONSTRAINT fk_post_comment_post_id FOREIGN KEY (post_id) REFERENCES post
);
