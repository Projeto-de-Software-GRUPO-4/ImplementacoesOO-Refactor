ALTER TABLE professor DROP COLUMN area_ensino;

ALTER TABLE professor ADD COLUMN materia_id bigint;

ALTER TABLE professor ADD CONSTRAINT professor_materia_id
    FOREIGN KEY(materia_id) REFERENCES materia(id);