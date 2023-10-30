-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 30, 2023 at 11:31 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tp2_jdbc`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `MiseAJourPrixVehicules`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `MiseAJourPrixVehicules` (IN `nom_marque` VARCHAR(255), IN `nouveau_prix` DECIMAL(4,2))   BEGIN
    UPDATE véhicules SET Prix_Loc_Journée = nouveau_prix WHERE Marque = nom_marque;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `ID_Client` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Prénom` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Adresse` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Numéro_Téléphone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_Client`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`ID_Client`, `Nom`, `Prénom`, `Adresse`, `Numéro_Téléphone`) VALUES
(2, 'fName', 'name', 'adresse', '01-23-45-67-89'),
(3, 'Durand', 'Paul', '789 Boulevard du Soleil', '03-45-67-89-01'),
(4, 'Lefebvre', 'Sophie', '1010 Rue de la Mer', '04-56-78-90-12'),
(5, 'Garcia', 'Pierre', '555 Avenue de la Lune', '05-67-89-01-23'),
(6, 'Moreau', 'Céline', '999 Rue de la Montagne', '06-78-90-12-34'),
(7, 'Petit', 'Luc', '123 Avenue des Étoiles', '07-89-01-23-45'),
(8, 'Roux', 'Emma', '333 Rue de la Forêt', '08-90-12-34-56'),
(9, 'Jeanne', 'D\'arc', '15 Avenue des Champs', '07-64-81-35-97'),
(12, 'Jeanne', 'D\'arc', '15 Avenue des Champs', '07-64-81-35-97');

-- --------------------------------------------------------

--
-- Table structure for table `comptes`
--

DROP TABLE IF EXISTS `comptes`;
CREATE TABLE IF NOT EXISTS `comptes` (
  `Numéro_Compte` int NOT NULL AUTO_INCREMENT,
  `Titulaire` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Solde` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Numéro_Compte`)
) ENGINE=MyISAM AUTO_INCREMENT=100012 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comptes`
--

INSERT INTO `comptes` (`Numéro_Compte`, `Titulaire`, `Solde`) VALUES
(100001, 'name', '5000.50'),
(100002, 'Jane Smith', '3399.00'),
(100003, 'Alice Johnson', '7752.50'),
(100004, 'Bob Williams', '6200.00'),
(100005, 'Eva Davis', '4300.00'),
(100006, 'Michael Brown', '8800.00'),
(100007, 'Olivia Lee', '3000.00'),
(100008, 'David Wilson', '4100.00'),
(100009, 'Sophia Miller', '6500.00'),
(100010, 'Liam Anderson', '7700.00');

-- --------------------------------------------------------

--
-- Table structure for table `employés`
--

DROP TABLE IF EXISTS `employés`;
CREATE TABLE IF NOT EXISTS `employés` (
  `ID_Employé` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Prénom` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Poste` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Salaire` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID_Employé`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employés`
--

INSERT INTO `employés` (`ID_Employé`, `Nom`, `Prénom`, `Poste`, `Salaire`) VALUES
(1, 'Dubois', 'Marc', 'Agent de location', '3000.00'),
(2, 'fName', 'name', 'post', '2500.50'),
(3, 'Fontaine', 'Alex', 'Agent de location', '3100.00'),
(4, 'Lecomte', 'Sophie', 'Gestionnaire de comptes', '4100.00'),
(5, 'Boucher', 'Thomas', 'Agent de location', '3050.00'),
(6, 'Rousseau', 'Marie', 'Gestionnaire de comptes', '4200.00'),
(7, 'Martin', 'Paul', 'Agent de location', '3150.00'),
(8, 'Gagnon', 'Julie', 'Gestionnaire de comptes', '4300.00');

-- --------------------------------------------------------

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
CREATE TABLE IF NOT EXISTS `locations` (
  `ID_Location` int NOT NULL AUTO_INCREMENT,
  `ID_Client` int DEFAULT NULL,
  `ID_Véhicule` int DEFAULT NULL,
  `ID_Employé` int DEFAULT NULL,
  `Date_Début` date DEFAULT NULL,
  `Date_Fin` date DEFAULT NULL,
  `Coût_Total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID_Location`),
  KEY `ID_Client` (`ID_Client`),
  KEY `ID_Véhicule` (`ID_Véhicule`),
  KEY `ID_Employé` (`ID_Employé`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `locations`
--

INSERT INTO `locations` (`ID_Location`, `ID_Client`, `ID_Véhicule`, `ID_Employé`, `Date_Début`, `Date_Fin`, `Coût_Total`) VALUES
(1, 1, 1, 1, '2023-09-10', '2023-09-15', '250.00'),
(2, 10001, 123, 10004, '2023-10-21', '2023-11-25', '50.50'),
(3, 3, 2, 3, '2023-09-12', '2023-09-17', '275.00'),
(4, 4, 5, 4, '2023-09-13', '2023-09-16', '220.00'),
(5, 5, 4, 5, '2023-09-14', '2023-09-19', '260.00'),
(6, 6, 7, 6, '2023-09-15', '2023-09-18', '240.00');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE IF NOT EXISTS `transactions` (
  `ID_Transaction` int NOT NULL AUTO_INCREMENT,
  `Numéro_Compte_Source` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Numéro_Compte_Cible` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Montant` decimal(10,2) DEFAULT NULL,
  `Date_Transaction` date DEFAULT NULL,
  PRIMARY KEY (`ID_Transaction`),
  KEY `Numéro_Compte_Source` (`Numéro_Compte_Source`),
  KEY `Numéro_Compte_Cible` (`Numéro_Compte_Cible`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`ID_Transaction`, `Numéro_Compte_Source`, `Numéro_Compte_Cible`, `Montant`, `Date_Transaction`) VALUES
(1, '100001', '100002', '500.00', '2023-09-15'),
(2, '100001', '100004', '500.12', '1989-02-13'),
(3, '100002', '100005', '300.00', '2023-09-17'),
(4, '100006', '100001', '1000.00', '2023-09-18'),
(5, '100007', '100008', '200.00', '2023-09-19'),
(6, '100009', '100010', '600.00', '2023-09-20'),
(7, '100004', '100003', '400.00', '2023-09-21'),
(8, '100005', '100001', '700.00', '2023-09-22'),
(9, '100010', '100009', '900.00', '2023-09-23'),
(10, '100008', '100007', '150.00', '2023-09-24'),
(11, '100001', '100002', '50.50', '2023-10-16'),
(12, '100001', '100002', '50.50', '2023-10-16'),
(13, '100002', '100003', '50.50', '2023-10-16'),
(14, '100001', '100003', '50.50', '2023-10-16'),
(15, '100001', '100003', '50.50', '2023-10-16'),
(16, '100001', '100003', '50.50', '2023-10-19'),
(17, '100001', '100003', '50.50', '2023-10-19'),
(18, '100001', '100002', '0.00', '2023-10-19');

-- --------------------------------------------------------

--
-- Table structure for table `véhicules`
--

DROP TABLE IF EXISTS `véhicules`;
CREATE TABLE IF NOT EXISTS `véhicules` (
  `ID_Véhicule` int NOT NULL AUTO_INCREMENT,
  `Marque` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Modèle` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Année_Fabrication` int DEFAULT NULL,
  `Plaque_Immatriculation` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Prix_Loc_Journée` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ID_Véhicule`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `véhicules`
--

INSERT INTO `véhicules` (`ID_Véhicule`, `Marque`, `Modèle`, `Année_Fabrication`, `Plaque_Immatriculation`, `Prix_Loc_Journée`) VALUES
(1, 'Toyota', 'Corolla', 2020, 'AB 123 CD', '50.00'),
(3, 'Ford', 'Focus', 2021, 'IJ 789 KL', '25.00'),
(4, 'Nissan', 'Altima', 2020, 'MN 123 OP', '48.00'),
(5, 'Volkswagen', 'Jetta', 2019, 'QR 456 ST', '47.00'),
(6, 'Chevrolet', 'Malibu', 2022, 'UV 789 WX', '60.00'),
(7, 'Hyundai', 'Elantra', 2021, 'YZ 123 AB', '52.00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
