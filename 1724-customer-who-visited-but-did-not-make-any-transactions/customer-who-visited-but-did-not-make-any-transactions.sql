# Write your MySQL query statement below
SELECT c.customer_id , COUNT(c.customer_id) AS count_no_trans
FROM Transactions t
RIGHT JOIN Visits c
   ON c.visit_id = t.visit_id
WHERE t.visit_id IS NULL
GROUP BY c.customer_id;