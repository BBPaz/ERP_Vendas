CREATE DATABASE  IF NOT EXISTS `all` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `all`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: all
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `notafiscal`
--

DROP TABLE IF EXISTS `notafiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notafiscal` (
  `id_nf` int(11) NOT NULL,
  `data_emissao` date DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `cfop` int(11) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `dados_adicionais` varchar(200) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `chave` varchar(100) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_nf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notafiscal_saida`
--

DROP TABLE IF EXISTS `notafiscal_saida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notafiscal_saida` (
  `data_emissao` date DEFAULT NULL,
  `id_nf` int(11) DEFAULT NULL,
  `cfop` int(11) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `dados_adicionais` varchar(40) DEFAULT NULL,
  `estado` varchar(40) DEFAULT NULL,
  `serie` varchar(40) DEFAULT NULL,
  `insc_estadual` varchar(40) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `val_icms` float DEFAULT NULL,
  `val_ipi` float DEFAULT NULL,
  `natureza_op` varchar(40) DEFAULT NULL,
  `id_nfsaida` int(11) DEFAULT NULL,
  `cod_contabil` varchar(35) DEFAULT NULL,
  `procedencia` varchar(100) DEFAULT NULL,
  `emitente` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `notafiscal_servico`
--

DROP TABLE IF EXISTS `notafiscal_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notafiscal_servico` (
  `data_emissao` date DEFAULT NULL,
  `cfop` varchar(4) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `dados_adicionais` varchar(40) DEFAULT NULL,
  `estado` varchar(40) DEFAULT NULL,
  `serie` bit(1) DEFAULT NULL,
  `insc_estadual` varchar(40) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `val_iss` float DEFAULT NULL,
  `id_nfservico` int(11) DEFAULT NULL,
  `id_nf` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produto_nf`
--

DROP TABLE IF EXISTS `produto_nf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto_nf` (
  `nome` varchar(40) DEFAULT NULL,
  `qtd_item` int(11) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  `valor_icms` float DEFAULT NULL,
  `valor_ipi` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produtonota`
--

DROP TABLE IF EXISTS `produtonota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtonota` (
  `nome` varchar(40) DEFAULT NULL,
  `qtd_item` int(11) DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  `valor_unitario` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servico_nf`
--

DROP TABLE IF EXISTS `servico_nf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico_nf` (
  `id_servico` int(11) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `descricao` varchar(40) DEFAULT NULL,
  `nome` varchar(40) DEFAULT NULL,
  `valor_iss` float DEFAULT NULL,
  `valor_unitario` float DEFAULT NULL,
  `meses` int(11) DEFAULT NULL,
  `id_nfservico` int(11) DEFAULT NULL,
  `servico_nfcol` varchar(45) DEFAULT NULL,
  `id_nf` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `serviconota`
--

DROP TABLE IF EXISTS `serviconota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serviconota` (
  `id_servico` int(11) NOT NULL,
  `valor_total` float DEFAULT NULL,
  `valor_unitario` float DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `valor_iss` float DEFAULT NULL,
  `mes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_centro_custo`
--

DROP TABLE IF EXISTS `tb_centro_custo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_centro_custo` (
  `cnpj` varchar(14) NOT NULL,
  `razao_social` varchar(45) DEFAULT NULL,
  `fantasia` varchar(45) DEFAULT NULL,
  `longradouro` varchar(45) DEFAULT NULL,
  `nro` int(11) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `municipio` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `inscricao_estadual` varchar(45) DEFAULT NULL,
  `inscricao_municipal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_cliente_fisico`
--

DROP TABLE IF EXISTS `tb_cliente_fisico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cliente_fisico` (
  `nome` varchar(40) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `telefone` varchar(40) DEFAULT NULL,
  `id_endereco` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_cliente_juridico`
--

DROP TABLE IF EXISTS `tb_cliente_juridico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cliente_juridico` (
  `cnpj` varchar(14) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `incricao_estadual` varchar(40) DEFAULT NULL,
  `id_endereco` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_default`
--

DROP TABLE IF EXISTS `tb_default`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_default` (
  `uf` varchar(2) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_endereco`
--

DROP TABLE IF EXISTS `tb_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_endereco` (
  `estado` varchar(40) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `bairro` varchar(40) DEFAULT NULL,
  `cidade` varchar(40) DEFAULT NULL,
  `rua` varchar(40) DEFAULT NULL,
  `numero` varchar(40) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_funcionario`
--

DROP TABLE IF EXISTS `tb_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_funcionario` (
  `nome` varchar(40) DEFAULT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_ordem_expedicao`
--

DROP TABLE IF EXISTS `tb_ordem_expedicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ordem_expedicao` (
  `_status` varchar(40) DEFAULT NULL,
  `data_entrega` date DEFAULT NULL,
  `id_vendedor` int(11) DEFAULT NULL,
  `id_pedido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_pedido`
--

DROP TABLE IF EXISTS `tb_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `valor_total` float DEFAULT NULL,
  `_status` varchar(40) DEFAULT NULL,
  `_data` date DEFAULT NULL,
  `forma_pagamento` varchar(40) DEFAULT NULL,
  `id_vendedor` int(11) DEFAULT NULL,
  `id_cliente` varchar(14) DEFAULT NULL,
  `tipo_pagamento` varchar(40) DEFAULT NULL,
  `pago` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_produto`
--

DROP TABLE IF EXISTS `tb_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_produto` (
  `id_produto` int(11) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `descricao` varchar(40) DEFAULT NULL,
  `nome` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_produto_pedido`
--

DROP TABLE IF EXISTS `tb_produto_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_produto_pedido` (
  `id_produto` int(11) DEFAULT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_servico`
--

DROP TABLE IF EXISTS `tb_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_servico` (
  `id_servico` varchar(40) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `descricao` varchar(40) DEFAULT NULL,
  `nome` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_servico_pedido`
--

DROP TABLE IF EXISTS `tb_servico_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_servico_pedido` (
  `id_servico` int(11) DEFAULT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `meses_duracao` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12 17:21:39
