INSERT INTO institutions (name, mail, schedule, address, isAvailable) VALUES ('Camara  de Lisboa', 'lisboa@camaradelisboa.pt', 'from 10am to 8pm', 'Praca do Municipio', 1);
INSERT INTO institutions (name, mail, schedule, address, isAvailable) VALUES ('Caritas', 'caritas@doaratodos.pt', 'from 10am to 4pm', 'No Ceu', 1);
INSERT INTO institutions (name, mail, schedule, address, isAvailable) VALUES ('Unicef Portugal', 'unicef@uportugal.pt', 'from 9:30am to 6:30 pm', 'No outro ceu', 1);

INSERT INTO users (name, phone, mail, donations) VALUES ('Carolina', '123456789', 'carolina@donator.pt', 0);
INSERT INTO users (name, phone, mail, donations) VALUES ('Fritz', '987654321', 'fritz@anotherdonator.pt', 0);
INSERT INTO users (name, phone, mail, donations) VALUES ('Ruben', '123987456', 'ruben_doando@theactualdonator.pt', 0);
INSERT INTO users (name, phone, mail, donations) VALUES ('Miguel', '321456789', 'miguel@doandozin.pt', 0);

INSERT INTO giftees (name, age, description, institutions_id, users_id, status) VALUES ('Adriana',5,  'Little girl from Porto', 1, 3, 0);
INSERT INTO giftees (name, age, description, institutions_id, users_id, status) VALUES ('Ricardo',7,  'Little boy from Faro', 1, 3, 0);
INSERT INTO giftees (name, age, description, institutions_id, users_id, status) VALUES ('KarolG',4,  'Little girl from Avenida da Liberdade', 1, null, null);
INSERT INTO giftees (name, age, description, institutions_id, users_id, status) VALUES ('Maria',14,  'Little girl from Cascais', 2, null, null);
INSERT INTO giftees (name, age, description, institutions_id, users_id, status) VALUES ('Ana',9,  'Little girl from Coimbra', 3, null, null);
INSERT INTO giftees (name, age, description, institutions_id, users_id, status) VALUES ('João',4,  'Little boy from Beja', 3, null, null);
