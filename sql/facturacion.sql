-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2017 at 01:40 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `facturacion`
--

-- --------------------------------------------------------

--
-- Table structure for table `catclientes`
--

CREATE TABLE `catclientes` (
  `CveCte` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `RFC` varchar(13) NOT NULL,
  `Domicilio` varchar(40) NOT NULL,
  `Status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catclientes`
--

INSERT INTO `catclientes` (`CveCte`, `Nombre`, `RFC`, `Domicilio`, `Status`) VALUES
(42069, 'Daniel Carbajal EsTodo', '1230124081230', 'calle 1 colonia 2', 'A'),
(1, 'Pedro1', '12312421', 'La luna', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `catproductos`
--

CREATE TABLE `catproductos` (
  `CveProd` int(11) NOT NULL,
  `Descripcion` varchar(30) NOT NULL,
  `Precio` float NOT NULL,
  `Existencia` varchar(11) NOT NULL,
  `Status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catproductos`
--

INSERT INTO `catproductos` (`CveProd`, `Descripcion`, `Precio`, `Existencia`, `Status`) VALUES
(1, 'este producto rifa machin', 69.69, '420', 'A'),
(2, 'Producto 2', 123, '222', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `factdeta`
--

CREATE TABLE `factdeta` (
  `Folio` int(11) NOT NULL,
  `Renglon` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `CveProd` float NOT NULL,
  `Precio` float NOT NULL,
  `Importe` int(11) NOT NULL,
  `Descripcion` varchar(30) NOT NULL,
  `Status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `factdeta`
--

INSERT INTO `factdeta` (`Folio`, `Renglon`, `Cantidad`, `CveProd`, `Precio`, `Importe`, `Descripcion`, `Status`) VALUES
(0, 0, 1, 1, 69.69, 70, 'este producto rifa machin', 'A'),
(0, 1, 1, 2, 123, 123, 'Producto 2', 'A'),
(0, 2, 5, 1, 69.69, 348, 'este producto rifa machin', 'A'),
(1, 0, 5, 2, 123, 615, 'Producto 2', 'A'),
(1, 1, 1002333, 1, 69.69, 69852592, 'este producto rifa machin', 'A'),
(1, 2, 666, 1, 69.69, 46414, 'este producto rifa machin', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `factenca`
--

CREATE TABLE `factenca` (
  `Folio` int(11) NOT NULL,
  `Fecha` varchar(8) NOT NULL,
  `CveCte` int(11) NOT NULL,
  `SubTotal` float NOT NULL,
  `Impuesto` float NOT NULL,
  `Total` float NOT NULL,
  `Status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `factenca`
--

INSERT INTO `factenca` (`Folio`, `Fecha`, `CveCte`, `SubTotal`, `Impuesto`, `Total`, `Status`) VALUES
(1, '20112017', 1, 69899600, 11183900, 81083600, 'A'),
(1, '20112017', 1, 69899600, 11183900, 81083600, 'A'),
(2, '20112017', 1, 0, 0, 0, 'A');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
