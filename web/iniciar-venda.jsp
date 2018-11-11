<%-- 
    Document   : iniciar-venda
    Created on : 13/10/2018, 22:12:46
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
        <link rel="stylesheet" href="css/iniciar-venda.css">
        
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
        <%@include file="nav.jsp" %>

        <div id="btnMenu"><img src="img/btn-menu.png"></div>

        <!--%@include file="menu.jsp" %-->

        <div class="cont-mid row">
                <div class="col-md-5 col-md-offset-5">
                    <div class="border-titulo text-center">
                            <h2>Iniciar Venda</h2>
                            <br>
                            <div class="form-group">
                                CPF/CNPJ do cliente:<input type="text" class="form-control" id="numCadastro">
                                <input type="button" class="btn btn-primary" value="Iniciar Venda" id="buscarCliente"><br>
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
