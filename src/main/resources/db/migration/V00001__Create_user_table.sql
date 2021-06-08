create table user
(
    id            BIGINT auto_increment
        primary key,
    user_name     VARCHAR(255) not null,
    e_mail        VARCHAR(255) not null,
    user_password VARCHAR(255) not null,
    registration_date DATETIME not null,
    last_login_date DATETIME not null,
    active DATETIME not null
);
