function mostrarGridFilmes() {    
    $('#div-conteudo-filmes').collapse('hide');
    $('#div-grid-filmes').collapse('show');
}

function mostrarConteudoFilme(img_filme) {
    var img_id = $(img_filme).attr('id');
    $('#div-grid-filmes').collapse('hide');
    $('#div-conteudo-filmes').collapse('show');
}