-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 14, 2023 at 11:43 AM
-- Server version: 10.5.20-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id20933068_practice`
--

-- --------------------------------------------------------

--
-- Table structure for table `ag_order`
--

CREATE TABLE `ag_order` (
  `id` int(11) NOT NULL,
  `product_image` text NOT NULL,
  `email` text NOT NULL,
  `product_name` text NOT NULL,
  `product_price` text NOT NULL,
  `payment_method` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ag_order`
--

INSERT INTO `ag_order` (`id`, `product_image`, `email`, `product_name`, `product_price`, `payment_method`) VALUES
(2, 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.16.47%20PM%20(1).jpeg', 'viradiamanan4@gmail.com ', 'Female', 'Rs. 15000', 'cod');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ag_order`
--
ALTER TABLE `ag_order`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ag_order`
--
ALTER TABLE `ag_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
