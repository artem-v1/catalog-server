CREATE TABLE cities (
    cities_id BIGINT PRIMARY KEY,
    latitude DECIMAL(9, 6),
    longitude DECIMAL(9, 6),
    population BIGINT,
    population_date DATE,
    location GEOGRAPHY(POINT, 4326)
);