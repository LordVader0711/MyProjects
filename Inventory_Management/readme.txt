#Swagger URL
localhost:8080/swagger-ui/index.html

#DB Config
DBMS: MySQL
Schema: product
DDL: -- product.inventory definition

CREATE TABLE `inventory` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `price` double DEFAULT NULL,
  `gst` float NOT NULL,
  `inventory_stock` int NOT NULL,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `model_name` varchar(100) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#Java Version 20

