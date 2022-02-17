-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2019 at 03:34 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AUsername` varchar(20) NOT NULL,
  `APassword` varchar(20) NOT NULL,
  `Aphone` varchar(20) NOT NULL,
  `A_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AUsername`, `APassword`, `Aphone`, `A_id`) VALUES
('Gourab', '123', '0171-5794069', 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `C_id` int(11) NOT NULL,
  `CUserName` varchar(20) NOT NULL,
  `CPassword` varchar(20) NOT NULL,
  `CMobileNumer` varchar(20) NOT NULL,
  `CEmail` varchar(20) NOT NULL,
  `CAge` varchar(20) NOT NULL,
  `CGander` varchar(20) NOT NULL,
  `CAddress` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`C_id`, `CUserName`, `CPassword`, `CMobileNumer`, `CEmail`, `CAge`, `CGander`, `CAddress`) VALUES
(1, 'Kotha', '123', '01717-408647', 'kothak@gmail.com', '21', 'Female', 'Dhaka'),
(2, 'mala', '132', '015784534', 'ads@bjkhsadb.com', '12', 'female', 'dhaka');

-- --------------------------------------------------------

--
-- Table structure for table `delivery_man`
--

CREATE TABLE `delivery_man` (
  `DName` varchar(20) NOT NULL,
  `DPassword` varchar(20) NOT NULL,
  `DPhone` varchar(20) NOT NULL,
  `D_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivery_man`
--

INSERT INTO `delivery_man` (`DName`, `DPassword`, `DPhone`, `D_id`) VALUES
('Ratan', '123', '017-17048045', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `E_id` int(11) NOT NULL,
  `EPhone` varchar(20) NOT NULL,
  `EPassword` varchar(20) NOT NULL,
  `EName` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `salary` varchar(20) NOT NULL,
  `Gander` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`E_id`, `EPhone`, `EPassword`, `EName`, `role`, `salary`, `Gander`) VALUES
(1, '', '123', 'Mala', 'manager', '7000', 'Female'),
(2, '0171654321', '123', 'Antra', 'product manager', '500', 'female');

-- --------------------------------------------------------

--
-- Table structure for table `order_product`
--

CREATE TABLE `order_product` (
  `Product_Name` varchar(20) NOT NULL,
  `Customer_Name` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Delivery_Address` varchar(20) NOT NULL,
  `Order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_product`
--

INSERT INTO `order_product` (`Product_Name`, `Customer_Name`, `Email`, `Phone`, `Delivery_Address`, `Order_id`) VALUES
('Computer', 'Kiron', 'abxz@gmail.com', '0178654345', 'comilla', 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `price` varchar(20) NOT NULL,
  `catagory` varchar(20) NOT NULL,
  `Product_name` varchar(20) NOT NULL,
  `availablity` varchar(20) NOT NULL,
  `Product_id` int(11) NOT NULL,
  `Buy_price` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`price`, `catagory`, `Product_name`, `availablity`, `Product_id`, `Buy_price`) VALUES
('1000', 'book', 'pen', 'yes', 1, '500');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`A_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`C_id`);

--
-- Indexes for table `delivery_man`
--
ALTER TABLE `delivery_man`
  ADD PRIMARY KEY (`D_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`E_id`);

--
-- Indexes for table `order_product`
--
ALTER TABLE `order_product`
  ADD PRIMARY KEY (`Order_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`Product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `A_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `C_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `delivery_man`
--
ALTER TABLE `delivery_man`
  MODIFY `D_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `E_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order_product`
--
ALTER TABLE `order_product`
  MODIFY `Order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `Product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
