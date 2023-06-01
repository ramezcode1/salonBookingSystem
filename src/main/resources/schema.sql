DROP SCHEMA IF EXISTS `salon_booking`;
CREATE SCHEMA `salon_booking`;
USE `salon_booking`;

CREATE TABLE `barbers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `services` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `service_provider` (
  `service_id` int NOT NULL,
  `barber_id` int NOT NULL,
  KEY `FKn8ywx2qjbmmvi2tu4skkad0wq` (`barber_id`),
  KEY `FKixo2nhgr5wetrmaojxu0l2pjt` (`service_id`),
  CONSTRAINT `FKixo2nhgr5wetrmaojxu0l2pjt` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`),
  CONSTRAINT `FKn8ywx2qjbmmvi2tu4skkad0wq` FOREIGN KEY (`barber_id`) REFERENCES `barbers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bookings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `booking_date` date DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `barber_id` int DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6osayelf1dyyrh6p0y0sm0ii2` (`barber_id`),
  KEY `FKbvfibgflhsb0g2hnjauiv5khs` (`customer_id`),
  KEY `FKjcwbou2jlblfwu14uoxs65b25` (`service_id`),
  CONSTRAINT `FK6osayelf1dyyrh6p0y0sm0ii2` FOREIGN KEY (`barber_id`) REFERENCES `barbers` (`id`),
  CONSTRAINT `FKbvfibgflhsb0g2hnjauiv5khs` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `FKjcwbou2jlblfwu14uoxs65b25` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;