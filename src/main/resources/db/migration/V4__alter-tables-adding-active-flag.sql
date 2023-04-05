ALTER TABLE professor ADD active tinyint not null;
ALTER TABLE aluno ADD active tinyint not null;

UPDATE professor SET active = 1;
UPDATE aluno SET active = 1;