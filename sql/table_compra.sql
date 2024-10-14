USE autoprime;
CREATE TABLE `compra` (
    `id` int NOT NULL AUTO_INCREMENT,
    `valor` double NOT NULL,
    `desconto` double NOT NULL,
    `veiculo_id` int NOT NULL,
    `status` varchar(60) NOT NULL,
    `data` varchar(60) NOT NULL,
    `cliente_cpf` varchar(60) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`veiculo_id`) REFERENCES `veiculo`(`id`) ,
    FOREIGN KEY (`cliente_cpf`) REFERENCES `cliente`(`cpf`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM compra;