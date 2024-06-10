CREATE TABLE reviews (
    review_item_id SERIAL PRIMARY KEY,
    company_id INT,
    photo TEXT,
    title VARCHAR(255),
    date DATE,
    rating INT,
    review_content TEXT,
    review_like INT,
    review_unlike INT,
    FOREIGN KEY (company_id) REFERENCES companies(company_id) ON DELETE CASCADE
);
