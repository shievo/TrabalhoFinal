<%-- 
    Document   : alterarCompeticao
    Created on : Nov 1, 2014, 8:28:15 PM
    Author     : WelentonA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Competição</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Alterar Competição</h1>
        <fieldset>
            <form action="AlterarCompeticaoServlet" name="form">
                <label for="codigo">Código:</label><br />
                <%
                    out.println("<input type=\"text\" readonly=\"true\" name=\"codigo\" id =\"codigo\" value=\"" + request.getParameter("codigo") + "\" size=\"8\" /><br />");
                %>
                <label for="nome">Nome:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"nome\" value=\"" + request.getParameter("nome") + "\" size=\"70\" /><br />");
                %>
                <label for="dataInicio">Nome:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"dataInicio\" value=\"" + request.getParameter("dataInicio") + "\" size=\"70\" /><br />");
                %>
                <label for="dataFim">Nome:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"dataFim\" value=\"" + request.getParameter("dataFim") + "\" size=\"70\" /><br />");
                %>
                <br />
                <br />
                <input type="submit" value="Salvar" name="enviar" id= "enviar" />
            </form>
        </fieldset>
    </body>
</html>
