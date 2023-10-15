# Instructions

## Exercice 1

An optical shop, named "Cul de Ampolla," wants to computerize the management of customers and eyeglass sales.

- Firstly, the optical shop wants to know who the supplier is for each pair of glasses. Specifically, they want to know about each supplier:
  - Name
  - Address (street, number, floor, door, city, postal code, and country)
  - Phone
  - Fax
  - Tax Identification Number (NIF).
- The optical shop's purchasing policy is based on buying glasses from a single supplier for each brand (to get better prices), but they can buy glasses from multiple brands from a single supplier. For each pair of glasses, they want to know:
  - Brand
  - Prescription for each lens
  - Frame type (floating, plastic, or metal)
  - Frame color
  - Lens color
  - Price
- They wish to store the following information for customers:
  - Name
  - Postal address
  - Phone number
  - Email
  - Registration date
  - When a new customer arrives, they store the information about the customer who recommended the shop (provided someone recommended them).
- Our system should indicate which employee has sold each pair of glasses.

## Exercice 2

- You have been hired to design a website that allows for online food delivery orders.
- Consider the following instructions to model the database for the project:
- For each customer, we store a unique identifier:
  - Name.
  - Last name.
  - Address.
  - Postal code.
  - City.
  - Province.
  - Phone number.
  - Locality and province data will be stored in separate tables. We know that a locality belongs to a single province, and a province can have many localities.
- For each locality, we store a unique identifier and a name. In each province, we store a unique identifier and a name.
- An individual can place multiple orders, but a single order can only be placed by one person. We store a unique identifier for each order:
  - Date/time.
  - Whether the order is for home delivery or for pick-up in the store.
  - The quantity of products selected for each type.
  - Total price.
- An order can consist of one or more products.
- The products can be pizzas, hamburgers, and beverages. We store a unique identifier for each product:
  - Name.
  - Description.
  - Image.
  - Price.
- In the case of pizzas, there are several categories that can change their names throughout the year. A pizza can only belong to one category, but a category can have many pizzas.
- For each category, we store a unique identifier and a name.
- An order is managed by a single store, and a store can handle many orders. We store a unique identifier for each store:
  - Address.
  - Postal code.
  - City.
  - Province.
- Many employees can work in a store, and an employee can only work in one store. For each employee, we store a unique identifier:
  - Name.
  - Last name.
  - Tax Identification Number (NIF).
  - Phone number.
  - Whether they work as a cook or delivery person. For home delivery orders, it is important to keep track of the delivery person and the date/time of the delivery.
