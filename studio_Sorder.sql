-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: studio
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `Sorder`
--

DROP TABLE IF EXISTS `Sorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Sorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `movie` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `place` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `round` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `seat` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sorder`
--

LOCK TABLES `Sorder` WRITE;
/*!40000 ALTER TABLE `Sorder` DISABLE KEYS */;
INSERT INTO `Sorder` VALUES (1,NULL,'1','1','1','1'),(2,NULL,'速度與激情9','文賢廳','18:40','B2'),(3,NULL,'格林奇','大武廳','17:30','F19'),(4,NULL,'格林奇','大武廳','17:30','B14'),(5,NULL,'格林奇','文賢廳','22:00','C20'),(6,NULL,'格林奇','大武廳','19:40','D25'),(7,NULL,'格林奇','文賢廳','17:30','G20'),(8,NULL,'格林奇','大武廳','17:30','G19'),(9,NULL,'格林奇','文賢廳','19:30','B20'),(10,NULL,'格林奇','大武廳','17:30','F19'),(11,NULL,'格林奇','大武廳','19:40','F1'),(12,'11','格林奇','11','11','11'),(13,'22','格林奇','22','22','22'),(14,'','格林奇','a','a','a'),(15,'','格林奇','aa','aa','aa'),(16,'','格林奇','','',''),(17,'','格林奇','','',''),(18,'4','格林奇','','',''),(22,'4','格林奇','大武廳','17:30','B12'),(23,'4','格林奇','文賢廳','19:40','C13'),(91,'test1','格林奇','大武廳','17:30','B25'),(92,'test1','胡桃夾子和四個王國','文賢廳','19:40','C23'),(93,'test1','少年泰坦出發！','文賢廳','22:00','c23'),(94,'test1','無敵破壞王 2','大武廳','17:30','D20'),(95,'test1','無敵破壞王 2','文賢廳','17:30','G21'),(96,'test1','少年泰坦出發！','文賢廳','22:00','C25'),(97,'test2','無敵破壞王 2','文賢廳','17:30','D14'),(98,'test1','無敵破壞王 2','文賢廳','17:30','C10');
/*!40000 ALTER TABLE `Sorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-17 15:23:19
