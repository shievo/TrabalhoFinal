<%-- 
    Document   : consultaApostadores
    Created on : Oct 15, 2014, 1:32:17 PM
    Author     : WelentonA
--%>

<%@page import="dao.TimeDao"%>
<%@page import="modelo.Time"%>
<%@page import="modelo.Apostador"%>
<%@page import="java.util.List"%>
<%@page import="dao.ApostadorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <title>Consulta de Apostadores</title>
    </head>
    <body>
        <br><a href="index.html">Início</a>
        <%
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Nome</th>");
            out.println("<th>CPF</th>");
            out.println("<th>Data de Nascimento</th>");
            out.println("<th>Email</th>");
            out.println("<th>Apelido</th>");
            out.println("<th>Time Preferido</th>");
            out.println("<th>Grupo de Apostadores</th>");
            out.println("<th>Editar</th>");
            out.println("<th>Excluir</th>");
            out.println("</tr>");
            out.println("</thead>");

            ApostadorDao apostadorDao = new ApostadorDao();
            List<Apostador> lista = apostadorDao.listar();

            for (Apostador apostador : lista) {
                out.println("<tr>");
                out.println("<td align='center'>" + apostador.getCod_apostador() + "</td>");
                out.println("<td>" + apostador.getNome() + "</td>");
                out.println("<td>" + apostador.getCpf() + "</td>");
                out.println("<td>" + apostador.getData_nascimento() + "</td>");
                out.println("<td>" + apostador.getEmail() + "</td>");
                out.println("<td>" + apostador.getApelido() + "</td>");
                out.println("<td>" + new TimeDao().buscaTime(1, String.valueOf(apostador.getCod_time_preferido())) + "</td>");
                out.println("<td>" + apostador.getGrupo().getNome() + "</td>");

                //link para alteração
                out.println("<td><form name=\"alterarForm\" action=\"alterarGrupoDeApostadores.jsp\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + apostador.getCod_apostador() + "\"/>");
                out.println("<input type=\"hidden\" name=\"nome\" id=\"nome\" value=\"" + apostador.getNome() + "\"/>");

                out.println("<input type=\"submit\" value=\"Alterar\" name=\"btAlterar\" id=\"btAlterar\" />");
                out.println("</form></td>");

                out.println("<td><form name=\"excluirForm\" action=\"ExcluirGrupoDeApostadoresServlet\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + apostador.getCod_apostador() + "\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        %>

    </body>
</html>
