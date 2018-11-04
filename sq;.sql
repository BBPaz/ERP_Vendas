create table tb_pessoa_juridica(
cnpj VARCHAR(40) NOT NULL PRIMARY KEY,
ie VARCHAR(40) NOT NULL,
razao_social VARCHAR (40));

--
insert into  value('6362333000147', '123456', 'Inferno');
insert into tb_pessoa_juridica value('3157997000130', '123111', 'Paleta');
insert into tb_pessoa_juridica value('9713887000130', '123222', 'Globo');
insert into tb_pessoa_juridica value('9214434000112', '222222', 'charlie');
insert into tb_pessoa_juridica value('4546121000109', '33333', 'Emprego');
insert into tb_pessoa_juridica value('0647060000186', '556654', 'Ceu');

create table tb_pessoa_fisica(
cpf VARCHAR(40) NOT NULL PRIMARY KEY,
razao_social VARCHAR (40));

insert into tb_pessoa_juridica value('88006227047', 'Igor Alves da Silva');
insert into tb_pessoa_juridica value('13157997000130', 'Ana Beatriz');
insert into tb_pessoa_juridica value('09713887000130', 'Bruno Lessa Paz');
insert into tb_pessoa_juridica value('19214434000112', 'charlie');
insert into tb_pessoa_juridica value('44546121000109',  'Doritos com mel');
insert into tb_pessoa_juridica value('70647060000186', 'Ceu');

--

create table tb_cliente(
id_cliente VARCHAR(40) primary key not null,
cpf varchar(40),
cnpj varchar(40),
email varchar(40),
cidade varchar(40),
uf varchar(40),
bairro varchar(40),
nm_endereco integer (40),
logradouro varchar(40),
cep varchar(40),
data_nascimento varchar(40),

constraint fk_pedido_cliente foreign key (cpf) references tb_pessoa_fisica,
constraint fk_pedido_juridico foreign key (cnpj) references tb_pessoa_juridica);

create table servico_pedido(
id_pedido varchar(40),
id_servico varchar(40) primary key not null,
nm_servico varchar(40)not null);

insert into servico_pedido value ('1', '1', 'Panelada');
insert into servico_pedido value ('2', '2', 'Jogar bola');
insert into servico_pedido value ('3', '3', 'Gankar');

create table produto_pedido(
id_pedido varchar(40),
id_produto varchar(40)primary key not null,
valor_produto float(40),
nome_produto varchar(40),
tipo_produto varchar(40));

insert into produto_pedido value ('1', '00000000000000',200.0
,'Panela bonita', 'acabado');

insert into produto_pedido value ('2', '22000000000000',300.0
,'Panela azul', 'acabado');

insert into produto_pedido value ('3', '33000000000000',400.0
,'Panela roxa', 'acabado');

create table pedido (
id_pedido varchar(40)primary key not null auto_increment,
valor_total_pedido float (40),
rastreabilidade varchar (40),
data_abertura varchar(40),
data_fechamento varchar(40),
forma_pagamento varchar(40),
tipo_pagamento varchar(40));

insert into pedido value ('1', 200.0, 'Aprovado', '02/03/1999'
, '02/03/1999' , 'dinheiro' , 'azul');

insert into pedido value ('2', 300.0, 'Aprovado', '02/03/1999'
, '02/03/1999' , 'dinheiro' , 'azul');
insert into pedido value ('3', 400.0, 'Aprovado', '02/03/1999'
, '02/03/1999' , 'dinheiro' , 'azul');

create table cliente(
id_cliente VARCHAR(40),
email VARCHAR(40),
telefone varchar (40),
cad_valido boolean );



