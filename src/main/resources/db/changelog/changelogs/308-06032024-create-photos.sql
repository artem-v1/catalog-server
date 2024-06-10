CREATE TABLE photos (
    photo_id SERIAL PRIMARY KEY,
    company_id INT,
    offer_item_id INT,
    photo_name VARCHAR(100),
    photo_link VARCHAR(100),
    FOREIGN KEY (company_id) REFERENCES Companies(company_id) ON DELETE CASCADE,
    FOREIGN KEY (offer_item_id) REFERENCES Offers(offer_item_id) ON DELETE CASCADE
);
