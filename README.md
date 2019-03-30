# DStructs.java

A simple data structure library.

-----------------------------------

## About the project

This is a college project for the Data Structures course, the goal is to implement the functionalities of some data structures viewed in class. 

I've created this library to use as a model for the application which the user will be interacting with the structures.

--------------------------------------

## Implementation Details

- The list package contains a LinkedList model, this model will be usedd in the first application, which the user will be able to:
    
    1. Insert values at start, end and at some position in the list.
    2. Delete values at start, end and at some position in the list.
    3. Search for a value in the list
    4. Update values of the list.

- The queue package contains a Queue model, it's just a LinkedList with insert and delete restrictions, this model will be used in the second application about Academic Access Control Registries, which the user will be able to:

    1. Add a registry with date, college registry and the type of occurrence (Lost access card, forgotten access card, etc).
    2. Remove registries.
    3. Search for a registry by date, college registry or type of occurrence.
    4. Update registries.
    
- The stack package contains a Stack model, like the queue, it's just a LinkedList with insert and delete restrictions, this model will be used in a thrid application about commitments memo, which the user will be able to:

    1. Add commitments (Date and description).
    2. Remove commitments. 
    3. Search commitments by date or description.
    4. Update commitments.