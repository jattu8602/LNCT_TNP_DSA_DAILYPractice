# Write your MySQL query statement below
SELECT d.name AS Department , e.name AS Employee , e.salary AS Salary
FROM Employee e
JOIN Department d
ON d.id = e.departmentID
WHERE e.salary>=ALL (
    SELECT salary
    FROM Employee 
    WHERE d.id = departmentID
);