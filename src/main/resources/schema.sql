CREATE TABLE LIST
(
    id   IDENTITY     NOT NULL PRIMARY KEY,
    name VARCHAR(300) NOT NULL
);

CREATE TABLE TASK
(
    id          IDENTITY     NOT NULL PRIMARY KEY,
    description VARCHAR(300) NOT NULL,
    done        BOOLEAN      NOT NULL DEFAULT FALSE,
    list        INT          NOT NULL DEFAULT 1,
    FOREIGN KEY (list) REFERENCES LIST (id)
);