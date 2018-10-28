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
        <script>
            $(function(){
                $("#btn").on("click",function(){
                    console.log("batata");
                    $.ajax({
                        url:"Teste",
                        type:"get",
                        data: "x=uso de droga&y="+$("#text").val(),
                        success: function(data){
                            console.log("sucesso: "+data);
                        },
                        error: function(er){
                            console.log("erro");
                        }
                    });
                });
            });
        </script>
        
    </head>
    <body>

        <input type="text" id="text">
        <input type="button" id="btn" value="Bora">
        <div id="result"></div>
    </body>
</html>
