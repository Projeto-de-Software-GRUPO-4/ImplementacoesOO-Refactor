ALTER TABLE professor DROP COLUMN area_ensino;

ALTER TABLE professor ADD COLUMN area_ensino tinyint unique;

ALTER TABLE professor ADD CONSTRAINT area_ensino_materia_id
    FOREIGN KEY(area_ensino) REFERENCES materia(id);