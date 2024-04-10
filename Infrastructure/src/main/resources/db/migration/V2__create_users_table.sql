CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(45) NOT NULL UNIQUE,
                       password VARCHAR(64) NOT NULL,
                       first_name VARCHAR(20) NOT NULL,
                       last_name VARCHAR(20) NOT NULL
);

--  password is 123
INSERT INTO users (email, password, first_name, last_name) VALUES
                  ('john.doe@example.com', '$2a$10$96Ql8hlnY4yk3GbgnS04de0caq8aQQydqFYRFLZh83fS8x/g/qcSG', 'John', 'Doe'),
                  ('jane.doe@example.com', '$2a$10$96Ql8hlnY4yk3GbgnS04de0caq8aQQydqFYRFLZh83fS8x/g/qcSG', 'Jane', 'Doe');
