ALTER TABLE boletim DROP COLUMN bimestre;

ALTER TABLE boletim ADD COLUMN bimestre varchar(100) not null;