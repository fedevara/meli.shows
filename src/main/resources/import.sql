-- TEATROS
INSERT INTO Teatro (id_teatro, nombre, direccion) VALUES (1,'Teatro Colon', 'Tucuman 1171 o Cerrito 628'),(2,'Teatro Gran Rex', 'Av. Corrientes 857');

-- SHOWS
INSERT INTO Show (id_Show, categoria, duracion, nombre, id_TeatroFK) VALUES (1, 'Drama 1', 145, 'Drama 1', 1),(2, 'Comedia 1', 60, 'Comedia 1', 2);

-- SALAS
INSERT INTO Sala (id_sala, id_teatroFK) VALUES (1, 1),(2, 2);

-- SECCION
INSERT INTO Seccion (id_seccion, precio, id_showFK) VALUES (1, 100, 1),(2, 200, 1),(3, 200, 2);

-- FUNCIONES
INSERT INTO Funcion (id_funcion, dia_horario, id_showFK,id_SalaFK) VALUES (1, '2021-09-10 10:00:00', 1, 1),(2, '2021-05-14 14:00:00', 2, 2);

-- BUTACAS
INSERT INTO Butaca (id_butaca, fila, posicion, id_seccionFK, id_salaFK) VALUES (1, 0, 1, 1, 1),(2, 0, 2, 2, 1),(3, 0, 3, 2, 2),(4, 0, 4, 2, 2),(5, 0, 5, 1, 1);

-- RESERVAS
INSERT INTO Reserva (id_funcionFK, nombre, documento, id_butacaFK, precio) VALUES (1, 'Federico', 12345678, 1, 100),(1, 'Bruno', 12345678, 2, 200);