CREATE TABLE professor (
  id bigint not null AUTO_INCREMENT,
  nome varchar(500) not null,
  data_de_nascimento char(10),
  dia_de_pagamento smallint,
  area_ensino varchar(200),
  carga_horaria_diaria smallint,
  salario_hora double,
  cpf char(11) not null unique,

  primary key (id)
);

ALTER TABLE professor AUTO_INCREMENT = 500000;