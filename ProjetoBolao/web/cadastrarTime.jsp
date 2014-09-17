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
        <title>Cadastro de Times</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Cadastro de Times</h1>
        <fieldset>
            <form action="TimeServlet">
                <label for="codigo">Código:</label><br />
                <input type="text" readonly="true" name="codigo" id ="codigo" value="" size="8" /><br />
                <label for="nomeTime">Nome:</label><br />
                <input type="text" name="nomeTime" id ="nomeTime" value="" size="70" /><br />
                <label for="endereco">Endereço:</label><br />
                <input type="text" name="endereco" id ="endereco" value="" size="70" /><br />
                <label for="cidade">Cidade:</label><br />
                <input type="text" name="cidade" id ="cidade" value="" size="70" /><br />
                <label for="email">Email:</label><br />
                <input type="text" name="email" id ="email" value="" size="70" /><br />
                <label for="site">Site:</label><br />
                <input type="text" name="site" id ="site" value="" size="70" /><br />
                <label for="fone">Telefone:</label><br />
                <input type="text" name="fone" id ="fone" value="" size="70" /><br />
                <label for="dataCadastro">Data de Cadastro (yyyy-MM-dd):</label><br />
                <input type="text" name="dataCadastro" id ="dataCadastro" value="" size="70" /><br />
                <label for="dataFundacao">Data de Fundação (yyyy-MM-dd):</label><br />
                <input type="text" name="dataFundacao" id ="dataFundacao" value="" size="70" /><br />
                <label for="historico">Histórico:</label><br />
                <textarea name="historico" id ="historico" value="" style="width: 500px"></textarea>
                <br />
                <br />
                <input type="submit" value="Incluir >>" name="enviar" id= "enviar" />
            </form>
        </fieldset>
        
    </body>
</html>
