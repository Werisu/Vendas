-- MySQL Workbench Synchronization
-- Generated: 2018-11-30 08:56
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Wellysson

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `vendas` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `vendas`.`tb_fornecedores` (
  `for_codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `for_descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`for_codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `vendas`.`tb_produtos` (
  `pro_codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pro_descricao` VARCHAR(45) NOT NULL,
  `pro_valor` DECIMAL(7,2) UNSIGNED NOT NULL,
  `pro_quantidade` INT(10) UNSIGNED NOT NULL,
  `tb_fornecedores_for_codigo` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`pro_codigo`),
  INDEX `fk_tb_produtos_tb_fornecedores_idx` (`tb_fornecedores_for_codigo` ASC),
  CONSTRAINT `fk_tb_produtos_tb_fornecedores`
    FOREIGN KEY (`tb_fornecedores_for_codigo`)
    REFERENCES `vendas`.`tb_fornecedores` (`for_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `vendas`.`tb_funcionarios` (
  `fun_codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `fun_nome` VARCHAR(45) NOT NULL,
  `fun_cpf` VARCHAR(45) NOT NULL,
  `fun_senha` VARCHAR(50) NOT NULL,
  `fun_funcao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`fun_codigo`),
  UNIQUE INDEX `fun_cpf_UNIQUE` (`fun_cpf` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `vendas`.`tb_vendas` (
  `ven_codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ven_horario` TIMESTAMP NOT NULL,
  `ven_valor_total` DECIMAL(7,2) NOT NULL,
  `tb_funcionarios_fun_codigo` INT(11) NOT NULL,
  PRIMARY KEY (`ven_codigo`),
  INDEX `fk_tb_vendas_tb_funcionarios1_idx` (`tb_funcionarios_fun_codigo` ASC),
  CONSTRAINT `fk_tb_vendas_tb_funcionarios1`
    FOREIGN KEY (`tb_funcionarios_fun_codigo`)
    REFERENCES `vendas`.`tb_funcionarios` (`fun_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `vendas`.`tb_itens` (
  `ite_codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ite_quantidade` INT(10) UNSIGNED NOT NULL,
  `ite_valor_parcial` DECIMAL(7,2) UNSIGNED NOT NULL,
  `tb_produtos_pro_codigo` INT(10) UNSIGNED NOT NULL,
  `tb_vendas_ven_codigo` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ite_codigo`),
  INDEX `fk_tb_itens_tb_produtos1_idx` (`tb_produtos_pro_codigo` ASC),
  INDEX `fk_tb_itens_tb_vendas1_idx` (`tb_vendas_ven_codigo` ASC),
  CONSTRAINT `fk_tb_itens_tb_produtos1`
    FOREIGN KEY (`tb_produtos_pro_codigo`)
    REFERENCES `vendas`.`tb_produtos` (`pro_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_itens_tb_vendas1`
    FOREIGN KEY (`tb_vendas_ven_codigo`)
    REFERENCES `vendas`.`tb_vendas` (`ven_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
