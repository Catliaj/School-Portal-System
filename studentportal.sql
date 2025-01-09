-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2025 at 04:06 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentportal`
--

-- --------------------------------------------------------

--
-- Table structure for table `academicbackground`
--

CREATE TABLE `academicbackground` (
  `AcademicBackgroundID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `HighSchoolName` varchar(255) NOT NULL,
  `DateGraduated` date NOT NULL,
  `SeniorHighAddress` varchar(255) NOT NULL,
  `FinalAvarage` int(11) NOT NULL,
  `HonorRewards` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `courseenrollmentdetails`
--

CREATE TABLE `courseenrollmentdetails` (
  `CourseDetailsID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `ProgramCourse` varchar(255) NOT NULL,
  `SchoolarApplication` varchar(255) NOT NULL,
  `ID_Picture` longblob NOT NULL,
  `TOR` longblob NOT NULL,
  `Good_Moral` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `parent/guardian_info`
--

CREATE TABLE `parent/guardian_info` (
  `HomeAddress` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `parentinfo`
--

CREATE TABLE `parentinfo` (
  `ParentID` int(11) NOT NULL,
  `StudentID` int(11) DEFAULT NULL,
  `FirstName` varchar(255) NOT NULL,
  `MiddleInitial` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `RelationshipStudent` varchar(255) NOT NULL,
  `ContactNumber` varchar(255) NOT NULL,
  `HomeAddress` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `studentaccount`
--

CREATE TABLE `studentaccount` (
  `AccountID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `UserName` varchar(255) NOT NULL,
  `Passwords` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `students_personal_details`
--

CREATE TABLE `students_personal_details` (
  `StudentID` int(11) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `MiddleInitial` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Gender` enum('Male','Female','Others','') NOT NULL,
  `DateOfBirth` date NOT NULL,
  `ContactNumber` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `HomeAddress` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `academicbackground`
--
ALTER TABLE `academicbackground`
  ADD PRIMARY KEY (`AcademicBackgroundID`);

--
-- Indexes for table `courseenrollmentdetails`
--
ALTER TABLE `courseenrollmentdetails`
  ADD PRIMARY KEY (`CourseDetailsID`);

--
-- Indexes for table `parentinfo`
--
ALTER TABLE `parentinfo`
  ADD PRIMARY KEY (`ParentID`),
  ADD KEY `fk_studentsss` (`StudentID`);

--
-- Indexes for table `studentaccount`
--
ALTER TABLE `studentaccount`
  ADD PRIMARY KEY (`AccountID`);

--
-- Indexes for table `students_personal_details`
--
ALTER TABLE `students_personal_details`
  ADD PRIMARY KEY (`StudentID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `academicbackground`
--
ALTER TABLE `academicbackground`
  MODIFY `AcademicBackgroundID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `courseenrollmentdetails`
--
ALTER TABLE `courseenrollmentdetails`
  MODIFY `CourseDetailsID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `parentinfo`
--
ALTER TABLE `parentinfo`
  MODIFY `ParentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `studentaccount`
--
ALTER TABLE `studentaccount`
  MODIFY `AccountID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `students_personal_details`
--
ALTER TABLE `students_personal_details`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `parentinfo`
--
ALTER TABLE `parentinfo`
  ADD CONSTRAINT `fk_studentsss` FOREIGN KEY (`StudentID`) REFERENCES `students_personal_details` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
