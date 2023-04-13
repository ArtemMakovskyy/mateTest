SELECT id, name, lastname
FROM authors a
JOIN books_authors ba
ON a.id = ba.author_id
WHERE ba.book_id = 2;

SELECT c.id, model, manufacturer_id, name, country
FROM cars c
JOIN manufacturers m
ON m.id = c.manufacturer_id
WHERE c.is_deleted = FALSE AND c.id = 1;

SELECT c.is_deleted, driver_id, d.name AS driver_name, license_number, car_id,  model, manufacturer_id, m.name, country
FROM drivers d
JOIN cars_drivers cd ON cd.driver_id = d.id
JOIN cars c ON c.id = cd.car_id
JOIN manufacturers m ON m.id = c.manufacturer_id
WHERE c.is_deleted = FALSE AND driver_id = 5;

SELECT country, COUNT(id)
FROM customer
WHERE country != 'USA'
GROUP BY country
HAVING COUNT (id) >= 6
ORDER BY COUNT(id) DESC;

Select subject, AVG(mark) AS average_mark
from scoreboard
Inner join pupil
on scoreboard.pupil_id = pupil.id
WHERE first_name = 'Eugen' AND last_name = 'Tsven'
GROUP BY subject
HAVING AVG(mark)>=10;