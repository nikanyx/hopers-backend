DROP DATABASE IF EXISTS untitled_orange_app;
CREATE DATABASE untitled_orange_app;
USE untitled_orange_app;

DROP TABLE IF EXISTS institutions;
CREATE TABLE institutions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    schedule VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    isAvailable BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    donations INT NOT NULL
);

DROP TABLE IF EXISTS giftees;
CREATE TABLE giftees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    description TEXT,
    institutions_id INT NOT NULL,
    users_id INT NOT NULL,
    status TINYINT NOT NULL
);

INSERT INTO institutions (name, mail, schedule, address, isAvailable)
VALUES ('Camara  de Lisboa', 'lisboa@camaradelisboa.pt', 'from 10am to 8pm', 'Praca do Municipio', 0),
       ('Caritas', 'caritas@doaratodos.pt', 'from 10am to 4pm', 'No Ceu', 1),
       ('Unicef Portugal', 'unicef@uportugal.pt', 'from 9:30am to 6:30 pm', 'No outro ceu', 0);


INSERT INTO users (name, phone, mail, donations)
VALUES ('Carolina', '123456789', 'carolina@donator.pt', 0),
       ('Fritz', '987654321', 'fritz@anotherdonator.pt', 0),
       ('Ruben', '123987456', 'ruben_doando@theactualdonator.pt', 0),
       ('Miguel', '321456789', 'miguel@doandozin.pt', 0);


INSERT INTO giftees (name, age, description, institutions_id, users_id, status)
VALUES('Adriana',5,  'Little girl from Porto', 1, 1, 0),
      ('Ricardo',7,  'Little boy from Faro', 1, 1, 0);