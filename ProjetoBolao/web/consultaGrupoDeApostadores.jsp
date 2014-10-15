<%-- 
    Document   : consultaTime
    Created on : Aug 30, 2014, 5:46:27 PM
    Author     : WelentonA
--%>

<%@page import="dao.GrupoDeApostadoresDao"%>
<%@page import="modelo.GrupoDeApostadores"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <title>Consulta de Grupo de Apostadores</title>
    </head>
    <body>
        <br><a href="index.html">Início</a>
        <%
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Editar</th>");
            out.println("<th>Excluir</th>");
            out.println("</tr>");
            out.println("</thead>");

            GrupoDeApostadoresDao grupoDeApostadoresDao = new GrupoDeApostadoresDao();
            List<GrupoDeApostadores> lista = grupoDeApostadoresDao.listar();

            for (GrupoDeApostadores grupoDeApostadores : lista) {
                out.println("<tr>");
                out.println("<td align='center'>" + grupoDeApostadores.getCod_grupo_de_apostadores() + "</td>");
                out.println("<td>" + grupoDeApostadores.getNome() + "</td>");
                
                //link para alteração
                out.println("<td><form name=\"alterarForm\" action=\"alterarGrupoDeApostadores.jsp\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + grupoDeApostadores.getCod_grupo_de_apostadores() + "\"/>");
                out.println("<input type=\"hidden\" name=\"nome\" id=\"nome\" value=\"" + grupoDeApostadores.getNome() + "\"/>");
                
                out.println("<input type=\"submit\" value=\"Alterar\" name=\"btAlterar\" id=\"btAlterar\" />");
                out.println("</form></td>");

                out.println("<td><form name=\"excluirForm\" action=\"ExcluirGrupoDeApostadoresServlet\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + grupoDeApostadores.getCod_grupo_de_apostadores() + "\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        %>

    </body>
</html>
