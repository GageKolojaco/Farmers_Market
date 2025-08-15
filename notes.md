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

To be fixed:
- Search feature currently breaks after selection of item to search for.
- Fixed - *Adding a second produce adds the quantity values together instead of adding them as seperate items*
- Exit to Market Menu currently exits program in some cases