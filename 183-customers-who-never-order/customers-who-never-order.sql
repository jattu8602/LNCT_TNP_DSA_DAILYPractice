# Write your MySQL query statement below
-- SELECT c.name AS Customers
-- FROM Customers c
-- WHERE NOT EXISTS (
--     SELECT 1
--     FROM Orders o
--     WHERE o.customerId = c.id
-- );

SELECT c.name AS Customers
FROM Customers c 
LEFT JOIN Orders o
ON o.customerId = c.id 
WHERE o.customerId IS NULL;
