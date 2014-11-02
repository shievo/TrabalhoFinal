<%-- 
    Document   : cadastrarRodada
    Created on : Nov 2, 2014, 1:05:22 PM
    Author     : WelentonA
--%>

<%@page import="modelo.Competicao"%>
<%@page import="dao.CompeticaoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Rodada</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Cadastro de Rodada</h1>
        <fieldset>
            <form action="RodadaServlet">
                <label for="codigo">Código:</label><br />
                <input type="text" readonly="true" name="codigo" id ="codigo" value="" size="8" /><br />

                <label for="nome">Nome:</label><br />
                <input type="text" name="nome" value="" size="70" /><br />

                <label for="data_final_apostas">Data Final Apostas:</label><br />
                <input type="text" name="data_final_apostas" value="" size="70" /><br />

                <label for="competicao">Competição:</label><br />
                <select name="competicao">
                    <%
                        CompeticaoDao competicaoDao = new CompeticaoDao();
                        for (Competicao competicao : competicaoDao.listar()) {
                            out.print("<option value=\"" + competicao.getCod_competicao() + "\">" + competicao.getNome() + "</option>");
                        }
                    %>
                </select>
                <br />
                <br />
                <input type="submit" value="Incluir >>" name="enviar" id= "enviar" />
            </form>
        </fieldset>

    </body>
</html>
