CREATE DATABASE playground /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE genre (
  id        INT(3)       NOT NULL AUTO_INCREMENT,
  genretext VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8;

CREATE TABLE `movie` (
  `id`        INT(3)       NOT NULL AUTO_INCREMENT,
  `title`     VARCHAR(100) NOT NULL,
  `year`      INT(4)                DEFAULT NULL,
  `rating`    INT(11)               DEFAULT NULL,
  `director`  VARCHAR(150)          DEFAULT NULL,
  `imdb_link` VARCHAR(150)          DEFAULT NULL,
  `imdblink`  VARCHAR(255)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 85
  DEFAULT CHARSET = utf8;


CREATE TABLE movie_genre (
  movie_id INT(3) DEFAULT NULL,
  genre_id INT(3) DEFAULT NULL,
  KEY fk_movieid_idx (movie_id),
  KEY fk_genreid_idx (genre_id),
  CONSTRAINT fk_genreid FOREIGN KEY (genre_id) REFERENCES genre (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_movieid FOREIGN KEY (movie_id) REFERENCES movie (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;