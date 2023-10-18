# Exercise 1 - Optics

An optic, called “Cul of Ampolla”, wants to computerize customer management /es and eye sales.

First, the optics wants to know what the supplier of each of the glasses is. Specifically, you want to know about each supplier:

The name

The address (street, number, floor, door, city, zip code and country)

Phone

Fax

NIF.

Optics' purchasing policy is based on a brand's glasses being bought from a single supplier (as you can get better prices), but they can buy glasses from various brands to a supplier. From the glasses flight know:

The brand.

The graduation of each of the glasses.

The type of mount (floating, paste or metal).

The color of the mount.

The color of each glass.

The price.

Of the customers/es want to store:

The name.

The postal address.

The phone.

Email.

The date of registration.

When a new customer / customer arrives, store the client/a recommended by the establishment (as long as someone has recommended it).

Our system must indicate who has been the employee /da who has sold each eye.

## Exercise 2 - Pizzeria

You have been hired to design a website that allows home food orders over the Internet.

Consider the following indications for modeling what the project database would be like:

For each client/a we store a unique identifier:

Name.

Surnames.

Address.

Postal code.

Locality.

Province.

Phone number.

Locality and province data will be stored in separate tables. We know that a locality belongs to a single province, and that a province can have many localities. For each locality we store a unique identifier and a name. For each province we store a unique identifier and a name.

A person can place many orders, but a single order can only be placed by a single person. A unique identifier is stored in each order:

Date/ time.

If the order is for home delivery or for picking up in store.

The amount of products that have been selected of each type.

The total price.

An order may consist of one or more products.

Products can be pizzas, burgers and drinks. A unique identifier is stored for each product:

Name.

Description.

Image.

Price.

In the case of pizzas there are several categories that can be changing their names throughout the year. A pizza can only be within a category, but a category can have a lot of pizzas.

A unique identifier and a name are stored in each category. An order is managed by a single store and a store can manage many orders. A unique identifier is stored in each store:

Address.

Postal code.

Locality.

Province.

In a store you can work many employees /des and an employee/da can only work in a store. From each employee /da, a unique identifier is stored:

Name.

Surnames.

NIF.

Phone.

If you work as a cook/a or dealer/a. For home-sharing orders is interested in saving who is the dealer / a who makes the delivery of the order and the date/ time of delivery time.
