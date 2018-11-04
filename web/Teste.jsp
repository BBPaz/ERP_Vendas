<%-- 
    Document   : Teste
    Created on : 21/10/2018, 22:22:22
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.12.1/jquery-ui.min.js" type="text/javascript"></script>
        <link href="js/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script>
            $(function(){
                $("#btn").on("click",function(){
                    console.log("batata");
                        $("#infoItem").dialog();

                });
            });
        </script>
        
    </head>
    <body>

        <input type="text" id="text">
        <input type="button" id="btn" value="Bora">
        <div id="infoItem" title="Informações do produto">BATATA</div>
        <tr>
            <th>Código</th>
            <td></td>
        </tr>
        <tr>
            <th>Nome</th>
            <td></td>
        </tr>
        <tr>
            <th>Descrição</th>
            <td></td>
        </tr>
        <tr>
            <th>Valor</th>
            <td></td>
        </tr>
        <tr>
            <th>Qte. Disponível no estoque</th>
            <td></td>
        </tr>
    </body>
</html>
