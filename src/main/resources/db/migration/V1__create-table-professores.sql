CREATE TABLE professores (
  id char(11) not null,
  nome varchar(500) not null,
  data_de_nascimento char(10),
  dia_de_pagamento smallint,
  area_ensino varchar(200),
  carga_horaria_diaria smallint,
  salario_hora double,
  cpf char(11) not null,

  primary key (id)
);