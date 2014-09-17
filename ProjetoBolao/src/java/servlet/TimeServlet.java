package servlet;

import dao.TimeDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Time;

@WebServlet(name = "TimeServlet", urlPatterns = {"/TimeServlet"})
public class TimeServlet extends HttpServlet {

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
            out.println("<title>Servlet TimeServlet</title>");
            out.println("</head>");
            out.println("<body>");

            Time time = new Time();

            String nomeTime = request.getParameter("nomeTime");
            time.setNome(nomeTime);
            String endereco = request.getParameter("endereco");
            time.setEndereco(endereco);
            String cidade = request.getParameter("cidade");
            time.setCidade(cidade);
            String email = request.getParameter("email");
            time.setEmail(email);
            String site = request.getParameter("site");
            time.setSite(site);
            String fone = request.getParameter("fone");
            time.setFone(fone);
            Date dataCadastro = Date.valueOf(request.getParameter("dataCadastro"));
            time.setData_cadastro(dataCadastro);
            Date dataFundacao = Date.valueOf(request.getParameter("dataFundacao"));
            time.setData_fundacao(dataFundacao);
            String historico = request.getParameter("historico");
            time.setHistorico(historico);

            TimeDao timeDao = new TimeDao();
            timeDao.salvar(time);

            response.sendRedirect("consultaTime.jsp");

            out.println("<h1>Servlet TimeServlet at " + request.getContextPath() + "</h1>");
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
