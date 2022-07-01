CREATE DATABASE `articles_feed` DEFAULT CHARACTER SET utf8;

CREATE TABLE `article` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `created_time` timestamp NOT NULL,
   `title` varchar(128) NOT NULL,
   `content` text,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;