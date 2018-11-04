<%-- 
    Document   : venda
    Created on : 13/10/2018, 22:16:30
    Author     : Bruno
    --%>

    <%@page import="Business.VendaTemp"%>
    <%@page import="Dao.ServicoDao"%>
    <%@page import="entidades.Servico"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="Dao.ProdutoDao"%>
    <%@page import="entidades.Produto"%>
<%-- 
    Document   : dashboard-vendas
    Created on : 13/10/2018, 21:50:35
    Author     : Bruno
    --%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <%ProdutoDao pDao = new ProdutoDao();%>
    <head>
        <meta charset="utf-8">
        <title>Vendas</title>

        <link rel="stylesheet" href="css/all.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Grupo 6 - Vendas" />

        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
        <link href="js/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.bootstrap4.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="js/jquery-ui-1.12.1/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/vendas_1.js" type="text/javascript"></script>
        <!--script>
            $(function(){
                
            });
        </script-->

    </head>

    <body>

        <%@include file="nav.jsp" %>

        <div id="btnMenu"><img src="img/btn-menu.png"></div>

        <!--%@include file="menu.jsp" %-->


        <div class="cont">
            <div class="col-md-3">
                <div class="border-titulo">
                    <form>
                        <h2>Dados da Venda</h2>
                        <br>
                        <div class="col-md-6 form-group">
                            <input type="button" class="btn btn-default" value="Gerar Pedido">
                            <input type="button" class="btn btn-default" style="background: #e31" value="Cancelar Pedido"><br>
                            Valor total:<br>
                            <h3>R$ </h3>
                        </div>
                    </form>
                    <div class="clearfix"></div>
                </div>
                
                <br>
                <div class="border-titulo">
                    <form>
                        <h2>Adicionar Produto</h2>
                        <br>
                        <div class="col-md-6 form-group">
                            <input type="text" id="textProduto" class="form-control">
                            <input type="button" value="Buscar Produto" class="btn btn-primary" id="buscar">
                            <input type="button" value="Adicionar Produto" class="btn btn-primary" id="addProduto">
                            <div id="prodPesquisado" title="Informações do produto"></div>
                        </div>
                    </form>
                    <div class="clearfix"></div>
                </div>
                <br>
                <div class="border-titulo">
                    <form>
                        <h2>Adicionar Servico</h2>
                        <br>
                        <div class="col-md-6 form-group">
                            <input type="text" id="textServico" class="form-control">
                            <input type="button" value="Buscar Produto" class="btn btn-primary" id="buscarServico">
                            <input type="button" value="Adicionar Produto" class="btn btn-primary" id="addServico">
                            <div id="prodPesquisado" title="Informações do serviço"></div>
                        </div>
                    </form>
                    <div class="clearfix"></div>
                </div>
            </div>
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

                        <h2>Produtos</h2><br>
                        
                        <div class="col-md-12 p-30 table-responsive">

                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>Ean</th>
                                        <th>Nome</th>
                                        <th>Valor Unitário</th>
                                        <th>Qtd.</th>
                                        <th>Valor Total</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody id="tbody_produtos">

                                </tbody>
                            </table>
                            <button id="teste">TESTE</button>
                        </div>
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
                                        <th>Id</th>
                                        <th>Nome</th>
                                        <th>Valor Unitário</th>
                                        <th>Duração(Meses)</th>
                                        <th>Valor total</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%  ServicoDao sDao = new ServicoDao();
                                    ArrayList<Servico> sList = sDao.getServicos(); 
                                    for(Servico s:sList){
                                    %><tr>
                                        <td><%=s.getId()%></td>
                                        <td><%=s.getNome()%></td>
                                        <td>R$<%=s.getValor()%></td>
                                        <td><input type="number" class="form-control" name="qte<%=s.getId()%>"></td>
                                        <td></td>
                                        <td><input type="button" value="Remover"></td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>

                        </div>
                    </form>
                    <div class="clearfix"></div>
                </div>
                
            </div>
            <br>
            <div class="col-md-3">
                
            </div>
        <!--div class="col-sm-6">
            <div class="border-titulo">
                Batata
            </div>
                
            </div>
                
        </div-->
        
        <div class="clearfix"></div>
    </div>
    
    <div id="popup"></div>

    
</body>

</html>