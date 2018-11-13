$(function(){

    var urlParams = new URLSearchParams(window.location.search);
    var idCliente = urlParams.get('idCliente');
    var tipo;
    if(idCliente.length===11){
        tipo="fisica";
    }
    else{
        tipo="juridica";
    }
     $("#salvarCliente").prop("disabled",true);
    var x;
    $.ajax({
            url:"IniciarVenda",
            type:"get",
            data:"op=PopularCliente&idCliente="+idCliente+"&tipo="+tipo,
            success: function(data){
                x += data;
                console.log(x);
                eval(data);
                if(tipo==="juridica"){
                    $("#dados-pf").hide();
                    $("#dados-pj").show();
                }
            },
            error: function(er){
                x = er.responseText;
            }
        });
    
    $("#editarCliente").on("click",function(){
        $("input").prop("disabled",false);
        $("#cpfCliente").prop("disabled",true);
        $("#cnpjCliente").prop("disabled",true);
        $("#salvarCliente").prop("disabled",false);
        $("#cancelarEditCliente").prop("disabled",false);   
        $(this).prop("disabled",true);
    });
    
    $("#salvarCliente").on("click",function(){
        $("input").prop("disabled",true);
        $("#cancelarEditCliente").prop("disabled",false);
        $("#editarCliente").prop("disabled",false);
        $(this).prop("disabled",true);
        alterarCliente();
    });
    
    $("#cancelarEditCliente").on("click",function(){
        if(confirm("Cancelar edição de cliente?"))
        window.location.replace("/ERP_Panelas/dashboard-vendas.jsp"/*ERP_Panelas/verificar-cliente-venda.jsp?idCliente="+idCliente*/);
    });
    
    $("#prosseguirVenda").on("click",function(){
        $.ajax({
            url:"IniciarVenda",
            type:"get",
            data:"op=IniciarVenda&idCliente="+idCliente+"&tipo="+tipo,
            success: function(data){
                window.location.replace("/ERP_Panelas/venda.jsp"/*ERP_Panelas/verificar-cliente-venda.jsp?idCliente="+idCliente*/);
            },
            error: function(er){
                x = er.responseText;
            }
        });
    });
    
    function alterarCliente(){
        $.ajax({
            url:"GerenciarCliente",
            type:"get",
            data:"op=alterarCliente&idCliente="+idCliente+"&tipo="+tipo+"&nomeCliente="+$("#nomeCliente").val()+"&cpfCliente="+$("#cpfCliente").val()+"&dataNascCliente="+$("#dataNascCliente").val()+"&razaoSocialCliente="+$("#razaoSocialCliente").val()+"&cnpjCliente="+$("#cnpjCliente").val()+"&inscMunicCliente="+$("#inscMunicCliente").val()+"&inscEstCliente="+$("#inscEstCliente").val()+"&emailCliente="+$("#emailCliente").val()+"&numeroCliente="+$("#numeroCliente").val()+"&log="+$("#log").val()+"&numeroEndereco="+$("#numeroEndereco").val()+"&complemento="+$("#complemento").val()+"&bairro="+$("#bairro").val()+"&cidade="+$("#cidade").val()+"&cep="+$("#cep").val()+"&estado="+$("#estado").val()+"&idEndereco="+$("#idEndereco").html(),
            success: function(data){
                alert("Salvo");
                //window.location.replace("/ERP_Panelas/venda.jsp"/*ERP_Panelas/verificar-cliente-venda.jsp?idCliente="+idCliente*/);
            },
            error: function(er){
                x = er.responseText;
            }
        });
    }
    
    
    
    
});

