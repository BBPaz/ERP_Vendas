<%-- 
    Document   : cliente
    Created on : 06/11/2018, 19:00:03
    Author     : logonaf
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
        <!--%@include file="nav.jsp" %>

        <div id="btnMenu"><img src="img/btn-menu.png"></div>

        <!--%@include file="menu.jsp" %-->
        <div class="container-fluid">
            
            <div class="row">


                    <div class="text-center">
                                <h2>Dados do Cliente</h2>
                                <br>
                                <div class="col-md-12 form-group">
                                    <label>ID</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                <div id="dados-pf">
                                    <div class="col-md-12 form-group">
                                    <label>Nome completo</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>CPF</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Data de nascimento</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                </div>
                                <div id="dados-pj" style="display:none;">
                                <div class="col-md-12 form-group">
                                    <label>Razão Social</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                <div class="col-md-4 form-group">
                                    <label>CNPJ</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                
                                <div class="col-md-4 form-group">
                                    <label>Inscrição municipal</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                <div class="col-md-4 form-group">
                                    <label>Inscrição Estadual</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                </div>
                                
                                <div class="col-md-6 form-group">
                                    <label>E-mail</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                 <div class="col-md-6 form-group">
                                    <label>Telefone</label>
                                    <input type="text" class="form-control" disabled="true">
                                </div>
                                
                                
                        <div class="clearfix"></div>
                    </div>
                    <hr style="border-top: 1px solid #000;">
                    <div class="text-center">
                        <h2>Endereço</h2>
                        <div class="col-md-10 form-group">
                            <label>Logradouro</label>
                            <input type="text" class="form-control" disabled="true">
                        </div>
                        <div class="col-md-2 form-group">
                            <label>Num</label>
                            <input type="text" class="form-control" disabled="true">
                        </div>                   
                        <div class="col-md-6 form-group">
                            <label>Bairro</label>
                            <input type="text" class="form-control" disabled="true">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Cidade</label>
                            <input type="text" class="form-control" disabled="true">
                        </div>
                        <div class="col-md-12 form-group">
                            <label>CEP</label>
                            <input type="text" class="form-control" disabled="true">
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
