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
                    break;
                case 12:
                    $("#aviso").html("CNPJ");
                    $("#aviso").dialog();
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
    
});

