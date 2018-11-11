create table tb_cliente_fisico(
nome varchar(40),
cpf varchar(11),
data_nasc date,
email varchar (40),
telefone varchar(40),
estado varchar(40),
cep varchar(8),
bairro varchar(40),
cidade varchar (40),
rua varchar(40),
numero varchar(10),
complemento varchar(40));

create table tb_cliente_juridico(
cnpj varchar(14),
email varchar (40),
telefone varchar(20),
estado varchar(40),
cep varchar(8),
bairro varchar(40),
cidade varchar (40),
rua varchar(40),
numero varchar(10),
complemento varchar(40),
incricao_estadual varchar(40)
);

create table tb_servico(
id_servico varchar(40),
valor float ,
descricao varchar(40),
nome varchar (40));

create table tb_servico_pedido(
id_servico int,
id_pedido int,
meses_duracao int);

create table tb_pedido(
id_pedido int,
valor_total float,
_status varchar(40),
_data date,
forma_pagamento varchar(40), 
id_vendedor int,
id_cliente int,
tipo_pagamento varchar(40),
pago boolean);

create table tb_produto(
id_produto int,
valor float,
descricao varchar(40),
nome varchar(40));
-- nome produto
create table tb_produto_pedido(
nome varchar(40),
qtd_item int,
valor_total float,
devolvido boolean,
id_produto int);

create table tb_ordem_expedicao(
_status varchar(40),
data_entrega date,
id_vendedor int,
id_pedido int);

create table tb_funcionario(
nome varchar(40),
id int);



create table tb_nf_produtos(
data_emissao date,
numero int,
cfop int,
valor_total float,
dados_adicionais varchar(40),
estado varchar(40),
serie varchar(40),
insc_estadual varchar(40),
cnpj varchar(14),
cpf varchar(11),
val_icms float,
val_ipi float,
natureza_op varchar(40)
);


-- cod de servico

create table tb_nf_servicos(
cod_servico varchar(40),
data_emissao date,
numero int,
cfop varchar(4),
valor_total float,
dados_adicionais varchar(40),
estado varchar(40),
serie bit,
insc_estadual varchar(40),
cnpj varchar(14),
val_iss float
);


create table produto_nf(
nome varchar(40),
qtd_item int,
valor_total float,
devolvido boolean,
id_produto int,
valor_icms float,
valor_ipi float);

create table servico_nf (
id_servico varchar(40),
valor float ,
descricao varchar(40),
nome varchar (40),
valor_iss float);




select *
from tb_nf_produtos;


