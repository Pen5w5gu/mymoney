-- Tạo bảng người dùng
CREATE TABLE dbo.Users (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Username VARCHAR(50) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Name VARCHAR(100),
    Email VARCHAR(100) UNIQUE
);

-- Tạo bảng thu nhập
CREATE TABLE dbo.ThuNhap (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    Ngay DATE,
    SoTien DECIMAL(10, 2),
    MoTa TEXT,
    FOREIGN KEY (UserID) REFERENCES dbo.Users(ID)
);

-- Tạo bảng chi tiêu
CREATE TABLE dbo.ChiTieu (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT,
    Ngay DATE,
    SoTien DECIMAL(10, 2),
    MoTa TEXT,
    FOREIGN KEY (UserID) REFERENCES dbo.Users(ID)
);
