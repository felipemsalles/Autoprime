USE autoprime;
CREATE TABLE `cliente` (
  `nome` varchar(60) NOT NULL,
  `telefone` varchar(60) NOT NULL,
  `cpf` varchar(60) NOT NULL,
  `data_de_nascimento` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `senha` varchar(60) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM cliente;