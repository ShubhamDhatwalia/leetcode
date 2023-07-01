# Write your MySQL query statement below
Select Name as Customers from Customers where Id not in 
(
    Select CustomerId from Orders
)