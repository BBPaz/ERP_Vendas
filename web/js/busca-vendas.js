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
    
    function populaTabela(){
        
        t.row.add( [
            'Teste',
            'Batata',
            'Igor',
            'nota',
            'Numero'
        ]).draw(false);
        t.row.add([
            'Joia',
            'Cenoura',
            'Bruno',
            '08310520',
            'Pedra'
        ] ).draw( false );
        
    }
    
    
});

