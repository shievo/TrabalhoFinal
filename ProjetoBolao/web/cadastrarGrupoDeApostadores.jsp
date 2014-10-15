<%-- 
    Document   : CadastrarTime
    Created on : Aug 30, 2014, 4:49:20 PM
    Author     : WelentonA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <title>Cadastro de Grupo de Apostadores</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Cadastro de Grupo de Apostadores</h1>
        <fieldset>
            <form action="GrupoDeApostadoresServlet">
                <label for="codigo">Código:</label><br />
                <input type="text" readonly="true" name="codigo" id ="codigo" value="" size="8" /><br />
                <label for="nomeGrupo">Nome:</label><br />
                <input type="text" name="nomeGrupo" id ="nomeGrupo" value="" size="70" /><br />
                <br />
                <br />
                <input type="submit" value="Incluir >>" name="enviar" id= "enviar" />
            </form>
        </fieldset>
        
    </body>
</html>
