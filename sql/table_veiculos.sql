USE autoprime;
CREATE TABLE `veiculo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(60) NOT NULL,
  `ano` int NOT NULL,
  `preco` double NOT NULL,
  `status` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM veiculo;