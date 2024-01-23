CREATE TABLE Users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       date_created DATETIME DEFAULT CURRENT_TIMESTAMP,
                       date_modified DATETIME ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Posts (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       body TEXT NOT NULL,
                       user_id INT NOT NULL,
                       date_created DATETIME DEFAULT CURRENT_TIMESTAMP,
                       date_modified DATETIME ON UPDATE CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE Categories (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            date_created DATETIME DEFAULT CURRENT_TIMESTAMP,
                            date_modified DATETIME ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Post_Categories (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 post_id INT NOT NULL,
                                 category_id INT NOT NULL,
                                 date_created DATETIME DEFAULT CURRENT_TIMESTAMP,
                                 date_modified DATETIME ON UPDATE CURRENT_TIMESTAMP,
                                 FOREIGN KEY (post_id) REFERENCES Posts(id),
                                 FOREIGN KEY (category_id) REFERENCES Categories(id)
);