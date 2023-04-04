CREATE TABLE turmas(
                       id varchar(5) unique not null,
                       ano_escolar int not null,
                       letra varchar(2) not null,
                       primary key (id)
);

CREATE TABLE alunos (
                             numeroDeMatricula int not null AUTO_INCREMENT,
                             nome varchar(500) not null,
                             data_de_nascimento char(10),
                             dia_de_pagamento smallint,
                             cpf char(11) not null,
                             nome_responsavel varchar(500) not null,
                             telefone_responsavel char(11) not null,
                             cpf_responsavel char(11) not null,
                             turma varchar(5),
                             ano_escolar int,
                             foreign key (turma) references turmas(id),
                             primary key (numeroDeMatricula)
);

ALTER TABLE alunos AUTO_INCREMENT = 100000;


CREATE TABLE turma_professor(
    turma_id varchar(5),
    professor_id char(11),
    foreign key (turma_id) references turmas(id),
    foreign key (professor_id) references professores(id),
    primary key (turma_id, professor_id)
)

