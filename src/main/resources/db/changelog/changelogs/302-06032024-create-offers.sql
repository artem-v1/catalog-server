CREATE TABLE offers (
    offer_item_id SERIAL PRIMARY KEY,
    company_id INT,
    category_offer VARCHAR(100),
    type VARCHAR(50),
    title VARCHAR(255),
    description TEXT,
    photo TEXT,
    FOREIGN KEY (company_id) REFERENCES companies(company_id) ON DELETE CASCADE
);
