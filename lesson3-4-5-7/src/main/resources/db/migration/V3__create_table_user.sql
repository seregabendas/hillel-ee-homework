CREATE TABLE user
(
    id int AUTO_INCREMENT PRIMARY KEY,
    name char(50),
    city_id int references city(id)
);