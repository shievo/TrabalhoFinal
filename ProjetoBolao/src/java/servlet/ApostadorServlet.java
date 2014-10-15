/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ApostadorDao;
import dao.GrupoDeApostadoresDao;
import dao.TimeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Apostador;
import modelo.GrupoDeApostadores;
import modelo.Time;

/**
 *
 * @author Kelvin
 */
@WebServlet(name = "ApostadorServlet", urlPatterns = {"/ApostadorServlet"})
public class ApostadorServlet extends HttpServlet {

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
            out.println("<title>Servlet GrupoDeApostadoresServlet</title>");
            out.println("</head>");
            out.println("<body>");

            Apostador apostador = new Apostador();
            ApostadorDao apostadorDao = new ApostadorDao();

            String nomeApostador = request.getParameter("nomeApostador");
            apostador.setNome(nomeApostador);
            
            String cpf = request.getParameter("cpf");
            apostador.setCpf(cpf);
            
            Date data_nascimento = new Date(request.getParameter("data_nascimento"));
            apostador.setData_nascimento(data_nascimento);
            
            String email = request.getParameter("email");
            apostador.setEmail(email);
            
            String apelido = request.getParameter("apelido");
            apostador.setApelido(apelido);
            
            String time = request.getParameter("time");
            Time time_preferido = (Time) new TimeDao().buscaTime(1, time);
            apostador.setTime_preferido(time_preferido);
            
            String grupo = request.getParameter("grupo");
            GrupoDeApostadores grupo_apostadores = (GrupoDeApostadores) new GrupoDeApostadoresDao().buscaGrupoDeApostadores(1, grupo);
            apostador.setGrupo(grupo_apostadores);
            
            apostadorDao.salvar(apostador);
            
            response.sendRedirect("consultaApostadores.jsp");

            out.println("<h1>Servlet GrupoDeApostadoresServlet at " + request.getContextPath() + "</h1>");
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
