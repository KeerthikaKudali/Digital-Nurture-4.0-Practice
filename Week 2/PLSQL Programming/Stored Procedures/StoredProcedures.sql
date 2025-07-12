-- Table for Savings Accounts
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    Balance NUMBER,
    AccountType VARCHAR2(20)
);

-- Table for Employees
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    DepartmentID NUMBER,
    Salary NUMBER
);

-- Table for Fund Transfers (optional log)
CREATE TABLE Transfers (
    TransferID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    FromAccount NUMBER,
    ToAccount NUMBER,
    Amount NUMBER,
    TransferDate DATE DEFAULT SYSDATE
);
-- Insert Accounts (Savings and Current)
INSERT INTO Accounts VALUES (101, 1, 10000, 'Savings');
INSERT INTO Accounts VALUES (102, 2, 5000, 'Savings');
INSERT INTO Accounts VALUES (103, 3, 2000, 'Current');

-- Insert Employees (Different Departments)
INSERT INTO Employees VALUES (1, 'Alice', 10, 50000);
INSERT INTO Employees VALUES (2, 'Bob', 10, 45000);
INSERT INTO Employees VALUES (3, 'Charlie', 20, 40000);

COMMIT;
SELECT * FROM Accounts;
SELECT * FROM Employees;



