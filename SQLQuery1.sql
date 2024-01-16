-- Tạo bảng người dùng
CREATE TABLE dbo.Account (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Username VARCHAR(50) NOT NULL,
    [Password] VARCHAR(255) NOT NULL,
    [Name] NVARCHAR(100),
    Email VARCHAR(100) UNIQUE
);

-- Tạo bảng thu nhập
CREATE TABLE dbo.Income (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    [Date] DATE,
    [Value] DECIMAL(10, 2),
    Detail TEXT,
    FOREIGN KEY (UserID) REFERENCES dbo.Account(ID)
);

-- Tạo bảng chi tiêu
CREATE TABLE dbo.Expense (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    [Date] DATE,
    [Value] DECIMAL(10, 2),
    Detail TEXT,
    FOREIGN KEY (UserID) REFERENCES dbo.Account(ID)
);


//-----------------------------------------

INSERT INTO Account (Username, Password, Name, Email)
VALUES ('test2', 'djtmethangtinhngu', N'Bố Quân dz', 'test2@example.com');
INSERT INTO dbo.Account (Username, Password, Name, Email)
VALUES ('test', 'djtmethangtinhngu', N'Bố Quân dz', 'asdas@example.com');

Insert into Income(UserID, date, value,


-- login
select * from Account
where [Username] = 'test'
and [Password] = 'djtmethangtinhngu'

-- getAllIncome

select * from Income
where [UserID] = 'test'

//----------------------------------------
drop table Expense
drop table Income
drop table Account