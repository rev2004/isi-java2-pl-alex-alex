/*
SQLyog Community v8.53 
MySQL - 5.5.16-log : Database - bdepicerie
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bdepicerie` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bdepicerie`;

/*Table structure for table `cartproduits` */

DROP TABLE IF EXISTS `cartproduits`;

CREATE TABLE `cartproduits` (
  `noClient` bigint(20) DEFAULT NULL,
  `noProduit` bigint(20) DEFAULT NULL,
  `qteProduitCommande` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cartproduits` */

insert  into `cartproduits`(`noClient`,`noProduit`,`qteProduitCommande`) values (19,25,1),(19,30,1),(19,31,1),(19,32,1);

/*Table structure for table `categories` */

DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `noCategorie` bigint(20) NOT NULL AUTO_INCREMENT,
  `descriptionCategorie` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`noCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `categories` */

insert  into `categories`(`noCategorie`,`descriptionCategorie`,`image`) values (1,'Fruits','fruitsSmall.gif'),(2,'Légumes','legumesSmall.gif'),(3,'Boulangerie','boulangerieSmall.gif'),(4,'Fromages','fromageSourisSmall.jpg'),(5,'ViandesProtéines','viandeSmall.jpg'),(6,'Conserves','conserveSmall.jpg'),(7,'Céréales','cerealeSmall.jpg'),(8,'Breuvages','breauvageSmall.jpg'),(9,'Surgelés','surgelesSmall.gif'),(10,'Non comestibles','nonCommestibleSmall.gif'),(11,'nouvelle cat','uneImage.jpg'),(12,'nouvelle cat1','uneImage.jpg'),(14,'nouvelle cat3','uneImage.jpg');

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `noClient` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomClient` varchar(100) DEFAULT NULL,
  `prenomClient` varchar(100) DEFAULT NULL,
  `noCiviqueClient` int(11) DEFAULT NULL,
  `rueClient` varchar(100) DEFAULT NULL,
  `codePostalClient` varchar(10) DEFAULT NULL,
  `villeClient` varchar(100) DEFAULT NULL,
  `noCarteCredit` varchar(30) DEFAULT NULL,
  `telephoneClient` varchar(30) DEFAULT NULL,
  `courrielClient` varchar(100) DEFAULT NULL,
  `passwordClient` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`noClient`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*Data for the table `clients` */

insert  into `clients`(`noClient`,`nomClient`,`prenomClient`,`noCiviqueClient`,`rueClient`,`codePostalClient`,`villeClient`,`noCarteCredit`,`telephoneClient`,`courrielClient`,`passwordClient`) values (1,'Tremblay','Bob',12,'Boucher','h4h 2b5','Chicoutimi','111 111 111 123','555 555-5555','bob@hotmail.ca','123456'),(10,'Gilbert','Anette',3443,'Boucher','h4h 2b5','Chicoutimi','111 111 111 111','555 555-5555','anette@videotron.ca\r','123456'),(11,'Bérubé','Simone',33,'Boucher','h4h 2b5','Chicoutimi','111 111 111 111','555 555-5555','client@videotron.com\r','123456'),(12,'Tyler','Simon',54,'Boucher','h4h 2b5','Chicoutimi','111 111 111 111','555 555-5555','client@epicerie.ca\r','123456'),(13,'dalton','mike',666,'Boucher','h4h 2b5','montreal','111 111 111 111','555 555-5555','mdalton@isi-mtl.com\r','123456'),(14,'Tyler','Bob',7656,'Boucher','h4h 2b5','Chicoutimi','111 111 111 111','555 555-5555','bob@videotron.ca\r','123456'),(17,'client','mike',554,'rue','oui','ville','123 456 789','123','mdalton@isi-mtl.com\r','123456'),(18,'Marchildon','Rock',2233,'unrrue','g3g3g3','mtl','1234567899','123-456-7847','rock.marchildon@isi-mtl.com\r','123456'),(19,'Marchildon','Rock',2233,'unrrue','g3g3g3','mtl','1234567899','123-456-7847','a','b');

/*Table structure for table `commandesclients` */

DROP TABLE IF EXISTS `commandesclients`;

CREATE TABLE `commandesclients` (
  `noCommande` bigint(20) NOT NULL AUTO_INCREMENT,
  `totalCommande` double DEFAULT NULL,
  `noClient` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`noCommande`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

/*Data for the table `commandesclients` */

insert  into `commandesclients`(`noCommande`,`totalCommande`,`noClient`) values (1,230.29,1),(2,40.3,10),(3,140.3,11),(4,10.1,12),(5,40.4,12),(6,50.5,12),(7,22.22,1),(8,33.33,1),(9,44.44,11),(10,3.33,10),(13,2.5,1),(14,5,1),(15,2.5,1),(16,2.5,1),(17,5,1),(18,1,1),(19,2.5,1),(20,26,1),(21,26,1),(22,5,1),(23,5,1),(24,5,1),(25,2.5,1),(26,1,1),(27,1,1),(28,2.5,1),(29,2.5,1),(30,24,1),(31,24,1),(32,38,13),(33,38,13),(34,38,13),(35,2.5,17),(36,2,13),(37,12.5,13),(38,12.5,13),(39,2,13),(40,20.5,19),(41,20.5,19),(42,20.5,19);

/*Table structure for table `produits` */

DROP TABLE IF EXISTS `produits`;

CREATE TABLE `produits` (
  `noProduit` bigint(20) NOT NULL AUTO_INCREMENT,
  `descriptionProduit` varchar(100) DEFAULT NULL,
  `qteProduit` int(11) DEFAULT NULL,
  `formatProduit` varchar(100) DEFAULT NULL,
  `prixCoutant` double DEFAULT NULL,
  `prixVendu` double DEFAULT NULL,
  `noCategorie` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`noProduit`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

/*Data for the table `produits` */

insert  into `produits`(`noProduit`,`descriptionProduit`,`qteProduit`,`formatProduit`,`prixCoutant`,`prixVendu`,`noCategorie`) values (1,'Pomme',285,'1x10g',0.5,0.5,1),(2,'Poire',97,'1x10g',0.5,0.5,1),(3,'Oranges',29,'6x10g',2,2,1),(4,'Bananes',14,'6x12g',1,1,1),(5,'Celerie',10,'1x30g',2,2,2),(6,'Concombre',22,'1x13g',1,1,2),(7,'Zuchini',15,'1x13g',2,2,2),(8,'Epinard',20,'1x16oz(sac)',1,1,2),(9,'Mini carottes',20,'1x454g(sac)',2,2,2),(10,'Artichot',20,'1x36g',1,1,2),(11,'Oignons verts',20,'1x30g',1,1,2),(12,'Poivron vert',20,'1x10g',0.5,0.5,2),(13,'Muffins',20,'6x900g',3,3,3),(14,'Tarte aux fruits',20,'1x1kg',7,7,3),(15,'Bagel',20,'6x75g',2,2,3),(16,'Muffin anglais',20,'6x45g',1,1,3),(17,'Pain tranché',20,'1x675g',1,1,3),(18,'Mozzarella',20,'1x350g',2,2,4),(19,'Cheddar',20,'1x350g',2,2,4),(20,'Camembert',18,'1x250g',6,6,4),(21,'Bleu',10,'1x100g',5,5,4),(22,'Swiss tranché',20,'1x200g',3,3,4),(23,'Saucisses italiennes',10,'1x1.2kg',9,9,5),(24,'Mortadelle',10,'1x1kg',12,12,5),(25,'Escalopes de porc',8,'1x1kg',9,9,5),(26,'Jambon Forêt Noir',10,'1x2kg',26,26,5),(27,'Jambon Cuit',10,'1x2kg',22,22,5),(28,'Cotelettes de porc',10,'4x50g',2,2,5),(29,'Saumon',50,'1x100g',4,4,5),(30,'Thon pâle',9,'1x170g',1,1,6),(31,'Soupe pois',10,'1x540ml',2,2,6),(32,'Soupe poulet',20,'1x540ml',2,2,6),(33,'Pois tendres',20,'1x341ml',1,1,6),(34,'Sauce pour pâtes',10,'1x680ml',2,2,6),(35,'Special K',10,'1x400g',4,4,7),(36,'Vector',10,'1x400g',4,4,7),(37,'Cheerios',10,'1x450g',3,3,7),(38,'HoneyComb',10,'1x450g',4,4,7),(39,'Corn pops',10,'1x450g',4,4,7),(40,'Jus pommes',10,'1x1L',3,3,8),(41,'Jus d\'oranges',2,'1x1L',3,3,8),(42,'Jus raisins',6,'1x1L',3,3,8),(43,'Jus légumes',10,'1x1.89L',2,2,8),(44,'Coca cola',50,'1x2L',1,1,8),(45,'Pepsi',50,'1x2L',1,1,8),(46,'Filets de poulet',20,'1x730g',7,7,9),(47,'Pétoncles',20,'1x400g',10,10,9),(48,'Lasagne',20,'1x1kg',8,8,9),(49,'Filet de possons',20,'1x700g',4,4,9),(50,'Pizza garnie',20,'1x800g',6,6,9),(51,'Mouchoirs',20,'1x250f',2,2,10),(52,'Papier hygiénique',20,'6x200f',2,2,10),(53,'Piles',20,'4xAA',3,3,10),(54,'Liquide vaisselle',20,'1x950ml',2,2,10),(55,'Nettoyant',20,'1x950ml',4,4,10),(56,'Essuie-tout',20,'8x100f',5,5,10),(58,'mike',10,'100kg',10,10,5),(59,'bidon',8,'8',8,8,NULL),(60,'Pomme',20,NULL,0.75,0.75,1),(61,'Pomme',20,NULL,0.99,0.99,1),(62,'Pomme',20,NULL,0.99,0.25,1);

/*Table structure for table `produitscommandes` */

DROP TABLE IF EXISTS `produitscommandes`;

CREATE TABLE `produitscommandes` (
  `noProduit` bigint(20) NOT NULL,
  `noCommande` bigint(20) NOT NULL,
  `qteProduitCommande` int(11) DEFAULT NULL,
  `prixPaye` double DEFAULT NULL,
  PRIMARY KEY (`noProduit`,`noCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `produitscommandes` */

insert  into `produitscommandes`(`noProduit`,`noCommande`,`qteProduitCommande`,`prixPaye`) values (1,3,4,3.3),(1,9,4,3.3),(1,10,4,3.3),(2,1,4,3.3),(2,2,4,3.3),(2,3,4,3.3),(2,6,4,3.3),(2,7,4,3.3),(2,8,4,3.3),(2,9,4,3.3),(2,10,4,3.3),(3,1,4,3.3),(3,2,4,3.3),(3,3,4,3.3),(3,6,4,3.3),(3,7,4,3.3),(3,8,4,3.3),(3,9,4,3.3),(3,10,4,3.3),(4,1,4,3.3),(4,2,4,3.3),(4,4,4,3.3),(4,6,4,3.3),(4,7,4,3.3),(4,8,4,3.3),(4,9,4,3.3),(4,10,4,3.3),(5,1,4,3.3),(5,2,4,3.3),(5,5,4,3.3),(5,6,4,3.3),(5,8,3,3.3),(5,9,1,3.3),(5,10,3,3.3),(6,1,2,3.3),(6,2,3,3.3),(6,5,4,3.3),(7,1,5,3.3),(7,2,6,3.3),(7,5,7,3.3),(8,1,8,3.3),(8,2,90,3.3),(8,5,2,3.3),(9,1,22,3.3),(9,2,12,3.3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
