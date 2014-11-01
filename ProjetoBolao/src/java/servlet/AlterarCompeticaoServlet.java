/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import dao.CompeticaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Competicao;

/**
 *
 * @author WelentonA
 */
@WebServlet(name = "AlterarCompeticaoServlet", urlPatterns = {"/AlterarCompeticaoServlet"})
public class AlterarCompeticaoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlterarCompeticaoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            CompeticaoDao competicaoDao = new CompeticaoDao();
            Competicao competicao = new Competicao();
            
            int codigo = Integer.valueOf(request.getParameter("codigo"));
            competicao.setCod_competicao(codigo);
            String nome = request.getParameter("nome");
            competicao.setNome(nome);
            Date dataInicio = Date.valueOf(request.getParameter("dataInicio"));
            competicao.setData_inicio(dataInicio);
            Date dataFim = Date.valueOf(request.getParameter("dataFim"));
            competicao.setData_fim(dataFim);
            
            competicaoDao.atualizar(competicao);
            
            response.sendRedirect("consultaCompeticoes.jsp");
            
            out.println("<h1>Servlet AlterarCompeticaoServlet at " + request.getContextPath() + "</h1>");
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
