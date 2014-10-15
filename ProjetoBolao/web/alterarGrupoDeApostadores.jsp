<%-- 
    Document   : alterarGrupoDeApostadores
    Created on : Oct 14, 2014, 9:20:20 PM
    Author     : WelentonA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <title>Alterar Grupo de Apostadores</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Alterar Grupo de Apostadores</h1>
        <fieldset>
            <form action="AlterarServlet" name="form">
                <label for="codigo">Código:</label><br />
                <%
                    out.println("<input type=\"text\" readonly=\"true\" name=\"codigo\" id =\"codigo\" value=\"" + request.getParameter("codigo") + "\" size=\"8\" /><br />");
                %>
                <label for="nomeGrupo">Nome:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"nome\" value=\"" + request.getParameter("nome") + "\" size=\"70\" /><br />");
                %>
                <br />
                <br />
                <input type="submit" value="Salvar" name="enviar" id= "enviar" />
            </form>
        </fieldset>
    </body>
</html>
