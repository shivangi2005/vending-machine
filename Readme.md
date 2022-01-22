###Vending machine Life cycle:

Initialisation -> Ready -> select product -> User change -> Return Change -> Ready

###Process:

1. Initialisation: 
    Initialisation includes 
   1. initialising products/prices, 
   2. assign initial change (coins) to total_change, 
   3. initialise customer_change to 0

2. Ready to accept Input 

3. Input product
    Accept product
	
4. Input customer change
    This includes accepting coins until matches with product price.
	
5. Calculate Change:
    calculate, deduct coins from toal_amount  and return change. 
	
6. Continue Step 2



##Model:
	Product -> name, price
	Change -> penny, 2p, 5p, 10p, 20p, 50p, 1£,2£
	State -> Init, Ready, Select_Product, Accept_change, Return_change
	
	
##Service: 
	 Calculator
	
##Controller
	Initialisation, Calculator
	
##Interface:
	Manage states
	

	
