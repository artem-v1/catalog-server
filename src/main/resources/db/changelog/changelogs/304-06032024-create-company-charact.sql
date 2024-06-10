CREATE TABLE company_characteristics (
    com_char_item_id SERIAL PRIMARY KEY,
    company_id INT,
    category VARCHAR(100),
    char_key VARCHAR(100),
    char_value VARCHAR(100),
    icon VARCHAR(50),
    FOREIGN KEY (company_id) REFERENCES companies(company_id) ON DELETE CASCADE
);
