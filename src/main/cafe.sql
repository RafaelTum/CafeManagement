/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.18-log : Database - cafe_manager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cafe_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cafe_manager`;

/*Table structure for table `cafe_order` */

DROP TABLE IF EXISTS `cafe_order`;

CREATE TABLE `cafe_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `table_id` int(11) unsigned NOT NULL,
  `status` enum('OPEN','CANCELLED','CLOSED') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `table_id` (`table_id`),
  CONSTRAINT `cafe_order_ibfk_1` FOREIGN KEY (`table_id`) REFERENCES `cafe_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `cafe_order` */

insert  into `cafe_order`(`id`,`table_id`,`status`) values (1,1,'OPEN'),(2,1,'OPEN'),(3,2,'OPEN'),(5,3,'OPEN');

/*Table structure for table `cafe_table` */

DROP TABLE IF EXISTS `cafe_table`;

CREATE TABLE `cafe_table` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `waiter_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `waiter_id` (`waiter_id`),
  CONSTRAINT `cafe_table_ibfk_1` FOREIGN KEY (`waiter_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `cafe_table` */

insert  into `cafe_table`(`id`,`waiter_id`) values (1,1),(2,2),(3,2);

/*Table structure for table `prod` */

DROP TABLE IF EXISTS `prod`;

CREATE TABLE `prod` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `prod` */

insert  into `prod`(`id`,`name`) values (1,'juice'),(2,'coffee');

/*Table structure for table `product_order` */

DROP TABLE IF EXISTS `product_order`;

CREATE TABLE `product_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(11) unsigned NOT NULL,
  `prod_id` int(11) unsigned NOT NULL,
  `amount` int(11) NOT NULL,
  `status` enum('ACTIVE','CANCELLED') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_inorder_ibfk_2` (`prod_id`),
  CONSTRAINT `product_order_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `cafe_order` (`id`),
  CONSTRAINT `product_order_ibfk_2` FOREIGN KEY (`prod_id`) REFERENCES `prod` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `product_order` */

insert  into `product_order`(`id`,`order_id`,`prod_id`,`amount`,`status`) values (1,1,1,4,'ACTIVE'),(2,2,2,3,'ACTIVE');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('MANAGER','WAITER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`surname`,`username`,`password`,`role`) values (1,'manager','manager','manager','manager','MANAGER'),(2,'waiter','waiter','waiter','waiter','WAITER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
