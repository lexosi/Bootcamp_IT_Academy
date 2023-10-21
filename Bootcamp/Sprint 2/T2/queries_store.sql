-- List the name of all the products in the producto table.
SELECT nombre FROM producto;

-- List the names and prices of all the products in the producto table.
SELECT nombre, precio FROM producto;

-- List all the columns of the producto table.
SELECT * FROM producto;

-- List the names of the products, the price in euros and the price in US dollars (USD).
SELECT nombre AS "product name", precio AS "euros", precio * 1.18 AS "dollars" FROM producto;

-- List the names of the products, the price in euros and the price in US dollars (USD). Use the following aliases for the columns: product name, euros, dollars.
SELECT nombre AS "product name", precio AS "euros", precio * 1.18 AS "dollars" FROM producto;

-- List the names and prices of all the products in the producto table, converting the names to uppercase.
SELECT UPPER(nombre), precio FROM producto;

-- List the names and prices of all the products in the producto table, converting the names to lowercase.
SELECT LOWER(nombre), precio FROM producto;

-- List the name of all the manufacturers in one column, and in another column obtain in uppercase the first two characters of the manufacturer's name.
SELECT nombre_fabricante, UPPER(SUBSTR(nombre_fabricante, 1, 2)) FROM fabricante;

-- List the names and prices of all the products in the producto table, rounding the price value.
SELECT nombre, ROUND(precio) FROM producto;

-- List the names and prices of all the products in the producto table, truncating the price value to show it without any decimal places.
SELECT nombre, TRUNC(precio) FROM producto;

-- List the code of the manufacturers that have products in the producto table.
SELECT DISTINCT codigo_fabricante FROM producto;

-- List the code of the manufacturers that have products in the producto table, eliminating the codes that appear repeated.
SELECT DISTINCT codigo_fabricante FROM producto;

-- List the names of the manufacturers ordered in ascending order.
SELECT nombre_fabricante FROM fabricante ORDER BY nombre_fabricante ASC;

-- List the names of the manufacturers ordered in descending order.
SELECT nombre_fabricante FROM fabricante ORDER BY nombre_fabricante DESC;

-- List the names of the products ordered, first by name in ascending order and secondly by price in descending order.
SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;

-- Return a list with the first 5 rows of the fabricante table.
SELECT * FROM fabricante LIMIT 5;

-- Return a list with 2 rows starting from the fourth row of the fabricante table. The fourth row must also be included in the response.
SELECT * FROM fabricante LIMIT 2 OFFSET 3;

-- List the name and price of the cheapest product. (Use only the ORDER BY and LIMIT clauses). NOTE: Here I could not use MIN(price), I would need GROUP BY.
SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1;

-- List the name and price of the most expensive product. (Use only the ORDER BY and LIMIT clauses). NOTE: Here I could not use MAX(price), I would need GROUP BY.
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;

-- List the name of all the products of the manufacturer whose manufacturer code is equal to 2.
SELECT nombre FROM producto WHERE codigo_fabricante = 2;

-- Return a list with the name of the product, price and manufacturer name of all the products in the database.
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante;

-- Return a list with the name of the product, price and manufacturer name of all the products in the database. Order the result by the name of the manufacturer, in alphabetical order.
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante ORDER BY f.nombre_fabricante ASC;

-- Return a list with the code of the product, name of the product, manufacturer code and name of the manufacturer, of all the products in the database.
SELECT p.codigo_producto, p.nombre, p.codigo_fabricante, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante;

-- Return the name of the product, its price and the name of its manufacturer, of the cheapest product.
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante ORDER BY precio ASC LIMIT 1;

-- Return the name of the product, its price and the name of its manufacturer, of the most expensive product.
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante ORDER BY precio DESC LIMIT 1;

-- Return a list of all the products of the Lenovo manufacturer.
SELECT * FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo');

-- Return a list of all the products of the Crucial manufacturer that have a price greater than 200 €.
SELECT * FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Crucial') AND precio > 200;

-- Return a list with all the products of the Asus, Hewlett-Packard and Seagate manufacturers. Without using the IN operator.
SELECT p.nombre, p.precio FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND (f.nombre_fabricante = 'Asus' OR f.nombre_fabricante = 'Hewlett-Packard' OR f.nombre_fabricante = 'Seagate');

-- Return a list with all the products of the Asus, Hewlett-Packard and Seagate manufacturers. Using the IN operator.
SELECT p.nombre, p.precio FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND f.nombre_fabricante IN ('Asus', 'Hewlett-Packard', 'Seagate');

-- Return a list with the name and price of all the products whose manufacturer name ends with the vowel e.
SELECT p.nombre, p.precio FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND f.nombre_fabricante LIKE '%e';

-- Return a list with the name and price of all the products whose manufacturer name contains the character w in its name.
SELECT p.nombre, p.precio FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND f.nombre_fabricante LIKE '%w%';

-- Return a list with the name of the product, price and manufacturer name, of all the products that have a price greater than or equal to 180 €. Order the result, first by price (in descending order) and, secondly, by name (in ascending order).
SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND p.precio >= 180 ORDER BY p.precio DESC, p.nombre ASC;

-- Return a list with the code and name of the manufacturer, only of those manufacturers that have associated products in the database.
SELECT DISTINCT f.codigo_fabricante, f.nombre_fabricante FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante;

-- Return a list of all the manufacturers that exist in the database, together with the products that each of them has. The list must also show those manufacturers that do not have associated products.
SELECT f.nombre_fabricante, p.nombre, p.precio FROM fabricante f LEFT JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante;

-- Return a list where only those manufacturers that do not have any associated product appear.
SELECT f.nombre_fabricante FROM fabricante f LEFT JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante WHERE p.codigo_producto IS NULL;

-- Return all the products of the Lenovo manufacturer. (Without using INNER JOIN).
SELECT * FROM producto p, fabricante f WHERE p.codigo_fabricante = f.codigo_fabricante AND f.nombre_fabricante = 'Lenovo';

-- Return all the data of the products that have the same price as the most expensive product of the Lenovo manufacturer. (Without using INNER JOIN).
SELECT * FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'));

-- List the name of the most expensive product of the Lenovo manufacturer.
SELECT nombre FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'));

-- List the name of the cheapest product of the Hewlett-Packard manufacturer.
SELECT nombre FROM producto WHERE precio = (SELECT MIN(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Hewlett-Packard'));

-- Return all the products of the database that have a price greater than or equal to the most expensive product of the Lenovo manufacturer.
SELECT * FROM producto WHERE precio >= (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'));

-- List all the products of the Asus manufacturer that have a price higher than the average price of all its products.
SELECT nombre, precio FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Asus') AND precio > (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Asus'));