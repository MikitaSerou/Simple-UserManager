-- POSTGRES
create table role
(
    id   SMALLINT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) not null,
    PRIMARY KEY(id)
);


INSERT INTO role (name) VALUES ('ROLE_USER');

create table users
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY,
    role_id SMALLINT,
    user_name          VARCHAR(255),
    e_mail             VARCHAR(255),
    user_password      VARCHAR(255),
    registration_date  timestamp,
    last_login_date    timestamp,
    account_locked boolean,
    PRIMARY KEY(id),
    FOREIGN KEY(role_id)
        REFERENCES role(id)
);


INSERT INTO users (user_name, e_mail, user_password, registration_date, last_login_date, account_locked, role_id) VALUES ('Mikita', 'mikita.serou@gmail.com', '$2a$10$EyBjOAKzM8LMmpfzMSigeOv6TCYfPnejmRFVCvrhbiZp0.IOJLv4y', '2021-06-13 14:35:35', '2021-06-13 14:35:35', false, 1);
INSERT INTO users (user_name, e_mail, user_password, registration_date, last_login_date, account_locked, role_id) VALUES ('Vlad', 'Vlad@mail.ru', '$2a$10$gbvEAgvFjXUNNCdjRrgYHOg6H5HJP6Thm8jBQ4Z/L/xm8rsxEn2vi', '2021-06-13 14:35:59', '2021-06-13 14:35:59', false, 1);
INSERT INTO users (user_name, e_mail, user_password, registration_date, last_login_date, account_locked, role_id) VALUES ('Dmitry', 'Dmitry@gmail.com', '$2a$10$FN4.bqvXse7eZg3.uTFHw.7DZKSo8j1r7A9iw8VlJv8pi4lVTmvpC', '2021-06-13 14:36:24', '2021-06-13 14:36:24', true, 1);
INSERT INTO users (user_name, e_mail, user_password, registration_date, last_login_date, account_locked, role_id) VALUES ('Konstantin', 'Konstantin@gmail.com', '$2a$10$mzK6tfJ84BX6R3YAUWJaBO1EQW0z2JRMbmt8g66fvRMAhxI.Vo.A2', '2021-06-13 14:36:58', '2021-06-13 14:36:58', true, 1);
INSERT INTO users (user_name, e_mail, user_password, registration_date, last_login_date, account_locked, role_id) VALUES ('Anna', 'Anna@mail.ru', '$2a$10$62EiOZBlbflCidi7vCPUC./qp3GIeLljG4YCb/lqX4legl9dT5CeO', '2021-06-13 14:37:16', '2021-06-13 14:37:16', true, 1);
INSERT INTO users (user_name, e_mail, user_password, registration_date, last_login_date, account_locked, role_id) VALUES ('Maria', 'Maria@gmail.com', '$2a$10$Set/hBYWxQmPDUadjiiUv.BAyx3lbXli15dQhamRswhEDPDKzqfW.', '2021-06-13 14:37:35', '2021-06-13 14:37:35', true, 1);
INSERT INTO users (user_name, e_mail, user_password, registration_date, last_login_date, account_locked, role_id) VALUES ('Ksenia', 'Ksenia@gmail.com', '$2a$10$kWH74lrYIXtYmb.7rFPH8.Tzl/JkXocfHHPdyBu6WqqwSEWcAvDoy', '2021-06-13 14:37:51', '2021-06-13 14:37:51', true, 1);
