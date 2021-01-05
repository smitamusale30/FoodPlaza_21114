-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 14, 2020 at 04:22 PM
-- Server version: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.4-7ubuntu2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `FoodPlaza_21115`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin_21114`
--

CREATE TABLE `Admin_21114` (
  `admEmailID` varchar(255) NOT NULL,
  `admPassword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Admin_21114`
--

INSERT INTO `Admin_21114` (`admEmailID`, `admPassword`) VALUES
('Admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `Cart_21114`
--

CREATE TABLE `Cart_21114` (
  `cartID` int(11) NOT NULL,
  `foodID` int(11) DEFAULT NULL,
  `foodQuantity` int(11) DEFAULT NULL,
  `foodPrice` double DEFAULT NULL,
  `custEmailID` varchar(255) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Customer_21114`
--

CREATE TABLE `Customer_21114` (
  `custName` varchar(255) DEFAULT NULL,
  `custEmailID` varchar(255) NOT NULL,
  `custAddress` text,
  `custContactNo` mediumtext,
  `custPassword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Customer_21114`
--

INSERT INTO `Customer_21114` (`custName`, `custEmailID`, `custAddress`, `custContactNo`, `custPassword`) VALUES
('SmitaMusale', 'smita', 'vashi', '7700087628', 'smita'),
('Smita', 'Smita@gmail.com', 'vashi', '9876541230', '654321'),
('swati', 'swati@gmail.com', 'vashi', '9876543210', 'swati');

-- --------------------------------------------------------

--
-- Table structure for table `Food_21114`
--

CREATE TABLE `Food_21114` (
  `foodID` int(11) NOT NULL,
  `foodName` varchar(255) NOT NULL,
  `foodDescription` text,
  `foodCategory` varchar(255) DEFAULT NULL,
  `foodType` varchar(255) DEFAULT NULL,
  `foodPrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Food_21114`
--

INSERT INTO `Food_21114` (`foodID`, `foodName`, `foodDescription`, `foodCategory`, `foodType`, `foodPrice`) VALUES
(8, 'qwe', 'ffjyfuj ', 'dftfh', 'asdf', 123),
(9, 'fdhgf', 'uu', 'mm', 'gkg', 321),
(10, 'veg pulav', 'veg food ', 'rice', 'veg', 100);

-- --------------------------------------------------------

--
-- Table structure for table `Order_21114`
--

CREATE TABLE `Order_21114` (
  `orderID` int(11) NOT NULL,
  `foodName` varchar(255) DEFAULT NULL,
  `custAddress` text,
  `totalPrice` double DEFAULT NULL,
  `custEmailID` varchar(255) DEFAULT NULL,
  `orderDate` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Order_21114`
--

INSERT INTO `Order_21114` (`orderID`, `foodName`, `custAddress`, `totalPrice`, `custEmailID`, `orderDate`) VALUES
(1, NULL, 'vashi', 1092, 'smita', 'Mon Mar 02 17:15:18 IST 2020'),
(2, NULL, 'vashi', 842, 'smita', 'Mon Mar 02 17:47:12 IST 2020'),
(3, NULL, 'vashi', 546, 'smita', 'Mon Mar 02 17:47:55 IST 2020'),
(4, NULL, 'vashi', 963, 'smita', 'Mon Mar 02 17:48:21 IST 2020'),
(5, NULL, 'vashi', 0, 'smita', 'Mon Mar 02 17:53:28 IST 2020'),
(6, NULL, 'vashi', 123, 'smita', 'Mon Mar 02 18:10:23 IST 2020'),
(7, NULL, 'vashi', 0, 'smita', 'Mon Mar 02 18:40:02 IST 2020'),
(8, NULL, 'vashi', 123, 'smita', 'Mon Mar 02 18:41:29 IST 2020'),
(9, NULL, 'vashi', 1455, 'Smita@gmail.com', 'Mon Mar 02 20:02:12 IST 2020'),
(10, NULL, 'vashi', 742, 'Smita@gmail.com', 'Mon Mar 02 20:02:30 IST 2020');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Cart_21114`
--
ALTER TABLE `Cart_21114`
  ADD PRIMARY KEY (`cartID`),
  ADD KEY `custEmailID` (`custEmailID`);

--
-- Indexes for table `Customer_21114`
--
ALTER TABLE `Customer_21114`
  ADD PRIMARY KEY (`custEmailID`);

--
-- Indexes for table `Food_21114`
--
ALTER TABLE `Food_21114`
  ADD PRIMARY KEY (`foodID`);

--
-- Indexes for table `Order_21114`
--
ALTER TABLE `Order_21114`
  ADD PRIMARY KEY (`orderID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Cart_21114`
--
ALTER TABLE `Cart_21114`
  MODIFY `cartID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Food_21114`
--
ALTER TABLE `Food_21114`
  MODIFY `foodID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `Order_21114`
--
ALTER TABLE `Order_21114`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Cart_21114`
--
ALTER TABLE `Cart_21114`
  ADD CONSTRAINT `Cart_21114_ibfk_1` FOREIGN KEY (`custEmailID`) REFERENCES `Customer_21114` (`custEmailID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
