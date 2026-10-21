# Write your MySQL query statement below
WITH min_year AS (
    SELECT product_id , MIN(year) AS first_year 
    FROM Sales 
    GROUP BY product_id
) 
SELECT s.product_id , m.first_year AS first_year , s.quantity , s.price 
FROM Sales s
CROSS JOIN min_year m 
WHERE s.product_id  = m.product_id AND  s.year = m.first_year;