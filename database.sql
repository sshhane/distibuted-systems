CREATE TABLE Rentals (
    rentalId int,
    carId int,
    customerId int,
    date date,
    Primary key(rentalId)
)

insert into Rentals values(123, 234, 456, '2018-12-10');

-- CREATE TABLE Cars (
--     carId int not null auto increment,
--     make VARCHAR(30) NOT NULL,
--     cost int NOT NULL,
--     Primary key(carId)
-- )

-- CREATE TABLE Customers (
--     customerId int not null auto increment,
--     firstname VARCHAR(30) NOT NULL,
--     astname VARCHAR(30) NOT NULL,
--     Email VARCHAR(50),
--     CustomerId not null,
--     date date,
--     Primary key(CustomerId)
-- )