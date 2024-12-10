CREATE DATABASE moview;
USE moview;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255),
    duration INT,
    release_date DATE,
    genre VARCHAR(100),
    rating FLOAT,
    synopsis TEXT,
    poster_url VARCHAR(255),
    trailer_url VARCHAR(255),
    format VARCHAR(50)
);

CREATE TABLE projection (
    id INT AUTO_INCREMENT PRIMARY KEY,
    projection_date DATE NOT NULL,
    projection_time TIME NOT NULL,
    movie_id INT,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE
);

CREATE TABLE ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    space_code VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    is_used BOOLEAN DEFAULT FALSE,
    timestamp DATETIME NOT NULL,
    fk_user_id INT,
    fk_movie_id INT,
    FOREIGN KEY (fk_user_id) REFERENCES user(id),
    FOREIGN KEY (fk_movie_id) REFERENCES movies(id)
);

CREATE TABLE snack (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description TEXT,
    image VARCHAR(255)
);

CREATE TABLE card (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(16) NOT NULL,
    expiry_date VARCHAR(5) NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    holder_name VARCHAR(255) NOT NULL,
    fk_user_id INT,
    FOREIGN KEY (fk_user_id) REFERENCES user(id)
);

CREATE TABLE orden (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATETIME NOT NULL,
    total DOUBLE NOT NULL,
    status VARCHAR(50) NOT NULL,
    fk_user_id INT NOT NULL,
    fk_movie_id INT NOT NULL,
    fk_ticket_id INT NOT NULL,
    fk_snack_id INT,
    fk_card_id INT,
    FOREIGN KEY (fk_user_id) REFERENCES user(id),
    FOREIGN KEY (fk_movie_id) REFERENCES movies(id),
    FOREIGN KEY (fk_ticket_id) REFERENCES ticket(id),
    FOREIGN KEY (fk_snack_id) REFERENCES snack(id),
    FOREIGN KEY (fk_card_id) REFERENCES card(id)
);
