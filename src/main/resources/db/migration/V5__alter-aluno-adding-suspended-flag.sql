ALTER TABLE aluno ADD suspended tinyint not null;
UPDATE aluno SET suspended = 0;