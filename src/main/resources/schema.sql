DROP TABLE IF EXISTS Teatro;
DROP TABLE IF EXISTS Show;
DROP TABLE IF EXISTS Seccion;
DROP TABLE IF EXISTS Sala;
DROP TABLE IF EXISTS Butaca;
DROP TABLE IF EXISTS Funcion;
DROP TABLE IF EXISTS Reserva;

CREATE TABLE Teatro (
  idTeatro      INT AUTO_INCREMENT  PRIMARY KEY,
  nombre        VARCHAR(250) NOT NULL
);

CREATE TABLE Show (
  idShow        INT AUTO_INCREMENT  PRIMARY KEY,
  nombre        VARCHAR(250) NOT NULL,
  categoria     INT NOT NULL,
  duracion      INT NOT NULL,
  idTeatroFK    INT NOT NULL,
  foreign key (idTeatroFK) references Teatro(idTeatro)
);

CREATE TABLE Seccion (
  idSeccion     INT AUTO_INCREMENT  PRIMARY KEY,
  idShowFK      INT NOT NULL,
  precio        INT NOT NULL,
  foreign key (idShowFK) references Show(idShow)
);

CREATE TABLE Sala (
  idSala        INT AUTO_INCREMENT  PRIMARY KEY,
  idTeatroFK    INT NOT NULL,
  foreign key (idTeatroFK) references Teatro(idTeatro)
);

CREATE TABLE Butaca (
  idButaca      INT AUTO_INCREMENT  PRIMARY KEY,
  nombre        VARCHAR(250) NOT NULL,
  fila          INT NOT NULL,
  posicion      INT NOT NULL,
  idSeccionFK   VARCHAR(250) NOT NULL,
  idSalaFK      VARCHAR(250) NOT NULL,
  foreign key (idSeccionFK) references Seccion(idSeccion),
  foreign key (idSalaFK) references Sala(idSala)
);

CREATE TABLE Funcion (
  idFuncion     INT AUTO_INCREMENT  PRIMARY KEY,
  diaHorario    VARCHAR(250) NOT NULL,
  idShowFK      VARCHAR(250) NOT NULL,
  idSalaFK      VARCHAR(250) NOT NULL,
  foreign key (idShowFK) references Show(idShow),
  foreign key (idSalaFK) references Sala(idSala)
);

CREATE TABLE Reserva (
  idReserva     INT AUTO_INCREMENT  PRIMARY KEY,
  nombre        VARCHAR(250) NOT NULL,
  documento     INT NOT NULL,
  idSeccionFK   VARCHAR(250) NOT NULL,
  precio        VARCHAR(250) NOT NULL,
  foreign key (idSeccionFK) references Seccion(idSeccion)
);