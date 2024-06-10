ALTER TABLE constants.reference
ADD COLUMN type VARCHAR(255) NOT NULL;

ALTER TABLE constants.reference
ADD COLUMN category_key VARCHAR(255);