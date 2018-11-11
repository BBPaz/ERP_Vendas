$(function(){
    var dash_vendas = "/ERP_Panelas/dashboard-vendas.jsp";
    exibirProdutos();
    exibirServicos();
    exibirCliente();
    valTot();
    
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
    
    
    $("#buscarServico").on("click",function(){
        var codServico = $("#textServico").val();
        var res = $("#servPesquisado");
        pesquisaServico(codServico,res);

    });
    
    $("div#prodPesquisado").on("click","#addProduto",function(){
        //alert("Adicionar Produto");
        //$("#example").dialog();
        
        var codProduto = $("#textProduto").val();
        adicionaProduto(codProduto);
        $(this).closest('.ui-dialog-content').dialog('close'); 
    });
    
    $("div#servPesquisado").on("click","#addServico",function(){
        //alert("Adicionar Produto");
        //$("#example").dialog();
        
        var codServico = $("#textServico").val();
        adicionaServico(codServico);
        $(this).closest('.ui-dialog-content').dialog('close'); 
    });
    
    $("#tbody_produtos").on("click",".removeProd",function(){
        //alert("Remover Produto");
        var cod = $(this).val();
        removeProduto(cod);
    });
    
    $("#tbody_servicos").on("click",".removeServ",function(){
        //alert("Remover Serviço");
        var cod = $(this).val();
        removeServico(cod);
    });
    
    $("#tbody_produtos").on("change","input[type=number]",function(){
        //alert("Alterar Qte");
        console.log($(this).val());
        mudarQte($(this).val(),$(this).attr("data-produto"));
    });
    
    $("#tbody_produtos").on("keyup","input[type=number]",function(){
        //alert("Alterar Qte");
        console.log($(this).val());
        mudarQte($(this).val(),$(this).attr("data-produto"));
        if(numVazio($(this))){
            mudarQte(1,$(this).attr("data-produto"));
        }
    });
    
    $("#tbody_servicos").on("change","input[type=number]",function(e){
        //alert("Alterar Qte");
        console.log($(this).val());
        mudarDur($(this).val(),$(this).attr("data-servico"));
    });
    
    $("#tbody_servicos").on("keyup","input[type=number]",function(e){
        //alert("Alterar Qte");
        console.log($(this).val());
        mudarDur($(this).val(),$(this).attr("data-servico"));
        if(numVazio($(this))){
            mudarDur(1,$(this).attr("data-servico"));
        }
    });
    
    $('tbody#tbody_produtos').on('input','input', function () {
        var value = $(this).val();
        if ((value !== '') && (value.indexOf('.') === -1)) {    
            $(this).val(Math.max(Math.min(value, $(this).attr("max")), $(this).attr("min")));
        }
    });
    
    $('tbody#tbody_servicos').on('input','input', function () {
        var value = $(this).val();
        if ((value !== '') && (value.indexOf('.') === -1)) {    
            $(this).val(Math.max(Math.min(value, 24), 1));
        }
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
                valTot();
            },
            error: function(er){
                
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
                x = "Erro: "+er.responseText;
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
                x = er.responseText;
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
                x = "Erro: "+er.responseText;
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
                x = "Erro: "+er.responseText;
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
                x = "Erro: "+er.responseText;
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
                x = "Erro: "+er.responseText;
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
                x = er.responseText;
            }
        });
    }
    
});

