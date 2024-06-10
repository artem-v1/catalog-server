CREATE TABLE city_tags (
    city_tags_id BIGINT,
    tag_key VARCHAR(255),
    tag_value VARCHAR(255),
    FOREIGN KEY (city_tags_id) REFERENCES cities(cities_id)
);