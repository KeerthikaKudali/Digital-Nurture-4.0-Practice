-- ==============================
-- Procedure 1: ProcessMonthlyInterest
-- ==============================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR rec IN (
    SELECT AccountID, Balance
    FROM Accounts
    WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts
    SET Balance = rec.Balance + (rec.Balance * 0.01)
    WHERE AccountID = rec.AccountID;

    DBMS_OUTPUT.PUT_LINE('Interest added to Account ' || rec.AccountID ||
                         ': New Balance = ' || (rec.Balance + (rec.Balance * 0.01)));
  END LOOP;

  COMMIT;
END;
/

-- ==============================
-- Procedure 2: UpdateEmployeeBonus
-- ==============================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  dept_id IN NUMBER,
  bonus_percent IN NUMBER
) AS
BEGIN
  FOR rec IN (
    SELECT EmployeeID, Name, Salary
    FROM Employees
    WHERE DepartmentID = dept_id
  ) LOOP
    UPDATE Employees
    SET Salary = rec.Salary + (rec.Salary * bonus_percent / 100)
    WHERE EmployeeID = rec.EmployeeID;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to ' || rec.Name ||
                         ': New Salary = ' || (rec.Salary + (rec.Salary * bonus_percent / 100)));
  END LOOP;

  COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) AS
  v_from_balance NUMBER;
BEGIN
  -- Get the balance of the source account
  SELECT Balance INTO v_from_balance
  FROM Accounts
  WHERE AccountID = p_from_account;

  -- Check if sufficient balance exists
  IF v_from_balance >= p_amount THEN
    -- Subtract from source
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    -- Optional: log the transfer
    INSERT INTO Transfers (FromAccount, ToAccount, Amount)
    VALUES (p_from_account, p_to_account, p_amount);

    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_amount || 
                         ' from Account ' || p_from_account || 
                         ' to Account ' || p_to_account);
  ELSE
    DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in Account ' || p_from_account);
  END IF;

  COMMIT;
END;
/
--BEGIN
--  ProcessMonthlyInterest;
--END; use this for scenario-1
--BEGIN
--  UpdateEmployeeBonus(10, 10);
--END; use this for scenario-1
--BEGIN
--  TransferFunds(101, 102, 1000);
--END; use this for scenario 3 but only use F5 to run


