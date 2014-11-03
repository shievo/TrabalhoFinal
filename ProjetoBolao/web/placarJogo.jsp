<%-- 
    Document   : placarJogo
    Created on : Nov 2, 2014, 9:53:28 PM
    Author     : WelentonA
--%>

<%@page import="modelo.Jogo"%>
<%@page import="modelo.Time"%>
<%@page import="dao.JogoDao"%>
<%@page import="dao.RodadaDao"%>
<%@page import="modelo.Rodada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lançar Placar</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Lançar placar</h1>
        <fieldset>
            <form action="JogoPlacarServlet">
                <label for="codigo">Código:</label><br />
                <input type="text" readonly="true" name="codigo" id ="codigo" value="" size="8" /><br />

                <label for="competicao-rodada">Competição - Rodada:</label><br />
                <select name="competicao-rodada">
                    <%
                        Jogo jogo = new JogoDao().buscaJogoUniqueResult(Integer.valueOf("codigo_jogo"));
                        Rodada rodada = jogo.getRodada();
                        out.print("<option value=\"" + rodada.getCod_rodada() + "\">"
                                + rodada.getCompeticao().getNome() + " - "
                                + rodada.getNome() + "</option>");
                    %>
                </select><br><br>

                <label for="time1">Time 1:</label>
                <select name="time1">
                    <%
                        out.print("<option value=\"" + jogo.getTime1().getCod_time() + "\">"
                                + jogo.getTime1().getNome() + " - " + "</option>");
                    %>
                </select><br>
                <label for="placar1">Placar Time 1:</label>
                <input type="text" name="placar1" value="" size="10" /><br /><br>

                <label for="time2">Time 2:</label>
                <select name="time2">
                    <%
                        out.print("<option value=\"" + jogo.getTime2().getCod_time() + "\">"
                                + jogo.getTime2().getNome() + " - " + "</option>");
                    %>
                </select><br>
                <label for="placar2">Placar Time 2:</label>
                <input type="text" name="placar2" value="" size="10" /><br /><br>

                <label for="data_jogo">Data do jogo:</label><br />
                <input type="text"  readonly="true" name="data_jogo" value="<%out.print(jogo.getData_jogo());%>" size="30" /><br />
                <br />
                <br />
                <input type="submit" value="Incluir >>" name="enviar" id= "enviar" />
            </form>
        </fieldset>
    </body>
</html>
