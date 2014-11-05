<%-- 
    Document   : consultaJogos
    Created on : Nov 2, 2014, 7:02:22 PM
    Author     : WelentonA
--%>

<%@page import="dao.JogoDao"%>
<%@page import="modelo.Jogo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Jogos</title>
    </head>
    <body>
        <br><a href="index.html">Início</a>
        <%
            out.println("<h2>Jogos em andamento</h2>");
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Competicão/Rodada</th>");
            out.println("<th>Time 1</th>");
            out.println("<th>Time 2</th>");
            out.println("<th>Data do jogo</th>");
            out.println("<th>Lançar placar</th>");
            out.println("<th>Excluir</th>");
            out.println("</tr>");
            out.println("</thead>");

            for (Jogo jogo : new JogoDao().listar()) {
                out.println("<tr>");
                out.println("<td align='center'>" + jogo.getCod_jogo() + "</td>");
                out.println("<td>" + jogo.getRodada().getCompeticao().getNome() + "/" + jogo.getRodada().getNome() + "</td>");
                out.println("<td>" + jogo.getTime1().getNome() + "</td>");
                out.println("<td>" + jogo.getTime2().getNome() + "</td>");
                out.println("<td>" + jogo.getData_jogo() + "</td>");

                out.println("<td><form name=\"placarForm\" action=\"placarJogo.jsp\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" value=\"" + jogo.getCod_jogo() + "\"/>");

                out.println("<input type=\"submit\" value=\"Placar\" name=\"btAlterar\" id=\"btAlterar\" />");
                out.println("</form></td>");

                out.println("<td><form name=\"excluirForm\" action=\"ExcluirJogoServlet\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + jogo.getCod_jogo() + "\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");

            out.println("<h2>Jogos finalizados</h2>");
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Competicão/Rodada</th>");
            out.println("<th>Time 1</th>");
            out.println("<th>Time 2</th>");
            out.println("<th>Data do jogo</th>");
            out.println("<th>Placar</th>");
            out.println("<th>Vencedor</th>");
            out.println("</tr>");
            out.println("</thead>");

            for (Jogo jogo : new JogoDao().listarFinalizados()) {
                out.println("<tr>");
                out.println("<td align='center'>" + jogo.getCod_jogo() + "</td>");
                out.println("<td>" + jogo.getRodada().getCompeticao().getNome() + "/" + jogo.getRodada().getNome() + "</td>");
                out.println("<td>" + jogo.getTime1().getNome() + "</td>");
                out.println("<td>" + jogo.getTime2().getNome() + "</td>");
                out.println("<td>" + jogo.getData_jogo() + "</td>");
                out.println("<td>" + jogo.getPlacar_time1() + " x " + jogo.getPlacar_time2() + "</td>");
                out.println("<td>" + jogo.getVencedor().getNome() + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        %>
    </body>
</html>
