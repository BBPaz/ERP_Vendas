function popup_filtrar(){
    $("#popup").html("");

    var conteudo = "<div id='myModal' class='modal'> <div class='modal-content'> <span class='close' onClick='fecha_popup()'>&times;</span> <h3>PERÍODO</h3> <div class='col-md-5'> <input type='date' class='form-control' /> </div> <div class='col-md-2'> <center>à</center> </div> <div class='col-md-5'> <input type='date' class='form-control' /> </div> <div class='clearfix'></div> <hr class='mb-0'> <p class='btn-nao' onClick='fecha_popup()'>CANCELAR</p> <p class='btn-sim' onClick='fecha_popup()'>OK</p> </div> </div>";

    $("#popup").html(conteudo);
}

function popup_selecionarnotafiscal(){
    $("#popup").html("");

    var conteudo = "<div id='myModal' class='modal'> <div class='modal-content' style='border-radius:10px;'> <span class='close' onClick='fecha_popup()'>&times;</span> <h3>NOTAS FISCAIS</h3> <ul class='lista-notasfiscais'> <li> 201805201054.xml </li> <li> 201805211120.xml </li> <li> 201805220926.xml </li> </ul> <div class='clearfix'></div> </div> </div>";
    
    $("#popup").html(conteudo);
}

function popup_sucesso(){
    $("#popup").html("");

    var conteudo = "<div id='myModal' class='modal'> <div class='modal-content' style='border-radius:10px;'> <span class='close' onClick='fecha_popup()'>&times;</span> <h3>SUCESSO!</h3> <center>Operação realizada com sucesso!</center><br> <div class='clearfix'></div> </div> </div>";
    
    $("#popup").html(conteudo);
}

function popup_restauracao(){
    $("#popup").html("");

    var conteudo = "<div id='myModal' class='modal'> <div class='modal-content'> <span class='close' onClick='fecha_popup()'>&times;</span> <h3>RESTAURAÇÃO</h3> <center>Tem certeza que deseja restaurar este registro?</center> <div class='clearfix'></div> <hr class='mb-0'> <p class='btn-nao' onClick='fecha_popup()'>CANCELAR</p> <p class='btn-sim' onClick='fecha_popup()'>OK</p> </div> </div>";
    
    $("#popup").html(conteudo);
}

function popup_geracao(){
    $("#popup").html("");

    var conteudo = "<div id='myModal' class='modal'> <div class='modal-content'> <span class='close' onClick='fecha_popup()'>&times;</span> <h3>GERAÇÃO DE ARQUIVO</h3> <center>Tem certeza que deseja gerar este documento?</center> <div class='clearfix'></div> <hr class='mb-0'> <p class='btn-nao' onClick='fecha_popup()'>CANCELAR</p> <p class='btn-sim' onClick='fecha_popup()'>OK</p> </div> </div>";
    
    $("#popup").html(conteudo);
}

function popup_arquivomagnetico(){
    $("#popup").html("");

    var conteudo = "<div id='myModal' class='modal'> <div class='modal-content'> <span class='close' onClick='fecha_popup()'>&times;</span> <h3>ARQUIVO MAGNÉTICO</h3> <center>Tem certeza que deseja adicionar um novo arquivo magnético à lista?</center> <div class='clearfix'></div> <hr class='mb-0'> <p class='btn-nao' onClick='fecha_popup()'>CANCELAR</p> <p class='btn-sim' onClick='fecha_popup()'>OK</p> </div> </div>";
    
    $("#popup").html(conteudo);
}

function popup_sair(){
    $("#popup").html("");

    var conteudo = "<div id='myModal' class='modal'> <div class='modal-content'> <span class='close' onClick='fecha_popup()'>&times;</span> <h3>SAIR</h3> <center>Tem certeza que deseja sair do sistema?</center> <div class='clearfix'></div> <hr class='mb-0'> <p class='btn-nao' onClick='fecha_popup()'>CANCELAR</p> <a href='index.html'><p class='btn-sim'>OK</p></a> </div> </div>";
    
    $("#popup").html(conteudo);
}

function popup_entregar(){
    $("#popup").html("");

    var conteudo = "<div id='myModal' class='modal'> <div class='modal-content'> <span class='close' onClick='fecha_popup()'>&times;</span> <h3>ENTREGAR LIVRO FISCAL</h3> <center>Anexe o livro fiscal solicitado:<br><hr> <input type='file' class='form-control-file' id='exampleFormControlFile1'></center> <div class='clearfix'></div> <hr class='mb-0'> <p class='btn-nao' onClick='fecha_popup()'>CANCELAR</p> <p class='btn-sim' onClick='fecha_popup()'>ENVIAR</p> </div> </div>";
    
    $("#popup").html(conteudo);
}

function fecha_popup(){
    $("#popup").html("");
}

$("#btnMenu").click(function(){
    $("nav").toggle();
});

$(document).ready(function () {
    $('#frm').DataTable();
});