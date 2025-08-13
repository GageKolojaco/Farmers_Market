Ideas for classes:
FarmersMarket class: Contains a linked list of _Stand_ objects
Stand class: Contains a stand ID#, a _Farmer_ Object and a list of _Produce_ objects
Farmer class: Contains the name of the farmer
Produce class: Parent class of the 5 fruit/vegetable subclasses to be created


Notes: 
- Would probably be easier to implement a wrapper class for inventory management, something that would hold a single instance of a produce subclass and an int value to represent quantity.
- Stand class would then hold a list of mentioned wrapper class instead of list of produce subclass objects
- Moving forward from there, searching would then look like the following: Iterate through the linked list of stand objects, Check if there is an instance of the desired subclass in the list of wrapper class objects contained in each node, check if the int value contained is >0, add farmers name and stand ID # to result to be returned.