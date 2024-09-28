# DSA_Question Notes

# Introduction of the Linked List.

- // Linked List is linear data structure 
// It's a dynamic data structure  
// we connect each data with a chain .
// I'ts chain is link to attached each data 
// It's store the data in a heap memory
// NUll is reperesent null.
// In java we store reference variable . Reference variable point to object. and object is node 
// First value to store in Node class  is data  
// Next variable ka type node hi hoga .kyu ki node point karta hai object ko 

// Every single data two parts
// 1. which type of data can be store
// 2. next is reference . it's a pointer to point the next node 
- In doubly linked list we pointing to the back but in single linked list cann't do.
- in the linked list next is pointing to the next node.


# Stack
- TOP :- This structure is use for access the topest element.
- pop :- This structure is use for empty the stack.
- push :- push is used to insert the data into the stack


static_cast<long long>(mid*mid);

map<Node*,int>mpp;


# Tortise and horse 
Node* slow=head;
Node* fast=head;
slow increase by one .
fast increase by two.

# Put data in hashmap.
mpp.put({temp,1});


# Strings
# s.isEmpty() check the string is null or not.

# Trim Method
Trim any leading or trailing spaces
        s = s.trim();


# codPointAt(0).
Str.codePointAt(0) Return the Unicode of the first character in a string (the Unicode value of "H" is 72):

# Java String codePointBefore() Method
Definition and Usage
The codePointBefore() method returns the Unicode value of the character before the specified index in a string.

The index of the first character is 1, the second character is 2, and so on.

Note: The value 0 will generate an error, as this is a negative number (out of reach).

# Delete Node in a linkedlist
after delete the node in c++ make sure free of the node otherwise still in the memory.

In java the garbage collection take place and deleted 

# static use because we directly access in the main method


# String convert to number.
int num = Integer.parseInt(String s);

# Math.pow(x,n);
Find easily square


# In the comparison part, left.data != right.data needs to be handled carefully for reference comparison (== vs .equals()).


# 
The logic remains the same, but since Java’s boolean type expects an explicit comparison, we check if ((n >> k) & 1) is equal to 1.


# Stack
stack using arraylist.

offer() and poll() Methods: offer() is used to add elements to the queue, and poll() is used to remove and return the front element.

# 

CREATE DATABASE COLLEGES;
USE collges;

CREATE TABLE COLLEGES (
    Id int,
    Name varchar(20),
    Address varchar(50),
    Age int
);
select * from COLLEGES;
select Name from COLLEGES;
select Address from COLLEGES;
INSERT INTO COLLEGES(Id,Name,Address,Age)
VALUES(1,'SONU','DORABAD',4);
SELECT Name,Address FROM COLLEGES;


-- Add a new column 'Gmail'
ALTER TABLE COLLEGES
ADD COLUMN Gmail VARCHAR(50);

-- Check if the new column is added
DESCRIBE COLLEGES;

-- Select the new column along with existing data
SELECT Name, Address, Gmail FROM COLLEGES;


--  DML
UPDATE CLASS1
SET ADDRESS ='INDORE'
where id=1;
sql_set_safe_updates=0;



# Recursion
those problem to convert non polynomial to polynomial.

Recursion is an algorithm in which a method is called directly or indirectly again and again until a certain condition is meet
This condition is known as base case. 

Direct call to itself and indirect call to another function.


There are three types of recursion.
 the first statement of every recursion code is the base condition
# Head Recursion
 M()
 BC
 M() // Recursive case

# Tail Recursion
M(){
    BC 
    print()
    M() // Recursive Code.
}

#  Tree Recursion

When  there are two or more recursive case are  called recursive case.



Point 
Recursion uses stack memory to store it's recursive case(LIFO)

# Iteration
1. No extra space
2. Faster than linear Recursion but slower than tree
3. More line of code 


# Rcursion
1. stack space 
2. vice versa 
3. less line of code.



It is used to represent all the states of recursion  from the initale state to the base case






