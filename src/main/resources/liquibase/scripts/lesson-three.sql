-- liquibase formatted sql

-- changeset julia:1

CREATE INDEX students_name_index ON student (name);

-- changeset julia:2

CREATE INDEX faculty_name_color_index ON faculty (name, colour);