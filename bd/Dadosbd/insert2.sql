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
-- Dumping data for table `notafiscal`
--

LOCK TABLES `notafiscal` WRITE;
/*!40000 ALTER TABLE `notafiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `notafiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notafiscal_saida`
--

LOCK TABLES `notafiscal_saida` WRITE;
/*!40000 ALTER TABLE `notafiscal_saida` DISABLE KEYS */;
/*!40000 ALTER TABLE `notafiscal_saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notafiscal_servico`
--

LOCK TABLES `notafiscal_servico` WRITE;
/*!40000 ALTER TABLE `notafiscal_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `notafiscal_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `produto_nf`
--

LOCK TABLES `produto_nf` WRITE;
/*!40000 ALTER TABLE `produto_nf` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto_nf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `produtonota`
--

LOCK TABLES `produtonota` WRITE;
/*!40000 ALTER TABLE `produtonota` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtonota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `servico_nf`
--

LOCK TABLES `servico_nf` WRITE;
/*!40000 ALTER TABLE `servico_nf` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico_nf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `serviconota`
--

LOCK TABLES `serviconota` WRITE;
/*!40000 ALTER TABLE `serviconota` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviconota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_centro_custo`
--

LOCK TABLES `tb_centro_custo` WRITE;
/*!40000 ALTER TABLE `tb_centro_custo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_centro_custo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_cliente_fisico`
--

LOCK TABLES `tb_cliente_fisico` WRITE;
/*!40000 ALTER TABLE `tb_cliente_fisico` DISABLE KEYS */;
INSERT INTO `tb_cliente_fisico` VALUES ('Bruno Paz','44197291809','2018-02-18','bruno@email.com','11985255612','6');
/*!40000 ALTER TABLE `tb_cliente_fisico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_cliente_juridico`
--

LOCK TABLES `tb_cliente_juridico` WRITE;
/*!40000 ALTER TABLE `tb_cliente_juridico` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cliente_juridico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_default`
--

LOCK TABLES `tb_default` WRITE;
/*!40000 ALTER TABLE `tb_default` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_default` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_endereco`
--

LOCK TABLES `tb_endereco` WRITE;
/*!40000 ALTER TABLE `tb_endereco` DISABLE KEYS */;
INSERT INTO `tb_endereco` VALUES ('SP','04144020','Vila da Saúde','São Paulo','Rua Fiação da Saúde','330','Conjunto 1',5),('SP','08310520','Pq. São Rafael','São Paulo','Avenida Salvador','330','Casa 3',6);
/*!40000 ALTER TABLE `tb_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_funcionario`
--

LOCK TABLES `tb_funcionario` WRITE;
/*!40000 ALTER TABLE `tb_funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_ordem_expedicao`
--

LOCK TABLES `tb_ordem_expedicao` WRITE;
/*!40000 ALTER TABLE `tb_ordem_expedicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_ordem_expedicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_pedido`
--

LOCK TABLES `tb_pedido` WRITE;
/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` VALUES (15,225,'Aberto','2018-11-13','1X',1,'44197291809','Dinheiro',0),(16,180,'Aberto','2018-11-13','3X',1,'44197291809','Cartao de Credito',0),(17,510,'Aberto','2018-11-13','5X',1,'44197291809','Cartao de Debito',0);
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_produto`
--

LOCK TABLES `tb_produto` WRITE;
/*!40000 ALTER TABLE `tb_produto` DISABLE KEYS */;
INSERT INTO `tb_produto` VALUES (1,30,'Panela inox tamanho 2','Panela Inox'),(2,90,'Panela anti-aderente tamanho 3','Panela anti-aderente'),(3,180,'Panela industrial reforçada tam. 8','Panela industrial');
/*!40000 ALTER TABLE `tb_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_produto_pedido`
--

LOCK TABLES `tb_produto_pedido` WRITE;
/*!40000 ALTER TABLE `tb_produto_pedido` DISABLE KEYS */;
INSERT INTO `tb_produto_pedido` VALUES (2,15,1),(2,17,5);
/*!40000 ALTER TABLE `tb_produto_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_servico`
--

LOCK TABLES `tb_servico` WRITE;
/*!40000 ALTER TABLE `tb_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_servico_pedido`
--

LOCK TABLES `tb_servico_pedido` WRITE;
/*!40000 ALTER TABLE `tb_servico_pedido` DISABLE KEYS */;
INSERT INTO `tb_servico_pedido` VALUES (1,15,3),(2,15,1),(3,16,3),(3,17,1);
/*!40000 ALTER TABLE `tb_servico_pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-13 17:07:07
