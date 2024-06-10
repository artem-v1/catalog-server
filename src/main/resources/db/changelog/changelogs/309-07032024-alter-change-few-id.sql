ALTER TABLE prices RENAME COLUMN price_item_id TO price_id;
ALTER TABLE work_times RENAME COLUMN work_time_item_id TO work_time_id;
ALTER TABLE company_characteristics RENAME COLUMN com_char_item_id TO com_char_id;
ALTER TABLE offers RENAME COLUMN offer_item_id TO offer_id;
ALTER TABLE offer_characteristics RENAME COLUMN offer_char_item_id TO offer_char_id;
ALTER TABLE reviews RENAME COLUMN review_item_id TO review_id;