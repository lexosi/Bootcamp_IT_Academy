# Description

Store database

We have the product and manufacturing tables, each with the following fields:

- product (codigo, number, precious, codigo_fabricante)

- manufacturer (codigo, number)

The "codigo_fabricante" field of the product entity is related to the ‘code’ field of the manufacturing entity.

Please make the following inquiries:

List the name of all the products in the product table.

List the names and prices of all products in the table here.

List all columns in the product table.

List the name of the products, the price in euros and the price in stateless dollars (USD).

List the name of the products, the price in euros and the price in stateless dollars (USD).

Use the following alias for the columns: product name, euros, dollars.

List the names and prices of all the products in the table I produce, turning the names to capital letters.

List the names and prices of all the products in the table, turning the names to lowercase.

List the name of all manufacturers in one column, and in another column you get in capital letters the first two characters in the manufacturer's name.

List the names and prices of all the products in the table, rounding the value of the price.

List the names and prices of all the products in the table, truncating the value of the price to display it without any decimal places.

List the code of the manufacturers who have products in the product table.

List the code of the manufacturers that have products in the product table, removing the codes that appear repeated.

List the names of the manufacturers ordered ascending.

List the names of the manufacturers ordered in a descending manner.

List the names of the products ordered, first of all, by the name ascending and, secondly, by the price descending.

Returns a list with the top 5 rows in the manufacturing table.

Returns a list with 2 rows from the fourth row of the manufacturing table. The fourth row should also be included in the response.

List the name and price of the cheapest product. (Use only ORDER BY and LIMIT clauses). NOTE: I couldn’t use MIN (price) here, I would need GROUP BY.

List the name and price of the most expensive product. (Use only ORDER BY and LIMIT clauses). NOTE: I couldn't use MAX (price) here, I would need GROUP BY.

List the name of all manufacturer products whose manufacturer code is equal to 2.

Returns a list with the product name, price and manufacturer name of all database products.

Returns a list with the product name, price and manufacturer name of all database products. Sort the result by the manufacturer's name, by alphabetical order.

Returns a list with the product code, product name, manufacturer code and manufacturer name, of all database products.

Returns the product name, price and name of its manufacturer, of the cheapest product.

Returns the product name, price and name of its manufacturer, of the most expensive product.

Returns a list of all Lenovo manufacturer products.

Returns a list of all Crucial manufacturer products that are priced higher than 200 €.

Returns a list with all products from Asus, Hewlett-Packardy Seagate manufacturers. Without using the IN operator.

Returns a list with all products from Asus, Hewlett-Packardy Seagate manufacturers. Using the IN operator.

Returns a list with the name and price of all products of the manufacturers whose name ends by the vowel e.

Returns a list with the name and price of all products whose manufacturer name contains the w character in its name.

Returns a list with the product name, price and manufacturer's name, of all products priced greater than or equal to 180 €. Sort the result, firstly, by the price (in descending order) and, secondly, by the name (in order ascending).

Returns a list with the code and manufacturer name, only of those manufacturers who have associated products in the database.

Returns a list of all manufacturers that exist in the database, along with the products each has. The list must also show those manufacturers that do not have associated products.

Returns a list where only those manufacturers who have no associated product appear.

Returns all products from the Lenovo manufacturer. (Without using INNER JOIN).

Returns all data from the products that have the same price as the most expensive product of the manufacturer Lenovo. (No use INNER JOIN).

List the most expensive product name of manufacturer Lenovo.

List the cheapest product name of manufacturer Hewlett-Packard.

Returns all products in the database that are priced higher or equal to the most expensive product of the manufacturer Lenovo.

Ready all products from the manufacturer Asus that are priced higher than the average price of all its products.

University database

Please download the database of the schema_universidad.sql file, view the E-R diagram in an editor and make the following queries:

Returns a list with the first surname, second surname and the name of all the students. The list must be sorted alphabetically from minor to major by the first surname, second surname and name.

Find out the name and two surnames of students who have not discharged their phone number in the database.

Returns the list of students who were born in 1999.

Returns the list of teachers /es who have not discharged their phone number in the database and also their NIF ends in K.

Returns the list of subjects that are taught in the first quadrimester, in the third course of the degree that identifier 7 has.

Returns a list of teachers /es along with the name of the department to which they are linked. The list must return four columns, first surname, second surname, name and name of the department. The result will be sorted alphabetically from minor to greater for the surnames and the name.

Returns a list with the name of the subjects, start year and end year of the student school year with NIF 26902806M.

Returns a list with the name of all departments that have teachers / are imparting some subject in the Grau in Computer Engineering (Pla 2015).

Returns a list with all students who have enrolled in some subject during the 2018/2019 school year.
Resolving the following 6 consultations using the LEFT JOIN and RIGHT JOIN clauses.

Returns a list with the names of all teachers /es and the departments they have linked. The list must also show those teachers /es that have no associated department. The list must return four columns, name of the department, first surname, second surname and name of the teacher /a. The result will be sorted alphabetically from minor to major by the department's name, surnames and name.

Returns a list with teachers /es who are not associated with a department.

Returns a list with departments that do not have teachers / are associated.

Returns a list with teachers /es that do not impart any subject.

Returns a list with subjects that do not have an assigned teacher/to.

Returns a list with all departments that have not taught subjects in any school year.

Summary consultations:

Returns the total number of students out there.

Calculate how many students were born in 1999.

Calculate how many teachers /es are in each department. The result should only show two columns, one with the name of the department and another with the number of teachers /es in that department. The result should only include departments that have teachers / associates and must be ordered from greater to minor by the number of teachers /es.

Returns a list with all departments and the number of teachers /es in each of them. Please note that departments that do not have teachers or associates may exist. These departments must also appear in the list.

Returns a list with the name of all existing degrees in the database and the number of subjects each has. Please note that there may be degrees that have no associated subjects. These degrees must also appear in the list. The result must be ordered from greater to minor by the number of subjects.
Returns a list with the name of all existing degrees in the database and the number of subjects each has, of the degrees that have more than 40 associated subjects.

Returns a list showing the name of the degrees and the sum of the total number of credits that are for each type of subject. The result must have three columns: grade name, subject type and the sum of the credits of all the subjects of this type.

Returns a list showing how many students have been enrolled in some subject in each of the school courses. The result must show two columns, one column with the school year of start and another with the number of enrolled students.

Returns a list with the number of subjects taught by each teacher/a. The list must take into account those teachers /es who do not impart any subject. The result will show five columns: id, name, first last name, second surname and number of subjects. The result will be ordered from greater to minor by the number of subjects.

Returns all the data from the youngest student / alumni.

Returns a list with teachers /es who have an associate department and who do not impart any subject.

## Exercise

You will certify your level 1 if you build 37 correct queries, 20 of which must be from the University diagram.
