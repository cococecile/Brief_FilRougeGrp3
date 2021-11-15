-- Database: gestion_de_personnel

DROP DATABASE gestion_de_personnel;

CREATE DATABASE gestion_de_personnel
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE gestion_de_personnel
    IS 'Choix n°1 BRIEF fil rouge POEI Java ';

    -- Role: directeur
-- DROP ROLE directeur;

CREATE USER backend WITH PASSWORD 'password';
ALTER DEFAULT PRIVILEGES 
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLES TO backend;