CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);


INSERT INTO users (login, email,password) VALUES ('john_doe', 'john@example.com','123');
INSERT INTO users (login, email,password) VALUES ('jane_doe', 'jane@example.com','123');
INSERT INTO users (login, email,password) VALUES ('artemmm', 'artemmm@example.com','12345');