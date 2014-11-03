<%-- 
    Document   : cadastrarJogo
    Created on : Nov 2, 2014, 6:35:37 PM
    Author     : WelentonA
--%>

<%@page import="dao.RodadaDao"%>
<%@page import="modelo.Rodada"%>
<%@page import="dao.TimeDao"%>
<%@page import="modelo.Time"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Jogo</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Cadastro de Jogo</h1>
        <fieldset>
            <form action="JogoServlet">
                <label for="codigo">Código:</label><br />
                <input type="text" readonly="true" name="codigo" id ="codigo" value="" size="8" /><br />

                <label for="competicao-rodada">Competição - Rodada:</label><br />
                <select name="competicao-rodada">
                    <%
                        for (Rodada rodada : new RodadaDao().listar()) {
                            out.print("<option value=\"" + rodada.getCod_rodada() + "\">" + rodada.getCompeticao().getNome() + " - " + rodada.getNome() + "</option>");
                        }
                    %>
                </select><br><br>

                <label for="time1">Time 1:</label>
                <select name="time1">
                    <%
                        /*
                         Temos que arrumar uma maneira de mostrar só os times da 
                         rodada selecionada acima, talvez por javascript
                         */
                        for (Time time : new TimeDao().listar()) {
                            out.print("<option value=\"" + time.getCod_time() + "\">" + time.getNome() + "</option>");
                        }
                    %>
                </select><br>
                <label for="placar1">Placar Time 1:</label>
                <input type="text" name="placar1" value="" size="10" /><br /><br>

                <label for="time2">Time 2:</label>
                <select name="time2">
                    <%
                        /*
                         Temos que arrumar uma maneira de mostrar só os times da 
                         rodada selecionada acima, talvez por javascript
                         */
                        for (Time time : new TimeDao().listar()) {
                            out.print("<option value=\"" + time.getCod_time() + "\">" + time.getNome() + "</option>");
                        }
                    %>
                </select><br>
                <label for="placar2">Placar Time 2:</label>
                <input type="text" name="placar2" value="" size="10" /><br /><br>

                <label for="data_jogo">Data do jogo:</label><br />
                <input type="text" name="data_jogo" value="" size="30" /><br />

                <br />
                <br />
                <input type="submit" value="Incluir >>" name="enviar" id= "enviar" />
            </form>
        </fieldset>
    </body>
</html>
