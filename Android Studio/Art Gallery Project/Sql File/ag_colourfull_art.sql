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
-- Table structure for table `ag_colourfull_art`
--

CREATE TABLE `ag_colourfull_art` (
  `id` int(11) NOT NULL,
  `product_name` text NOT NULL,
  `product_price` text NOT NULL,
  `product_image` text NOT NULL,
  `product_des` text NOT NULL,
  `product_category` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ag_colourfull_art`
--

INSERT INTO `ag_colourfull_art` (`id`, `product_name`, `product_price`, `product_image`, `product_des`, `product_category`) VALUES
(1, 'Natural', 'Rs. 20000', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.16.46%20PM.jpeg', 'black and white picture', 'Black & White'),
(2, 'Tiger ', 'Rs. 5000', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.16.46%20PM%20(1).jpeg', 'Tiger picture', 'Black & White'),
(3, 'Female', 'Rs. 15000', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.16.47%20PM%20(1).jpeg', 'Female picture', 'Black & White'),
(4, 'Colour', 'Rs. 1000', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.21.46%20PM.jpeg', 'Colour picture', 'ColourFull Art'),
(5, 'ColourFull', 'Rs. 1500', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.21.45%20PM.jpeg', 'Colur picture', 'ColourFull Art'),
(6, 'Boy', 'Rs. 2000', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.20.33%20PM.jpeg', 'Boy picture', 'Sketch'),
(7, 'Footballer', 'Rs. 3000', 'https://mananviradia14.000webhostapp.com/art_gallery/uploads/WhatsApp%20Image%202023-09-14%20at%204.20.33%20PM%20(2).jpeg', 'Footballer picture', 'Sketch');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ag_colourfull_art`
--
ALTER TABLE `ag_colourfull_art`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ag_colourfull_art`
--
ALTER TABLE `ag_colourfull_art`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
