-- 1. NATURAL JOIN
SELECT *
FROM locations
NATURAL JOIN countries;

-- 2. JOIN ... USING (country_id)
SELECT l.location_id, l.city, c.country_name, c.region_id
FROM locations l
JOIN countries c USING (country_id);

-- 3. JOIN ... ON
SELECT l.location_id, l.city, c.country_name, c.region_id
FROM locations l
JOIN countries c ON l.country_id = c.country_id;

-- 4. INNER JOIN
SELECT l.location_id, l.city, c.country_name
FROM locations l
INNER JOIN countries c ON l.country_id = c.country_id;

-- 5. LEFT JOIN
SELECT l.location_id, l.city, c.country_name
FROM locations l
LEFT JOIN countries c ON l.country_id = c.country_id;

-- 6. RIGHT JOIN
SELECT l.location_id, l.city, c.country_name
FROM locations l
RIGHT JOIN countries c ON l.country_id = c.country_id;

-- 7. FULL OUTER JOIN (MySQL version)
SELECT l.location_id, l.city, c.country_name
FROM locations l
LEFT JOIN countries c ON l.country_id = c.country_id
UNION
SELECT l.location_id, l.city, c.country_name
FROM locations l
RIGHT JOIN countries c ON l.country_id = c.country_id;