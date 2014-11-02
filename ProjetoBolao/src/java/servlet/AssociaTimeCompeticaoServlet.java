/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import dao.AssociarTimeCompeticaoDao;
import dao.CompeticaoDao;
import dao.TimeDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AssociarTimeCompeticao;
import modelo.Competicao;
import modelo.Time;

/**
 *
 * @author WelentonA
 */
@WebServlet(name = "AssociaTimeCompeticaoServlet", urlPatterns = {"/AssociaTimeCompeticaoServlet"})
public class AssociaTimeCompeticaoServlet extends HttpServlet {

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
            out.println("<title>Servlet AssociaTimeCompeticaoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            AssociarTimeCompeticaoDao associaDao = new AssociarTimeCompeticaoDao();
            AssociarTimeCompeticao associa = new AssociarTimeCompeticao();
            
            CompeticaoDao competicaoDao = new CompeticaoDao();
            Competicao competicao = competicaoDao.buscaCompeticaoUniqueResult(Integer.valueOf(request.getParameter("competicao")));
            associa.setCompeticao(competicao);
            
            TimeDao timeDao = new TimeDao();
            Time time = timeDao.buscaTimeUniqueResult(Integer.valueOf(request.getParameter("time")));
            associa.setTime(time);
            
            associaDao.salvar(associa);
            
            response.sendRedirect("consultaAssociaTimeCompeticao.jsp");
            
            out.println("<h1>Servlet AssociaTimeCompeticaoServlet at " + request.getContextPath() + "</h1>");
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
