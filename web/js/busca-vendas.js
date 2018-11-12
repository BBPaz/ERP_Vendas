$(function(){
    var dash_vendas = "/ERP_Panelas/dashboard-vendas.jsp";
    exibirVendas();
    
    $("#cancelarVenda").on("click",function(){
        if(confirm("Deseja mesmo cancelar a venda?")){
            window.location.replace(dash_vendas);
        }
    });
    
    $("#buscar").on("click",function(){
        var codProduto = $("#textProduto").val();
        var res = $("#prodPesquisado");
        pesquisaProduto(codProduto,res);

    });

    function exibirVendas(){
        $.ajax({
            url:"BuscarVendas",
            type:"get",
            data:"op=exibirVendas",
            success: function(data){
                exibirProdutos();
                console.log(data);
                $("#form tbody").html(data);
                //teste(codProduto);
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function pesquisaProduto(codProduto,elemResultado){
        //alert("Pesquisar Produto");
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
                    elemResultado.dialog();
                }
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
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
                var x = er.responseText;
                console.log(x);
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
                valTot();
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function mudarQte(qte,prod){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"qte="+qte+"&op=altQuantProduto&textProduto="+prod,
            success: function(data){
                $("#valTotalP"+prod).html(data);
                valTot();
                //alert("Alterado");
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function pesquisaServico(codServico,elemResultado){
        //alert("Pesquisar Produto");
        console.log(codServico);
        var x = "";
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=pesqServico&textServico="+codServico,
            success: function(data){
                x += data;
                console.log(x);
                if(x === "Serviço não encontrado"){
                    alert(x);
                }
                else{
                    elemResultado.html(x);
                    elemResultado.dialog();
                }
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
        
    }
    
    function adicionaServico(codServico){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=addServico&textServico="+codServico,
            success: function(data){
                exibirServicos();
                var qte = $("#qte"+codServico);
                console.log(qte.attr("id"));
                //teste(codProduto);
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function exibirServicos(){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=attServicos",
            success: function(data){
                x = data;
                console.log(x);
                $("#tbody_servicos").html(x);
                valTot();
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function removeServico(codServico){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=removeServico&textServico="+codServico,
            success: function(data){
                exibirServicos();
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
        
    }
    
    function mudarDur(dur,serv){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"dur="+dur+"&op=altDurServico&textServico="+serv,
            success: function(data){
                $("#valTotalS"+serv).html(data);
                valTot();
                //alert("Alterado");
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function numVazio(elem){
        if(elem.val()===""){
            elem.val(1);
            valTot();
            return true;
        }
        return false;
    }
    
    function valTot(){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=valTot",
            success: function(data){
                $("#valorTotalPed").html(data);
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function exibirCliente(){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=exibirCliente",
            success: function(data){
                eval(data);
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function confirmarFimVenda(){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=ConfirmarFimVenda",
            success: function(data){
                $("#finalVenda").html(data);
                $("#finalVenda").dialog();
                
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function setPagamento(){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=setPagamento&tipo="+$("#tipoPagamento").val()+"&forma="+$("#formaPagamento").val(),
            success: function(data){
                
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
    function  FinalizarVenda(){
        $.ajax({
            url:"Venda",
            type:"get",
            data:"op=FinalizarVenda",
            success: function(data){
                alert("Venda realizada com sucesso!");
                window.location.replace("/ERP_Panelas/dashboard-vendas.jsp");
            },
            error: function(er){
                var x = er.responseText;
                console.log(x);
            }
        });
    }
    
});

