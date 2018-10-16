-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 16, 2018 at 06:54 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `shopping_product`
--

DROP TABLE IF EXISTS `shopping_product`;
CREATE TABLE IF NOT EXISTS `shopping_product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(100) NOT NULL,
  `productType` varchar(50) NOT NULL,
  `productDesc` text NOT NULL,
  `productImg` varchar(100) NOT NULL,
  `productPrice` double NOT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=MyISAM AUTO_INCREMENT=1235 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shopping_product`
--

INSERT INTO `shopping_product` (`productId`, `productName`, `productType`, `productDesc`, `productImg`, `productPrice`) VALUES
(1230, 'Samsung 9+', 'Cell Phone', 'product 1 description!!!', 'p1.jpg', 700),
(1231, 'iPhone X', 'Cell Phone', 'product 2 description!!!', 'p2.jpg', 999),
(1232, 'Sony XZ2', 'Cell Phone', 'product 3 description!!!', 'p3.jpg', 999),
(1233, 'Dell XPS 15', 'Laptop', 'product 4 description!!!', 'p4.jpg', 1500),
(1234, 'Asus', 'Laptop', 'product 5 description!!!', 'p5.jpg', 1900);

-- --------------------------------------------------------

--
-- Table structure for table `shopping_role`
--

DROP TABLE IF EXISTS `shopping_role`;
CREATE TABLE IF NOT EXISTS `shopping_role` (
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shopping_role`
--

INSERT INTO `shopping_role` (`username`, `role`) VALUES
('bhautik@gmail.com', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `shopping_user`
--

DROP TABLE IF EXISTS `shopping_user`;
CREATE TABLE IF NOT EXISTS `shopping_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `address` text NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shopping_user`
--

INSERT INTO `shopping_user` (`userId`, `username`, `password`, `full_name`, `address`) VALUES
(1, 'bhautik@gmail.com', '12345', 'Bhautik Patel', 'NJ'),
(2, 'yahn@gmail.com', '12345', 'Janu Bhanani', 'Cebu');

-- --------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
