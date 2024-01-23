--Create table

-- Tạo bảng người dùng
CREATE TABLE dbo.Account (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Username VARCHAR(50) NOT NULL,
    [Password] VARCHAR(255) NOT NULL,
    [FirstName] NVARCHAR(100),
	[LastName] NVARCHAR(100),
    Email VARCHAR(100) UNIQUE
);

-- Thể loại thu nhập 
CREATE TABLE dbo.IncomeCategory (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    [Name] NVARCHAR(50)
);

--Thể loại chi tiêu
CREATE TABLE dbo.ExpenseCategory (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    [Name] NVARCHAR(50) 
);

-- Tạo bảng thu nhập
CREATE TABLE dbo.Income (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    [Date] DATE,
    [Value] DECIMAL(10, 2),
    Detail NVARCHAR(200),
	CategoryID int,
    FOREIGN KEY (UserID) REFERENCES dbo.Account(ID),
	FOREIGN KEY (CategoryID) REFERENCES dbo.IncomeCategory(ID)
);

-- Tạo bảng chi tiêu
CREATE TABLE dbo.Expense (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    [Date] DATE,
    [Value] DECIMAL(10, 2),
    Detail NVARCHAR(200),
	CategoryID int,
    FOREIGN KEY (UserID) REFERENCES dbo.Account(ID),
	FOREIGN KEY (CategoryID) REFERENCES dbo.ExpenseCategory(ID)
);

-- Tạo bảng Event từ bảng Income và Expense

-----------------------------------------
--------------SELECT---------------------
-----------------------------------------

select * from Account
select * from Income
select * from Expense

-- login
select * from Account
where [Username] = 'test'
and [Password] = 'djtmethangtinhngu'

-- getIncomeByUserID
select * from Income
where [UserID] = '1'

-----------------------------------------
--------------INSERT---------------------
-----------------------------------------

--Insert Account (Sign Up)
INSERT INTO Account (Username, Password, Name, Email)
VALUES ('test2', 'djtmethangtinhngu', N'Bố Quân dz', 'test2@example.com');

-- Insert Income
Insert into Income(UserID, Date, Value,Detail)
Values ('1','12/12/2024','200000','địt mẹ thằng tỉnh');

-- Insert Expense
Insert into Expense(UserID, Date, Value,Detail)
Values ('1','12/12/2024','200000','địt mẹ thằng tỉnh');

-----------------------------------------
--------------UPDATE---------------------
-----------------------------------------
UPDATE dbo.Account
SET [Name] = N'Quân'
WHERE ID = '1';


//----------------------------------------
drop table Expense
drop table Income
drop table Account
delete from dbo.Account;