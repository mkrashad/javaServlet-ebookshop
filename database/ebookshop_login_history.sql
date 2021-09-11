-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: ebookshop
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `login_history`
--

DROP TABLE IF EXISTS `login_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(45) NOT NULL,
  `ip` varchar(45) NOT NULL,
  `date` timestamp(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_history`
--

LOCK TABLES `login_history` WRITE;
/*!40000 ALTER TABLE `login_history` DISABLE KEYS */;
INSERT INTO `login_history` VALUES (3,'rko','0:0:0:0:0:0:0:1','2021-09-08 13:26:24.692000'),(4,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 13:44:45.340000'),(5,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 16:27:32.088000'),(6,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 16:38:52.268000'),(7,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 16:40:03.365000'),(8,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 16:42:44.013000'),(9,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 16:44:09.200000'),(10,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 16:44:37.994000'),(11,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 16:45:16.760000'),(12,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 16:45:37.678000'),(13,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 17:12:56.568000'),(14,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 21:37:20.262000'),(15,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 21:37:25.425000'),(16,'rashad','0:0:0:0:0:0:0:1','2021-09-08 21:38:10.331000'),(17,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 22:12:47.514000'),(18,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 22:15:00.919000'),(19,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 22:15:59.214000'),(20,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 22:17:05.167000'),(21,'johndoe','0:0:0:0:0:0:0:1','2021-09-08 22:24:31.129000'),(22,'nurlan','0:0:0:0:0:0:0:1','2021-09-08 22:25:05.893000');
/*!40000 ALTER TABLE `login_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-11 23:44:05
