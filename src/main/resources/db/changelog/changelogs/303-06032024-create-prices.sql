CREATE TABLE prices (
    price_item_id SERIAL PRIMARY KEY,
    company_id INT,
    name VARCHAR(100),
    price INT,
    unit VARCHAR(50),
    info VARCHAR(50),
    FOREIGN KEY (company_id) REFERENCES companies(company_id) ON DELETE CASCADE
);
