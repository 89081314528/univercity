1)	Возраст студента не может быть меньше 16 лет.
ALTER TABLE student
ADD CONSTRAINT age_constraint CHECK (age > 16);
2)	Имена студентов должны быть уникальными и не равно нулю.
ALTER TABLE student
ALTER COLUMN name SET NOT NULL;
ALTER TABLE student
ADD CONSTRAINT name_unique UNIQUE (name);
3)	Пара значений названия и цвета факультета должны быть уникальными.
ALTER TABLE faculty
ADD CONSTRAINT colour_name_unique UNIQUE (colour, name);
4)	При создании студента без возраста присваивать ему 20 лет.
ALTER TABLE student
ALTER COLUMN age SET default(20);
