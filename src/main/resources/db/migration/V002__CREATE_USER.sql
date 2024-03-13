create table if not exists tb_users
(
    id       BIGINT GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255),
    email     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled  BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id),
    UNIQUE (email)
)