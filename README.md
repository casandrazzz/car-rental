# car-rental
MODEL
- model/ domain : Car, User: Customer/Employee, Registration, 

REPO
- repository: In memory/ in database -> Use 'in memory' until final set up of table relations and DB design

SERVICE
- service:
	- Car - create(add), remove(delete), update(-), read(display);
	- Customer - creates an account/signs up    - user name/email -> addCustomer 
												- password 
			   - deletes account                -> deleteCustomer 		
			TO DO : define methods
	- Employee - create(add), remove(delete), update(-), read(display);
	- Registration - create(add), remove(delete), update(-), read(display);
					
*enums: for each value that is available for selection:

FIRST PAGE
- country(combo box): Romania ENUMS
- city(combo box): Cluj-Napoca ENUMS
- location(combo box): Cluj Airport ENUMS

- pick-up date (date widget)
- return date (date widget)

method: Calculate price for the rental period
method: Calculate rental period
- different prices for intervals: TO DO decide which are the intervals (Rental intervals.png)

-Link to ANOTHER Page: Car Fleet, where all cars are displayed -> "Check availability" button 
method: CheckAvailability (if rented if false -> display available) -> message for available/not available


After selecting the rental period and the price is calculated for each car that is found not rented.

Method: Find available cars

On SECOND PAGE(which opens when pressing the "calculate cost" button) 

Section for filtering : Drop down lists with checkboxes (multiple vehicle types can be selected)->
										Vehicle Type (Limousine, Van, SUV, Coupe, Convertible, Pick-up) ENUMS
										Vehicle Transmission (Manual, Automatic) ENUMS
										Age of the user(18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 29, 30+) (User model) ENUMS
										Seats (2,3,4,5,6,7,8,9,10,11,12)ENUMS
List of available cars:
Photo of car 			Description: VehicleMake, VehicleModel, Seats, Transmission		 price/per day, total cost, info(free cancelling etc)		


After the user selects the car, registration is neccesary
Registration: User, Email, Age, Password

method: Validation for age > 18
