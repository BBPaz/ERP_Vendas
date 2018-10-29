$(function(){
    debugger
    
    $("#buscar").on("click",function(){
        pesquisaProduto();
    });
    
    $("#addProduto").on("click",function(){
        alert("Adicionar Produto");
        console.log($("#textProduto").val());
        var x = "";
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=addProduto&textProduto="+$("#textProduto").val(),
            success: function(data){
                exibirProdutos();
            },
            error: function(er){
                x = "Erro: "+er.responseText;
            }
        });
        
    });
    
    $(".removeProd").on("click",function(){
        alert("Remover Produto");
        console.log($("#textProduto").val());
        var x = "";
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=addProduto&textProduto="+$("#textProduto").val(),
            success: function(data){
                x = data;
                console.log(x);
                $("#tbody_produtos").html(x);
            },
            error: function(er){
                x = "Erro: "+er.responseText;
            }
        });
        
    });
    
    function pesquisaProduto(){
        alert("Pesquisar Produto");
        console.log($("#textProduto").val());
        var x = "";
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=pesqProduto&textProduto="+$("#textProduto").val(),
            success: function(data){
                x += data;
                console.log(x);
                $("#prodPesquisado").html(x);
            },
            error: function(er){
                x = er.responseText;
            }
        });
        
    }
    
    function exibirProdutos(){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=attProdutos",
            success: function(data){
                x = data;
                console.log(x);
                $("#tbody_produtos").html(x);
            },
            error: function(er){
                
            }
        });
    }

});
