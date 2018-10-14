<%-- 
    Document   : venda
    Created on : 13/10/2018, 22:16:30
    Author     : Bruno
--%>

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

    <link rel="stylesheet" href="css/all.css">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Grupo 6 - Vendas" />

    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
</head>

<body>

    <%@include file="nav.jsp" %>

    <div id="btnMenu"><img src="img/btn-menu.png"></div>

    <%@include file="menu.jsp" %>

    
    <div class="cont">
        <div class="col-md-9">
            <div class="border-titulo">
                <form>
                    <h2>Dados do Cliente</h2>
                    <br>
                    <div class="col-md-3 form-group">
                        <label>ID</label>
                        <input type="text" class="form-control" disabled="true">
                    </div>
                    <div class="col-md-5 form-group">
                        <label>Nome</label>
                        <input type="text" class="form-control" disabled="true">
                    </div>
                    <div class="col-md-4 form-group">
                        <label>CPF/CNPJ</label>
                        <input type="text" class="form-control" disabled="true">
                    </div>
                </form>
                <div class="clearfix"></div>
            </div>
            <br>
            <div class="border-titulo">
                
                <form>
                    <h2>Produtos</h2>
                   <div class="col-md-12 p-30 table-responsive">

                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Ean</th>
                                <th>Nome</th>
                                <th>Valor Unitário</th>
                                <th>Qtd.</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>4123</td>
                                <td>Panela Bonita</td>
                                <td>R$18.67</td>
                                <td><input type="number" class="form-control"></td>
                            </tr>
                        </tbody>
                    </table>

                </div>
                </form>
                <div class="clearfix"></div>
            </div>
            <br>
            <div class="border-titulo">
                
                <form>
                    <h2>Serviços</h2>
                   <div class="col-md-12 p-30 table-responsive">

                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Ean</th>
                                <th>Nome</th>
                                <th>Valor Unitário</th>
                                <th>Qtd.</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>132</td>
                                <td>Garantia</td>
                                <td>R$99.11</td>
                                <td><input type="number" class="form-control"></td>
                            </tr>
                        </tbody>
                    </table>

                </div>
                </form>
                <div class="clearfix"></div>
            </div>
            
        </div>
        <br>
        <div class="col-md-3">
            <div>
                <input type="button" class="btn btn-default" value="Gerar Pedido">
                <input type="button" class="btn btn-default" style="background: #e31" value="Cancelar Pedido"><br>
                Valor total:<br>
                <h3>R$ </h3>
            </div>
        </div>
        <!--div class="col-sm-6">
            <div class="border-titulo">
                Batata
            </div>
                
            </div>
                
        </div-->
        
        
    </div>
    
<div id="popup"></div>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap4.min.js"></script>
<script src="js/scripts.js"></script>

</body>

</html>