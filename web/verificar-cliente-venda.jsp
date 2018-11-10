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
        <div class="col-md-8">
            <div class="cont-mid row">

                <div class="col-md-8 col-md-offset-3">

                    <div class="border-titulo text-center">
                        <%@include file="cliente.jsp" %>
                        <div class="clearfix"></div>
                    </div>
                        <div class="clearfix"></div>
                </div>
                <!--div class="parent-div bg-danger d-flex align-items-center" style="height: 600px;width: 400px;">
                    <div class="child-div bg-warning" style="height: 300px;width: 200px;">
                      BATATA
                    </div>
                </div-->
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="cont-mid row">
                <div class="border-titulo text-center">
                    <h2>Confirmar Cliente</h2>
                    <input type="button" class="btn btn-primary" value="Prosseguir para venda">
                    <input type="button" class="btn btn-danger"  value="Cancelar" id="cancelarConfirmacao">
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        

    
    

</body>

</html>