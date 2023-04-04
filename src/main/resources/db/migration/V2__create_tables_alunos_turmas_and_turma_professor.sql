CREATE TABLE turma(
                       id bigint not null AUTO_INCREMENT,
                       ano_escolar int not null,
                       letra varchar(2) not null,
                       primary key (id)
);

CREATE TABLE aluno (
                            id bigint not null AUTO_INCREMENT,
                             nome varchar(500) not null,
                             data_de_nascimento char(10),
                             dia_de_pagamento smallint,
                             cpf char(11) not null,
                             nome_responsavel varchar(500) not null,
                             telefone_responsavel char(11) not null,
                             cpf_responsavel char(11) not null,
                             turma_id bigint,
                             ano_escolar int,
                             foreign key (turma_id) references turma(id),
                             primary key (id)
);

ALTER TABLE aluno AUTO_INCREMENT = 100000;


CREATE TABLE turma_professor(
    turma_id bigint,
    professor_id bigint,
    foreign key (turma_id) references turma(id),
    foreign key (professor_id) references professor(id),
    primary key (turma_id, professor_id)
)

