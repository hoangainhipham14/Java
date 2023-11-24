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




