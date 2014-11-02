<%-- 
    Document   : consultaRodadas
    Created on : Nov 2, 2014, 1:15:58 PM
    Author     : WelentonA
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Rodada"%>
<%@page import="dao.RodadaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Rodadas</title>
    </head>
    <body>
        <br><a href="index.html">Início</a>
        <%
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Data Final Apostas</th>");
            out.println("<th>Competicão</th>");
            out.println("<th>Editar</th>");
            out.println("<th>Excluir</th>");
            out.println("</tr>");
            out.println("</thead>");

            List<Rodada> lista = new RodadaDao().listar();

            for (Rodada rodada : lista) {
                out.println("<tr>");
                out.println("<td align='center'>" + rodada.getCod_rodada() + "</td>");
                out.println("<td>" + rodada.getNome() + "</td>");
                out.println("<td>" + rodada.getData_final_apostas() + "</td>");
                out.println("<td>" + rodada.getCompeticao().getNome() + "</td>");

                //link para alteração
                out.println("<td><form name=\"alterarForm\" action=\"alterarRodada.jsp\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + rodada.getCod_rodada() + "\"/>");
                out.println("<input type=\"hidden\" name=\"nome\" id=\"nome\" value=\"" + rodada.getNome() + "\"/>");
                out.println("<input type=\"hidden\" name=\"data_final_apostas\" value=\"" + rodada.getData_final_apostas() + "\"/>");
                out.println("<input type=\"hidden\" name=\"competicao\" value=\"" + rodada.getCompeticao().getCod_competicao() + "\"/>");

                out.println("<input type=\"submit\" value=\"Alterar\" name=\"btAlterar\" id=\"btAlterar\" />");
                out.println("</form></td>");

                out.println("<td><form name=\"excluirForm\" action=\"ExcluirRodadaServlet\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + rodada.getCod_rodada() + "\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        %>

    </body>
</html>
