CREATE TABLE professor (
  id char(11) not null unique,
  nome varchar(500) not null,
  data_de_nascimento char(10),
  dia_de_pagamento smallint,
  area_ensino varchar(200),
  carga_horaria_diaria smallint,
  salario_hora double,
  cpf char(11) not null unique,
#   materia_id bigint,
# foreign key (materia_id) references materia(id),
  primary key (id)
);