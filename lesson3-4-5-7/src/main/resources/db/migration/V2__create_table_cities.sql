CREATE TABLE city
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name char(50),
    country_id int references country(id)
);