<%-- 
    Document   : newjspconsultaAssociaTimeCompeticao
    Created on : Nov 1, 2014, 9:18:37 PM
    Author     : WelentonA
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.AssociarTimeCompeticao"%>
<%@page import="dao.AssociarTimeCompeticaoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Times em competições</title>
    </head>
    <body>
        
        <br><a href="index.html">Início</a>
        <%
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Competição</th>");
            out.println("<th>Time</th>");
            out.println("<th>Excluir</th>");
            out.println("</tr>");
            out.println("</thead>");

            AssociarTimeCompeticaoDao associaDao = new AssociarTimeCompeticaoDao();
            List<AssociarTimeCompeticao> lista = associaDao.listar();

            for (AssociarTimeCompeticao associa : lista) {
                out.println("<tr>");
                out.println("<td align='center'>" + associa.getCod_associar_time_competicao() + "</td>");
                out.println("<td>" + associa.getCompeticao().getNome() + "</td>");
                out.println("<td>" + associa.getTime().getNome() + "</td>");
                
                out.println("<td><form name=\"excluirForm\" action=\"ExcluirAssociaTimeCompeticaoServlet\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + associa.getCod_associar_time_competicao() + "\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        %>
    </body>
</html>
