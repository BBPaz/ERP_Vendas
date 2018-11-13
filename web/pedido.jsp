<%-- 
    Document   : cliente
    Created on : 06/11/2018, 19:00:03
    Author     : logonaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Vendas</title>

        

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Grupo 6 - Vendas" />

        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <link href="js/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/all.css">
        
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.12.1/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/iniciar-venda.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>
        <script src="js/scripts.js"></script>
        
        <script>
            jQuery(function(){
                
            });
        </script>

    </head>
    <body>
        <!--%@include file="nav.jsp" %>

        <div id="btnMenu"><img src="img/btn-menu.png"></div>

        <!--%@include file="menu.jsp" %-->
        <div class="container-fluid">
            
            <div class="row">


                    <div class="text-center col-md-10 col-md-offset-1">
                                <h2>Dados do Pedido</h2>
                                <br>
                                <div id="dados-pf">
                                    <div class="col-md-6 form-group">
                                    <label>Nome do cliente</label>
                                    <input type="text" class="form-control"  id="nomeCliente" disabled>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>CPF do cliente</label>
                                    <input type="text" class="form-control"  id="cpfCliente" disabled>
                                </div>
                                </div>
                                <div id="dados-pj" style="display:none;">
                                <div class="col-md-6 form-group">
                                    <label>Razão social do cliente</label>
                                    <input type="text" class="form-control" id="razaoSocialCliente" disabled>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>CNPJ</label>
                                    <input type="text" class="form-control" id="cnpjCliente" disabled>
                                </div>
                                <div class="clearfix"></div>
                                </div>
                                <hr class='col-md-12' style="border-top: 1px solid #000;">
                                <div class="text-center">
                                    <div class="col-md-4 form-group">
                                        <label>Status</label>
                                        <input type="text" class="form-control"  id="statusPedido" disabled>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label>Pago</label>
                                        <input type="text" class="form-control"  id="pagoPedido" disabled>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label>Data</label>
                                        <input type="data" class="form-control"  id="dataPedido" disabled>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label>Tipo de pagamento</label>
                                        <input type="data" class="form-control"  id="tipoPagamento" disabled>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label>Forma de pagamento</label>
                                        <input type="data" class="form-control"  id="formaPagamento" disabled>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        <label>Valor Total</label>
                                        <input type="data" class="form-control"  id="valTotal" disabled>
                                    </div>
                                    <div id="tabelaProdutos">
                                    <h2>Lista de Produtos</h2>
                                        <div class="col-md-12 p-30 table-responsive">
                                            <table class="table table-striped table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Código</th>
                                                        <th>Nome</th>
                                                        <th>Valor Unitário</th>
                                                        <th>Qtd.</th>
                                                        <th>Valor Total</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="tbody_produtos">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div id="tabelaServicos">
                                    <h2>Lista de Serviços</h2>
                                        <div class="col-md-12 p-30 table-responsive">
                                            <table class="table table-striped table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Código</th>
                                                        <th>Nome</th>
                                                        <th>Valor(mês)</th>
                                                        <th>Duração(meses)</th>
                                                        <th>Valor Total</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="tbody_servicos">

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                        </div>
                    <!--div class="parent-div bg-danger d-flex align-items-center" style="height: 600px;width: 400px;">
                        <div class="child-div bg-warning" style="height: 300px;width: 200px;">
                          BATATA
                        </div>
                    </div-->
                    <div class="clearfix"></div>
        </div>
        <div id="aviso" title="Aviso &#x26a0;" class="text-center bg-danger"></div>
         
        
    </body>
</html>
