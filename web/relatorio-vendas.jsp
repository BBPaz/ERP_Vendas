<%-- 
    Document   : relatorio-vendas
    Created on : 11/11/2018, 23:53:39
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Vendas</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Grupo 6 - Vendas" />

        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <link href="js/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/all.css">
        
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.12.1/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>
        <script src="js/scripts.js"></script>
        
    </head>
    <body>

        <%@include file="nav.jsp" %>
        
        <div id="btnMenu"><img src="img/btn-menu.png"></div>
        
        <%@include file="menu.jsp" %>
        <div class="cont cont-mid">
        <div class="col-md-12">
            <div class="row">
                
                <div class="col-md-12">

                    <div class="border-titulo text-center">
                        <div class="col-md-6" style='padding-top: 50px'>
                        <div class="col-md-4 form-group">
                           
                            <input type="radio" value="Produtos" name="radioRelatorio" id="radioProdutos" checked><label>Produtos</label>
                        </div>
                        <div class="col-md-4 form-group">
                            
                            <input type="radio" value="Serviços" name="radioRelatorio" id="radioServicos"><label>Serviços</label>
                        </div>
                        <div class="col-md-4 form-group">
                            
                            <input type="radio" value="Todos" name="radioRelatorio" id="radioTodos"><label>Todos</label>
                        </div>
                        </div>
                        <div class="col-md-6">
                            <div class="col-md-6 form-group">
                            <label>Data Inicio</label>
                            <input type="date" class="form-control" id="nomeCliente">
                            </div>
                            <div class="col-md-6 form-group">
                            <label>Data Fim</label>
                            <input type="date" class="form-control" id="nomeCliente">
                            </div>
                        </div>
                        
                         <div class="col-md-6 form-group">
                            <select class="form-control" id="opcoesRelatorio">
                                <option>1X</option>
                                <option>2X</option>
                                <option>3X</option>
                                <option>4X</option>
                                <option>5X</option>
                                <option>6X</option>
                              </select>
                        </div>

                        <div class="col-md-2 form-group">
                            <input type="button" class="btn form-control" value="Incluir" id="botAdd">
                        </div>
                        <div class="col-md-2 form-group">
                            <input type="button" class="btn form-control" value="Incluir Todos" id="botAddTodos">
                        </div>
                        <div class="col-md-2 form-group">
                            <input type="button" class="btn form-control" value="Remover Todos" id="botRemoverTodos">
                        </div>
                        <div class="col-md-10" style="height:120px;overflow-y: auto;text-align: left;">
                            <table class="table table-bordered">
                                <tbody>
                                    <tr id="d1" onclick="$('#d1').hide();"><td>Produto 1</td></tr>
                                <tr><td>Produto 2</td></tr>
                                <tr><td>Produto 3</td></tr>
                                <tr><td>Produto 4</td></tr>
                                <tr><td>Produto 5</td></tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-2 form-group">
                            <input type="button" class="btn form-control" value="Gerar" id="gerarRelatorio">
                        </div>
                        <div class="col-md-12 p-30 table-responsive">

                        <table id="frm" class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nome</th>
                                    <th>%</th>
                                    <th>Valor</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>#0001</td>
                                    <td>Produto 1</td>
                                    <td>X%</td>
                                    <td>11</td>
                                </tr>
                                <tr>
                                    <td>#0002</td>
                                    <td>Produto 2</td>
                                    <td>Y%</td>
                                    <td>22</td>
                                </tr>
                                <tr>
                                    <td>#0003</td>
                                    <td>Produto 3</td>
                                    <td>Z%</td>
                                    <td>33</td>
                                </tr>
                            </tbody>
                        </table>

                    </div>
                        
                        
                        
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        </div>
        <script src="js/editar-cliente.js" type="text/javascript"></script>
</body>
</html>
