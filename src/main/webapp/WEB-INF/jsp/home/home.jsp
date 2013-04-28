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

        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="img/favicon.ico" type="image/x-icon">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Cinemapp!</title>
        <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-slimscroll.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/bootstrap-datetimepicker.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/global.js"/>"></script>
        <link rel="stylesheet" href="<c:url value="/css/global.css"/>">
        <link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/>">
        <link rel="stylesheet" href="<c:url value="/css/bootstrap-datetimepicker.min.css"/>">

        <script type="text/javascript">

            $(document).ready(function() {
                $('#div-lista-sessoes').slimScroll({
                    height: '440px'
                });

            });

            $(function() {
                $('#data-sessao').datetimepicker({
                    pickTime: false,
                    startDate: new Date(),
                    language: 'pt-BR',
                    endDate: Infinity
                });

                $('#hora-sessao').datetimepicker({
                    pickDate: false
                });
            });

        </script>

        <style type="text/css">
            body {
                padding-top: 20px;
                padding-bottom: 60px;
            }

            /* Custom container */
            .container {
                margin: 0 auto;
                max-width: 1000px;
            }
            .container > hr {
                margin: 60px 0;
            }

            /* Main marketing message and sign up button */
            .jumbotron {
                margin: 80px 0;
                text-align: center;
            }
            .jumbotron h1 {
                font-size: 100px;
                line-height: 1;
            }
            .jumbotron .lead {
                font-size: 24px;
                line-height: 1.25;
            }
            .jumbotron .btn {
                font-size: 21px;
                padding: 14px 24px;
            }

            /* Supporting marketing content */
            .marketing {
                margin: 60px 0;
            }
            .marketing p + h4 {
                margin-top: 28px;
            }


            /* Customize the navbar links to be fill the entire space of the .navbar */
            .navbar .navbar-inner {
                padding: 0;
            }
            .navbar .nav {
                margin: 0;
                display: table;
                width: 100%;
            }
            .navbar .nav li {
                display: table-cell;
                width: 1%;
                float: none;
            }
            .navbar .nav li a {
                font-weight: bold;
                text-align: center;
                border-left: 1px solid rgba(255,255,255,.75);
                border-right: 1px solid rgba(0,0,0,.1);
            }
            .navbar .nav li:first-child a {
                border-left: 0;
                border-radius: 3px 0 0 3px;
            }
            .navbar .nav li:last-child a {
                border-right: 0;
                border-radius: 0 3px 3px 0;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid text-center">
                <img src="img/logo.png"></img>
            </div>

            <div class="row-fluid">
                <%@include file="header.jspf" %>        
            </div>

            <div class="row-fluid">
                <%@include file="grid.jspf" %>
            </div>

            <div class="row-fluid">
                <%@include file="content.jspf" %>
            </div>
        </div>
    </body>
</html>