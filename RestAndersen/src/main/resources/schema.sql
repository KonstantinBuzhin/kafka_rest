DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    id         BIGSERIAL                             NOT NULL,
    username   VARCHAR(255) UNIQUE                   NOT NULL,
    email      VARCHAR(255) UNIQUE                   NOT NULL,
    first_name VARCHAR(255)                          NOT NULL,
    last_name  VARCHAR(255)                          NOT NULL,
    password   VARCHAR(255)                          NOT NULL,
    created    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP NOT NULL,
    status     VARCHAR(25) DEFAULT 'ACTIVE'          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS roles (
    id      BIGSERIAL                             NOT NULL,
    name    VARCHAR(100) UNIQUE                   NOT NULL,
    created TIMESTAMP   DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated TIMESTAMP   DEFAULT CURRENT_TIMESTAMP NOT NULL,
    status  VARCHAR(25) DEFAULT 'ACTIVE'          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT,
    role_id BIGINT
);

ALTER TABLE user_roles ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE user_roles ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE;

