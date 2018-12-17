-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 17-Dez-2018 às 21:41
-- Versão do servidor: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sige`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `estado_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`, `estado_id`) VALUES
(1, 'ARAGUAINA', 1),
(2, 'BALSAS', 3),
(3, 'PALMAS', 1),
(4, 'GURUPI', 1),
(5, 'GOIANIA', 2),
(6, 'APARECIDA DE GOIANIA', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `dataCadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `dataCadastro`, `nome`, `cpf`, `rg`, `endereco`, `complemento`, `bairro`, `cidade`, `estado`, `cep`, `telefone`) VALUES
(1, '2018-12-11 18:09:46', 'WELLYSSON NASCIMENTO ROCHA', '052.774.401-86', '1235752', 'RUA BOA ESPERANÇA, QD06 LT08, 0', 'QD06 LT8', 'MAORADA DO SOL', 1, 0, '77828-322', '(63) 99253-2920'),
(2, '2018-12-11 18:12:37', 'RENIKELLI PEREIRA SILVA', '151.913.971-34', '24.773.646-6', 'QUADRA 403 SUL ALAMEDA', 'N 29', 'NOROESTE', 1, 0, '77800-000', '(92) 99269-4799'),
(3, '2018-12-17 19:08:04', 'BRYAN MÁRCIO DANILO BERNARDES', '443.994.997-53', '25.583.136-5', 'RUA 12', 'N 206', 'GIRASSÓIS', 6, 0, '59160-585', '(63) 99999-9999');

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `id` int(11) NOT NULL,
  `dataRegistro` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valorTotalCompra` decimal(10,2) DEFAULT NULL,
  `fornecedor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `compra`
--

INSERT INTO `compra` (`id`, `dataRegistro`, `valorTotalCompra`, `fornecedor_id`) VALUES
(38, '2018-12-11 15:37:23', '200.00', 1),
(39, '2018-12-11 15:37:23', '360.00', 1),
(40, '2018-12-11 15:37:23', '50.00', 1),
(41, '2018-12-11 15:37:23', '50.00', 1),
(42, '2018-12-11 15:54:50', '240.00', 5),
(43, '2018-12-15 08:35:30', '150.00', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `sigla` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`id`, `nome`, `sigla`) VALUES
(1, 'TOCANTINS', 'TO'),
(2, 'GOIAS', 'GO'),
(3, 'MARANHÃO', 'MA'),
(4, 'MATO GROSSO', 'MG');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL,
  `dataCadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cnpj` varchar(45) DEFAULT NULL,
  `inscEstadual` varchar(45) DEFAULT NULL,
  `nomeFantasia` varchar(45) DEFAULT NULL,
  `razaoSocial` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `dataCadastro`, `cnpj`, `inscEstadual`, `nomeFantasia`, `razaoSocial`, `email`, `endereco`, `complemento`, `bairro`, `cidade`, `estado`, `cep`, `telefone`, `status`) VALUES
(1, '2018-12-03 03:22:30', '41.575.666/0001-55', '669.720.860.993', 'Tiago e Juan Publicidade e Propaganda ME', 'Tiago e Juan Publicidade e Propaganda ME', 'treinamento@tiagoejuanpublicidadeepropagandame.com.br', 'Rua Roberto Benedetti', '102', 'Quintino Facci II', 2, 0, '14070-035', '(16) 3630-9516', NULL),
(3, '2018-12-03 16:27:59', '84.801.798/0001-60', '030.340.768.2', 'Iago e Erick Financeira ME', 'Iago e Erick Financeira ME', 'contato@iagoeerickfinanceirame.com.br', 'Quadra 1103 Sul Alameda 25', '629', 'Plano Diretor Sul', 1, 0, '77800-000', '(63) 3575-0559', NULL),
(4, '2018-12-03 16:29:09', '20.924.170/0001-70', '210.370.823.5', 'Simone e Guilherme Eletrônica ME', 'Simone e Guilherme Eletrônica ME', 'administracao@simoneeguilhermeeletronicame.com.br', 'Rua 24 D', '605', 'Jardim Aureny III (Taquaralto)', 1, 0, '77800-000', '(63) 2693-9981', NULL),
(5, '2018-12-11 18:45:23', '44.880.240/0001-01', '119.826.968', 'Livraria Estante Virtual', 'Joaquim e Diogo Ltda', 'posvenda@joaquimediogocontabilltda.com.br', 'Rua 803', 'n 695', 'Setor Universitário', 5, 0, '75706-220', '(64) 39119-702', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `dataEntrada` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dataSaida` timestamp NULL DEFAULT NULL,
  `nome` varchar(45) NOT NULL,
  `rg` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `nivelAcesso` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `dataEntrada`, `dataSaida`, `nome`, `rg`, `cpf`, `endereco`, `complemento`, `bairro`, `cidade`, `estado`, `cep`, `telefone`, `dataNascimento`, `salario`, `senha`, `nivelAcesso`, `status`) VALUES
(1, '2018-12-03 00:22:57', NULL, 'WELLYSSON NASCIMENTO ROCHA', '1235752', '052.774.401-86', 'RUA BOA ESPERANÇA, QD06 LT08', '0', 'MORADA DO SOL', 1, 0, '77828-322', '(63) 99253-2920', '1995-06-12', '980.00', '34125234', NULL, NULL),
(2, '2018-12-03 16:31:51', NULL, 'GUSTAVO IAGO DANILO RODRIGUES', '18.958.491-9', '032.540.843-22', 'RUA E', '625', 'PORTO D\'ANTAS', 1, 0, '77842-522', '(79) 98580-3106', '1996-08-19', '980.00', 'gus123', NULL, NULL),
(3, '2018-12-03 16:33:35', NULL, 'ANTHONY RYAN FERNANDO JESUS', '35.569.780-8', '493.956.622-63', 'SERVIDÃO RECANTO DA FORTALEZA', '772', 'BARRA DA LAGOA', 5, 0, '88061-418', '(48) 99796-5415', '1994-07-25', '980.00', '123', NULL, NULL),
(4, '2018-12-17 20:13:23', NULL, 'PATRÍCIA LARA CALDEIRA', '20.382.548-2', '435.812.121-70', 'RUA URCA', 'N12', 'URCA', 1, 0, '77800-000', '(63) 99999-9999', '1999-12-15', '980.00', 'paty123', NULL, NULL),
(5, '2018-12-17 20:13:23', NULL, 'PATRÍCIA LARA CALDEIRA', '20.382.548-2', '435.812.121-70', 'RUA URCA', 'N12', 'URCA', 1, 0, '77800-000', '(63) 99999-9999', '1999-12-15', '980.00', 'holy', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `gerente`
--

CREATE TABLE `gerente` (
  `id` int(11) NOT NULL,
  `dataGerencia` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `bonus` decimal(10,2) DEFAULT NULL,
  `funcionario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemcompra`
--

CREATE TABLE `itemcompra` (
  `id` int(11) NOT NULL,
  `qtdItem` int(11) DEFAULT NULL,
  `valorItem` decimal(10,2) DEFAULT NULL,
  `compra_id` int(11) NOT NULL,
  `produto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `itemcompra`
--

INSERT INTO `itemcompra` (`id`, `qtdItem`, `valorItem`, `compra_id`, `produto_id`) VALUES
(27, 20, '10.00', 38, 1),
(28, 20, '18.00', 39, 2),
(29, 5, '10.00', 40, 1),
(30, 5, '10.00', 41, 1),
(31, 20, '12.00', 42, 3),
(32, 10, '15.00', 43, 4);

--
-- Acionadores `itemcompra`
--
DELIMITER $$
CREATE TRIGGER `Tgr_ItensCompra_Delete` AFTER DELETE ON `itemcompra` FOR EACH ROW BEGIN
    UPDATE Produto SET quantidade = quantidade - OLD.qtdItem
WHERE id = OLD.produto_id;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `Tgr_ItensCompra_Insert` AFTER INSERT ON `itemcompra` FOR EACH ROW BEGIN
    UPDATE Produto SET quantidade = quantidade + NEW.qtdItem
WHERE id = NEW.produto_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemvenda`
--

CREATE TABLE `itemvenda` (
  `id` int(11) NOT NULL,
  `qtdItem` int(11) DEFAULT NULL,
  `valorItem` decimal(10,2) DEFAULT NULL,
  `venda_id` int(11) DEFAULT NULL,
  `produto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `itemvenda`
--

INSERT INTO `itemvenda` (`id`, `qtdItem`, `valorItem`, `venda_id`, `produto_id`) VALUES
(18, 1, '19.00', 12, 1),
(19, 1, '18.00', 12, 2),
(20, 1, '25.00', 13, 4);

--
-- Acionadores `itemvenda`
--
DELIMITER $$
CREATE TRIGGER `Tgr_ItensVenda_Delete` AFTER DELETE ON `itemvenda` FOR EACH ROW BEGIN
    UPDATE Produto SET quantidade = quantidade + OLD.qtdItem
WHERE id = OLD.produto_id;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `Tgr_ItensVenda_Insert` AFTER INSERT ON `itemvenda` FOR EACH ROW BEGIN
    UPDATE Produto SET quantidade = quantidade - NEW.qtdItem
WHERE id = NEW.produto_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valorCompra` decimal(10,2) DEFAULT NULL,
  `valorVenda` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `descricao`, `quantidade`, `valorCompra`, `valorVenda`) VALUES
(1, 'O PODER DO SUBCONSCIENTE', 29, '10.00', '18.00'),
(2, 'CEM ANOS DE SOLIDÃO', 19, '18.00', '23.99'),
(3, 'A DROGA DA OBEDIÊNCIA', 20, '12.00', '19.99'),
(4, 'A GUERRA DOS GLOBS', 9, '15.00', '25.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `id` int(11) NOT NULL,
  `dataVenda` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `valorTotalVenda` decimal(10,2) DEFAULT NULL,
  `cliente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`id`, `dataVenda`, `valorTotalVenda`, `cliente_id`) VALUES
(12, '2018-12-12 17:45:35', '19.00', 1),
(13, '2018-12-12 17:58:43', '18.00', 2),
(14, '2018-12-15 11:35:56', '25.00', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cidade_estado_idx` (`estado_id`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cliente_cidade_idx` (`cidade`);

--
-- Indexes for table `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_compra_fornecedor1_idx` (`fornecedor_id`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_fornecedor_cidade_idx` (`cidade`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_funcionario_cidade1_idx` (`cidade`);

--
-- Indexes for table `gerente`
--
ALTER TABLE `gerente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_gerente_funcionario1_idx` (`funcionario_id`);

--
-- Indexes for table `itemcompra`
--
ALTER TABLE `itemcompra`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `compra_id_UNIQUE` (`compra_id`),
  ADD KEY `fk_itemCompra_compra1_idx` (`compra_id`),
  ADD KEY `fk_itemCompra_produto1_idx` (`produto_id`);

--
-- Indexes for table `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_itemvenda_venda1_idx` (`venda_id`),
  ADD KEY `fk_itemvenda_produto1_idx` (`produto_id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_venda_cliente1_idx` (`cliente_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `compra`
--
ALTER TABLE `compra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `gerente`
--
ALTER TABLE `gerente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `itemcompra`
--
ALTER TABLE `itemcompra`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `itemvenda`
--
ALTER TABLE `itemvenda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `fk_cidade_estado` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_cidade` FOREIGN KEY (`cidade`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `fk_compra_fornecedor1` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fk_fornecedor_cidade` FOREIGN KEY (`cidade`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_funcionario_cidade` FOREIGN KEY (`cidade`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `gerente`
--
ALTER TABLE `gerente`
  ADD CONSTRAINT `fk_gerente_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `itemcompra`
--
ALTER TABLE `itemcompra`
  ADD CONSTRAINT `fk_itemCompra_compra1` FOREIGN KEY (`compra_id`) REFERENCES `compra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_itemCompra_produto1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD CONSTRAINT `fk_itemvenda_produto1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_itemvenda_venda1` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `fk_venda_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
