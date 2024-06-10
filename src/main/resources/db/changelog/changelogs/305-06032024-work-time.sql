CREATE TABLE work_times (
    work_time_item_id SERIAL PRIMARY KEY,
    company_id INT,
    day_of_week VARCHAR(50),
    start_time TIME,
    end_time TIME,
    note VARCHAR(250),
    FOREIGN KEY (company_id) REFERENCES companies(company_id) ON DELETE CASCADE
);
