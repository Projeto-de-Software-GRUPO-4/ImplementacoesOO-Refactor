CREATE TABLE ocorrencia (
    id bigint auto_increment,
    aluno_id char(11),
    descricao text,
    foreign key (aluno_id) references aluno(id),
    primary key (id)
);

CREATE TABLE materia (
    id tinyint auto_increment,
    titulo varchar(500),
    primary key (id)
);




CREATE TABLE boletim (
    id bigint auto_increment,
    aluno_id char(11),
    ano year,
    bimestre enum('Primeiro', 'Segundo', 'Terceiro', 'Quarto'),
    materia_id tinyint,
    foreign key (aluno_id) references aluno(id),
    foreign key (materia_id) references materia(id),
    primary key (id)
);