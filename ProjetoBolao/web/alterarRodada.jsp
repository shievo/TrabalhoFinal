<%-- 
    Document   : alterarRodada
    Created on : Nov 2, 2014, 1:21:19 PM
    Author     : WelentonA
--%>

<%@page import="modelo.Competicao"%>
<%@page import="dao.CompeticaoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Rodada</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Alterar Rodada</h1>
        <fieldset>
            <form action="AlterarRodadaServlet" name="form">
                <label for="codigo">Código:</label><br />
                <%
                    out.println("<input type=\"text\" readonly=\"true\" name=\"codigo\" id =\"codigo\" value=\"" + request.getParameter("codigo") + "\" size=\"8\" /><br />");
                %>
                <label for="nome">Nome:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"nome\" value=\"" + request.getParameter("nome") + "\" size=\"70\" /><br />");
                %>
                <label for="data_final_apostas">Data Final Apostas:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"data_final_apostas\" value=\"" + request.getParameter("data_final_apostas") + "\" size=\"70\" /><br />");
                %>
                <label for="competicao">Competicão:</label><br />
                <select name="competicao">
                    <%
                        for (Competicao competicao : new CompeticaoDao().listar()) {
                            if (competicao.getCod_competicao() == Integer.valueOf(request.getParameter("competicao"))) {
                                out.print("<option selected value=\"" + competicao.getCod_competicao() + "\">" + competicao.getNome() + "</option>");
                                continue;
                            }
                            out.print("<option value=\"" + competicao.getCod_competicao() + "\">" + competicao.getNome() + "</option>");
                        }
                    %>
                </select> <br>
                <br />
                <br />
                <input type="submit" value="Salvar" name="enviar" id= "enviar" />
            </form>
        </fieldset>
    </body>
</html>
