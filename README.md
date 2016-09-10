# SpringRestJpa
Spring Data + Restful Web Services + AngularJS

Sample Project using Spring Data , Hibernate , Restful Web Services and AngularJS, 
MySql is used as database.
Database scripts are below : 

CREATE DATABASE `playground` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `genre` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `genretext` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

CREATE TABLE `movie` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `year` int(4) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `director` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

CREATE TABLE `movie_genre` (
  `movie_id` int(3) DEFAULT NULL,
  `genre_id` int(3) DEFAULT NULL,
  KEY `fk_movieid_idx` (`movie_id`),
  KEY `fk_genreid_idx` (`genre_id`),
  CONSTRAINT `fk_genreid` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_movieid` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
