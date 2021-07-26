INSERT INTO STUDENTE(ID, NOME, COGNOME, MAIL) VALUES
(1, 'Fabio', 'Indovino', 'fabio.indovino@mail.it'),
(2, 'Daniele', 'Di Gregorio', 'daniele.digregorio@mail.it'),
(3, 'Michelangelo', 'Mazzitelli', 'michelangelo.mazzitelli@mail.it'),
(4, 'Giuseppe', 'Raffa', 'giuseppe.raffa@mail.it'),
(5, 'Federico', 'Abruzzese', 'federico.abruzzese@mail.it'),
(6, 'Ramona', 'Di Fruscia', 'ramona.difruscia@mail.it'),
(7, 'Chanel', 'Boris', 'chanel.boris@mail.it'),
(8, 'Ruth', 'RoCa', 'ruth.roca@mail.it'),
(9, 'Amin', 'Iggoute', 'amin.iggoute@mail.it');

INSERT INTO CORSO(ID, NOME, DESCRIZIONE, CREDITI) VALUES
(1, 'Analisi', 'Matematica', 12),
(2, 'Fisica Generale', 'Fisica', 12),
(3, 'Fondamenti di informatica', 'Informatica', 6),
(4, 'Fondamenti di Telecomunicazioni', 'Reti di Telecomunicazioni', 6),
(5, 'Chimica Generale', 'Chimica', 6),
(6, 'Basi di Dati', 'Database', 6),
(7, 'Programmazione e laboratorio', 'Linguaggio Java' ,9),
(8, 'Calcolatori Elettronici', 'Calcolatori Elettronici', 9),
(9, 'Elettrotecnica', 'Elettrotecnica', 9),
(10, 'Elettronica', 'Elettronica', 9),
(11, 'Reti di Calcolatori', 'Reti di Telecomunicazioni', 9),
(12, 'Matematica applicata', 'Matematica', 9);

INSERT INTO CORSO_STUDENTE(STUDENTE_ID, CORSO_ID) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 12),
(4, 3),
(4, 12),
(4, 4);