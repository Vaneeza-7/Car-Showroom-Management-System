create database carshowroom
use carshowroom

CREATE TABLE Inventory (
    VINs VARCHAR(17) Primary key,
	LastUpdated DATE
	--FOREIGN KEY (VIN) REFERENCES Car(VIN)  --removve one field in cd
);

CREATE TABLE Car (
    VIN VARCHAR(17) PRIMARY KEY,
    Make VARCHAR(50),
    Model VARCHAR(50),
    Price INT,
    Year INT,
    LastServiceDate DATE,
    Owner INT,  --give customer id here when bought other zero
    Color VARCHAR(20),
    Mileage INT,  --change in class diagram
    AvailabilityStatus VARCHAR(20),
	FOREIGN KEY (VIN) REFERENCES Inventory(VINs)
);

-- Base User table
CREATE TABLE Users ( --change user to users
    UserID INT PRIMARY KEY,
    Name VARCHAR(100),
    EmailID VARCHAR (255) UNIQUE,
    Password VARCHAR(255),
    ContactInformation VARCHAR(50)
);

-- Customer table (inherits from Users)
CREATE TABLE Customer (
    ownedCars varchar(17),
    CustomerID INT PRIMARY KEY,
    numberOfCarsOwned INT,
    FOREIGN KEY (CustomerID) REFERENCES Users(UserID),
	foreign key (ownedCars) references Car(VIN)
);

-- Manager table (inherits from Users)
CREATE TABLE Manager (
    ManagerID INT PRIMARY KEY,
    Department VARCHAR(50),  --change in cd
    FOREIGN KEY (ManagerID) REFERENCES Users(UserID)
);

CREATE TABLE Staff (
    StaffID INT PRIMARY KEY,  --change name in cd
    Designation VARCHAR(50),
    FOREIGN KEY (StaffID) REFERENCES Users(UserID)
);

CREATE TABLE ServiceSchedule (
    VIN VARCHAR(17),
    ServiceType VARCHAR(50),
    Date DATE,
    Status VARCHAR(20),
    Comments TEXT,
    PRIMARY KEY (VIN, Date),
    FOREIGN KEY (VIN) REFERENCES Inventory(VINs)
);

CREATE TABLE TestDrive (
    VIN VARCHAR(17),
    CustomerID INT,
    Date DATE,
    Time TIME,
    Status VARCHAR(20),
    Comments TEXT,
    PRIMARY KEY (VIN, CustomerID),
    FOREIGN KEY (VIN) REFERENCES Inventory(VINs),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

CREATE TABLE PurchaseOrder (
    OrderID INT PRIMARY KEY,
    CustomerID INT, --remove customer details
    Date DATE,
    VIN VARCHAR(17),
    Comments TEXT,
    Status VARCHAR(20),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (VIN) REFERENCES Inventory(VINs)
);

CREATE TABLE Invoice (
    InvoiceID INT PRIMARY KEY,
    OrderID INT,
    CustomerID INT,
    --Tax DECIMAL(10, 2),
	Tax INT,
    --Price DECIMAL(10, 2),
	Price INT,
    --TotalAmount DECIMAL(10, 2),
    TotalAmount Float,
    Date DATE,
    TermsAndConditions TEXT,
    FOREIGN KEY (OrderID) REFERENCES PurchaseOrder(OrderID),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

--CREATE TABLE Payment (
--    TransactionID INT PRIMARY KEY,
--    InvoiceID INT,
--    CustomerID INT,
--    Amount DECIMAL(10, 2),
--    Status VARCHAR(20),
--    PaymentDate DATE,
--    PaymentMethod VARCHAR(50),
--    FOREIGN KEY (InvoiceID) REFERENCES Invoice(InvoiceID),
--    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
--);

-- Common Payment table
CREATE TABLE Payment (
    TransactionID INT PRIMARY KEY,
    InvoiceID INT, --change order in cd
    CustomerID INT,
    Amount Float,
    Status VARCHAR(20) default 'unpaid',
    PaymentDate DATE,
    FOREIGN KEY (InvoiceID) REFERENCES Invoice(InvoiceID),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

-- CashPayment table (inherits from Payment)
CREATE TABLE Cash (
    TransactionID INT PRIMARY KEY,
    AccountNumber VARCHAR(20),
    PIN INT,
    Bank VARCHAR(50),
    FOREIGN KEY (TransactionID) REFERENCES Payment(TransactionID)
);

-- CreditCardPayment table (inherits from Payment)
CREATE TABLE CreditCard (
    TransactionID INT PRIMARY KEY,
    CreditCardNumber VARCHAR(16),
    Code int,
    FOREIGN KEY (TransactionID) REFERENCES Payment(TransactionID)
);

--change sales class in cd!!
CREATE TABLE Sales (
    SaleID INT PRIMARY KEY,
    SaleDate DATE,
    carSold VARCHAR(17),
	foreign key (carSold) references Inventory(VINs)
);

CREATE TABLE Report (
    ReportID INT PRIMARY KEY, --change in cd
    Name VARCHAR(100),
    Type VARCHAR(50),
    DateGenerated DATE,
    FilterProperty VARCHAR(255)
);

-- Select all rows from Users
SELECT * FROM Users;

-- Select all rows from Inventory
SELECT * FROM Inventory;

-- Select all rows from Car
SELECT * FROM Car;

-- Select all rows from Customer
SELECT * FROM Customer;

-- Select all rows from Manager
SELECT * FROM Manager;

-- Select all rows from Staff
SELECT * FROM Staff;

-- Select all rows from ServiceSchedule
SELECT * FROM ServiceSchedule;

-- Select all rows from TestDrive
SELECT * FROM TestDrive;

-- Select all rows from PurchaseOrder
SELECT * FROM PurchaseOrder;

-- Select all rows from Invoice
SELECT * FROM Invoice;

-- Select all rows from Payment
SELECT * FROM Payment;

-- Select all rows from Cash
SELECT * FROM Cash;

-- Select all rows from CreditCard
SELECT * FROM CreditCard;

-- Select all rows from Sales
SELECT * FROM Sales;

-- Select all rows from Report
SELECT * FROM Report;

--change for inventory 

--DELIMITER //
--CREATE TRIGGER AfterPaymentInsert
--AFTER INSERT ON Payment
--FOR EACH ROW
--BEGIN
--    DECLARE car_status VARCHAR(20);
--    DECLARE owner_id INT;

--    -- Fetch car status and owner id from Inventory based on the VIN
--    SELECT CarStatus, OwnerID INTO car_status, owner_id
--    FROM Inventory
--    WHERE VIN = NEW.VIN;

--    -- Check if payment status is Successful
--    IF NEW.Status = 'Successful' THEN
--        -- Insert into Sales table
--        INSERT INTO Sales (VIN, NumberOfCarsSold, SaleDate)
--        VALUES (NEW.VIN, 1, NEW.SaleDate);

--        -- Update Inventory table
--        UPDATE Inventory
--        SET CarStatus = 'Sold', OwnerID = NEW.CustomerID, LastUpdated = CURRENT_DATE
--        WHERE VIN = NEW.VIN;
--    END IF;
--END;
--//
--DELIMITER ;

--go
--CREATE TRIGGER AfterPaymentInsert
--ON Payment
--AFTER INSERT
--AS
--BEGIN
--    SET NOCOUNT ON;

--    DECLARE @car_status VARCHAR(20);
--    DECLARE @owner_id INT;

--    -- Fetch car status and owner id from Inventory based on the VIN
--    SELECT @car_status = CarStatus, @owner_id = OwnerID
--    FROM Inventory
--    WHERE VIN = (SELECT VIN FROM INSERTED);

--    -- Check if payment status is Successful
--    IF (SELECT Status FROM INSERTED) = 'Successful'
--    BEGIN
--        -- Insert into Sales table
--        INSERT INTO Sales (VIN, NumberOfCarsSold, SaleDate)
--        VALUES ((SELECT VIN FROM INSERTED), 1, (SELECT SaleDate FROM INSERTED));

--        -- Update Inventory table
--        UPDATE Inventory
--        SET CarStatus = 'Sold', OwnerID = (SELECT CustomerID FROM INSERTED), LastUpdated = GETDATE()
--        WHERE VIN = (SELECT VIN FROM INSERTED);
--    END
--END;
--go

---insertion

-- Insert into Users
INSERT INTO Users (UserID, Name, EmailID, Password, ContactInformation) VALUES (1, 'John Doe', 'john@example.com', 'password123', '555-1234');

-- Insert into Inventory
INSERT INTO Inventory (VINs) VALUES ('ABC123');
INSERT INTO Inventory (VINs) VALUES ('DEF567');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES ('ABC123', 'Toyota', 'Camry', 25000, 2022, '2023-10-01', 0, 'Blue', 5000, 'Available');
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES ('DEF567', 'Ford', 'Escape', 28000, 2023, '2023-11-01', 0, 'Silver', 2000, 'Available');

--muust modiFY all these insertions below commented, not right
---- Insert into Customer
--INSERT INTO Customer (CustomerID, numberOfCarsOwned, ownedCars) VALUES (1, 1, 'ABC123');

---- Insert into ServiceSchedule
--INSERT INTO ServiceSchedule (VIN, ServiceType, Date, Status, Comments) VALUES ('ABC123', 'Oil Change', '2023-11-18', 'Scheduled', 'Routine maintenance');

---- Insert into TestDrive
--INSERT INTO TestDrive (VIN, CustomerID, Date, Time, Status, Comments) VALUES ('DEF567', 1, '2023-11-20', '14:00:00', 'Completed', 'Test drive for potential purchase');

---- Insert into PurchaseOrder
--INSERT INTO PurchaseOrder (OrderID, Date, VIN, Comments, Status) VALUES (1, '2023-11-21', 'DEF567', 'Interested in buying', 'Pending');

---- Insert into Invoice
--INSERT INTO Invoice (InvoiceID, OrderID, CustomerID, Tax, Price, TotalAmount, Date, TermsAndConditions) VALUES (1, 1, 1, 5, 28000, 28005, '2023-11-22', 'Payment due in 30 days');

---- Insert into Payment
--INSERT INTO Payment (TransactionID, InvoiceID, CustomerID, Amount, PaymentDate) VALUES (1, 1, 1, 28005, '2023-11-23');

---- Insert into Cash
--INSERT INTO Cash (TransactionID, AccountNumber, PIN, Bank) VALUES (1, '9876543210', 4321, 'Secure Bank');

---- Insert into CreditCard
--INSERT INTO CreditCard (TransactionID, CreditCardNumber, Code) VALUES (1, '1234567890123456', 789);

---- Insert into Sales
--INSERT INTO Sales (SaleID, SaleDate, carSold) VALUES (1, '2023-11-24', 'DEF567');

---- Insert into Report
--INSERT INTO Report (ReportID, Name, Type, DateGenerated, FilterProperty) VALUES (1, 'SalesReport', 'Monthly', '2023-11-25', 'Type=New');

INSERT INTO Users (UserID, Name, EmailID, Password, ContactInformation) VALUES 
(2, 'Jane Smith', 'jane@example.com', 'pass456', '555-5678'),
(3, 'Alice Johnson', 'alice@example.com', 'pass789', '555-7890'),
(4, 'Bob Wilson', 'bob@example.com', 'pass123', '555-4567');

INSERT INTO Inventory (VINs) VALUES 
('GHI789'),
('JKL012');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES 
('GHI789', 'Honda', 'Accord', 30000, 2021, '2023-09-15', 0, 'Red', 8000, 'Available'),
('JKL012', 'Chevrolet', 'Malibu', 27000, 2022, '2023-11-05', 0, 'White', 6000, 'Available');

-- Insert into Users
INSERT INTO Users (UserID, Name, EmailID, Password, ContactInformation) VALUES 
(5, 'Eva Rodriguez', 'eva@example.com', 'pass567', '555-2345'),
(6, 'Charlie Brown', 'charlie@example.com', 'pass890', '555-6789');

-- Insert into Inventory
INSERT INTO Inventory (VINs) VALUES 
('MNO345'),
('PQR678');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES 
('MNO345', 'Nissan', 'Altima', 26000, 2022, '2023-10-20', 0, 'Black', 7000, 'Available'),
('PQR678', 'Hyundai', 'Elantra', 23000, 2021, '2023-09-10', 0, 'Silver', 9000, 'Available');

-- Insert into Inventory
INSERT INTO Inventory (VINs) VALUES 
('STU901'),
('VWX234');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES 
('STU901', 'Toyota', 'Rav4', 32000, 2023, '2023-11-15', 0, 'Green', 4000, 'Available'),
('VWX234', 'Honda', 'Civic', 28000, 2022, '2023-10-05', 0, 'Blue', 5500, 'Available');

-- Insert into Inventory
INSERT INTO Inventory (VINs) VALUES 
('YZA567'),
('BCD890');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES 
('YZA567', 'Ford', 'Explorer', 35000, 2023, '2023-11-25', 0, 'Silver', 3000, 'Available'),
('BCD890', 'Chevrolet', 'Equinox', 30000, 2022, '2023-10-10', 0, 'Black', 6000, 'Available');

-- Insert into Inventory
INSERT INTO Inventory (VINs) VALUES 
('EFG123'),
('HIJ456');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES 
('EFG123', 'Toyota', 'Highlander', 38000, 2023, '2023-11-30', 0, 'Red', 2000, 'Available'),
('HIJ456', 'Honda', 'Pilot', 40000, 2022, '2023-11-20', 0, 'White', 5000, 'Available');

-- Insert into Inventory
INSERT INTO Inventory (VINs) VALUES 
('KLM789'),
('NOP012');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES 
('KLM789', 'Ford', 'Fusion', 32000, 2023, '2023-11-15', 0, 'Blue', 3000, 'Available'),
('NOP012', 'Chevrolet', 'Traverse', 35000, 2022, '2023-11-05', 0, 'Black', 4000, 'Available');


-- Insert into Inventory
INSERT INTO Inventory (VINs) VALUES 
('QRS345'),
('TUV678');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES 
('QRS345', 'Nissan', 'Rogue', 30000, 2023, '2023-11-25', 0, 'Silver', 2500, 'Available'),
('TUV678', 'Hyundai', 'Santa Fe', 32000, 2022, '2023-11-20', 0, 'Red', 3500, 'Available');

-- Insert into Inventory
INSERT INTO Inventory (VINs) VALUES 
('WXY901'),
('ZAB234'),
('CDE567'),
('FGH890');

-- Insert into Car
INSERT INTO Car (VIN, Make, Model, Price, Year, LastServiceDate, Owner, Color, Mileage, AvailabilityStatus) VALUES 
('WXY901', 'Toyota', 'Corolla', 25000, 2023, '2023-11-10', 0, 'White', 1500, 'Available'),
('ZAB234', 'Honda', 'CR-V', 28000, 2022, '2023-10-30', 0, 'Black', 2000, 'Available'),
('CDE567', 'Ford', 'Edge', 32000, 2023, '2023-11-05', 0, 'Blue', 3000, 'Available'),
('FGH890', 'Chevrolet', 'Camaro', 40000, 2022, '2023-10-20', 0, 'Red', 5000, 'Available');

