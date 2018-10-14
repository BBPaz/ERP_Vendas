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

<div id="popup"></div>

<script src="js/jquery.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap4.min.js"></script>
<script src="js/scripts.js"></script>

</body>

</html>