<%-- 
    Document   : auditoriaApostadores
    Created on : 28/10/2014, 20:04:10
    Author     : Kelvin
--%>
<%@page import="java.sql.Date"%>
<%@page import="conexao.Conexao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css" />
        <title>Consulta de auditoria de Apostadores</title>
    </head>
    <body>
        <br><a href="index.html">Início</a>
        
        <%
            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Tipo alt.</th>");
            out.println("<th>Time</th>");
            out.println("<th>Data/hora alt.</th>");
            out.println("</tr>");
            out.println("</thead>");

            Conexao c = new Conexao();
            c.iniciaConexao();
            String sql = "select case when aud.revtype = 0 then \'Inclusão\' when aud.revtype = 1 then \'Alteração\' "
                    + "else \'Exclusão\' end as tipoRevisao, "
                    + "aud.cod_time, aud.nome, inf.REVTSTMP "
                    + "from app.APOSTADOR_AUD aud "
                    + "inner join app.REVINFO inf on (aud.REV = inf.REV)";
            ResultSet rs = c.getConexao().prepareStatement(sql).executeQuery();

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td align='center'>" + rs.getString("tipoRevisao") + "</td>");
                out.println("<td>" + rs.getInt("cod_time") + " - " + rs.getString("nome") + "</td>");
                out.println("<td>" + new Date(rs.getLong("REVTSTMP")) + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
        %>

    </body>
</html>




