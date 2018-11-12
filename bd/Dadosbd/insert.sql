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
INSERT INTO `tb_endereco` VALUES ('SP','08310520','Pq. São Rafael','São Paulo','Avenida Salvador','330','',5),('SP','04456140','Vila Matilde','São Paulo','Rua dos Santos','231','',6);
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
INSERT INTO `tb_pedido` VALUES (5,615,'Aberto','2018-11-12','4X',1,'44197291809','Cartao de Debito',1),(6,30,'Aberto','2018-11-12','1X',1,'44197291809','Dinheiro',1),(7,1200,'Aberto','2018-11-12','1X',1,'44197291809','Dinheiro',1),(8,60,'Aberto','2018-11-12','1X',1,'44197291809','Dinheiro',0),(9,30,'Aberto','2018-11-12','1X',1,'44197291809','Dinheiro',0),(10,120,'Aberto','2018-11-12','1X',1,'44197291809','Dinheiro',0);
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_produto`
--

LOCK TABLES `tb_produto` WRITE;
/*!40000 ALTER TABLE `tb_produto` DISABLE KEYS */;
INSERT INTO `tb_produto` VALUES (1234,30,'Panela inox tamanho 2','Panela Inox'),(12231,90,'Panela anti-aderente tamanho 3','Panela anti-aderente');
/*!40000 ALTER TABLE `tb_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_produto_pedido`
--

LOCK TABLES `tb_produto_pedido` WRITE;
/*!40000 ALTER TABLE `tb_produto_pedido` DISABLE KEYS */;
INSERT INTO `tb_produto_pedido` VALUES (1234,9,1),(1234,10,1),(12231,10,1);
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

-- Dump completed on 2018-11-12 17:19:37
