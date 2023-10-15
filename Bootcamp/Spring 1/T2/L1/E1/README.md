# Instructions

Create a class called "Product" with the attributes name and price, and another class called "Sale". This class has the attributes of a collection of products and the total sale price.

The "Sale" class has a method called calculateTotal() that throws the custom VentaBuidaException and displays "To make a sale you must first add products" if the product collection is empty. If the collection has products, then you should loop through the collection and save the sum of all the product prices in the total sale price attribute.

The custom exception VendaBuidaException must be a child of the Exception class. We must pass the message to its constructor “To make a sale you must first add products” and when we catch the exception, we must display it on the screen with the getMessage() method of the exception.

Write the code necessary to generate and catch an exception of type ArrayIndexOutOfBoundsException.
