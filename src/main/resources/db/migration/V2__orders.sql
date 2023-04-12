CREATE TABLE `order_location` (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `date` datetime(6) DEFAULT NULL,
                                  `latitude` double DEFAULT NULL,
                                  `longitude` double DEFAULT NULL,
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `operator_id` bigint NOT NULL,
                          `end_order_location_id` bigint DEFAULT NULL,
                          `start_order_location_id` bigint DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FK_end_order_id` (`end_order_location_id`),
                          KEY `FK_start_order_id` (`start_order_location_id`),
                          CONSTRAINT `FK_end_order_id` FOREIGN KEY (`end_order_location_id`) REFERENCES `order_location` (`id`),
                          CONSTRAINT `FK_start_order_id` FOREIGN KEY (`start_order_location_id`) REFERENCES `order_location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders_assists` (
                                  `order_id` bigint NOT NULL,
                                  `assists_id` bigint NOT NULL,
                                  KEY `FK_assits_id` (`assists_id`),
                                  KEY `FK_orders_id` (`order_id`),
                                  CONSTRAINT `FK_orders_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
                                  CONSTRAINT `FK_assits_id` FOREIGN KEY (`assists_id`) REFERENCES `assistances` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;