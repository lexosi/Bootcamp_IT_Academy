-- Llista el nom de tots els productes que hi ha en la taula producto.
SELECT nombre FROM producto;

-- Llista els noms i els preus de tots els productes de la taula producto.
SELECT nombre, precio FROM producto;

-- Llista totes les columnes de la taula producto.
SELECT * FROM producto;

-- Llista el nom dels productes, el preu en euros i el preu en dòlars estatunidencs (USD).
SELECT nombre AS "nom de producto", precio AS "euros", precio * 1.18 AS "dòlars" FROM producto;

-- Llista el nom dels productes, el preu en euros i el preu en dòlars estatunidencs (USD). Utilitza els següents àlies per a les columnes: nom de producto, euros, dòlars.
SELECT nombre AS "nom de producto", precio AS "euros", precio * 1.18 AS "dòlars" FROM producto;

-- Llista els noms i els preus de tots els productes de la taula producto, convertint els noms a majúscula.
SELECT UPPER(nombre), precio FROM producto;

-- Llista els noms i els preus de tots els productes de la taula producto, convertint els noms a minúscula.
SELECT LOWER(nombre), precio FROM producto;

-- Llista el nom de tots els fabricants en una columna, i en una altra columna obtingui en majúscules els dos primers caràcters del nom del fabricant.
SELECT nombre_fabricante, UPPER(SUBSTR(nombre_fabricante, 1, 2)) FROM fabricante;

-- Llista els noms i els preus de tots els productes de la taula producto, arrodonint el valor del preu.
SELECT nombre, ROUND(precio) FROM producto;

-- Llista els noms i els preus de tots els productes de la taula producto, truncant el valor del preu per a mostrar-lo sense cap xifra decimal.
SELECT nombre, TRUNC(precio) FROM producto;

-- Llista el codi dels fabricants que tenen productes en la taula producto.
SELECT DISTINCT codigo_fabricante FROM producto;

-- Llista el codi dels fabricants que tenen productes en la taula producto, eliminant els codis que apareixen repetits.
SELECT DISTINCT codigo_fabricante FROM producto;

-- Llista els noms dels fabricants ordenats de manera ascendent.
SELECT nombre_fabricante FROM fabricante ORDER BY nombre_fabricante ASC;

-- Llista els noms dels fabricants ordenats de manera descendent.
SELECT nombre_fabricante FROM fabricante ORDER BY nombre_fabricante DESC;

-- Llista els noms dels productes ordenats, en primer lloc, pel nom de manera ascendent i, en segon lloc, pel preu de manera descendent.
SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;

-- Retorna una llista amb les 5 primeres files de la taula fabricante.
SELECT * FROM fabricante LIMIT 5;

-- Retorna una llista amb 2 files a partir de la quarta fila de la taula fabricante. La quarta fila també s'ha d'incloure en la resposta.
SELECT * FROM fabricante LIMIT 2 OFFSET 3;

-- Llista el nom i el preu del producte més barat. (Utilitza solament les clàusules ORDER BY i LIMIT). NOTA: Aquí no podria usar MIN(preu), necessitaria GROUP BY.
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;

-- Llista el nom i el preu del producte més car. (Utilitza solament les clàusules ORDER BY i LIMIT). NOTA: Aquí no podria usar MAX(preu), necessitaria GROUP BY.
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;

-- Llista el nom de tots els productes del fabricant el codi de fabricant del qual és igual a 2.
SELECT nombre FROM producto WHERE codigo_fabricante = 2;

-- Retorna una llista amb el nom del producte, preu i nom de fabricant de tots els productes de la base de dades.
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante;

-- Retorna una llista amb el nom del producte, preu i nom de fabricant de tots els productes de la base de dades. Ordena el resultat pel nom del fabricant, per ordre alfabètic.
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante ORDER BY f.nombre_fabricante ASC;

-- Retorna una llista amb el codi del producte, nom del producte, codi del fabricador i nom del fabricador, de tots els productes de la base de dades.
SELECT p.codigo_producto, p.nombre, p.codigo_fabricante, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante;

-- Retorna el nom del producte, el seu preu i el nom del seu fabricant, del producte més barat.
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante ORDER BY precio ASC LIMIT 1;

-- Retorna el nom del producte, el seu preu i el nom del seu fabricant, del producte més car.
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante ORDER BY precio DESC LIMIT 1;

-- Retorna una llista de tots els productes del fabricador Lenovo.
SELECT * FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo');

-- Retorna una llista de tots els productes del fabricant Crucial que tinguin un preu major que 200 €.
SELECT * FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Crucial') AND precio > 200;

-- Retorna un llistat amb tots els productes dels fabricants Asus, Hewlett-Packardy Seagate. Sense utilitzar l'operador IN.
SELECT p.nombre, p.precio FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND (f.nombre_fabricante = 'Asus' OR f.nombre_fabricante = 'Hewlett-Packard' OR f.nombre_fabricante = 'Seagate');

-- Retorna un llistat amb tots els productes dels fabricants Asus, Hewlett-Packardy Seagate. Fent servir l'operador IN.
SELECT p.nombre, p.precio FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND f.nombre_fabricante IN ('Asus', 'Hewlett-Packard', 'Seagate');

-- Retorna un llistat amb el nom i el preu de tots els productes dels fabricants el nom dels quals acabi per la vocal e.
SELECT p.nombre, p.precio FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND f.nombre_fabricante LIKE '%e';

-- Retorna un llistat amb el nom i el preu de tots els productes el nom de fabricant dels quals contingui el caràcter w en el seu nom.
SELECT p.nombre, p.precio FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND f.nombre_fabricante LIKE '%w%';

-- Retorna un llistat amb el nom de producte, preu i nom de fabricant, de tots els productes que tinguin un preu major o igual a 180 €. Ordena el resultat, en primer lloc, pel preu (en ordre descendent) i, en segon lloc, pel nom (en ordre ascendent).
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND p.precio >= 180 ORDER BY p.precio DESC, p.nombre ASC;

-- Retorna un llistat amb el codi i el nom de fabricant, solament d'aquells fabricants que tenen productes associats en la base de dades.
SELECT DISTINCT f.codigo_fabricante, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante;

-- Retorna un llistat de tots els fabricants que existeixen en la base de dades, juntament amb els productes que té cadascun d'ells. El llistat haurà de mostrar també aquells fabricants que no tenen productes associats.
SELECT f.nombre_fabricante, p.nombre, p.precio FROM fabricante f LEFT JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante;

-- Retorna un llistat on només apareguin aquells fabricants que no tenen cap producte associat.
SELECT f.nombre_fabricante FROM fabricante f LEFT JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante WHERE p.codigo_producto IS NULL;

-- Retorna tots els productes del fabricador Lenovo. (Sense utilitzar INNER JOIN).
SELECT * FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND f.nombre_fabricante = 'Lenovo';

-- Retorna totes les dades dels productes que tenen el mateix preu que el producte més car del fabricant Lenovo. (Sense usar INNER JOIN).
SELECT * FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'));

-- Llista el nom del producte més car del fabricant Lenovo.
SELECT nombre FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'));

-- Llista el nom del producte més barat del fabricant Hewlett-Packard.
SELECT nombre FROM producto WHERE precio = (SELECT MIN(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Hewlett-Packard'));

-- Retorna tots els productes de la base de dades que tenen un preu major o igual al producte més car del fabricant Lenovo.
SELECT * FROM producto WHERE precio >= (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'));

-- Llesta tots els productes del fabricant Asus que tenen un preu superior al preu mitjà de tots els seus productes.
SELECT nombre, precio FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Asus') AND precio > (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Asus'));