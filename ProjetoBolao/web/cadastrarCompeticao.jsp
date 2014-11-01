<%-- 
    Document   : cadastrarCompeticao
    Created on : Nov 1, 2014, 8:15:47 PM
    Author     : WelentonA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Competições</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Cadastro de Competições</h1>
        <fieldset>
            <form action="CompeticaoServlet">
                <label for="codigo">Código:</label><br />
                <input type="text" readonly="true" name="codigo" value="" size="8" /><br />
                <label for="nomeCompeticao">Nome:</label><br />
                <input type="text" name="nomeCompeticao" value="" size="70" /><br />
                <label for="dataInicio">Data de início:</label><br />
                <input type="text" name="dataInicio" value="" size="70" /><br />
                <label for="dataFinal">Data de final:</label><br />
                <input type="text" name="dataFinal" value="" size="70" /><br />
                <br />
                <br />
                <input type="submit" value="Incluir >>" name="enviar" id= "enviar" />
            </form>
        </fieldset>
        
    </body>
</html>
