<%-- 
    Document   : busca-vendas
    Created on : 12/11/2018, 11:22:40
    Author     : k
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
        <script src="js/busca-vendas.js"></script>
        
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
                        <div class="col-md-12 p-30 table-responsive">

                        <table id="frm" class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Codigo</th>
                                    <th>ID Cliente</th>
                                    <th>Nome Cliente</th>
                                    <th>Valor Total</th>
                                    <th>Data</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Exemplo</td>
                                    <td>Cliente 1</td>
                                    <td>11</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Exemplo</td>
                                    <td>Y%</td>
                                    <td>22</td>
                                </tr>
                                <tr>
                                    <td>3</td>
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

