CREATE TABLE companies (
    company_id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    phone VARCHAR(15),
    email VARCHAR(100),
    street VARCHAR(100),
    hause VARCHAR(10),
    city VARCHAR(100),
    land VARCHAR(100),
    post_code VARCHAR(10),
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
	location GEOGRAPHY(POINT, 4326)
);