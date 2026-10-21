# Write your MySQL query statement below
SELECT w.id AS Id
FROM Weather w
JOIN Weather p
ON w.recordDate = DATE_ADD(p.recordDate, INTERVAL 1 DAY)
WHERE w.temperature > p.temperature;


