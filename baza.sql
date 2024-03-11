/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.21-MariaDB : Database - bazaprojekat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bazaprojekat` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bazaprojekat`;

/*Table structure for table `autor` */

DROP TABLE IF EXISTS `autor`;

CREATE TABLE `autor` (
  `AutorID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ImeAutora` varchar(255) DEFAULT NULL,
  `PrezimeAutora` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AutorID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `autor` */

insert  into `autor`(`AutorID`,`ImeAutora`,`PrezimeAutora`) values 
(1,'Dz.R.R. ','Tolkin'),
(2,'Harlan','Koben'),
(3,'Agata','Kristi'),
(4,'Luiza Mej','Alkot'),
(5,'Andea','Barc'),
(6,'Slavenka','Drakulic'),
(7,'Luis','Kerol');

/*Table structure for table `kategorija` */

DROP TABLE IF EXISTS `kategorija`;

CREATE TABLE `kategorija` (
  `KnjigaID` bigint(20) unsigned NOT NULL,
  `ZanrID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`KnjigaID`,`ZanrID`),
  KEY `fk_kat_zanr` (`ZanrID`),
  CONSTRAINT `fk_kat_knjigaID` FOREIGN KEY (`KnjigaID`) REFERENCES `knjiga` (`KnjigaID`),
  CONSTRAINT `fk_kat_zanr` FOREIGN KEY (`ZanrID`) REFERENCES `zanr` (`ZanrID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `kategorija` */

insert  into `kategorija`(`KnjigaID`,`ZanrID`) values 
(1,1),
(2,3),
(3,2),
(4,7),
(5,6),
(6,1),
(7,4),
(19,1),
(19,3),
(20,7);

/*Table structure for table `knjiga` */

DROP TABLE IF EXISTS `knjiga`;

CREATE TABLE `knjiga` (
  `KnjigaID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `NazivKnjige` varchar(255) DEFAULT NULL,
  `Izdavac` varchar(255) DEFAULT NULL,
  `GodinaIzdavanja` int(11) DEFAULT NULL,
  `Pismo` varchar(255) DEFAULT NULL,
  `Cena` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`KnjigaID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

/*Data for the table `knjiga` */

insert  into `knjiga`(`KnjigaID`,`NazivKnjige`,`Izdavac`,`GodinaIzdavanja`,`Pismo`,`Cena`) values 
(1,'Vin','Laguna',2021,'Latinica',1100),
(2,'Gospodar prstenova','Vulkan',2019,'Latinica',1500),
(3,'Poslednja seansa','Laguna',2020,'Cirilica',900),
(4,'Alisa u zemlji cuda','Evro giunti',2012,'Cirilica',220),
(5,'Mileva Ajnštajn: Teorija tuge','Laguna',2023,'Cirilica',1200),
(6,'Nikad nismo bile ovde','Delfi',2022,'Cirilica',1300),
(7,'Male zene','Odiseja',2019,'Latinica',1100),
(19,'Hobit','Laguna',2021,'Latinica',1200),
(20,'Veseli brod','Vulkan',2023,'Cirilica',700);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `KorisnikID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ImeKorisnika` varchar(255) DEFAULT NULL,
  `PrezimeKorisnika` varchar(255) DEFAULT NULL,
  `JMBG` varchar(255) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`KorisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `korisnik` */

insert  into `korisnik`(`KorisnikID`,`ImeKorisnika`,`PrezimeKorisnika`,`JMBG`,`Username`,`Password`) values 
(1,'Ana','Anic','123456','ana','ana'),
(2,'Marija','Balotic','1230000233234','masa','masa'),
(3,'Stefan','Radujko','1120043124402','polis','polis'),
(4,'Ana Marija','Stankovic','1233431234345','anamarija','anamarija'),
(7,'Marija','Avramovic','1234123455123','maki','maki');

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `KupacID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ImeKupca` varchar(255) DEFAULT NULL,
  `PrezimeKupca` varchar(255) DEFAULT NULL,
  `Adresa` varchar(255) DEFAULT NULL,
  `BrojTelefona` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`KupacID`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kupac` */

insert  into `kupac`(`KupacID`,`ImeKupca`,`PrezimeKupca`,`Adresa`,`BrojTelefona`,`Email`) values 
(1,'Stevo','Balotic','Martine Valikovic 4','061200000','stevo@gmail.com'),
(2,'Marija','Balotic','Marine Velickovic','062000000','marija@gmail.com'),
(3,'Sanja','Srbovski','Franje Krca 12','0611564636','sanja@gmail.com'),
(30,'Ana','Savic','Stanoja Jankovica 12','067324542','ana@gmail.com'),
(31,'Sasa','Krupinovic','Marka Stojanovica 12','064023454','sasa@gmail.com'),
(32,'Filip','Stanojevic','Stanojko Velickovic 32','06325545','stanoje@gmail.com'),
(34,'Stanoje','Vrbic','Adresica 123','0623847','stan@gmail.com'),
(35,'Milka','Canic','Topolska 18','06666663','mikla@gmail.com'),
(36,'Desanka','Maksimovic','Levicanska 87','0674234','levo@levo.com'),
(42,'Neda','Vukovic','Valadimira Tomovica 19','0623743658','neda@gmail.com'),
(45,'Snezana','Teodorovic','Stamenka Krstica 12','062123323','snezana@gmail.com'),
(47,'Gavrilo','Gojkovic','Pozeska 23','06321234','gavrilo@gmail.com'),
(48,'Jasna','Zugic','Admirala Geprata 32','0642345544','jasna@gmail.com'),
(49,'Mihajlo','Jaranovic','Bele vode 23','063244562','miha@gmail.com'),
(51,'Marko','Gajic','Topolska 18','06234323','gajic@gmail.com');

/*Table structure for table `napisao` */

DROP TABLE IF EXISTS `napisao`;

CREATE TABLE `napisao` (
  `KnjigaID` bigint(20) unsigned NOT NULL,
  `AutorID` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`KnjigaID`,`AutorID`),
  KEY `fk_nap_AutorID` (`AutorID`),
  CONSTRAINT `fk_nap_AutorID` FOREIGN KEY (`AutorID`) REFERENCES `autor` (`AutorID`),
  CONSTRAINT `fk_nap_KnjigaID` FOREIGN KEY (`KnjigaID`) REFERENCES `knjiga` (`KnjigaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `napisao` */

insert  into `napisao`(`KnjigaID`,`AutorID`) values 
(1,2),
(2,1),
(3,3),
(4,7),
(5,6),
(6,5),
(7,4),
(19,1),
(20,6),
(20,7);

/*Table structure for table `narudzbina` */

DROP TABLE IF EXISTS `narudzbina`;

CREATE TABLE `narudzbina` (
  `NarudzbinaID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `DatumIzdavanja` date DEFAULT NULL,
  `UkupanIznos` decimal(10,0) DEFAULT NULL,
  `KorisnikID` bigint(20) unsigned DEFAULT NULL,
  `KupacID` bigint(20) unsigned DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`NarudzbinaID`),
  KEY `fk_korisnik_id` (`KorisnikID`),
  KEY `fk_kupac_id` (`KupacID`),
  CONSTRAINT `fk_korisnik_id` FOREIGN KEY (`KorisnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_kupac_id` FOREIGN KEY (`KupacID`) REFERENCES `kupac` (`KupacID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;

/*Data for the table `narudzbina` */

insert  into `narudzbina`(`NarudzbinaID`,`DatumIzdavanja`,`UkupanIznos`,`KorisnikID`,`KupacID`,`Status`) values 
(34,'2023-10-15',2700,1,2,''),
(36,'2023-10-16',3700,1,45,'obradjena'),
(41,'2023-10-16',6600,1,49,'stornirano'),
(43,'2023-10-16',1540,1,1,'stornirano'),
(44,'2023-10-16',1200,1,35,''),
(48,'2023-10-26',4800,1,45,'obradjena'),
(50,'2023-10-26',6700,1,2,'obradjena');

/*Table structure for table `stavkanarudzbine` */

DROP TABLE IF EXISTS `stavkanarudzbine`;

CREATE TABLE `stavkanarudzbine` (
  `NarudzbinaID` bigint(20) unsigned NOT NULL,
  `StavkaNarudzbineID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `UkupanIznosStavkeNarudzbine` decimal(10,0) DEFAULT NULL,
  `KnjigaID` bigint(20) unsigned DEFAULT NULL,
  `Kolicina` int(11) DEFAULT NULL,
  PRIMARY KEY (`NarudzbinaID`,`StavkaNarudzbineID`),
  KEY `StavkaNarudzbineID` (`StavkaNarudzbineID`),
  KEY `fk_sn_knjigaID` (`KnjigaID`),
  CONSTRAINT `fk_snn_knjigaID` FOREIGN KEY (`KnjigaID`) REFERENCES `knjiga` (`KnjigaID`) ON DELETE SET NULL,
  CONSTRAINT `fk_snn_narudzID` FOREIGN KEY (`NarudzbinaID`) REFERENCES `narudzbina` (`NarudzbinaID`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8mb4;

/*Data for the table `stavkanarudzbine` */

insert  into `stavkanarudzbine`(`NarudzbinaID`,`StavkaNarudzbineID`,`UkupanIznosStavkeNarudzbine`,`KnjigaID`,`Kolicina`) values 
(34,97,1500,2,1),
(34,98,1200,19,1),
(36,90,1100,1,1),
(36,133,1100,7,1),
(36,134,1500,2,1),
(41,127,3600,19,3),
(41,128,3000,2,2),
(43,125,440,4,2),
(43,126,1100,7,1),
(44,130,1200,5,1),
(48,150,900,3,1),
(48,157,1200,5,1),
(48,158,1200,19,1),
(48,159,1500,2,1),
(50,160,1500,2,1),
(50,161,2200,7,2),
(50,162,1200,19,1),
(50,163,1800,3,2);

/*Table structure for table `zanr` */

DROP TABLE IF EXISTS `zanr`;

CREATE TABLE `zanr` (
  `ZanrID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `NazivZanra` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ZanrID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `zanr` */

insert  into `zanr`(`ZanrID`,`NazivZanra`) values 
(1,'Triler'),
(2,'Horor'),
(3,'Fantastika'),
(4,'Romansa'),
(5,'Kuvari'),
(6,'Biografija'),
(7,'Knjige za decu');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
