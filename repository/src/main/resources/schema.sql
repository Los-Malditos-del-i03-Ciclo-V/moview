DROP DATABASE IF EXISTS moview;
CREATE DATABASE moview;
USE moview;

CREATE TABLE movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255),
    synopsis TEXT,
    image VARCHAR(255),
    duration INT,
    description TEXT,
    classification VARCHAR(10),
    language VARCHAR(50),
    category VARCHAR(50),
    format VARCHAR(50)
);
