CREATE TABLE offer_characteristics (
    offer_char_item_id SERIAL PRIMARY KEY,
    company_id INT,
    offer_item_id INT,
    offer_category VARCHAR(100),
    char_key VARCHAR(100),
    char_value VARCHAR(100),
    icon VARCHAR(50),
    FOREIGN KEY (company_id) REFERENCES companies(company_id) ON DELETE CASCADE,
    FOREIGN KEY (offer_item_id) REFERENCES offers(offer_item_id) ON DELETE CASCADE
);
