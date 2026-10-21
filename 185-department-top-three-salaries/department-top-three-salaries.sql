# Write your MySQL query statement below
WITH DEPT AS(
    SELECT d.name AS Department  , e.name AS Employee ,e.salary AS Salary ,  DENSE_RANK() OVER(PARTITION BY d.name  ORDER BY e.salary DESC) as rnk
    FROM Employee e 
    JOIN Department d
    ON d.id = e.departmentId
)
SELECT Department , Employee , Salary 
FROM DEPT
WHERE rnk<=3;