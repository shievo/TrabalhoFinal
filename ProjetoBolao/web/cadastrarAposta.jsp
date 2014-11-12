<%-- 
    Document   : cadastrarAposta
    Created on : 11/11/2014, 20:00:00
    Author     : Kelvin
--%>

<%@page import="dao.JogoDao"%>
<%@page import="dao.JogoDao"%>
<%@page import="modelo.Jogo"%>
<%@page import="dao.RodadaDao"%>
<%@page import="modelo.Rodada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Aposta</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Cadastrar Aposta</h1>
        <fieldset>
            <form action="ApostaServlet">
                
                <label for="codigo">Código:</label><br />
                <input type="text" readonly="true" name="codigo" id ="codigo" value="" size="8" /><br />

                <label for="cpf">CPF:</label><br />
                <input type="text" name="cpf" value="" size="11" /><br />
                
                <label for="competicao-rodada">Competição - Rodada:</label><br />
                <select name="competicao-rodada">
                    <%                        
                        for (Rodada rodada : new RodadaDao().listar()) {
                            out.print("<option value=\"" + rodada.getCod_rodada() + "\">" + rodada.getCompeticao().getNome() + " - " + rodada.getNome() + "</option>");
                        }
                    %>
                </select><br><br>
                
                <label for="cod_jogo">Jogo:</label><br />
                <select name="cod_jogo">
                    <%                        
                        for (Jogo jogo : new JogoDao().listar()) {
                            out.print("<option value=\"" + jogo.getCod_jogo()+ "\">" + jogo.getTime1().getNome() + " X " + jogo.getTime2().getNome() + "</option>");
                        }
                    %>
                </select><br><br>
               
                <label for="placarTime1">Time 1 </label><input type="text" name="placarTime1" value="" size="2" />
                <label for="placarTime2">Time 2 </label><input type="text" name="placarTime2" value="" size="2" />

                <br />
                <br />
                <input type="submit" value="Apostar >>" name="apostar" id= "enviar" />
            </form>
        </fieldset>
    </body>
</html>
