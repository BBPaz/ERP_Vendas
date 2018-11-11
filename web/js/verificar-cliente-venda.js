$(function(){

    var urlParams = new URLSearchParams(window.location.search);
    var idCliente = urlParams.get('idCliente');
    var tipo;
    if(idCliente.length===11){
        tipo="fisica";
    }
    else{
        tipo="juridica";
    }
    var x;
    $.ajax({
            url:"IniciarVenda",
            type:"get",
            data:"op=PopularCliente&idCliente="+idCliente+"&tipo="+tipo,
            success: function(data){
                x += data;
                console.log(x);
                eval(data);
            },
            error: function(er){
                x = er.responseText;
            }
        });
        
    $("#prosseguirVenda").on("click",function(){
        $.ajax({
            url:"IniciarVenda",
            type:"get",
            data:"op=IniciarVenda&idCliente="+idCliente+"&tipo="+tipo,
            success: function(data){
                window.location.replace("/ERP_Panelas/venda.jsp"/*ERP_Panelas/verificar-cliente-venda.jsp?idCliente="+idCliente*/);
            },
            error: function(er){
                x = er.responseText;
            }
        });
    });
    
    $("#cancelarVenda").on("click",function(){
        alert("Cancela");
        window.location.replace("/ERP_Panelas/dashboard-vendas.jsp"/*ERP_Panelas/verificar-cliente-venda.jsp?idCliente="+idCliente*/);
    });
    
    
});

