$(function(){
    debugger
    
    $("#teste").on("click",function(){
        $("#prodPesquisado").dialog();
    });
    
    $("#buscar").on("click",function(){
        var codProduto = $("#textProduto").val();
        pesquisaProduto(codProduto,$("#prodPesquisado"));
    });
    
    $("#addProduto").on("click",function(){
        alert("Adicionar Produto");
        //$("#example").dialog();
        
        var codProduto = $("#textProduto").val();
        adicionaProduto(codProduto);       
    });
    
    $("#tbody_produtos").on("click",".removeProd",function(){
        alert("Remover Produto");
        var cod = $(this).val();
        removeProduto(cod);
    });
    
    $("#tbody_produtos").on("change","input[type=number]",function(){
        alert("Alterar Qte");
        console.log($(this).val());
        /*$.ajax({
            url:"Venda",
            type:"get",
            data:"op=removeProduto&textProduto="+$(this).val(),
            success: function(data){
                exibirProdutos();
            },
            error: function(er){
                x = "Erro: "+er.responseText;
            }
        });*/
        
    });
    
    function adicionaProduto(codProduto){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=addProduto&textProduto="+codProduto,
            success: function(data){
                exibirProdutos();
                var qte = $("#qte"+codProduto);
                console.log(qte.attr("id"));
                //teste(codProduto);
            },
            error: function(er){
                x = "Erro: "+er.responseText;
            }
        });
    }
    
    function pesquisaProduto(codProduto,elemResultado){
        alert("Pesquisar Produto");
        console.log(codProduto);
        var x = "";
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=pesqProduto&textProduto="+codProduto,
            success: function(data){
                x += data;
                console.log(x);
                if(x === "Produto não encontrado"){
                    alert(x);
                }
                else{
                    elemResultado.html(x);
                    //elemResultado.dialog();
                }
            },
            error: function(er){
                x = er.responseText;
            }
        });
        
    }
    
    function removeProduto(codProduto){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=removeProduto&textProduto="+codProduto,
            success: function(data){
                exibirProdutos();
            },
            error: function(er){
                x = "Erro: "+er.responseText;
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

