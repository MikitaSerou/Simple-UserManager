create table role
(
    id   TINYINT auto_increment
        primary key,
    name VARCHAR(255) not null
);

INSERT INTO role (name) VALUES ('ROLE_USER');

create table user
(
    id                 BIGINT auto_increment
        primary key,
    user_name          VARCHAR(255) not null unique,
    e_mail             VARCHAR(255) not null unique,
    user_password      VARCHAR(255) not null,
    registration_date  DATETIME     not null,
    last_login_date    DATETIME,
    account_non_locked BOOLEAN      not null,
    role_id            TINYINT      not null,
    foreign key (role_id) references role (id)
);


