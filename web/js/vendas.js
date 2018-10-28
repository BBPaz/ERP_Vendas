$(function(){
    debugger
    
    $("#buscar").on("click",function(){
        alert("BANANA");
        console.log($("#textProduto").val());
        var x;
        $.ajax({
            url:"Venda",
            type:"get",
            data:"textProduto="+$("#textProduto").val(),
            success: function(data){
                x += data;
                $("#prodPesquisado").html(x);
            },
            error: function(er){
                x = er.responseText;
            }
        });
        
    });
    
    function pesquisaProduto(){
        var id = $("#textProduto").val();
        $.ajax({
            url:"Venda",
            type:"get",
            data:"operacao =pesqProduto&idProduto ="+id,
            success: function(data){
                $("#prodPesquisado").html(data);
            },
            error: function(er){
                $("#prodPesquisado").html(er.responseText);
            }
        });
    }
});
