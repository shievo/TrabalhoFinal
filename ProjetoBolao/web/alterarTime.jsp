<%-- 
    Document   : alterarTime
    Created on : Sep 2, 2014, 10:01:06 PM
    Author     : WelentonA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <title>Alterar time</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Alterar Time</h1>
        <fieldset>
            <form action="AlterarServlet" name="form">
                <label for="codigo">Código:</label><br />
                <% 
                    out.println("<input type=\"text\" readonly=\"true\" name=\"codigo\" id =\"codigo\" value=\"" + request.getParameter("codigo") + "\" size=\"8\" /><br />");
                %>
                <label for="nomeTime">Nome:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"nome\" value=\"" + request.getParameter("nome") + "\" size=\"70\" /><br />");
                %>
                <label for="endereco">Endereço:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"endereco\" value=\" " + request.getParameter("endereco") + "\" size=\"70\" /><br />");
                %>
                <label for="cidade">Cidade:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"cidade\" value=\"" + request.getParameter("cidade") + "\" size=\"70\" /><br />");
                %>
                <label for="email">Email:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"email\" value=\" " + request.getParameter("email") + "\" size=\"70\" /><br />");
                %>
                <label for="site">Site:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"site\" value=\"" + request.getParameter("site") + "\" size=\"70\" /><br />");
                %>
                <label for="fone">Telefone:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"fone\" value=\"" + request.getParameter("fone") + "\" size=\"70\" /><br />");
                %>
                <label for="dataCadastro">Data de Cadastro (yyyy-MM-dd):</label><br />
                <%
                    out.println("<input type=\"text\" name=\"dataCadastro\" value=\"" + request.getParameter("data_cadastro") + "\" size=\"70\" /><br />");
                %>
                <label for="dataFundacao">Data de Fundação (yyyy-MM-dd):</label><br />
                <%
                    out.println("<input type=\"text\" name=\"dataFundacao\" value=\"" + request.getParameter("data_fundacao") + "\" size=\"70\" /><br />");
                %>
                <label for="historico">Histórico:</label><br />
                <%
                    request.setCharacterEncoding("UTF-8");
                    out.println("<textarea name=\"historico\" value =\"\" style=\"width: 500px\">" + request.getParameter("historico") + "</textarea>");
                %>
                <br />
                <br />
                <input type="submit" value="Salvar" name="enviar" id= "enviar" />
            </form>
        </fieldset>
    </body>
</html>
