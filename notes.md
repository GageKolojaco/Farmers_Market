Requirements:
- Allow a user to build a farmer's market
- Allow user to instantiate the farmer's market
- Allow user to create a desired amount of stands
- Allow user to assign a farmer to a stand
- Allow user to assign a desired set of fruit/vegetables to a stand
- Allow interaction with every stand to view the following: Farmer name, Stand ID#, Unique fruits/vegetables assigned to the stand, inventory values of each unique fruit/vegetable assigned to the stand
- Allow user to globally search all stands simultaneously for a desired fruit/vegetable
- Return the result of said search with the Farmer names, Stand ID #'s, and potentially the stand's inventory value of the desired fruit/vegetable
- Allow user to buy a set of produce from a stand
- Accurately update a stand's inventory values corresponding to a purchase made 

Ideas for classes:
FarmersMarket class: Contains a linked list of _Stand_ objects
Stand class: Contains a stand ID#, a _Farmer_ Object and a list of _Produce_ objects
Farmer class: Contains the name of the farmer
Produce class: Parent class of the 5 fruit/vegetable subclasses to be created

Notes: 
- Would probably be easier to implement a wrapper class for inventory management, something that would hold a single instance of a produce subclass and an int value to represent quantity.
- Stand class would then hold a list of mentioned wrapper class instead of list of produce subclass objects
- Moving forward from there, searching would then look like the following: Iterate through the linked list of stand objects, Check if there is an instance of the desired subclass in the list of wrapper class objects contained in each node, check if the int value contained is >0, add farmers name and stand ID # to result to be returned.
- This way of searching sounds inneficient though, think this would be faster if you made a map that took the desired produce subclass as a key.
- Done - *Add flavor text if the produce search comes back empty*
- Maybe add a few more produce subclasses for stress testing
- Done - *Add farmer name to viewStandInDetail*
- Done - *Make it so that when produce is assigned to a stand already stocked in it, the new assignment resets the unit price to its most recent assignment*
- Maybe make it so that when your search for a piece of produce, it returns only the stand's specific item instead of the stand's entire inventory
- Could probably make changing unit price for a specific stands item its own menu category and method, but this is a nonpriority for now
To be fixed:
- Fixed - *Search feature currently breaks after selection of item to search for.*
- Fixed - *Adding a second produce adds the quantity values together instead of adding them as seperate items*
- Fixed - *Exit to Market Menu currently exits program in some cases*
- Fixed - *Program allows for the assignment of duplicate id's for stands, probably fix with a call of containsStand();*
- Fixed - *Program doesn't allow for the purchase of a greater quantity of item than assigned, but the flavor text confirming the sale still pops up*