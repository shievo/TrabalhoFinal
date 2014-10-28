<%-- 
    Document   : alterarApostador
    Created on : Oct 28, 2014, 8:21:14 PM
    Author     : WelentonA
--%>

<%@page import="modelo.Apostador"%>
<%@page import="dao.ApostadorDao"%>
<%@page import="modelo.GrupoDeApostadores"%>
<%@page import="dao.GrupoDeApostadoresDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <title>Alterar Apostador</title>
    </head>
    <body>
        <a href="index.html">Voltar</a> <br />
        <h1>Alterar Apostador</h1>
        <fieldset>
            <form action="AlterarApostadorServlet" name="form">
                <label for="codigo">Código:</label><br />
                <%
                    out.println("<input type=\"text\" readonly=\"true\" name=\"codigo\" id =\"codigo\" value=\"" + request.getParameter("codigo") + "\" size=\"8\" /><br />");
                %>
                <label for="nome">Nome:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"nome\" value=\"" + request.getParameter("nome") + "\" size=\"70\" /><br />");
                %>
                <label for="cpf">CPF:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"cpf\" value=\"" + request.getParameter("cpf") + "\" size=\"70\" /><br />");
                %>
                <label for="data_nascimento">Data de nascimento:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"data_nascimento\" value=\"" + request.getParameter("data_nascimento") + "\" size=\"70\" /><br />");
                %>
                <label for="email">Email:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"email\" value=\"" + request.getParameter("email") + "\" size=\"70\" /><br />");
                %>
                <label for="apelido">Apelido:</label><br />
                <%
                    out.println("<input type=\"text\" name=\"apelido\" value=\"" + request.getParameter("apelido") + "\" size=\"70\" /><br />");
                %>
                <label for="cod_time">Time preferido:</label><br />
                <select name="cod_time">
                    <%
                        ApostadorDao apostadorDao = new ApostadorDao();
                        for (Apostador apostador : apostadorDao.listar()) {
                            if (apostador.getCod_apostador() == Integer.valueOf(request.getParameter("cod_time"))) {
                                out.print("<option selected value=\"" + apostador.getCod_apostador() + "\">" + apostador.getNome() + "</option>");
                                //out.println("<input type=\"hidden\" name=\"cod_grupo_de_apostadores\" value=\"" + apostador.getTime_preferido().getCod_time() + "\"/>");
                                continue;
                            }
                            out.print("<option value=\"" + apostador.getCod_apostador() + "\">" + apostador.getNome() + "</option>");
                            //out.println("<input type=\"hidden\" name=\"cod_grupo_de_apostadores\" value=\"" + apostador.getTime_preferido().getCod_time() + "\"/>");
                        }
                    %>
                </select> <br>
                <label for="cod_grupo_de_apostadores">Grupo de apostadores:</label><br />
                <select name="cod_grupo_de_apostadores">
                    <%
                        GrupoDeApostadoresDao grupoDeApostadoresDao = new GrupoDeApostadoresDao();
                        for (GrupoDeApostadores grupoDeApostadores : grupoDeApostadoresDao.listar()) {
                            if (grupoDeApostadores.getCod_grupo_de_apostadores() == Integer.valueOf(request.getParameter("cod_grupo_de_apostadores"))) {
                                out.print("<option selected value=\"" + grupoDeApostadores.getCod_grupo_de_apostadores() + "\">" + grupoDeApostadores.getNome() + "</option>");
                                //out.println("<input type=\"hidden\" name=\"cod_time\" value=\"" + grupoDeApostadores.getCod_grupo_de_apostadores() + "\"/>");
                                continue;
                            }
                            out.print("<option value=\"" + grupoDeApostadores.getCod_grupo_de_apostadores() + "\">" + grupoDeApostadores.getNome() + "</option>");
                            //out.println("<input type=\"hidden\" name=\"cod_time\" value=\"" + grupoDeApostadores.getCod_grupo_de_apostadores() + "\"/>");
                        }
                    %>
                </select> <br>
                <br />
                <br />
                <input type="submit" value="Salvar" name="enviar" id= "enviar" />
            </form>
        </fieldset>
    </body>
</html>
