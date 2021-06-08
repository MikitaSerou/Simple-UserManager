create table user
(
    id            BIGINT auto_increment
        primary key,
    user_name     VARCHAR(255) not null unique,
    e_mail        VARCHAR(255) not null unique,
    user_password VARCHAR(255) not null,
    registration_date DATETIME not null,
    last_login_date DATETIME not null,
    active BOOLEAN not null
);
