$(function(){
    var urlParams = new URLSearchParams(window.location.search);
    var idCliente = urlParams.get('idCliente');
    var tipo;
    
    
    if(idCliente.length===11){
        tipo="fisica";
        $("#cpfCliente").val(idCliente);
        
        $("#dadosPf").show();
        $("#dadosPj").hide();
    }
    else{
        tipo="juridica";
        $("#cnpjCliente").val(idCliente);
        
        $("#dadosPf").show();
        $("#dadosPj").hide();
    }
        $("input").prop("disabled",false);
        $("#cnpjCliente").prop('disabled',true);
        $("#cpfCliente").prop('disabled',true);
        
        $("#cadCliente").on("click",function(){
            if($("#nomeCliente").val()===""&&$("#razaoSocialCliente").val()){
                alert("Preencha os campos");
            }
            else{
                $.ajax({
                url:"GerenciarCliente",
                type:"get",
                data:"op=cadastrarCliente&idCliente="+idCliente+"&tipo="+tipo+"&nomeCliente="+$("#nomeCliente").val()+"&cpfCliente="+$("#cpfCliente").val()+"&dataNascCliente="+$("#dataNascCliente").val()+"&razaoSocialCliente="+$("#razaoSocialCliente").val()+"&cnpjCliente="+$("#cnpjCliente").val()+"&inscMunicCliente="+$("#inscMunicCliente").val()+"&inscEstCliente="+$("#inscEstCliente").val()+"&emailCliente="+$("#emailCliente").val()+"&numeroCliente="+$("#numeroCliente").val()+"&log="+$("#log").val()+"&numeroEndereco="+$("#numeroEndereco").val()+"&complemento="+$("#complemento").val()+"&bairro="+$("#bairro").val()+"&cidade="+$("#cidade").val()+"&cep="+$("#cep").val()+"&estado="+$("#estado").val()+"&idEndereco="+$("#idEndereco").html(),
                success: function(data){
                    //exibirProdutos();

                    //teste(codProduto);
                },
                error: function(er){
                    var x = er.responseText;
                    console.log(x);
                }
            });
            }
            
        })
        
});

