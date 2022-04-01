SELECT student.name, student.age, faculty.name
FROM student
LEFT JOIN faculty ON student.faculty_id = faculty.id;

SELECT s.name, s.age
FROM avatar as a
LEFT JOIN student as s ON s.id = a.student_id;