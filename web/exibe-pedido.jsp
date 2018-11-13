<%-- 
    Document   : exibePedido
    Created on : 13/11/2018, 11:30:23
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
        <script src="js/exibe-pedido.js"></script>
        
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
                            <div class="col-md-12" style="text-align: left; margin: 0;padding:0;">
                                <div class="col-md-2 form-group" style="margin: 0; padding: 0;">
                                    <input type="button" class="btn btn-danger" value="Voltar" id="btnVoltar">
                                </div>
                            </div>
                            <%@include file="pedido.jsp" %>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        </div>
</body>
</html>