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
    </head>
    <body>
        <% int quant =  0;
        if(request.getParameter("quant")!=null){
            int oldQuant =  Integer.parseInt(request.getParameter("quant"));
            quant+=oldQuant;
        }
        quant += Integer.parseInt(request.getParameter("add"));
        %>
        <form action="Teste.jsp" method="get">
            batata
            <input value="<%=quant%>" name="quant">
            <input type="text" name="batata">
            <table>
            <%
                for(int c = 1;c<=quant;c++){
                    %><tr><td><input name="item" disabled="disabled" style="display: hidden;" value='item<%=c%>'>Item <%=c%></td></tr><%
                }
            %>
            </table>
       
            <input type="submit">
            <input style="display: none;" value="1" name="add">
            </form>
            
               
            
    </body>
</html>
