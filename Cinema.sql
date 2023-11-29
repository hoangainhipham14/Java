SELECT DISTINCT f.name
FROM film f
JOIN screening s
ON f.id = s.film_id;

SELECT r.name, s.row, s.number
FROM room r
JOIN seat s
ON s.room_id = r.id
WHERE r.name = "Room 2";

SELECT f.name, r.name, s.start_time
FROM film f
JOIN screening s ON f.id = s.film_id
JOIN room r ON r.id = s.room_id
WHERE f.name = "Tom&Jerry";

SELECT s.row, s.number, s.type, r.name
FROM booking b
JOIN customer c ON b.customer_id = c.id
JOIN reserved_seat rs ON b.id = rs.booking_id
JOIN seat s ON s.id = rs.seat_id
JOIN room r ON r.id = s.room_id
WHERE c.name = "Dung Nguyen";

SELECT COUNT(DISTINCT f.name)
FROM screening s
JOIN film f ON s.film_id = f.id
WHERE s.start_time BETWEEN '00:00:00 24/5/2022' AND '23:59:59 24/5/2022';

SELECT MAX(f.length) as max_length, MIN(f.length) as min_length
FROM film f;

SELECT COUNT(s.id)
FROM seat s
JOIN room r ON r.id = s.room_id
WHERE r.name = "ROOM 7";

SELECT COUNT(s.id)
FROM reserved_seat rs 
JOIN seat s ON rs.seat_id = s.id
JOIN booking b ON rs.booking_id = b.id
JOIN screening sc ON sc.id = b.screening_id
JOIN film f ON f.id = s.film_id
WHERE f.name = "Tom&Jerry";

-- 1. Show film which dont have any screening
SELECT DISTINCT f.name
FROM film f
LEFT JOIN screening s ON f.id = s.film_id
WHERE s.id IS NULL;

-- 2. Who book more than 1 seat in 1 booking
SELECT DISTINCT c.name
FROM reserved_seat rs
JOIN booking b ON rs.booking_id = b.id
JOIN customer c ON c.id = b.customer_id
GROUP BY b.id
HAVING COUNT(rs.seat_id) > 1;

-- 3. Show room show more than 2 film in one day
SELECT r.name
FROM screening s
JOIN room r ON r.id = s.room_id
GROUP BY s.room_id, DATE(s.start_time)
HAVING COUNT(s.film_id) > 2;

-- which room shows the least film
WITH film_count AS (
	SELECT s.room_id, r.name as room_name, COUNT(DISTINCT s.film_id) as number_of_films
	FROM screening s
	JOIN film f ON f.id = s.film_id
	JOIN room r ON r.id = s.room_id
	GROUP BY s.room_id
)
SELECT *
FROM film_count fc
WHERE fc.number_of_films = (SELECT MIN(number_of_films) FROM film_count);

-- which film doesn't have any booking
SELECT f.name
FROM film f
WHERE f.id NOT IN (
	SELECT DISTINCT s.film_id
    FROM booking b 
    JOIN screening s ON s.id = b.screening_id
);

-- 6. Which film was shown in the biggest number of room?
WITH room_count AS (
	SELECT f.name as film_name, COUNT(DISTINCT s.room_id) as number_of_rooms
	FROM screening s
	JOIN film f ON f.id = s.film_id
	GROUP BY f.id
)
SELECT film_name
FROM room_count rc
WHERE rc.number_of_rooms = (SELECT MAX(number_of_rooms) FROM room_count);

/* 7. Show number of film  that show in every day of week and order descending */
SELECT DATE(start_time) as screening_date, COUNT(DISTINCT film_id) as number_of_films
FROM screening
GROUP BY screening_date
ORDER BY number_of_films;

-- 8. Show total length of each film that showed in 28/05/2022
SELECT s.film_id, SUM(f.length)
FROM screening s
JOIN film f ON f.id = s.film_id
WHERE DATE(s.start_time) = "2022-05-28"
GROUP BY s.film_id;

-- 9. What film has showing time above and below average show time of all film
WITH screening_time AS (
	SELECT f.id, f.name as film_name, SUM(f.length) as total_screening_time
    FROM screening s 
    JOIN film f ON s.film_id = f.id
	GROUP BY f.id
)
SELECT st.id, st.film_name, st.total_screening_time
FROM screening_time st
HAVING st.total_screening_time != (SELECT AVG(total_screening_time) FROM screening_time);
    
-- 10. Which room has the least number of seat
WITH seat_count AS (
	SELECT r.name, COUNT(s.id) as number_of_seats
	FROM room r
	LEFT JOIN seat s ON s.room_id = r.id
	GROUP BY r.id
)
SELECT sc.name, sc.number_of_seats
FROM seat_count sc
WHERE sc.number_of_seats = (SELECT MIN(number_of_seats) FROM seat_count);

-- 11. Room with number of seats which is bigger than the average number of seats of all rooms
WITH seat_count AS (
	SELECT r.name, COUNT(s.id) as number_of_seats
	FROM room r
	LEFT JOIN seat s ON s.room_id = r.id
	GROUP BY r.id
)
SELECT sc.name, sc.number_of_seats
FROM seat_count sc
WHERE sc.number_of_seats > (SELECT AVG(number_of_seats) FROM seat_count);

-- 12. Are there any other available seats that Dung can book for screening 1?
SELECT s.id, s.seat_row, s.seat_number, s.seat_type, r.name
FROM screening sc
JOIN room r ON r.id = sc.room_id
JOIN seat s ON s.room_id = r.id
WHERE sc.id = 1 AND s.id NOT IN (
	SELECT rs.seat_id
    FROM reserved_seat rs
    JOIN booking b ON b.id = rs.booking_id
    JOIN customer c ON c.id = b.customer_id
    WHERE b.screening_id = 1
);

-- 13. Show films with total screening > 10 and order by total screening
SELECT f.id, f.name, SUM(f.length)
FROM film f
JOIN screening s ON s.film_id = f.id
GROUP BY s.film_id
HAVING SUM(f.length) > 10;

-- 14. TOP 3 days in a week based on the number of bookings
SELECT DAYNAME(s.start_time) AS day_of_week, COUNT(b.id) AS total_booking 
FROM booking b
JOIN screening s ON s.id = b.screening_id
GROUP BY DAYNAME(s.start_time)
ORDER BY total_booking DESC
LIMIT 3;

-- 15. Calculate booking rate over screening of each film order by rates.
WITH screening_count AS (
	SELECT f.name as film_name, COUNT(s.id) as total_screening
	FROM screening s
	JOIN film f ON f.id = s.film_id
	GROUP BY f.id
), booking_count AS (
	SELECT f.name as film_name, COUNT(b.id) as total_booking
    FROM booking b
    JOIN screening s ON s.id = b.screening_id
    JOIN film f ON f.id = s.film_id
    GROUP BY f.id
)
SELECT sc.film_name, (bc.total_booking/sc.total_screening) as rate
FROM screening_count sc
LEFT JOIN booking_count bc ON sc.film_name = bc.film_name;

