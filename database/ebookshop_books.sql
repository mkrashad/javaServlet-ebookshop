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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `description` longtext NOT NULL,
  `genre` varchar(45) NOT NULL,
  `img` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The Old Man and the Sea','Ernest Hemingway',10.15,'Santiago is an aging, experienced fisherman who has gone eighty-four days without catching a fish. He is now seen as \"salao,\" the worst form of unlucky.','Fiction','old.jpg'),(2,'The Call of the Wild','Jack London',5.98,'The story opens in 1897 with Buck, a powerful 140-pound St. Bernard?Scotch Collie mix, happily living in California\'s Santa Clara Valley as the pampered pet .','Fiction','wild.jpg'),(3,'Children of the Corn','Stephen King',13.12,'Burt and Vicky, a couple trying to save their marriage, are driving to California for a vacation and to visit Vicky\'s brother.','Horror','corn.jpg'),(4,'And Then There Were None','Agatha Christie',7.32,'Eight people arrive on a small, isolated island off the Devon coast, each having received an unexpected personal invitation. ','Thriller','ten.jpg'),(5,'Think of a Number','John Verdon',9.99,'Dave Gurney is a 47-year-old recently retired NYPD homicide detective. His successful career had made him “the most decorated detective in the NYPD.”','Thriller','number.jpg'),(6,'The Mist','Stephen King',4.56,'The morning after a severe thunderstorm, an unnaturally thick mist gradually envelopes the small town of Bridgton, Maine.','Horror','mist.jpg'),(7,'Dracula','Bram Stoker',8.5,'Jonathan Harker, a newly qualified English solicitor, visits Count Dracula at his castle in the Carpathian Mountains to help the Count purchase a house. ','Horror','dracula.jpg');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-11 23:44:04
