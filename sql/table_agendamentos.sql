USE autoprime;
CREATE TABLE `agendamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` varchar(60) NOT NULL,
  `info` varchar(60) NOT NULL,
  `status` varchar(60) NOT NULL,
  `tipo` varchar(60) NOT NULL,
  `veiculo_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`veiculo_id`) REFERENCES `veiculo`(`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM agendamento;