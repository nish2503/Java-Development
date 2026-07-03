-- ============================================================
-- Department Expense Approval System — Database Setup
-- ============================================================
-- Note: Tables themselves will be auto-created/updated by Hibernate
-- (spring.jpa.hibernate.ddl-auto=update) on first application run.
-- This script creates the database and optionally seeds sample data.
-- Run the CREATE DATABASE part first, then start the Spring Boot app
-- once to let Hibernate create the tables, then run the seed INSERTs.
-- ============================================================

CREATE DATABASE IF NOT EXISTS expense_approval_db;
USE expense_approval_db;

-- ============================================================
-- OPTIONAL: Run this section AFTER the Spring Boot app has started
-- at least once (so the tables exist).
-- ============================================================

-- Sample department budgets
INSERT INTO department_budgets (department, month, year, budget_amount)
VALUES
    ('Engineering', 6, 2026, 500000.00),
    ('Sales', 6, 2026, 300000.00),
    ('Marketing', 6, 2026, 200000.00),
    ('Human Resources', 6, 2026, 100000.00);

-- Sample expense claims
INSERT INTO expense_claims (employee_name, department, expense_category, amount, expense_date, description, status, created_at)
VALUES
    ('Aarav Sharma', 'Engineering', 'Travel', 15000.00, '2026-06-10', 'Client site visit travel costs', 'PENDING', NOW()),
    ('Priya Nair', 'Sales', 'Client Entertainment', 8000.00, '2026-06-12', 'Client dinner meeting', 'PENDING', NOW()),
    ('Rohan Verma', 'Marketing', 'Software', 12000.00, '2026-06-05', 'Design tool subscription', 'PENDING', NOW());

-- ============================================================
-- Verification queries (optional)
-- ============================================================
-- SELECT * FROM department_budgets;
-- SELECT * FROM expense_claims;
