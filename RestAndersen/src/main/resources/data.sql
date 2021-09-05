INSERT INTO roles(name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

INSERT INTO users(username, email, first_name, last_name, password)
VALUES ('admin', 'admin@admin', 'admin', 'admin', '$2a$04$v85QGlQ6afGKhqX9J7OCGudQh7Ppdt97sbyQ8mT2NfNaMVRbTv8.u');

INSERT INTO user_roles(user_id, role_id)
VALUES (1, 1);