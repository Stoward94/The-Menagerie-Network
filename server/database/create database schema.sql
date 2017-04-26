CREATE DATABASE IF NOT EXISTS `menagerie_network` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `menagerie_network`;

-- Animal table
CREATE TABLE `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `common_name` varchar(45) NOT NULL,
  `scientific_name` varchar(45) NOT NULL,
  `order` varchar(45) NOT NULL,
  `family` varchar(45) NOT NULL,
  `genus` varchar(45) NOT NULL,
  `species` varchar(45) NOT NULL,
  `origin` varchar(45) DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  `description` varchar(750) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Zoo table
CREATE TABLE `zoo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(75) NOT NULL,
  `site_url` varchar(100) NOT NULL,
  `latitude` decimal(10,8) NOT NULL,
  `longitude` decimal(10,8) NOT NULL,
  `postcode` varchar(8) NOT NULL,
  `thumbnail_url` varchar(200) NOT NULL,
  `summary` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Zoo Animal table with foreign key constraints
CREATE TABLE `zoo_animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `animal_id` int(11) NOT NULL,
  `zoo_id` int(11) NOT NULL,
  `pet_name` varchar(45) NOT NULL,
  `age_months` int(11) DEFAULT NULL,
  `male` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `zoo_id_idx` (`zoo_id`),
  KEY `animal_id_idx` (`animal_id`),
  CONSTRAINT `animal_id` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `zoo_id` FOREIGN KEY (`zoo_id`) REFERENCES `zoo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- User table
CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `password_hash` varchar(100) NOT NULL,
  `password_salt` varchar(24) NOT NULL,
  `role` varchar(24) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;