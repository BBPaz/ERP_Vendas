$(function(){

    var urlParams = new URLSearchParams(window.location.search);
    var myParam = urlParams.get('idCliente');
    console.log(myParam);

    function buscaPj(idCliente){
        alert("Pesquisar Produto");
        console.log(idCliente);
        var x = "";
        $.ajax({
            url:"IniciarVenda",
            type:"get",
            data:"op=BuscaPj&idCliente="+idCliente,
            success: function(data){
                x += data;
                console.log(x);
                if(x === "false"){
                    alert(x);
                }
            },
            error: function(er){
                x = er.responseText;
            }
        });
        
    }
    
});

