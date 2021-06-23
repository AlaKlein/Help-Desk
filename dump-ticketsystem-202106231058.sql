-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: ticketsystem
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.9-MariaDB

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
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `vendor` varchar(45) NOT NULL,
  `serial_number` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `user_id` int(11) NOT NULL,
  `ip` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_equipment_user_idx` (`user_id`),
  CONSTRAINT `fk_equipment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,'Lenovo i5 7200u, 8 gb RAM, 256 gb SSD','VK310','Laptop','Lenovo','12345678ABCDE','Active',1,'192.168.001.001'),(2,'Dell powerage Core2DUO, 4gb RAM, 500 HDD','Powerage 510','Microcomputer','Dell','1234ABCDERG','Active',2,'192.168.001.002'),(7,'Probook Pentium 2GB RAM, 250GB HDD','e420','Laptop','HP','5454ASD','Inactive',2,'192.168.001.003'),(13,'Lenovo e500 i5 2400, 8GB RAM, 500 GB SSD','e500','Microcomputer','Lenovo','564564ASDASD','Active',2,'192.168.001.004'),(14,'HP i3 2100, 4GB RAM, 500GB HDD','ds459','Microcomputer','HP','dsa4574','Active',2,'192.168.001.006'),(15,'Aspire Celeron, 2BG RAM, 320 HDD','320X','Laptop','Acer','sda5484','Active',2,'192.168.001.005'),(16,'Aspire i7 4740M, 16GB RAM, 240GB SSD','548X','Laptop','Acer','5485DAS','Active',2,'192.168.001.007'),(18,'saddas','dsadsa','dsadasdsa','HP','dsadasads','Active',2,'192.168.001.011'),(19,'Dell Latitude i7 4770, 16gb RAM, 120 SSD','125sad','Microcomputer','Dell','dasdsadsA456SD','Active',2,'192.168.001.009');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `equipment_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `status` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `priority` varchar(100) NOT NULL,
  `atendant` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_user1_idx` (`user_id`),
  KEY `fk_ticket_equipment1_idx` (`equipment_id`),
  CONSTRAINT `fk_ticket_equipment1` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (7,'I think its a Blue screen of death.','51991918012',2,14,'2021-05-24 19:22:00','Finished','Computer Shutting Down on its own','Urgent','ala.klein@gmail.com'),(8,'Need more RAM, my laptop is too slow.','51991918012',2,2,'2021-05-16 16:04:00','Finished','Install more memory','High','ala.klein@gmail.com'),(10,'Please install it so I can view pdf archives.','51991918012',2,2,'2021-05-16 16:36:00','Finished','Install Adobe Reader','Low','ala.klein@gmail.com'),(11,'I need a new VM to install new server to run aplications on new factory sector. I need at least 4 processor cores and 8 gbs of ram.','51 99191-8012',1,7,'2021-05-22 15:57:00','Finished','Create VM to New Server','Urgent','ala.klein@gmail.com'),(30,'Install VMWare Workstation in my computer. I will use some VMs to test deploy app.','51991918012',2,1,'2021-05-30 20:21:00','In Progress','Install VMWare ','Urgent','ala.klein@gmail.com'),(31,'install virtual box to work with vms.','51991918012',2,16,'2021-05-31 12:26:00','In Progress','Install Oracle Virtual Box','Urgent','ala.klein@gmail.com'),(32,'Install VLC player to play some videos.','51991918012',2,16,'2021-05-31 12:29:00','In Progress','Install VLC','Medium','ala.klein@gmail.com'),(33,'Please install Chrome.','51991918012',2,16,'2021-05-31 12:30:00','Finished','Install Chrome','Low','ala.klein@gmail.com'),(34,'Install Office.','51991918012',2,2,'2021-05-31 12:33:00','Finished','MS Office','Medium','ala.klein@gmail.com'),(37,'Install Firefox browserr.','51991918012',2,2,'2021-05-31 18:10:00','Finished','Install Firefox','Medium','ala.klein@gmail.com'),(38,'descricaofsdfsd','51991918012',2,2,'2021-05-31 19:59:00','Finished','teste','Urgent','ala.klein@gmail.com'),(39,'Please install photoshop CS6.','51991918012',2,19,'2021-06-14 18:46:00','Finished','install adobe photoshop','Urgent','ala.klein@gmail.com');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketitem`
--

DROP TABLE IF EXISTS `ticketitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticketitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description_item` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `atendant` varchar(45) DEFAULT NULL,
  `ticket_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticketitem_ticket1_idx` (`ticket_id`),
  CONSTRAINT `fk_ticketitem_ticket1` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketitem`
--

LOCK TABLES `ticketitem` WRITE;
/*!40000 ALTER TABLE `ticketitem` DISABLE KEYS */;
INSERT INTO `ticketitem` VALUES (17,'teste xuxu','2021-05-24 00:00:00','ala.klein@gmail.com',10),(50,'Changed RAM memory to test.','2021-05-30 20:42:00','ala.klein@gmail.com',7),(51,'Installed more memory.','2021-05-30 20:46:00','ala.klein@gmail.com',8),(52,'Waiting for test.','2021-05-30 20:52:00','ala.klein@gmail.com',7),(54,'more testing','2021-05-30 20:58:00','ala.klein@gmail.com',7),(55,'Testing OK. Problem solved.','2021-05-30 21:04:00','ala.klein@gmail.com',7),(56,'MS Office Installed.','2021-05-31 12:45:00','ala.klein@gmail.com',34),(57,'Installation OK.','2021-05-31 12:45:00','ala.klein@gmail.com',34),(58,'Browser installed.','2021-05-31 12:55:00','ala.klein@gmail.com',33),(59,'teste4','2021-05-31 13:44:00','ala.klein@gmail.com',32),(60,'teste5','2021-05-31 13:44:00','ala.klein@gmail.com',32),(61,'Installed.','2021-05-31 14:08:00','ala.klein@gmail.com',30),(63,'teste2','2021-05-31 15:05:00','ala.klein@gmail.com',8),(64,'teste3','2021-05-31 15:15:00','ala.klein@gmail.com',8),(65,'firefox installedd.','2021-05-31 18:11:00','ala.klein@gmail.com',37),(66,'teste','2021-05-31 19:24:00','ala.klein@gmail.com',32),(68,'instalei ram.','2021-05-31 19:59:00','ala.klein@gmail.com',38),(70,'Photoshop Installed.','2021-06-14 18:47:00','ala.klein@gmail.com',39),(71,'Installation ok.','2021-06-14 18:47:00','ala.klein@gmail.com',39),(72,'teste4','2021-06-14 19:33:00','ala.klein@gmail.com',32),(73,'teste6','2021-06-14 19:33:00','ala.klein@gmail.com',32),(75,'teste4','2021-06-14 20:14:00','ala.klein@gmail.com',8),(77,'teste 1','2021-06-14 20:15:00','ala.klein@gmail.com',11),(78,'teste 2','2021-06-14 20:15:00','ala.klein@gmail.com',11),(79,'teste 3','2021-06-14 20:15:00','ala.klein@gmail.com',11);
/*!40000 ALTER TABLE `ticketitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@admin.com','Administrator','25d55ad283aa400af464c76d713c07ad','Active'),(2,'ala.klein@gmail.com','Alã Klein','25d55ad283aa400af464c76d713c07ad','Active'),(3,'teste@insert.com','teste insert','25d55ad283aa400af464c76d713c07ad','Inactive'),(4,'teste@inactive.com','teste inactive','579646aad11fae4dd295812fb4526245','Inactive'),(5,'teste2@insert.com','teste2','25d55ad283aa400af464c76d713c07ad','Inactive'),(6,'joao@gmail.com','João da Silva Santos','550e1bafe077ff0b0b67f4e32f29d751','Active'),(7,'joao.costa@gmail.com','João da Costa','25d55ad283aa400af464c76d713c07ad','Active'),(8,'alaeklein@gmail.com','Alã Klein','25d55ad283aa400af464c76d713c07ad','Active'),(9,'larissa.soares@gmail.com','Larissa Moreira Soares','25d55ad283aa400af464c76d713c07ad','Active'),(18,'samuel.werner@gmail.com','Samuel Werner','25d55ad283aa400af464c76d713c07ad','Active'),(28,'julio.rosa@gmail.com','Júlio Rosa','25d55ad283aa400af464c76d713c07ad','Active'),(29,'alice.klein@gmail.com','Alice Klein','25d55ad283aa400af464c76d713c07ad','Active'),(32,'testeencoding@gmail.com','Teste Encoding','550e1bafe077ff0b0b67f4e32f29d751','Active'),(33,'test@hotmail.com','test ','25d55ad283aa400af464c76d713c07ad','Active'),(34,'testcombo@gmail.com','combo','550e1bafe077ff0b0b67f4e32f29d751','Active'),(35,'ze@carioca.com','Zé Carioca','5506b6b1de8c26ef3ee421e495f0e266','Active'),(36,'rubinho.atrasado@gmail.com','Ruuuuubinhuuuuu','c2f0789e6ad28c3f6f85da1fb9828d79','Active'),(37,'adasdsa@gmail.com','adasdasdas','550e1bafe077ff0b0b67f4e32f29d751','Active'),(67,'teste@testedemo.com','Teste do teste Demo','25d55ad283aa400af464c76d713c07ad','Inactive'),(68,'test@yahoo.com.br','testeadsad','550e1bafe077ff0b0b67f4e32f29d751','Active'),(69,'sadsads@ssaydgsayd.com','dasdasdas','f7e44a922df352c05c5f73cb40ba115','Active'),(70,'teste.final@gmail.com','Teste Final','25d55ad283aa400af464c76d713c07ad','Inactive'),(71,'marcio@gmail.com','Marcio Silva','25d55ad283aa400af464c76d713c07ad','Active'),(72,'testesteste@teste.com','testesteste','25d55ad283aa400af464c76d713c07ad','Active'),(73,'juca.demo@gmail.com','Juca Demo','25d55ad283aa400af464c76d713c07ad','Inactive'),(74,'juca@bala.com','Juca Bala2','25d55ad283aa400af464c76d713c07ad','Inactive');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (1,'Lenovo'),(2,'HP'),(3,'Acer'),(4,'Dell');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ticketsystem'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-23 10:58:28
