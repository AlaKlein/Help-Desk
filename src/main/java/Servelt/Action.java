/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelt;

import DAO.LoginDAO;
import DAO.UserDAO;
import Entity.User;
import Useful.Encoding;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Klein
 */
public class Action extends HttpServlet {

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
            out.println("<title>Servlet Action</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Action at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        System.out.println("GET");

        String param = request.getParameter("param");

        // ================= User =========================================
        if (param.equals("edUser")) {
            String id = request.getParameter("id");
            System.out.println("ID to edit: " + id);
            User user = new UserDAO().consultarId(Integer.parseInt(id));

            if (user != null) {
                request.setAttribute("objUser", user);
                forwardPage("User.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
        } else if (param.equals("exUser")) {

        }

        // ================= Equipment ======================================        
        //       To do
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
        //processRequest(request, response);
        System.out.println("ESTOU no POST");

        String param = request.getParameter("param");

        // ================= User =========================================
        if (param.equals("saveUser")) {
            String name = request.getParameter("UserName");
            System.out.println("User Name: " + name);

            int id = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");
            String UserName = request.getParameter("name");
            String password = Encoding.encodeToMD5(request.getParameter("password"));
            String status = request.getParameter("status").trim();

            User u = new User();

            u.setId(id);
            u.setEmail(email);
            u.setName(UserName);
            u.setPassword(password);
            u.setStatus(status);

            //call save method and wait return
            String ret = null;
            if (id == 0) {
                ret = new UserDAO().salvar(u);
            } else {
                ret = new UserDAO().atualizar(u);
            }

            if (ret == null) {
                // OK
                request.setAttribute("registerType", "User");
                request.setAttribute("returnPage", "User.jsp");

                forwardPage("User.jsp", request, response);
            } else {
                // Error
                forwardPage("Error.jsp", request, response);
            }
        }

        // ================= Equipment ======================================
        //To do
        // ==================== LOGIN ================================
        if (param.equals("login")) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            String a = new LoginDAO().login(email, Encoding.encodeToMD5(password));
            System.out.println(a);
            if (a.equals("Success")) {
                HttpSession sessao = ((HttpServletRequest) request).getSession();
                sessao.setAttribute("usuarioLogado", email);
                // redirecionando para User.jsp
                forwardPage("User.jsp", request, response);
            } else {
                request.setAttribute("msgLogin", "Error");
                request.setAttribute("ErrorMessage", a);
                forwardPage("Login.jsp", request, response);
            }
        }
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

    private void forwardPage(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Error while forwarding page: " + e);
        }
    }
}
