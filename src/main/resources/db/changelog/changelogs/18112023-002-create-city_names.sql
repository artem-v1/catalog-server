CREATE TABLE city_names (
    city_id BIGINT,
    language VARCHAR(10),
    name VARCHAR(255),
    FOREIGN KEY (city_id) REFERENCES cities(id)
);