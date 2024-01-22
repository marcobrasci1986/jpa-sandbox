CREATE TABLE IF NOT EXISTS sandbox.department
(
    id   int     NOT NULL PRIMARY KEY,
    name varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS sandbox.employee
(
    id   int     NOT NULL PRIMARY KEY,
    name varchar NOT NULL,
    department_id int,
    CONSTRAINT fk_employee_department_id FOREIGN KEY (id) REFERENCES department
);
