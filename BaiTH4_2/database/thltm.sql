-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2024 at 12:01 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thltm`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `role`) VALUES
(1, 'nguyenkhoi6546', 'password', 2),
(2, 'vandung', 'password', 1),
(3, 'minhhung', 'password', 1),
(4, 'ngananh', 'password', 2),
(5, 'trancong', 'password', 2),
(6, 'huonggiang', 'password', 1),
(7, 'vanluyn', 'password', 2),
(8, 'nhatminh', 'password', 2),
(17, 'nguyenkhoi', '123123', 2),
(18, 'test123', 'qweqwe', 1),
(20, 'vandung', 'password', 1),
(21, 'vandung12', 'password', 1),
(22, 'nguyenkhoi123', 'password', 2),
(24, 'nguyenkhoi', 'password', 1),
(25, 'nguyenkhoi234', 'password', 1),
(26, 'dung1702', 'password', 2);

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `faculityId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`id`, `name`, `faculityId`) VALUES
(1, '21NH99', 1),
(7, '21NH16', 1),
(8, '21NH78', 1);

-- --------------------------------------------------------

--
-- Table structure for table `faculities`
--

CREATE TABLE `faculities` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `faculities`
--

INSERT INTO `faculities` (`id`, `name`) VALUES
(1, 'Cong Nghe Thong Tin'),
(2, 'Xay dung'),
(27, 'Cong Nghe Thong ');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `yearOfStudent` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  `accountId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `birthday`, `gender`, `tel`, `email`, `yearOfStudent`, `classId`, `accountId`) VALUES
(1, 'Nguyen Khoi', '2018-05-01', 'Nam', '0123456789', 'nguyenkhoi@gmail.com', 3, 1, 1),
(2, 'Ngan Anh 123', '2018-05-01', 'Nu', '0123456789', 'ngananh@gmail.com', 4, 1, 4),
(3, 'Tran Cong', '2018-05-01', 'Nam', '0123456789', 'trancong@gmail.com', 3, 1, 5),
(4, 'Van Luyn', '2018-05-01', 'Nu', '0123456789', 'vanluyn@gmail.com', 3, 1, 7),
(5, 'Nhat Minh', '2018-05-01', 'Nam', '0123456789', 'nhatminh@gmail.com', 3, 1, 8),
(6, 'Dung', '2004-02-17', 'Nu', '0905116397', '234', 2, 2, 18),
(8, 'Dung123', '2003-02-17', 'Nam', '0905116391', 'dung1702@gmail.com', 3, 1, 20),
(10, 'Nguyen Khoi', '2018-05-01', 'Nam', '0123456789', 'nguyenkhoi@gmail.com', 3, 1, 22),
(11, 'Nguyen Khoi', '2018-05-01', 'Nam', '0123456789', 'nguyenkhoi@gmail.com', 3, 1, 23),
(12, 'Huong Giang', '2004-02-17', 'Nu', '0905116397', 'dung1702@gmail.com', 2, 8, 26);

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `faculityId` int(11) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`id`, `name`, `faculityId`, `email`) VALUES
(1, 'Huong Giang', 1, 'huonggiang@gmail.com'),
(2, 'Minh Hung', 1, 'minhhung@gmail.com'),
(6, 'Le Tuan Nguyen Khoi', 1, 'khoi123@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `faculities`
--
ALTER TABLE `faculities`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `faculities`
--
ALTER TABLE `faculities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
