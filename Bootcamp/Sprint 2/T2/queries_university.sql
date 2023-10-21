-- Returns a list with the first surname, second surname and name of all students. The list must be ordered alphabetically from lowest to highest by first surname, second surname and name.
SELECT primer_cognom, segon_cognom, nom
FROM persona
WHERE tipo = 'alumno'
ORDER BY primer_cognom, segon_cognom, nom;

-- Finds the name and both surnames of the students who have not registered their phone number in the database.
SELECT nom, primer_cognom, segon_cognom
FROM persona
WHERE tipo = 'alumno' AND telefon IS NULL;

-- Returns the list of students who were born in 1999.
SELECT *
FROM persona
WHERE tipo = 'alumno' AND YEAR(data_naixement) = 1999;

-- Returns the list of professors who have not registered their phone number in the database and whose NIF ends in K.
SELECT *
FROM persona p
INNER JOIN profesor pr ON p.id = pr.id_profesor
WHERE p.telefon IS NULL AND p.nif LIKE '%K';

-- Returns the list of subjects taught in the first semester, in the third year of the degree with identifier 7.
SELECT *
FROM asignatura
WHERE cuatrimestre = 1 AND curso = 3 AND id_grado = 7;

-- Returns a list of professors along with the name of the department they are associated with. The list must return four columns, first surname, second surname, name and department name. The result will be ordered alphabetically from lowest to highest by surnames and name.
SELECT p.primer_cognom, p.segon_cognom, p.nom, d.nom AS nom_departament
FROM persona p
INNER JOIN profesor pr ON p.id = pr.id_profesor
INNER JOIN departamento d ON pr.id_departamento = d.id
ORDER BY p.primer_cognom, p.segon_cognom, p.nom;

-- Returns a list with the name of the subjects, year of start and year of end of the school year of the student with NIF 26902806M.
SELECT a.nombre, ce.anyo_inicio, ce.anyo_fin
FROM persona p
INNER JOIN alumno_se_matricula_asignatura am ON p.id = am.id_alumno
INNER JOIN asignatura a ON am.id_asignatura = a.id
INNER JOIN curso_escolar ce ON am.id_curso_escolar = ce.id
WHERE p.nif = '26902806M';

-- Returns a list with the names of all departments that have professors who teach some subject in the Degree in Computer Engineering (Plan 2015).
SELECT DISTINCT d.nom
FROM departamento d
INNER JOIN profesor pr ON d.id = pr.id_departamento
INNER JOIN asignatura a ON pr.id_profesor = a.id_profesor
INNER JOIN grado g ON a.id_grado = g.id
WHERE g.nombre = 'Enginyeria Informàtica' AND g.pla = 2015;

-- Returns a list of all students who have enrolled in some subject during the 2018/2019 school year.
SELECT p.*
FROM persona p
INNER JOIN alumno_se_matricula_asignatura am ON p.id = am.id_alumno
INNER JOIN curso_escolar ce ON am.id_curso_escolar = ce.id
WHERE YEAR(ce.anyo_inicio) = 2018 AND YEAR(ce.anyo_fin) = 2019;

-- Returns a list with the names of all professors and the departments they are associated with. The list must also show those professors who do not have any associated department. The list must return four columns, department name, first surname, second surname and name of the professor. The result will be ordered alphabetically from lowest to highest by department name, surnames and name.
SELECT d.nom AS nom_departament, p.primer_cognom, p.segon_cognom, p.nom
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN departamento d ON pr.id_departamento = d.id
ORDER BY nom_departament, p.primer_cognom, p.segon_cognom, p.nom;

-- Returns a list with the professors who are not associated with a department.
SELECT p.*
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
WHERE pr.id_departamento IS NULL;

-- Returns a list with the departments that do not have associated professors.
SELECT d.*
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
WHERE pr.id_profesor IS NULL;

-- Returns a list with the professors who do not teach any subject.
SELECT p.*
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE a.id IS NULL;

-- Returns a list with the subjects that do not have an assigned professor.
SELECT a.*
FROM asignatura a
LEFT JOIN profesor pr ON a.id_profesor = pr.id_profesor
WHERE pr.id_profesor IS NULL;

-- Returns a list with all departments that have not taught any subject in any school year.
SELECT d.*
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
LEFT JOIN alumno_se_matricula_asignatura am ON a.id = am.id_asignatura
LEFT JOIN curso_escolar ce ON am.id_curso_escolar = ce.id
WHERE ce.id IS NULL;

-- Returns the total number of students.
SELECT COUNT(*) AS total_alumnos
FROM persona
WHERE tipo = 'alumno';

-- Calculates how many students were born in 1999.
SELECT COUNT(*) AS alumnos_1999
FROM persona
WHERE tipo = 'alumno' AND YEAR(data_naixement) = 1999;

-- Calculates how many professors there are in each department. The result must only show two columns, one with the name of the department and another with the number of professors in that department. The result must only include the departments that have associated professors and must be ordered from highest to lowest by the number of professors.
SELECT d.nom AS nom_departament, COUNT(*) AS num_profesores
FROM departamento d
INNER JOIN profesor p ON d.id = p.id_departamento
GROUP BY d.id
ORDER BY num_profesores DESC;

-- Returns a list with all departments and the number of professors in each one. Note that there may be departments that do not have associated professors. These departments must also appear in the list.
SELECT d.nom AS nom_departament, COUNT(p.id_profesor) AS num_profesores
FROM departamento d
LEFT JOIN profesor p ON d.id = p.id_departamento
GROUP BY d.id
ORDER BY num_profesores DESC;

-- Returns a list with the name of all degrees in the database and the number of subjects each one has. Note that there may be degrees that do not have associated subjects. These degrees must also appear in the list. The result must be ordered from highest to lowest by the number of subjects.
SELECT g.nombre, COUNT(a.id) AS num_assignatures
FROM grado g
LEFT JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.id
ORDER BY num_assignatures DESC;

-- Returns a list with the name of all degrees in the database and the number of subjects each one has, for degrees that have more than 40 associated subjects.
SELECT g.nombre, COUNT(a.id) AS num_assignatures
FROM grado g
LEFT JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.id
HAVING num_assignatures > 40
ORDER BY num_assignatures DESC;

-- Returns a list that shows the name of the degrees and the sum of the total number of credits for each type of subject. The result must have three columns: name of the degree, type of subject and the sum of the credits of all subjects of that type.
SELECT g.nombre, a.tipo, SUM(a.creditos) AS total_creditos
FROM grado g
LEFT JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.id, a.tipo;

-- Returns a list that shows how many students have enrolled in some subject in each school year. The result must show two columns, one with the year of start of the school year and another with the number of enrolled students.
SELECT YEAR(ce.anyo_inicio) AS anyo, COUNT(DISTINCT am.id_alumno) AS num_alumnos
FROM curso_escolar ce
LEFT JOIN alumno_se_matricula_asignatura am ON ce.id = am.id_curso_escolar
GROUP BY anyo;

-- Returns a list with the number of subjects taught by each professor. The list must take into account those professors who do not teach any subject. The result will show five columns: id, name, first surname, second surname and number of subjects. The result will be ordered from highest to lowest by the number of subjects.
SELECT p.id_profesor, p.nom, p.primer_cognom, p.segon_cognom, COUNT(a.id) AS num_assignatures
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
GROUP BY p.id
ORDER BY num_assignatures DESC;

-- Returns all data from the youngest student.
SELECT *
FROM persona
WHERE tipo = 'alumno'
ORDER BY data_naixement DESC
LIMIT 1;

-- Returns a list with the professors who have an associated department and who do not teach any subject.
SELECT p.*
FROM persona p
INNER JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE pr.id_departamento IS NOT NULL AND a.id IS NULL;