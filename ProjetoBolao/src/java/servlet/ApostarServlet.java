/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ApostadorDao;
import dao.CompeticaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aposta;
import modelo.Apostador;
import modelo.Competicao;
import modelo.Rodada;

/**
 *
 * @author WelentonA
 */
@WebServlet(name = "ApostarServlet", urlPatterns = {"/ApostarServlet"})
public class ApostarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String cpf;
    int etapa;
    Aposta aposta;
    Competicao competicao;
    Rodada rodada;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Apostar</title>");
            out.println("</head>");
            out.println("<body>");
            
            aposta = new Aposta();
            out.print("<form action=\"ApostarServlet\">");
            if (aposta.getApostador() != null) {
                cpf = aposta.getApostador().getCpf();
            } else {
                cpf = request.getParameter("cpf");
            }

            if (cpf.equals(null) || cpf.equals("")) {
                out.println("Preencha o CPF!");
            } else {

                if (aposta.getApostador() == null) {
                    aposta.setApostador(new ApostadorDao().buscaApostadorUniqueResult(cpf));
                }

                if (aposta.getApostador() == null) {
                    out.println("CPF não encontrado!");
                } else {
                    if (competicao == null) {

                        out.println("<select>");
                        for (competicao  : new CompeticaoDao().listar()) {
                            out.println("<option value=\"" + competicao.getCod_competicao() + "\">" + competicao.getNome() + "</option>");
                        }
                        out.println("</select>");
                        out.println("<input type=\"submit\" value=\"Próximo\"/>");
                    } else {
                        if (rodada == null) {
                            out.println("<select>");
                            for (rodada : new CompeticaoDao().listar()) {
                                out.println("<option value=\"" + competicao.getCod_competicao() + "\">" + competicao.getNome() + "</option>");
                            }
                            out.println("</select>");
                            out.println("<input type=\"submit\" value=\"Próximo\"/>");

                        }

                    }

                }

            }
            out.print("</form>");
            out.println("<br><a href=\"index.html\">Início</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
