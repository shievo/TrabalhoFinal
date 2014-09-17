<%-- 
    Document   : consultaTime
    Created on : Aug 30, 2014, 5:46:27 PM
    Author     : WelentonA
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Time"%>
<%@page import="dao.TimeDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Times</title>
    </head>
    <body>
        <br><a href="index.html">Início</a>
        <form action="PesquisaServlet">
            <fieldset>
                Pesquisa: <br>
                <label>Filtro</label>
                <select name="filtro">
                    <option value="1">Código</option>
                    <option value="2">Nome</option>
                    <option value="3">Cidade</option>
                </select>
                <input type="text" name="busca" value=""/><br>
                <input type="submit" value="Pesquisar"/>
            </fieldset>
        </form>
        <form action="PesquisaIntervaloServlet">
            <fieldset>
                Pesquisa Intervalo: <br>
                <label for="filtroi">Filtro</label>
                <select name="filtroi">
                    <option value="1">Código</option>
                    <option value="2">Data de cadastro</option>
                    <option value="3">Data de fundação</option>
                </select><br>
                <label for="busca1">Início</label>
                <input type="text" name="busca1" value=""/><br>
                <label for="busca2">Fim</label>
                <input type="text" name="busca2" value=""/><br>
                <input type="submit" value="Pesquisar"/>
            </fieldset>
        </form>

        <%
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Código</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Endereço</th>");
            out.println("<th>Cidade</th>");
            out.println("<th>E-mail</th>");
            out.println("<th>Site</th>");
            out.println("<th>Telefone</th>");
            out.println("<th>Data de Cadastro</th>");
            out.println("<th>Data de Fundação</th>");
            out.println("<th>Histórico</th>");
            out.println("<th>Editar</th>");
            out.println("<th>Excluir</th>");
            out.println("</tr>");
            out.println("</thead>");

            TimeDao timeDao = new TimeDao();
            List<Time> lista = null;

            String busca = request.getParameter("busca");
            String busca1 = request.getParameter("busca1");
            String busca2 = request.getParameter("busca2");
            if (busca != null && busca != "") {
                int filtro = Integer.valueOf(request.getParameter("filtro"));
                lista = timeDao.buscaTime(filtro, busca);
            } else {
                if (busca1 != null && busca2 != null && busca1 != "" && busca2 != "") {
                    int filtroi = Integer.valueOf(request.getParameter("filtroi"));
                    lista = timeDao.buscaTimeIntervalo(filtroi, busca1, busca2);
                } else {
                    lista = timeDao.listar();
                }
            }
            for (Time time : lista) {
                out.println("<tr>");
                out.println("<td align='center'>" + time.getCodigo() + "</td>");
                out.println("<td>" + time.getNome() + "</td>");
                out.println("<td>" + time.getEndereco() + "</td>");
                out.println("<td>" + time.getCidade() + "</td>");
                out.println("<td>" + time.getEmail() + "</td>");
                out.println("<td>" + time.getSite() + "</td>");
                out.println("<td>" + time.getFone() + "</td>");
                out.println("<td>" + time.getData_cadastro() + "</td>");
                out.println("<td>" + time.getData_fundacao() + "</td>");
                out.println("<td>" + time.getHistorico() + "</td>");

                //link para alteração
                out.println("<td><form name=\"alterarForm\" action=\"alterarTime.jsp\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + time.getCodigo() + "\"/>");
                out.println("<input type=\"hidden\" name=\"nome\" id=\"nome\" value=\"" + time.getNome() + "\"/>");
                out.println("<input type=\"hidden\" name=\"endereco\" id=\"endereco\" value=\"" + time.getEndereco()+ "\"/>");
                out.println("<input type=\"hidden\" name=\"cidade\" id=\"cidade\" value=\"" + time.getCidade()+ "\"/>");
                out.println("<input type=\"hidden\" name=\"email\" id=\"email\" value=\"" + time.getEmail()+ "\"/>");
                out.println("<input type=\"hidden\" name=\"site\" id=\"site\" value=\"" + time.getSite()+ "\"/>");
                out.println("<input type=\"hidden\" name=\"fone\" id=\"fone\" value=\"" + time.getFone()+ "\"/>");
                out.println("<input type=\"hidden\" name=\"data_cadastro\" id=\"data_cadastro\" value=\"" + time.getData_cadastro()+ "\"/>");
                out.println("<input type=\"hidden\" name=\"data_fundacao\" id=\"data_fundacao\" value=\"" + time.getData_fundacao()+ "\"/>");
                out.println("<input type=\"hidden\" name=\"historico\" id=\"historico\" value=\"" + time.getHistorico()+ "\"/>");
                
                out.println("<input type=\"submit\" value=\"Alterar\" name=\"btAlterar\" id=\"btAlterar\" />");
                out.println("</form></td>");
                
                out.println("<td><form name=\"excluirForm\" action=\"ExcluirTimeServlet\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\"" + time.getCodigo() + "\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
        %>

    </body>
</html>
