I use Java.

What packages can I use?

I do not think that the GUI solution with Swing is optimal. Would habe liked to add a datepicker and handle exceptions better for example.

Do not know the correct toll free dates, so I can not debug it.

Found it useful to remove more responsibility for showing if they are toll free to the cars.

Introduced a VehicleTypeHandler class to remove responsibility from other classes.

I put the vehicle classes and the interface in their own package to make it more easy to get an overview of the application. 