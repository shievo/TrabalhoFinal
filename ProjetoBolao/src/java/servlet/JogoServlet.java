/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import dao.JogoDao;
import dao.RodadaDao;
import dao.TimeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Jogo;
import modelo.Rodada;

/**
 *
 * @author WelentonA
 */
@WebServlet(name = "JogoServlet", urlPatterns = {"/JogoServlet"})
public class JogoServlet extends HttpServlet {

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
            out.println("<title>Servlet JogoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Jogo jogo = new Jogo();
            
            jogo.setRodada(new RodadaDao().buscaRodadaUniqueResult(Integer.valueOf(request.getParameter("competicao-rodada"))));
            jogo.setTime1(new TimeDao().buscaTimeUniqueResult(Integer.valueOf(request.getParameter("time1"))));
            jogo.setTime2(new TimeDao().buscaTimeUniqueResult(Integer.valueOf(request.getParameter("time2"))));
            jogo.setData_jogo(Date.valueOf(request.getParameter("data_jogo")));
            jogo.setFinalizada('f');
            
            new JogoDao().salvar(jogo);
            
            response.sendRedirect("consultaJogos.jsp");
            out.println("<h1>Servlet JogoServlet at " + request.getContextPath() + "</h1>");
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
