-- TEATROS
INSERT INTO Teatro (id_teatro, nombre, direccion) VALUES (1,'Teatro Colon', 'Cerrito 628'),(2,'Teatro Gran Rex', 'Av. Corrientes 857');

-- SHOWS
INSERT INTO Show (id_Show, categoria, duracion, nombre, id_TeatroFK) VALUES (1, 'Danza', 120, 'Ballet Programa Mixto', 1),(2, 'Concierto', 60, 'OETC - Concierto 10', 1);
INSERT INTO Show (id_Show, categoria, duracion, nombre, id_TeatroFK) VALUES (3, 'Concierto', 90, 'Nicki Nicole', 2),(4, 'Concierto', 90, 'Dalila', 2);

-- SALAS
INSERT INTO Sala (id_sala, id_teatroFK) VALUES (1, 1),(2, 2);

-- SECCION
INSERT INTO Seccion (id_seccion, precio, id_showFK) VALUES (1, 100, 1),(2, 150, 1);
INSERT INTO Seccion (id_seccion, precio, id_showFK) VALUES (3, 200, 2);
INSERT INTO Seccion (id_seccion, precio, id_showFK) VALUES (4, 500, 3);
INSERT INTO Seccion (id_seccion, precio, id_showFK) VALUES (5, 150, 4),(6, 250, 4);

-- FUNCIONES
INSERT INTO Funcion (id_funcion, dia_horario, id_showFK,id_SalaFK) VALUES (1, '2021-09-10 10:00:00', 1, 1);
INSERT INTO Funcion (id_funcion, dia_horario, id_showFK,id_SalaFK) VALUES (2, '2021-05-14 14:00:00', 2, 2);
INSERT INTO Funcion (id_funcion, dia_horario, id_showFK,id_SalaFK) VALUES (3, '2021-04-10 10:00:00', 3, 1);
INSERT INTO Funcion (id_funcion, dia_horario, id_showFK,id_SalaFK) VALUES (4, '2021-07-14 14:00:00', 4, 2);

-- BUTACAS
INSERT INTO Butaca (id_butaca, fila, posicion, id_seccionFK, id_salaFK) VALUES (1, 0, 1, 1, 1),(2, 0, 2, 2, 1),(3, 0, 3, 2, 2),(4, 0, 4, 2, 2),(5, 0, 5, 1, 1);

-- RESERVAS
INSERT INTO Reserva (id_funcionFK, nombre, documento, id_butacaFK, precio) VALUES (1, 'Federico', 12345678, 1, 100),(1, 'Bruno', 12345678, 2, 200);