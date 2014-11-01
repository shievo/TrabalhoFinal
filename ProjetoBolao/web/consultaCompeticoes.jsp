<%-- 
    Document   : consultaCompeticoes
    Created on : Nov 1, 2014, 8:23:17 PM
    Author     : WelentonA
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Competicao"%>
<%@page import="dao.CompeticaoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Competições</title>
    </head>
    <body>
        <br><a href="index.html">Início</a>
        <%
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Data de início</th>");
            out.println("<th>Data de final</th>");
            out.println("<th>Editar</th>");
            out.println("<th>Excluir</th>");
            out.println("</tr>");
            out.println("</thead>");

            CompeticaoDao competicaoDao = new CompeticaoDao();
            List<Competicao> lista = competicaoDao.listar();

            for (Competicao competicao : lista) {
                out.println("<tr>");
                out.println("<td align='center'>" + competicao.getCod_competicao() + "</td>");
                out.println("<td>" + competicao.getNome() + "</td>");
                out.println("<td>" + competicao.getData_inicio() + "</td>");
                out.println("<td>" + competicao.getData_fim() + "</td>");

                //link para alteração
                out.println("<td><form name=\"alterarForm\" action=\"alterarCompeticao.jsp\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + competicao.getCod_competicao() + "\"/>");
                out.println("<input type=\"hidden\" name=\"nome\" id=\"nome\" value=\"" + competicao.getNome() + "\"/>");
                out.println("<input type=\"hidden\" name=\"dataInicio\" value=\"" + competicao.getData_inicio() + "\"/>");
                out.println("<input type=\"hidden\" name=\"dataFim\" value=\"" + competicao.getData_fim() + "\"/>");

                out.println("<input type=\"submit\" value=\"Alterar\" name=\"btAlterar\" id=\"btAlterar\" />");
                out.println("</form></td>");

                out.println("<td><form name=\"excluirForm\" action=\"ExcluirCompeticaoServlet\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + competicao.getCod_competicao() + "\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        %>
    </body>
</html>
