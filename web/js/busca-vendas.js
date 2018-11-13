$(function(){
    var dash_vendas = "/ERP_Panelas/dashboard-vendas.jsp";
    var t = $('#frm').DataTable();
    exibirVendas();
    //populaTabela();
    debugger

    function exibirVendas(){
        
        $.ajax({
            url:"BuscaVendas",
            type:"get",
            data:"op=exibirVendas",
            success: function(data){
                //exibirProdutos();
                console.log(data);
                eval(data);
                //teste(codProduto);
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
   $('table#frm').on('click','tr',function(){
          var idPedido = $(this).find('td:first').text();
          $.ajax({
            url:"BuscaVendas",
            type:"get",
            data:"op=colocarIdPedido&idPedido="+idPedido,
            success: function(data){
                //exibirProdutos();
                window.location.replace("/ERP_Panelas/exibe-pedido.jsp");
                //teste(codProduto);
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });

    });
    
    
});

