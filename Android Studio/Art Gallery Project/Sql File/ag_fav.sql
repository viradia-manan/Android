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
-- Table structure for table `ag_fav`
--

CREATE TABLE `ag_fav` (
  `id` int(11) NOT NULL,
  `product_name` text NOT NULL,
  `product_price` text NOT NULL,
  `img` varchar(255) NOT NULL,
  `product_email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ag_fav`
--

INSERT INTO `ag_fav` (`id`, `product_name`, `product_price`, `img`, `product_email`) VALUES
(1, 'Colour', 'Rs. 1000', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.21.46%20PM.jpeg', 'viradiamanan4@gmail.com '),
(2, 'Female', 'Rs. 15000', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.16.47%20PM%20(1).jpeg', 'viradiamanan4@gmail.com ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ag_fav`
--
ALTER TABLE `ag_fav`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ag_fav`
--
ALTER TABLE `ag_fav`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
