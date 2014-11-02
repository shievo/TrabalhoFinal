<%-- 
    Document   : associaTimeCompeticao
    Created on : Nov 1, 2014, 8:53:11 PM
    Author     : WelentonA
--%>

<%@page import="modelo.Time"%>
<%@page import="dao.TimeDao"%>
<%@page import="modelo.Competicao"%>
<%@page import="dao.CompeticaoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Times em Competições</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Adicionar Times em Competições</h1>
        <fieldset>
            <form action="AssociaTimeCompeticaoServlet">
                <label for="competicao">Competição:</label><br />
                <select name="competicao">
                    <%
                        CompeticaoDao competicaoDao = new CompeticaoDao();
                        for (Competicao competicao : competicaoDao.listar()) {
                            out.print("<option value=\"" + competicao.getCod_competicao() + "\">" + competicao.getNome() + "</option>");
                        }
                    %>
                </select><br />

                <label for="time">Time:</label><br />
                <select name="time">
                    <%
                        TimeDao timeDao = new TimeDao();
                        for (Time time : timeDao.listar()) {
                            out.print("<option value=\"" + time.getCod_time() + "\">" + time.getNome() + "</option>");
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
