CREATE TABLE constants.reference (
    reference_id BIGSERIAL PRIMARY KEY,
    scope VARCHAR(255) NOT NULL,
    key VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    icon VARCHAR(255),
    sort_order INTEGER
);

