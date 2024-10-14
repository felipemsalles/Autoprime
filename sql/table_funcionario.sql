USE autoprime;
CREATE TABLE `funcionario` (
  `nome` varchar(60) NOT NULL,
  `telefone` varchar(60) NOT NULL,
  `cpf` varchar(60) NOT NULL,
  `data_de_nascimento` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `cargo` varchar(60) NOT NULL,
  `bonificacao` double NOT NULL,
  `salario` double NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM funcionario;