CREATE TABLE city_names (
    city_names_id BIGINT,
    language VARCHAR(10),
    name VARCHAR(255),
    FOREIGN KEY (city_names_id) REFERENCES cities(cities_id)
);