SELECT p.id, p.title, SUM(r.number_of_tickets) as reserved_tickets
FROM plays p
LEFT JOIN reservations r ON r.play_id = p.id
GROUP BY p.id
ORDER BY SUM(number_of_tickets);

WITH withdrawals AS (
	SELECT name, SUM(t.money) AS withdrawal
	FROM transfers t
	WHERE money < 0
	GROUP BY name
), deposits AS (
	SELECT name, SUM(t.money) AS deposit
	FROM transfers t
	WHERE money >= 0
	GROUP BY name
)
SELECT d.name, d.deposit, w.withdrawal
FROM withdrawals w
JOIN deposits d ON w.name = d.name
GROUP BY d.name;
