-- Create a new database called 'LNK'
-- Connect to the 'master' database to run this snippet
USE master
GO
-- Create the new database if it does not exist already
IF NOT EXISTS (
    SELECT [name]
        FROM sys.databases
        WHERE [name] = N'LNK'
)
CREATE DATABASE LNK
GO

-- Create a new table called '[Lendlord]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[Lendlord]', 'U') IS NOT NULL
DROP TABLE [dbo].[Lendlord]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Lendlord]
(
    [lendID] INT IDENTITY(6,1) PRIMARY KEY, -- Primary Key column
    [lendUsername] NVARCHAR(20) NOT NULL UNIQUE,
    [lendPassword] NVARCHAR(8) NOT NULL,
    [lendFullname] NVARCHAR(50),
    [lendPhoneNumber] VARCHAR(10) UNIQUE CONSTRAINT CK_Lendlord_lendPhoneNumber check (lendPhoneNumber NOT LIKE '%[^0-9]%'),
    [lendEmail] NVARCHAR(255) UNIQUE CONSTRAINT CK_Lendlord_lendEmail check (lendEmail LIKE '%_@__%.__%'),
    -- Specify more columns here
);
GO

-- Create a new table called '[User]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[User]', 'U') IS NOT NULL
DROP TABLE [dbo].[User]
GO
-- Create the table in the specified scAhema
CREATE TABLE [dbo].[User]
(
    [userID] INT IDENTITY(6,1) PRIMARY KEY, -- Primary Key column
    [userUsername] NVARCHAR(20) NOT NULL UNIQUE,
    [userPassword] NVARCHAR(8) NOT NULL,
    [userFullname] NVARCHAR(50),
    [userPhoneNumber] VARCHAR(10) UNIQUE CONSTRAINT CK_Lendlord_userPhoneNumber check (userPhoneNumber NOT LIKE '%[^0-9]%'),
    [userEmail] NVARCHAR(255) UNIQUE CONSTRAINT CK_Lendlord_userEmail check (userEmail LIKE '%_@__%.__%'),
    [userRole] INT NOT NULL,
    -- Specify more columns here
);
GO

-- Create a new table called '[Coupon]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[Coupon]', 'U') IS NOT NULL
DROP TABLE [dbo].[Coupon]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Coupon]
(
    [couponID] INT IDENTITY(6,1) PRIMARY KEY, -- Primary Key column
    [couponName] NVARCHAR(50) NOT NULL,
    [couponDetails] NVARCHAR(255) NOT NULL,
    [couponDiscount] FLOAT NOT NULL,
    [couponFor] nvarchar(30) NOT NULL Constraint CK_Coupon_couponFor CHECK (couponFor like 'Tour' or couponFor like 'Hotel'),
    [startDate] DATE not null CONSTRAINT CK_Coupon_startDate CHECK(startDate > getdate()) ,
    [expiredDate] DATE not null CONSTRAINT CK_Coupon_expiredDate CHECK(expiredDate > getdate()),
	[couponStatus] NVARCHAR(50) not null default 'Not Started'
    -- Specify more columns here
);
GO

-- Create a new table called '[Information]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[Information]', 'U') IS NOT NULL
DROP TABLE [dbo].[Information]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Information]
(
    [infoID] INT IDENTITY(6,1) PRIMARY KEY, -- Primary Key column
    [lendID] INT NOT NULL FOREIGN KEY REFERENCES Lendlord(lendID),
    [couponID] INT FOREIGN KEY REFERENCES Coupon(couponID),
    [infoTitle] NVARCHAR(50) NOT NULL,
    [infoAddress] NVARCHAR(255) NOT NULL,
	[infoType] NVARCHAR(255) NOT NULL,
    [infoTypeRoom] NVARCHAR (600) NOT NULL,
    [infoNumber] INT ,
    [infoPrice] FLOAT NOT NULL,
	[inforImage] NVARCHAR (2083) NOT NULL,
    [infoDecription] NVARCHAR(2083) NOT NULL,
	[uploadDate] Date CONSTRAINT CK_Information_uploadDate CHECK(uploadDate >= CAST(GETDATE() AS DATE)),
	[infoStatus] NCHAR(50) NOT NULL,

    -- Specify more columns here
);
GO


-- Create a new table called '[Contract]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[Contract]', 'U') IS NOT NULL
DROP TABLE [dbo].[Contract]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Contract]
(
    [contractID] INT IDENTITY(6,1) PRIMARY KEY, -- Primary Key column
    [infoID] INT NOT NULL FOREIGN KEY REFERENCES Information(infoID),
    [lendID] INT NOT NULL FOREIGN KEY  REFERENCES Lendlord(lendID),
    [userID] INT NOT NULL FOREIGN KEY REFERENCES [User](userID),
    [BookingDate] Date NOT NULL CONSTRAINT CK_Contract_BookingDate CHECK (BookingDate > getdate()),
    [Checkin] Date NOT NULL CONSTRAINT CK_Contract_Checkin CHECK (Checkin > getdate()),
    [Checkout] Date NOT NULL CONSTRAINT CK_Contract_Checkout CHECK (Checkout > getdate()),
    [contractStatus] NVARCHAR(20) not null DEFAULT 'PENDING'

    -- Specify more columns here 
);
GO

-- Create a new table called '[Invoice]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[Invoice]', 'U') IS NOT NULL
DROP TABLE [dbo].[Invoice]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Invoice]
(
    [invoiceID] INT IDENTITY(6,1) PRIMARY KEY, -- Primary Key column
    [contractID] INT NOT NULL FOREIGN KEY REFERENCES [Contract](contractID),
    [invoiceTotal] FLOAT
    -- Specify more columns here
);
GO



---------------------------------------------DATA INPUT--------------------------------------

--1. LendLord

INSERT INTO [Lendlord] ([lendUsername], [lendPassword], [lendFullname], [lendPhoneNumber], [lendEmail])
VALUES
( 'lend1', '12345678', 'Full Name 1', '1234567890', 'email1@example.com'),
( 'lend2', '12345678', 'Full Name 2', '2345678901', 'email2@example.com'),
( 'lend3', '12345678', 'Full Name 3', '3456789012', 'email3@example.com'),
( 'lend4', '12345678', 'Full Name 4', '4567890123', 'email4@example.com'),
( 'lend5', '12345678', 'Full Name 5', '5678901234', 'email5@example.com');

--2. User

INSERT INTO [User] ([userUsername], [userPassword], [userFullname], [userPhoneNumber], [userEmail], [userRole])
VALUES
( 'user1', '12345678', 'Full Name 1', '1234567890', 'email1@example.com', 1),
( 'user2', '12345678', 'Full Name 2', '2345678901', 'email2@example.com', 2),
( 'user3', '12345678', 'Full Name 3', '3456789012', 'email3@example.com', 1),
( 'user4', '12345678', 'Full Name 4', '4567890123', 'email4@example.com', 2),
( 'user5', '12345678', 'Full Name 5', '5678901234', 'email5@example.com', 1);

--3. Coupon
INSERT INTO [Coupon] ( [couponName], [couponDetails], [couponDiscount], [couponFor], [startDate], [expiredDate])
VALUES
( 'Coupon 1', 'Details for coupon 1', 10.0,'Hotel', '2023-09-01', '2023-12-31'),
( 'Coupon 2', 'Details for coupon 2', 20.0,'Tour', '2023-10-01', '2023-11-30'),
( 'Coupon 3', 'Details for coupon 3', 15.0, 'Hotel', '2023-11-01', '2023-10-31'),
( 'Coupon 4', 'Details for coupon 4', 25.0, 'Tour', '2023-09-01', '2023-09-30'),
( 'Coupon 5', 'Details for coupon 5', 30.0, 'Tour', '2023-8-01', '2023-08-31');

--4. Information
INSERT INTO [Information] ([lendID], [couponID], [infoTitle], [infoAddress], [infoType], [infoTypeRoom], [infoNumber], [infoPrice], [inforImage], [infoDecription], [uploadDate], [infoStatus])
VALUES
(6, 6, 'infoTitle_value1', 'infoAddress_value1', 'infoType_value1', 'infoTypeRoom_value1', 1, 10, 'infoImage_value1', 'infoDescription_value1', '2023-07-19', 'Canceled'),
(7, 7, 'infoTitle_value2', 'infoAddress_value2', 'infoType_value2', 'infoTypeRoom_value2', 2, 10, 'infoImage_value2', 'infoDescription_value2', '2023-07-19', 'Accepted'),
(8, 8, 'infoTitle_value3', 'infoAddress_value3', 'infoType_value3', 'infoTypeRoom_value3', 2, 10, 'infoImage_value3', 'infoDescription_value3', '2023-07-20', 'Canceled'),
(9, 9, 'infoTitle_value4', 'infoAddress_value4', 'infoType_value4', 'infoTypeRoom_value4', 3, 10, 'infoImage_value4', 'infoDescription_value4', '2023-07-21', 'Accepted'),
(10, 10, 'infoTitle_value5', 'infoAddress_value5', 'infoType_value5', 'infoTypeRoom_value5', 4, 10, 'infoImage_value5', 'infoDescription_value5', '2023-07-22', 'Canceled');
	


--5. CONTRACT

INSERT INTO [Contract] ([infoID],[lendID], [userID], [BookingDate], [Checkin], [Checkout], [contractStatus])
VALUES
(7, 6, 6, '2023-07-20', '2023-08-01', '2023-08-15', 'PENDING'),
(9, 7, 7, '2023-07-20', '2023-08-01', '2023-08-16', 'COMPLETED'),
(7, 8, 8, '2023-07-20', '2023-08-01', '2023-08-17', 'CANCELED'),
(7, 9, 9, '2023-07-20', '2023-08-01', '2023-08-18', 'PENDING'),
(8, 10, 10, '2023-07-20', '2023-08-01', '2023-08-19', 'PENDING');

--6. INVOICE 
INSERT INTO [Invoice] ( [contractID], [invoiceTotal])
VALUES
( 9, 100),
( 10, 200),
( 11, 300),
( 12, 400),
( 13, 500);
