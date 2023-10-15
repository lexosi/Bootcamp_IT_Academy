# Instructions

Exercise 1
Create a hierarchy of objects with three classes: Worker, Online Worker and In-Person Worker.

The Worker class has the attributes first name, last name, price/hour, and the calculateSou() method that receives the number of hours worked as a parameter and multiplies it by the price/hour. Child classes must override it, using @Override.

From the main() of the Main class, make the necessary invocations to demonstrate the operation of the @Override annotation.

For face-to-face workers, the method to calculate their salary will receive as a parameter the number of hours worked per month. When calculating the salary, the number of hours worked will be multiplied by the price/hour, plus the value of a static attribute called gasoline that we will add in this class.

For online workers, the method to calculate their salary will receive the number of hours worked per month as a parameter. When calculating the salary, the number of hours worked will be multiplied by the price/hour and the price of the Internet flat rate will be added, which will be a constant of the Online Worker class.

Exercise 2
Add some obsolete (deprecated) methods to the child classes, and use the corresponding annotation. Invokes obsolete methods from an external class, suppressing the “warnings” for being obsolete through the corresponding annotation.
