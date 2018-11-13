$(function(){
    
    $("#buscarCliente").on("click",function(){
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
                    buscaPf(num);
                    break;
                case 14:
                    buscaPj(num);
                    break;
                default:
                    alert("Digite um CPF ou CNPJ");
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
    
    function buscaPf(idCliente){
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
                    clienteEncontrado(idCliente);
                }
                else{
                    clienteInexistente(idCliente);
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
                if(x === "true"){
                    clienteEncontrado(idCliente);
                }
                else{
                    clienteInexistente(idCliente);
                }
            },
            error: function(er){
                x = er.responseText;
            }
        });
        
    }
    
    function clienteEncontrado(idCliente){
        window.location.replace("/ERP_Panelas/verificar-cliente-venda.jsp?idCliente="+idCliente);  
    }
    
    function clienteInexistente(idCliente){
        if(confirm("Cliente não encontrado. Deseja cadastrar?")){
            window.location.replace("/ERP_Panelas/cadastrar-cliente.jsp?idCliente="+idCliente);
        }
    }
    
});

