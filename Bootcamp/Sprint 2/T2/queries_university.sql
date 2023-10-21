-- Retorna un llistat amb el primer cognom, segon cognom i el nom de tots els/les alumnes. El llistat haurà d'estar ordenat alfabèticament de menor a major pel primer cognom, segon cognom i nom.
SELECT primer_cognom, segon_cognom, nom
FROM persona
WHERE tipo = 'alumno'
ORDER BY primer_cognom, segon_cognom, nom;

-- Esbrina el nom i els dos cognoms dels alumnes que no han donat d'alta el seu número de telèfon en la base de dades.
SELECT nom, primer_cognom, segon_cognom
FROM persona
WHERE tipo = 'alumno' AND telefon IS NULL;

-- Retorna el llistat dels alumnes que van néixer en 1999.
SELECT *
FROM persona
WHERE tipo = 'alumno' AND YEAR(data_naixement) = 1999;

-- Retorna el llistat de professors/es que no han donat d'alta el seu número de telèfon en la base de dades i a més el seu NIF acaba en K.
SELECT *
FROM persona p
INNER JOIN profesor pr ON p.id = pr.id_profesor
WHERE p.telefon IS NULL AND p.nif LIKE '%K';

-- Retorna el llistat de les assignatures que s'imparteixen en el primer quadrimestre, en el tercer curs del grau que té l'identificador 7.
SELECT *
FROM asignatura
WHERE cuatrimestre = 1 AND curso = 3 AND id_grado = 7;

-- Retorna un llistat dels professors/es juntament amb el nom del departament al qual estan vinculats. El llistat ha de retornar quatre columnes, primer cognom, segon cognom, nom i nom del departament. El resultat estarà ordenat alfabèticament de menor a major pels cognoms i el nom.
SELECT p.primer_cognom, p.segon_cognom, p.nom, d.nom AS nom_departament
FROM persona p
INNER JOIN profesor pr ON p.id = pr.id_profesor
INNER JOIN departamento d ON pr.id_departamento = d.id
ORDER BY p.primer_cognom, p.segon_cognom, p.nom;

-- Retorna un llistat amb el nom de les assignatures, any d'inici i any de fi del curs escolar de l'alumne/a amb NIF 26902806M.
SELECT a.nombre, ce.anyo_inicio, ce.anyo_fin
FROM persona p
INNER JOIN alumno_se_matricula_asignatura am ON p.id = am.id_alumno
INNER JOIN asignatura a ON am.id_asignatura = a.id
INNER JOIN curso_escolar ce ON am.id_curso_escolar = ce.id
WHERE p.nif = '26902806M';

-- Retorna un llistat amb el nom de tots els departaments que tenen professors/es que imparteixen alguna assignatura en el Grau en Enginyeria Informàtica (Pla 2015).
SELECT DISTINCT d.nom
FROM departamento d
INNER JOIN profesor pr ON d.id = pr.id_departamento
INNER JOIN asignatura a ON pr.id_profesor = a.id_profesor
INNER JOIN grado g ON a.id_grado = g.id
WHERE g.nombre = 'Enginyeria Informàtica' AND g.pla = 2015;

-- Retorna un llistat amb tots els alumnes que s'han matriculat en alguna assignatura durant el curs escolar 2018/2019.
SELECT p.*
FROM persona p
INNER JOIN alumno_se_matricula_asignatura am ON p.id = am.id_alumno
INNER JOIN curso_escolar ce ON am.id_curso_escolar = ce.id
WHERE YEAR(ce.anyo_inicio) = 2018 AND YEAR(ce.anyo_fin) = 2019;

-- Retorna un llistat amb els noms de tots els professors/es i els departaments que tenen vinculats. El llistat també ha de mostrar aquells professors/es que no tenen cap departament associat. El llistat ha de retornar quatre columnes, nom del departament, primer cognom, segon cognom i nom del professor/a. El resultat estarà ordenat alfabèticament de menor a major pel nom del departament, cognoms i el nom.
SELECT d.nom AS nom_departament, p.primer_cognom, p.segon_cognom, p.nom
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN departamento d ON pr.id_departamento = d.id
ORDER BY nom_departament, p.primer_cognom, p.segon_cognom, p.nom;

-- Retorna un llistat amb els professors/es que no estan associats a un departament.
SELECT p.*
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
WHERE pr.id_departamento IS NULL;

-- Retorna un llistat amb els departaments que no tenen professors/es associats.
SELECT d.*
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
WHERE pr.id_profesor IS NULL;

-- Retorna un llistat amb els professors/es que no imparteixen cap assignatura.
SELECT p.*
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE a.id IS NULL;

-- Retorna un llistat amb les assignatures que no tenen un professor/a assignat.
SELECT a.*
FROM asignatura a
LEFT JOIN profesor pr ON a.id_profesor = pr.id_profesor
WHERE pr.id_profesor IS NULL;

-- Retorna un llistat amb tots els departaments que no han impartit assignatures en cap curs escolar.
SELECT d.*
FROM departamento d
LEFT JOIN profesor pr ON d.id = pr.id_departamento
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
LEFT JOIN alumno_se_matricula_asignatura am ON a.id = am.id_asignatura
LEFT JOIN curso_escolar ce ON am.id_curso_escolar = ce.id
WHERE ce.id IS NULL;

-- Retorna el nombre total d'alumnes que hi ha.
SELECT COUNT(*) AS total_alumnos
FROM persona
WHERE tipo = 'alumno';

-- Calcula quants alumnes van néixer en 1999.
SELECT COUNT(*) AS alumnos_1999
FROM persona
WHERE tipo = 'alumno' AND YEAR(data_naixement) = 1999;

-- Calcula quants professors/es hi ha en cada departament. El resultat només ha de mostrar dues columnes, una amb el nom del departament i una altra amb el nombre de professors/es que hi ha en aquest departament. El resultat només ha d'incloure els departaments que tenen professors/es associats i haurà d'estar ordenat de major a menor pel nombre de professors/es.
SELECT d.nom AS nom_departament, COUNT(*) AS num_profesores
FROM departamento d
INNER JOIN profesor p ON d.id = p.id_departamento
GROUP BY d.id
ORDER BY num_profesores DESC;

-- Retorna un llistat amb tots els departaments i el nombre de professors/es que hi ha en cadascun d'ells. Tingui en compte que poden existir departaments que no tenen professors/es associats. Aquests departaments també han d'aparèixer en el llistat.
SELECT d.nom AS nom_departament, COUNT(p.id_profesor) AS num_profesores
FROM departamento d
LEFT JOIN profesor p ON d.id = p.id_departamento
GROUP BY d.id
ORDER BY num_profesores DESC;

-- Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun. Tingues en compte que poden existir graus que no tenen assignatures associades. Aquests graus també han d'aparèixer en el llistat. El resultat haurà d'estar ordenat de major a menor pel nombre d'assignatures.
SELECT g.nombre, COUNT(a.id) AS num_assignatures
FROM grado g
LEFT JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.id
ORDER BY num_assignatures DESC;

-- Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun, dels graus que tinguin més de 40 assignatures associades.
SELECT g.nombre, COUNT(a.id) AS num_assignatures
FROM grado g
LEFT JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.id
HAVING num_assignatures > 40
ORDER BY num_assignatures DESC;

-- Retorna un llistat que mostri el nom dels graus i la suma del nombre total de crèdits que hi ha per a cada tipus d'assignatura. El resultat ha de tenir tres columnes: nom del grau, tipus d'assignatura i la suma dels crèdits de totes les assignatures que hi ha d'aquest tipus.
SELECT g.nombre, a.tipo, SUM(a.creditos) AS total_creditos
FROM grado g
LEFT JOIN asignatura a ON g.id = a.id_grado
GROUP BY g.id, a.tipo;

-- Retorna un llistat que mostri quants alumnes s'han matriculat d'alguna assignatura en cadascun dels cursos escolars. El resultat haurà de mostrar dues columnes, una columna amb l'any d'inici del curs escolar i una altra amb el nombre d'alumnes matriculats.
SELECT YEAR(ce.anyo_inicio) AS anyo, COUNT(DISTINCT am.id_alumno) AS num_alumnos
FROM curso_escolar ce
LEFT JOIN alumno_se_matricula_asignatura am ON ce.id = am.id_curso_escolar
GROUP BY anyo;

-- Retorna un llistat amb el nombre d'assignatures que imparteix cada professor/a. El llistat ha de tenir en compte aquells professors/es que no imparteixen cap assignatura. El resultat mostrarà cinc columnes: id, nom, primer cognom, segon cognom i nombre d'assignatures. El resultat estarà ordenat de major a menor pel nombre d'assignatures.
SELECT p.id_profesor, p.nom, p.primer_cognom, p.segon_cognom, COUNT(a.id) AS num_assignatures
FROM persona p
LEFT JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
GROUP BY p.id
ORDER BY num_assignatures DESC;

-- Retorna totes les dades de l'alumne/a més jove.
SELECT *
FROM persona
WHERE tipo = 'alumno'
ORDER BY data_naixement DESC
LIMIT 1;

-- Retorna un llistat amb els professors/es que tenen un departament associat i que no imparteixen cap assignatura.
SELECT p.*
FROM persona p
INNER JOIN profesor pr ON p.id = pr.id_profesor
LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE pr.id_departamento IS NOT NULL AND a.id IS NULL;