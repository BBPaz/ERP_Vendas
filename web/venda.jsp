<%-- 
    Document   : venda
    Created on : 13/10/2018, 22:16:30
    Author     : Bruno
    --%>

<%@page import="Business.VendaTemp"%>
<%-- 
    Document   : dashboard-vendas
    Created on : 13/10/2018, 21:50:35
    Author     : Bruno
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
        <link rel="stylesheet" href="css/venda.css">
        
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.12.1/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/vendas.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>
        <script src="js/scripts.js"></script>
        
        <script>
            jQuery(function(){
                
            });
        </script>

    </head>

    <body>

        <%@include file="nav.jsp" %>

        <div id="btnMenu"><img src="img/btn-menu.png"></div>

        <!--%@include file="menu.jsp" %-->

        
        <div class="cont-left">
            <div class="col-md-3">
                <div class="border-titulo">

                        <h2>Dados da Venda</h2>
                        <br>
                        <div class="col-md-12 form-group">
                            <select class="form-control" id="tipoPagamento">
                                <option>Dinheiro</option>
                                <option>Cartão de Crédito</option>
                                <option>Cartão de Débito</option>
                              </select>
                            <select class="form-control" id="formaPagamento">
                                <option>1X</option>
                                <option>2X</option>
                                <option>3X</option>
                                <option>4X</option>
                                <option>5X</option>
                                <option>6X</option>
                              </select>
                            <input type="button" class="btn btn-primary" value="Gerar Pedido" id="confirmaFimVenda">
                            <input type="button" class="btn btn-danger" style="background: #e31" value="Cancelar Pedido" id="cancelarVenda"><br>
                            Valor total:<br>
                            <h3>R$<span id="valorTotalPed"></span> </h3>
                        </div>
                        <div id="finalVenda" title="Confirmar conclusão da venda" style="display: none;">STUFF HERE</div>
                    <div class="clearfix"></div>
                </div>
                
                <br>
                <div class="border-titulo">

                        <h2>Adicionar Produto</h2>
                        <br>
                        <div class="col-md-12 form-group">
                            <input type="text" id="textProduto" class="form-control">
                            <input type="button" value="Buscar Produto" class="btn btn-primary" id="buscar">
                            <div id="prodPesquisado" title="Informações do produto" style="display: none;">STUFF HERE</div>
                        </div>

                    <div class="clearfix"></div>
                </div>
                <br>
                <div class="border-titulo">

                        <h2>Adicionar Servico</h2>
                        <br>
                        <div class="col-md-12 form-group">
                            <input type="text" id="textServico" class="form-control">
                            <input type="button" value="Buscar Servico" class="btn btn-primary" id="buscarServico">
                            <div id="servPesquisado" title="Informações do serviço" style="display: none;">STUFF HERE</div>
                        </div>

                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="border-titulo">
                    <form>
                        <h2>Dados do Cliente</h2>
                        <br>
                        <div class="col-md-6 form-group">
                            <label>Nome</label>
                            <input type="text" class="form-control" id="nomeCliente" disabled="true">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>CPF/CNPJ</label>
                            <input type="text" class="form-control" id="idCliente" disabled="true">
                        </div>
                    </form>
                    <div class="clearfix"></div>
                </div>

                <br>
                <div class="border-titulo">

                        <h2>Produtos</h2>
                        
                        <div class="col-md-12 p-30 table-responsive">

                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>Ean</th>
                                        <th>Nome</th>
                                        <th>Valor Unitário</th>
                                        <th>Qtd.</th>
                                        <th>Valor Total</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody id="tbody_produtos">

                                </tbody>
                            </table>
                        </div>
                    <div class="clearfix"></div>
                </div>
                <br>
                <div class="border-titulo">
                        <h2>Serviços</h2>
                        <div class="col-md-12 p-30 table-responsive">

                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome</th>
                                        <th>Valor(Mês)</th>
                                        <th>Duração(Meses)</th>
                                        <th>Valor total</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody id="tbody_servicos">
                                </tbody>
                            </table>

                        </div>
                    <div class="clearfix"></div>
                </div>
                
            </div>
            <br>
            <div class="col-md-3">
                
            </div>
        <!--div class="col-sm-6">
            <div class="border-titulo">
                Batata
            </div>
                
            </div>
                
        </div-->
        
        <div class="clearfix"></div>
    </div>
    
    <div id="popup"></div>
    
    

</body>

</html>