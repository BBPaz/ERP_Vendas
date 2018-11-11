$(function(){
    
    
    $("#buscarCliente").on("click",function(){
        $("#aviso").html("Atenção!");
        $("#aviso").dialog();
        verificarCad();
    });
    
    $("#numCadastro").on("change",function(){
        $("#numCadastro").val($("#numCadastro").val().replace(/ /g,""));
    });
    
    
    function verificarCad(){
        var num = $("#numCadastro").val();
        if(numValido(num)){
            switch(num.length){
                case 11:
                    $("#aviso").html("CPF");
                    $("#aviso").dialog();
                    var exist = buscaPf(num);
                    if(exist){
                        alert("Cliente encontrado");
                        //window.location.replace("/ERP_Panelas/verificar-cliente-venda.jsp?idCliente="+num);                       
                    }
                    else{
                        alert("Cliente não encontrado");
                    }
                    break;
                case 12:
                    $("#aviso").html("CNPJ");
                    $("#aviso").dialog();
                    buscaPj(num);
                    break;
                default:
                    $("#aviso").html("Digite um CPF ou CNPJ");
                    $("#aviso").dialog();
                    break;
            }
        }
        else{
            $("#aviso").html("Digite somente números");
            $("#aviso").dialog();
        }
    }
    
    function numValido(num){
        if(num==="")return false;
        if(num===" ")return false;
        if(isNaN(num))return false;
        if(num.trim()==="")return false;
        return true;
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
    
    function buscaPf(idCliente){
        alert("Pesquisar Produto");
        console.log(idCliente);
        var x = "";
        $.ajax({
            url:"IniciarVenda",
            type:"get",
            data:"op=BuscaPf&idCliente="+idCliente,
            success: function(data){
                x += data;
                console.log(x);
                if(x === "true"){
                    return true;
                }
                else{
                    return false;
                }
            },
            error: function(er){
                x = er.responseText;
            }
        });
        
    }
    
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

