# Write your MySQL query statement belowz
WITH maxSalary AS (
    SELECT salary , DENSE_RANK() OVER(ORDER BY salary DESC) AS ranking
    FROM Employee
)
SELECT MAX(salary) AS SecondHighestSalary
FROM maxSalary 
WHERE ranking =2;