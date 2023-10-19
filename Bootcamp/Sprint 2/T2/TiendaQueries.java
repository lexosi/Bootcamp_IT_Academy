import java.sql.*;

public class TiendaQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Enumere el nombre de todos los productos en la tabla de productos.
            String query1 = "SELECT nombre FROM producto";
            printResultSet(conn, query1);

            // Enumere los nombres y precios de todos los productos en la tabla aquí.
            String query2 = "SELECT nombre, precio FROM producto";
            printResultSet(conn, query2);

            // Enumere todas las columnas en la tabla de productos.
            String query3 = "SELECT * FROM producto";
            printResultSet(conn, query3);

            // Enumere el nombre de los productos, el precio en euros y el precio en dólares sin estado (USD).
            String query4 = "SELECT nombre, precio, precio * 1.18 AS euros, precio AS dolares FROM producto";
            printResultSet(conn, query4);

            // Enumere el nombre de los productos, el precio en euros y el precio en dólares sin estado (USD). Utilice el siguiente alias para las columnas: nombre del producto, euros, dólares.
            String query5 = "SELECT nombre AS 'nombre del producto', precio * 1.18 AS euros, precio AS dolares FROM producto";
            printResultSet(conn, query5);

            // Enumere los nombres y precios de todos los productos en la tabla que produzco, convirtiendo los nombres en mayúsculas.
            String query6 = "SELECT UPPER(nombre) AS nombre, precio FROM producto WHERE codigo_fabricante = 1";
            printResultSet(conn, query6);

            // Enumere los nombres y precios de todos los productos en la tabla, convirtiendo los nombres en minúsculas.
            String query7 = "SELECT LOWER(nombre) AS nombre, precio FROM producto";
            printResultSet(conn, query7);

            // Enumere el nombre de todos los fabricantes en una columna, y en otra columna obtendrá en mayúsculas los dos primeros caracteres en el nombre del fabricante.
            String query8 = "SELECT nombre_fabricante, UPPER(SUBSTRING(nombre_fabricante, 1, 2)) AS dos_primeros_caracteres FROM fabricante";
            printResultSet(conn, query8);

            // Enumere los nombres y precios de todos los productos en la tabla, redondeando el valor del precio.
            String query9 = "SELECT nombre, ROUND(precio) AS precio FROM producto";
            printResultSet(conn, query9);

            // Enumere los nombres y precios de todos los productos en la tabla, truncando el valor del precio para mostrarlo sin decimales.
            String query10 = "SELECT nombre, TRUNCATE(precio, 0) AS precio FROM producto";
            printResultSet(conn, query10);

            // Enumere el código de los fabricantes que tienen productos en la tabla de productos.
            String query11 = "SELECT DISTINCT codigo_fabricante FROM producto";
            printResultSet(conn, query11);

            // Enumere el código de los fabricantes que tienen productos en la tabla de productos, eliminando los códigos que aparecen repetidos.
            String query12 = "SELECT DISTINCT codigo_fabricante FROM producto";
            printResultSet(conn, query12);

            // Enumere los nombres de los fabricantes ordenados ascendentes.
            String query13 = "SELECT nombre_fabricante FROM fabricante ORDER BY nombre_fabricante ASC";
            printResultSet(conn, query13);

            // Enumere los nombres de los fabricantes ordenados de manera descendente.
            String query14 = "SELECT nombre_fabricante FROM fabricante ORDER BY nombre_fabricante DESC";
            printResultSet(conn, query14);

            // Enumere los nombres de los productos pedidos, en primer lugar, por el nombre ascendente y, en segundo lugar, por el precio descendente.
            String query15 = "SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC";
            printResultSet(conn, query15);

            // Devuelve una lista con las 5 filas superiores en la tabla de fabricación.
            String query16 = "SELECT * FROM fabricante LIMIT 5";
            printResultSet(conn, query16);

            // Devuelve una lista con 2 filas de la cuarta fila de la tabla de fabricación. La cuarta fila también debe incluirse en la respuesta.
            String query17 = "SELECT * FROM fabricante LIMIT 3, 2";
            printResultSet(conn, query17);

            // Enumere el nombre y el precio del producto más barato. (Utilice solo las cláusulas ORDER BY y LIMIT). NOTA: No podía usar MIN (precio) aquí, necesitaría GROUP BY.
            String query18 = "SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT 1";
            printResultSet(conn, query18);

            // Enumere el nombre y el precio del producto más caro. (Utilice solo las cláusulas ORDER BY y LIMIT). NOTA: No podía usar MAX (precio) aquí, necesitaría GROUP BY.
            String query19 = "SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1";
            printResultSet(conn, query19);

            // Enumere el nombre de todos los productos del fabricante cuyo código de fabricante sea igual a 2.
            String query20 = "SELECT nombre FROM producto WHERE codigo_fabricante = 2";
            printResultSet(conn, query20);

            // Devuelve una lista con el nombre del producto, el precio y el nombre del fabricante de todos los productos de la base de datos.
            String query21 = "SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante";
            printResultSet(conn, query21);

            // Devuelve una lista con el nombre del producto, el precio y el nombre del fabricante de todos los productos de la base de datos. Ordenar el resultado por el nombre del fabricante, por orden alfabético.
            String query22 = "SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante ORDER BY f.nombre_fabricante ASC";
            printResultSet(conn, query22);

            // Devuelve una lista con el código del producto, nombre del producto, código del fabricante y nombre del fabricante, de todos los productos de la base de datos.
            String query23 = "SELECT p.codigo_producto, p.nombre, p.codigo_fabricante, f.nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante";
            printResultSet(conn, query23);

            // Devuelve el nombre del producto, precio y nombre de su fabricante, del producto más barato.
            String query24 = "SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE p.precio = (SELECT MIN(precio) FROM producto)";
            printResultSet(conn, query24);

            // Devuelve el nombre del producto, su precio y el nombre de su fabricante, el producto más caro.
            String query25 = "SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE p.precio = (SELECT MAX(precio) FROM producto)";
            printResultSet(conn, query25);

            // Devuelve una lista de todos los productos del fabricante de Lenovo.
            String query26 = "SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE f.nombre_fabricante = 'Lenovo'";
            printResultSet(conn, query26);

            // Devuelve una lista de todos los productos de fabricantes de Crucial con un precio superior a 200 €.
            String query27 = "SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE f.nombre_fabricante LIKE '%Crucial%' AND p.precio > 200";
            printResultSet(conn, query27);

            // Devuelve una lista con todos los productos de los fabricantes de Asus, Hewlett-Packardy Seagate. Sin usar el operador IN.
            String query28 = "SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE f.nombre_fabricante = 'Asus' OR f.nombre_fabricante = 'Hewlett-Packard' OR f.nombre_fabricante = 'Seagate'";
            printResultSet(conn, query28);

            // Devuelve una lista con todos los productos de los fabricantes de Asus, Hewlett-Packardy Seagate. Usando el operador IN.
            String query29 = "SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE f.nombre_fabricante IN ('Asus', 'Hewlett-Packard', 'Seagate')";
            printResultSet(conn, query29);

            // Devuelve una lista con el nombre y el precio de todos los productos de los fabricantes cuyo nombre termina con la voz e.
            String query30 = "SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE f.nombre_fabricante LIKE '%e'";
            printResultSet(conn, query30);

            // Devuelve una lista con el nombre y el precio de todos los productos cuyo nombre de fabricante contiene el carácter w en su nombre.
            String query31 = "SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE f.nombre_fabricante LIKE '%w%'";
            printResultSet(conn, query31);

            // Devuelve una lista con el nombre del producto, el precio y el nombre del fabricante, de todos los productos con un precio mayor o igual a 180 €. Ordenar el resultado, en primer lugar, por el precio (en orden descendente) y, en segundo lugar, por el nombre (en orden ascendente).
            String query32 = "SELECT p.nombre, p.precio, f.nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante WHERE p.precio >= 180 ORDER BY p.precio DESC, p.nombre ASC";
            printResultSet(conn, query32);

            // Devuelve una lista con el código y el nombre del fabricante, solo de aquellos fabricantes que tienen productos asociados en la base de datos.
            String query33 = "SELECT DISTINCT f.codigo_fabricante, f.nombre_fabricante FROM fabricante f JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante";
            printResultSet(conn, query33);

            // Devuelve una lista de todos los fabricantes que existen en la base de datos, junto con los productos que cada uno tiene. La lista también debe mostrar aquellos fabricantes que no tienen productos asociados.
            String query34 = "SELECT f.nombre_fabricante, p.nombre, p.precio FROM fabricante f LEFT JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante";
            printResultSet(conn, query34);

            // Devuelve una lista donde solo aparecen aquellos fabricantes que no tienen producto asociado.
            String query35 = "SELECT f.nombre_fabricante FROM fabricante f LEFT JOIN producto p ON f.codigo_fabricante = p.codigo_fabricante WHERE p.codigo_producto IS NULL";
            printResultSet(conn, query35);

            // Devuelve todos los productos del fabricante de Lenovo. (Sin usar INNER JOIN).
            String query36 = "SELECT * FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo')";
            printResultSet(conn, query36);

            // Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin uso INNER JOIN).
            String query37 = "SELECT * FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'))";
            printResultSet(conn, query37);

            // Enumere el nombre del producto más caro del fabricante Lenovo.
            String query38 = "SELECT nombre FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'))";
            printResultSet(conn, query38);

            // Enumere el nombre de producto más barato del fabricante Hewlett-Packard.
            String query39 = "SELECT nombre FROM producto WHERE precio = (SELECT MIN(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Hewlett-Packard'))";
            printResultSet(conn, query39);

            // Devuelve todos los productos en la base de datos que tienen un precio más alto o igual al producto más caro del fabricante Lenovo.
            String query40 = "SELECT * FROM producto WHERE precio >= (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Lenovo'))";
            printResultSet(conn, query40);

            // Prepare todos los productos del fabricante Asus que tengan un precio más alto que el precio promedio de todos sus productos.
            String query41 = "SELECT nombre, precio FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Asus') AND precio > (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre_fabricante = 'Asus'))";
            printResultSet(conn, query41);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printResultSet(Connection conn, String query) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();

            for (int i = 1; i <= numColumns; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
} 

