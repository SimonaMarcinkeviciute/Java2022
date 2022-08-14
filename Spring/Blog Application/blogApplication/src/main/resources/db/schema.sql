CREATE TABLE ARTICLES (
    id VARCHAR(36) NOT NULL primary key,
    title VARCHAR(100) NOT NULL,
    image VARCHAR(450) NOT NULL,
    content VARCHAR(5000) NOT NULL,
    date VARCHAR(50) NOT NULL
    comment_id VARCHAR  (36) foreign key
);
