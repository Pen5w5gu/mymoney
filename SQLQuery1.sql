-- Tạo bảng người dùng
CREATE TABLE dbo.Account (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Username VARCHAR(50) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Name VARCHAR(100),
    Email VARCHAR(100) UNIQUE
);

-- Tạo bảng thu nhập
CREATE TABLE dbo.Income (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    date DATE,
    income DECIMAL(10, 2),
    detail TEXT,
    FOREIGN KEY (UserID) REFERENCES dbo.Account(ID)
);

-- Tạo bảng chi tiêu
CREATE TABLE dbo.Expense (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    date DATE,
    expense DECIMAL(10, 2),
    detail TEXT,
    FOREIGN KEY (UserID) REFERENCES dbo.Account(ID)
);

drop table Account