-- Insert scripts for the Users table
INSERT INTO Users (username, email, password) VALUES ('user1', 'user1@example.com', 'password1');
INSERT INTO Users (username, email, password) VALUES ('user2', 'user2@example.com', 'password2');
INSERT INTO Users (username, email, password) VALUES ('user3', 'user3@example.com', 'password3');
INSERT INTO Users (username, email, password) VALUES ('user4', 'user4@example.com', 'password4');
INSERT INTO Users (username, email, password) VALUES ('user5', 'user5@example.com', 'password5');

-- Insert scripts for the Posts table
INSERT INTO Posts (title, body, user_id) VALUES ('Post 1', 'Body of Post 1', 1);
INSERT INTO Posts (title, body, user_id) VALUES ('Post 2', 'Body of Post 2', 2);
INSERT INTO Posts (title, body, user_id) VALUES ('Post 3', 'Body of Post 3', 3);
INSERT INTO Posts (title, body, user_id) VALUES ('Post 4', 'Body of Post 4', 4);
INSERT INTO Posts (title, body, user_id) VALUES ('Post 5', 'Body of Post 5', 5);

-- Insert scripts for the Categories table
INSERT INTO Categories (name) VALUES ('Category 1');
INSERT INTO Categories (name) VALUES ('Category 2');
INSERT INTO Categories (name) VALUES ('Category 3');
INSERT INTO Categories (name) VALUES ('Category 4');
INSERT INTO Categories (name) VALUES ('Category 5');

-- Insert scripts for the Post_Categories table
INSERT INTO Post_Categories (post_id, category_id) VALUES (1, 1);
INSERT INTO Post_Categories (post_id, category_id) VALUES (2, 2);
INSERT INTO Post_Categories (post_id, category_id) VALUES (3, 3);
INSERT INTO Post_Categories (post_id, category_id) VALUES (4, 4);
INSERT INTO Post_Categories (post_id, category_id) VALUES (5, 5);
