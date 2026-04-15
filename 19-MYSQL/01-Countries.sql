-- List all countries along with their region names.
select countries.country_name, regions.region_name
from countries
inner join regions
on countries.REGION_ID = regions.REGION_ID;
-- List all locations along with their country names.
select locations.*, countries.country_name
from locations
inner join countries
on locations.country_id = countries.country_id;
-- Find all regions, including those without any countries.
select r.region_name, c.country_name
from regions r
left join countries c
on r.region_id = c.region_id;
-- Find all countries, including those without any locations.
select c.country_name, l.city
from countries c
left join locations l
on c.COUNTRY_ID = l.COUNTRY_ID;
-- Get the count of countries in each region.
select r.region_name, count(c.country_name) as country_count
from regions r 
left join countries c
on r.REGION_ID = c.REGION_ID
group by r.region_name;
-- Get the count of locations in each country.
select c.country_name, count(l.city) as locations_count
from countries c
left join locations l
on c.country_id = l.country_id
group by c.country_name;
-- List regions that have more than 5 countries.
select r.region_name, count(c.country_name) as country_count
from regions r
left join countries c
on r.REGION_ID = c.REGION_ID
group by r.region_name 
having count(c.COUNTRY_NAME) > 5;
-- Find all cities with their country and region names.
select l.city, c.country_name, r.region_name
from locations l
inner join countries c
on l.country_id = c.COUNTRY_ID
inner join regions r
on c.REGION_ID = r.region_id;
-- List all countries that do not have any locations.
select c.country_name
from countries c
left join locations l
on c.country_id = l.COUNTRY_ID
where l.location_id IS NULL;
-- List the region name, country name, and the number of locations per country.
SELECT r.region_name, c.country_name, COUNT(l.location_id) AS location_count
FROM regions r
JOIN countries c ON r.region_id = c.region_id
LEFT JOIN locations l ON c.country_id = l.country_id
GROUP BY r.region_name, c.country_name;
-- Which countries are located in the "Asia" region?
SELECT c.country_name
FROM countries c
JOIN regions r ON c.region_id = r.region_id
WHERE r.region_name = 'Asia';
-- List the names of all countries in the "Americas" region that have at least one location.
SELECT DISTINCT c.country_name
FROM countries c
JOIN regions r ON c.region_id = r.region_id
JOIN locations l ON c.country_id = l.country_id
WHERE r.region_name = 'Americas';
-- Find all cities in the "Europe" region along with their respective country names.
SELECT l.city, c.country_name
FROM locations l
JOIN countries c ON l.country_id = c.country_id
JOIN regions r ON c.region_id = r.region_id
WHERE r.region_name = 'Europe';
-- How many countries are in the "Middle East and Asia" region?
SELECT COUNT(c.country_id)
FROM countries c
JOIN regions r ON c.region_id = r.region_id
WHERE r.region_name = 'Middle East and Asia';
-- List all regions along with the number of countries in each region.
select r.region_name, count(c.country_name) as country_count
from regions r 
left join countries c
on r.REGION_ID = c.REGION_ID
group by r.region_name;
-- Which countries do not have any associated locations?
select c.country_name
from countries c
left join locations l
on c.country_id = l.COUNTRY_ID
where l.location_id IS NULL;
-- Find all countries along with their region names, where the region name is either "Europe" or "Asia".
SELECT c.country_name, r.region_name
FROM countries c
JOIN regions r ON c.region_id = r.region_id
WHERE r.region_name IN ('Europe', 'Asia');
-- List all locations in "Italy" along with the city and postal code.
SELECT l.city, l.postal_code
FROM locations l
JOIN countries c ON l.country_id = c.country_id
WHERE c.country_name = 'Italy';
-- Which countries have more than one location?
SELECT c.country_name, COUNT(l.location_id)
FROM countries c
JOIN locations l ON c.country_id = l.country_id
GROUP BY c.country_name
HAVING COUNT(l.location_id) > 1;
-- Retrieve all locations in "Canada" and the United States along with the state/province information.
SELECT l.city, l.state_province, c.country_name
FROM locations l
JOIN countries c ON l.country_id = c.country_id
WHERE c.country_name IN ('Canada', 'USA');