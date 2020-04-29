-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: mail
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attachments`
--

DROP TABLE IF EXISTS `attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachments` (
  `id_attachment` bigint(20) NOT NULL AUTO_INCREMENT,
  `filename` varchar(50) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `id_message` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_attachment`),
  KEY `fk_attachments_message` (`id_message`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachments`
--

LOCK TABLES `attachments` WRITE;
/*!40000 ALTER TABLE `attachments` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `id_city` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(50) DEFAULT NULL,
  `id_country` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id_city`),
  UNIQUE KEY `unq_city` (`city_name`,`id_city`),
  KEY `fk_city_country` (`id_country`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Buenos Aires',1),(2,'Mar del Plata',1),(3,'Rio de Janeiro',2),(4,'Porto Seguro',2);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countries` (
  `id_country` smallint(6) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_country`),
  UNIQUE KEY `country_name` (`country_name`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (4,'Chile'),(5,'Chile2');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger TDB_COUNTRIES before delete on countries for each row
begin
	
	 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'No podes borrar paises', MYSQL_ERRNO = 9912; 
	
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id_message` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_from` bigint(20) DEFAULT NULL,
  `id_to` bigint(20) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `body` text,
  `message_date` date DEFAULT NULL,
  PRIMARY KEY (`id_message`),
  KEY `fk_user_from_message` (`id_from`),
  KEY `fk_user_to_message` (`id_to`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,3,2,'Mensaje 1','Mensaje 1','2019-10-17'),(2,3,2,'Mensaje 2','Mensaje 2','2019-10-17'),(3,3,1,'Mensaje 3','Mensaje 3','2019-10-17'),(4,3,1,'Mensaje 4','Mensaje 4','2019-10-17');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `id_city` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username` (`username`),
  KEY `fk_users_cities` (`id_city`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Juan','Perez','juanperez','81dc9bdb52d04dc20036dbd8313ed055',1),(2,'Pablo','Perez','pabloperez','81dc9bdb52d04dc20036dbd8313ed055',2),(3,'pablo','pablo','pablo','81dc9bdb52d04dc20036dbd8313ed055',1),(4,'Jose','Perez','joseperez','81dc9bdb52d04dc20036dbd8313ed055',4);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mail'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-02 22:34:10
