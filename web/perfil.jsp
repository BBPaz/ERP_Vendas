<%-- 
    Document   : perfil.jsp
    Created on : 13/10/2018, 22:08:58
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
    <meta name="author" content="Grupo 6 - Livros Fiscais" />

    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
</head>

<body>

    <%@include file="nav.jsp"%>

    <div id="btnMenu"><img src="img/btn-menu.png"></div>

    <%@include file="menu.jsp"%>

    <div class="cont">

        <div class="col-md-12">
            <div class="border-titulo pb-20 pb-0-mob">

                <h2>Meu perfil</h2>

                <br><br>

                <div class="col-md-2">
                    <img src="img/icon-perfil.jpg" style="width:100%;" />
                </div>

                <div class="col-md-4 mt-30-mob">
                    <p><strong>Nome:</strong> Teste de teste</p>
                    <p><strong>Data de Nascimento:</strong> 00/00/0000</p>
                    <p><strong>Cargo:</strong> X</p>
                    <p><strong>...</strong></p>
                </div>

                <div class="clearfix"></div>
        
            </div>
        </div>

    </div>

<div id="popup"></div>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap4.min.js"></script>
<script src="js/scripts.js"></script>

</body>

</html>