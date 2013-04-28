<%-- 
    Document   : index
    Created on : 11/04/2013, 18:42:17
    Author     : joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head lang="pt-BR">
        <link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>" type="image/x-icon">
        <link rel="icon" href="<c:url value="/img/favicon.ico"/>" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Cinemapp!</title>
        <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-slimscroll.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/bootstrap-datetimepicker.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/global.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-textext.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jasny-bootstrap.js"/>"></script>
        <link rel="stylesheet" href="<c:url value="/css/global.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/bootstrap-datetimepicker.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/jasny-bootstrap.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/css/jasny-bootstrap-responsive.css"/>"/>

        <script>
            function carregaValoresIMDB(titulo, ano) {
                var url = "http://imdbapi.org/?";

                $.getJSON(url, {
                    title: titulo,
                    type: "json",
                    plot: "full"
                }, function(data) {
                    $('#nome_2').val(data[0].also_known_as);
                    $('#resumo').val(data[0].plot);
                    $('#poster').html('<img class="img-polaroid" src="' + data[0].poster + '"></img>');
                    $('#duracao').val(data[0].runtime.toString().substring(0, 3));
                    $('#ano').val(data[0].year);

                    removeAllTags('#elenco');
                    removeAllTags('#diretores');
                    removeAllTags('#generos');

                    addTags('#elenco', data[0].actors.toString().split(','));
                    addTags('#diretores', data[0].directors.toString().split(','));
                    addTags('#generos', data[0].genres.toString().split(','));
                });

            }

            function addTags(textextId, arr) {
                var tags = $(textextId).textext()[0].tags().tagElements();

                for (i = 0; i < arr.length; i++) {
                    if ($.inArray(arr[i], tags) == -1)
                        $(textextId).textext()[0].tags().addTags([arr[i].toString()]);
                }
            }

            function removeAllTags(textextId) {
                $(textextId).textext()[0].tags().removeTag($(textextId).textext()[0].tags().tagElements());
            }

            function getValueOfTags(textextId) {
                var tags = $(textextId).textext()[0].tags().tagElements();
                var aux = "";
                for (i = 0; i < tags.length; i++) {
                    var span = $(tags[i]).find(".text-label");

                    if ($(span).text() != undefined) {
                        if (i != tags.length - 1)
                            aux += $(span).text() + ',';
                        else
                            aux += $(span).text();
                    }
                }

                return aux;
            }
        </script>
    </head>
    <body>
        <div id="div-adicionar-filmes" class="well">
            <div class="tabbable tabs-left">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#filme" data-toggle="tab"> Filme</a></li>
                    <li><a href="#cinema" data-toggle="tab">Cinema</a></li>
                    <br><br>
                    <a href="#" class="btn btn-large btn-success">Ok</a>  
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="filme">
                        <%@include file="adicionar_filme.jspf" %>        
                    </div>
                    <div class="tab-pane" id="cinema">
                        <%@include file="adicionar_cinema.jspf" %>        
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">

            $('#elenco').textext({
                plugins: 'tags autocomplete suggestions',
                suggestions: [${lista_atores}]
            }).bind('isTagAllowed', function(e, data) {
                var formData = $(e.target).textext()[0].tags()._formData,
                        list = eval(formData);
                if (formData.length && list.indexOf(data.tag) >= 0) {
                    data.result = false;
                }
            }).bind('tagClick', function(e, tag, value, callback) {
                var newValue = window.prompt('Novo valor', value);
                if (newValue)
                    callback(newValue);
            });

            $('#diretores').textext({
                plugins: 'tags autocomplete suggestions',
                suggestions: [${lista_diretores}]
            }).bind('isTagAllowed', function(e, data) {
                var formData = $(e.target).textext()[0].tags()._formData,
                        list = eval(formData);
                if (formData.length && list.indexOf(data.tag) >= 0) {
                    data.result = false;
                }
            }).bind('tagClick', function(e, tag, value, callback) {
                var newValue = window.prompt('Novo valor', value);
                if (newValue)
                    callback(newValue);
            });

            $('#generos').textext({
                plugins: 'tags autocomplete suggestions',
                suggestions: [${lista_generos}]
            }).bind('isTagAllowed', function(e, data) {
                var formData = $(e.target).textext()[0].tags()._formData,
                        list = eval(formData);
                if (formData.length && list.indexOf(data.tag) >= 0) {
                    data.result = false;
                }
            }).bind('tagClick', function(e, tag, value, callback) {
                var newValue = window.prompt('Novo valor', value);
                if (newValue)
                    callback(newValue);
            });

            $('#cinema').textext({
                plugins: 'tags autocomplete suggestions',
                suggestions: [${lista_cinemas}]
            }).bind('isTagAllowed', function(e, data) {
                var formData = $(e.target).textext()[0].tags()._formData,
                        list = eval(formData);
                if (formData.length && list.indexOf(data.tag) >= 0) {
                    data.result = false;
                }
            }).bind('tagClick', function(e, tag, value, callback) {
                var newValue = window.prompt('Novo valor', value);
                if (newValue)
                    callback(newValue);
            });
        </script>
    </body>
