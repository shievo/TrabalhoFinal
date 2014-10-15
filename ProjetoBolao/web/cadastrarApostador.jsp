<%-- 
    Document   : cadastrarApostador
    Created on : 14/10/2014, 21:14:03
    Author     : Kelvin
--%>

<%@page import="modelo.GrupoDeApostadores"%>
<%@page import="dao.GrupoDeApostadoresDao"%>
<%@page import="dao.TimeDao"%>
<%@page import="modelo.Time"%>
<%@page import="modelo.Apostador"%>
<%@page import="dao.ApostadorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <title>Cadastro de Grupo de Apostadores</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Cadastro de Grupo de Apostadores</h1>
        <fieldset>
            <form action="ApostadorServlet">
                <label for="codigo">Código:</label><br />
                <input type="text" readonly="true" name="codigo" id ="codigo" value="" size="8" /><br />
                <label for="nomeApostador">Nome:</label><br />
                <input type="text" name="nomeApostador" id ="nomeApostador" value="" size="70" /><br />

                <label for="cpf">CPF:</label><br />
                <input type="text" name="cpf" id ="cpf" value="" size="70" /><br />

                <label for="data_nascimento">Nascimento:</label><br />
                <input type="text" name="data_nascimento" id ="data_nascimento" value="" size="70" /><br />

                <label for="email">E-mail:</label><br />
                <input type="text" name="email" id ="email" value="" size="70" /><br />

                <label for="apelido">Apelido:</label><br />
                <input type="text" name="apelido" id ="apelido" value="" size="70" /><br />

                <label for="time">Time favorito:</label><br />
                <select name="time">
                    <%
                        TimeDao timeDao = new TimeDao();
                        for (Time time : timeDao.listar()) {
                            out.print("<option value=\"" + time.getCod_time() + "\">" + time.getNome() + "</option>");
                        }
                    %>
                </select>

                <label for="grupo">Grupo de apostadores:</label><br />
                <select name="grupo">
                    <%
                        GrupoDeApostadoresDao grupoDeApostadoresDao = new GrupoDeApostadoresDao();
                        for (GrupoDeApostadores grupoDeApostadores : grupoDeApostadoresDao.listar()) {
                            out.print("<option value=\"" + grupoDeApostadores.getCod_grupo_de_apostadores() + "\">" + grupoDeApostadores.getNome() + "</option>");
                        }
                    %>
                </select>
                
                <br />
                <br />
                <input type="submit" value="Incluir >>" name="enviar" id= "enviar" />
            </form>
        </fieldset>

    </body>
</html>
