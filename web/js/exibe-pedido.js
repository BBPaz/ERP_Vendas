$(function(){
        
    
    $.ajax({
            url:"BuscaVendas",
            type:"get",
            data:"op=exibirPedido",
            success: function(data){
                eval(data);
            },
            error: function(er){
                x = er.responseText;
            }
        });
    
    $("#btnVoltar").on("click",function(){
        window.location.replace("/ERP_Panelas/busca-vendas.jsp");
    });
    
    
});

