-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: lmsr_database
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `AirportId` int NOT NULL AUTO_INCREMENT,
  `AirportName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`AirportId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'KLIA'),(2,'Langkawi Airport'),(3,'Penang Airport'),(4,'KLIA II'),(5,'Sepang Airport'),(6,'Kota Kinabalu Airport');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkpoint`
--

DROP TABLE IF EXISTS `checkpoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checkpoint` (
  `CheckpointId` int NOT NULL AUTO_INCREMENT,
  `CheckpointName` varchar(50) NOT NULL,
  PRIMARY KEY (`CheckpointId`),
  UNIQUE KEY `CheckpointName_UNIQUE` (`CheckpointName`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkpoint`
--

LOCK TABLES `checkpoint` WRITE;
/*!40000 ALTER TABLE `checkpoint` DISABLE KEYS */;
INSERT INTO `checkpoint` VALUES (1,'Checkpoint 1'),(2,'Checkpoint 2'),(3,'Checkpoint 3'),(4,'Checkpoint 4');
/*!40000 ALTER TABLE `checkpoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conveyerlane`
--

DROP TABLE IF EXISTS `conveyerlane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conveyerlane` (
  `ConveyerLaneId` int NOT NULL AUTO_INCREMENT,
  `ConveyerLaneName` varchar(45) NOT NULL,
  PRIMARY KEY (`ConveyerLaneId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conveyerlane`
--

LOCK TABLES `conveyerlane` WRITE;
/*!40000 ALTER TABLE `conveyerlane` DISABLE KEYS */;
INSERT INTO `conveyerlane` VALUES (1,'Lane 1'),(2,'Lane 2'),(3,'Lane 3'),(4,'Lane 4'),(5,'Lane 5');
/*!40000 ALTER TABLE `conveyerlane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `FlightId` int NOT NULL AUTO_INCREMENT,
  `FlightName` varchar(100) DEFAULT NULL,
  `ArrivalTime` datetime NOT NULL,
  PRIMARY KEY (`FlightId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'MH370','2023-01-01 22:14:59');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luggage`
--

DROP TABLE IF EXISTS `luggage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luggage` (
  `LuggageId` int NOT NULL AUTO_INCREMENT,
  `LuggageStatus` varchar(45) NOT NULL,
  `TruckId` int NOT NULL,
  `FlightId` int NOT NULL,
  `PassengerId` int NOT NULL,
  `DateC1` varchar(45) NOT NULL,
  `TimeC1` varchar(45) NOT NULL,
  `DateC2` varchar(45) NOT NULL,
  `TimeC2` varchar(45) NOT NULL,
  `DateC3` varchar(45) NOT NULL,
  `TimeC3` varchar(45) NOT NULL,
  `DateC4` varchar(45) NOT NULL,
  `TimeC4` varchar(45) NOT NULL,
  `ConveyerLaneId` int NOT NULL,
  `StaffId` int NOT NULL,
  PRIMARY KEY (`LuggageId`),
  KEY `LuggageId_refer_TruckId_idx` (`TruckId`),
  KEY `FlightId_idx` (`FlightId`),
  KEY `Luggage_Conveyerlane_FK_idx` (`ConveyerLaneId`),
  KEY `Luggage_Passenger_FK_idx` (`PassengerId`),
  KEY `Luggage_Staff_FK_idx` (`StaffId`),
  CONSTRAINT `Luggage_Conveyerlane_FK` FOREIGN KEY (`ConveyerLaneId`) REFERENCES `conveyerlane` (`ConveyerLaneId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Luggage_Flight_FK` FOREIGN KEY (`FlightId`) REFERENCES `flight` (`FlightId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Luggage_Passenger_FK` FOREIGN KEY (`PassengerId`) REFERENCES `passenger` (`PassengerId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Luggage_Staff_FK` FOREIGN KEY (`StaffId`) REFERENCES `staff` (`StaffId`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Luggage_Truck_FK` FOREIGN KEY (`TruckId`) REFERENCES `truck` (`TruckId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luggage`
--

LOCK TABLES `luggage` WRITE;
/*!40000 ALTER TABLE `luggage` DISABLE KEYS */;
INSERT INTO `luggage` VALUES (1,'Collected',1,1,1,'2023/05/06','13:00','2023/05/06','13:20','2023/05/06','13:45','2023/05/06','14:00',1,1),(2,'Collected',2,1,2,'2023/05/06','13:00','2023/05/06','13:20','2023/05/06','13:45','2023/05/06','14:00',2,2),(3,'Collected',3,1,3,'2023/05/07','15:15','2023/05/07','15:30','2023/05/07','15:45','2023/05/07','16:00',3,3);
/*!40000 ALTER TABLE `luggage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `PassengerId` int NOT NULL AUTO_INCREMENT,
  `PassengerName` varchar(100) DEFAULT NULL,
  `PassengerIc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PassengerId`),
  UNIQUE KEY `PassengerIc_UNIQUE` (`PassengerIc`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'Adib Adlyana','010805083333'),(2,'Auni Afeeqah','991003045555'),(3,'Mohd Hafiz','930109140808'),(4,'Amir Roslan','970203020000'),(5,'Rose Asnarizza','971212149090'),(6,'Anis Sabrina','020613020150'),(7,'Ng Wei hen','990404003344'),(8,'Mohd Faiz','000202029119'),(9,'Siti Syafiqah','010127008989'),(10,'Lee Rang','950909028007');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `StaffId` int NOT NULL AUTO_INCREMENT,
  `StaffName` varchar(100) DEFAULT NULL,
  `StaffIc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`StaffId`),
  UNIQUE KEY `StaffIc_UNIQUE` (`StaffIc`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Yasmin Ahmad','930707025667'),(2,'Hanis Afiqah','941110076768'),(3,'Mohd Rafi','001219001334'),(4,'Ahmad Said','970101087799'),(5,'Aina Syazwani','960405021789');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trackingsheet`
--

DROP TABLE IF EXISTS `trackingsheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trackingsheet` (
  `TrackingSheetId` int NOT NULL AUTO_INCREMENT,
  `CheckInDateTime` datetime NOT NULL,
  PRIMARY KEY (`TrackingSheetId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trackingsheet`
--

LOCK TABLES `trackingsheet` WRITE;
/*!40000 ALTER TABLE `trackingsheet` DISABLE KEYS */;
INSERT INTO `trackingsheet` VALUES (1,'2022-12-31 09:15:27'),(2,'2023-01-01 08:01:59'),(3,'2023-01-01 08:03:48'),(4,'2023-01-02 11:10:34'),(5,'2023-01-02 13:23:19'),(6,'2023-02-21 14:27:00'),(7,'2023-02-25 15:00:59'),(8,'2023-02-28 09:45:29'),(9,'2023-03-10 12:48:33'),(10,'2023-03-11 10:10:10'),(11,'2023-03-15 19:20:38'),(12,'2023-04-08 11:01:08'),(13,'2023-04-09 17:34:12');
/*!40000 ALTER TABLE `trackingsheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truck`
--

DROP TABLE IF EXISTS `truck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `truck` (
  `TruckId` int NOT NULL AUTO_INCREMENT,
  `TruckRegistrationNo` varchar(45) NOT NULL,
  PRIMARY KEY (`TruckId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truck`
--

LOCK TABLES `truck` WRITE;
/*!40000 ALTER TABLE `truck` DISABLE KEYS */;
INSERT INTO `truck` VALUES (1,'HBA2032'),(2,'HDD2043'),(3,'HSD9237'),(4,'HSI2936'),(5,'HLW0293'),(6,'HPE0284');
/*!40000 ALTER TABLE `truck` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-17 14:05:29
