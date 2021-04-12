/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelt;

import DAO.EquipmentDAO;
import DAO.LoginDAO;
import DAO.UserDAO;
import Entity.Equipment;
import Entity.LoggedUser;
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
            String id = request.getParameter("id");
            User user = new UserDAO().consultarId(Integer.parseInt(id));
            System.out.println("ID to delete: " + id);
            if (user != null) {
                new UserDAO().excluir(Integer.parseInt(id));
                forwardPage("User.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
        }

        // ================= Equipment ======================================
        if (param.equals("edEquipment")) {
            String id = request.getParameter("id");
            System.out.println("ID to edit: " + id);
            Equipment equip = new EquipmentDAO().consultarId(Integer.parseInt(id));

            if (equip != null) {
                request.setAttribute("objEquipment", equip);
                forwardPage("Equipment.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
        } else if (param.equals("exEquipment")) {
            String id = request.getParameter("id");
            Equipment equip = new EquipmentDAO().consultarId(Integer.parseInt(id));
            System.out.println("ID to delete: " + id);
            if (equip != null) {
                new EquipmentDAO().excluir(Integer.parseInt(id));
                forwardPage("Equipment.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
        }
        if (param.equals("logout")) {
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            response.sendRedirect("Login.jsp");
        }
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
        if (param.equals("saveEquipment")) {
            String userName = request.getParameter("UserName");
            System.out.println("User Name: " + userName);

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String model = request.getParameter("model");
            String type = request.getParameter("type");
            String vendor = request.getParameter("vendor");
            String serialNumber = request.getParameter("serialNumber");
            String status = request.getParameter("status");
            int user_id = Integer.parseInt(request.getParameter("user_id"));

            Equipment eq = new Equipment();

            eq.setId(id);
            eq.setName(name);
            eq.setModel(model);
            eq.setType(type);
            eq.setVendor(vendor);
            eq.setSerialNumber(serialNumber);
            eq.setStatus(status);
            eq.setUser_id(user_id);

            //call save method and wait return
            String ret = null;
            if (id == 0) {
                ret = new EquipmentDAO().salvar(eq);
            } else {
                ret = new EquipmentDAO().atualizar(eq);
            }

            if (ret == null) {
                // OK
                request.setAttribute("registerType", "Equipment");
                request.setAttribute("returnPage", "Equipment.jsp");

                forwardPage("Equipment.jsp", request, response);
            } else {
                // Error
                forwardPage("Error.jsp", request, response);
            }
        }

        // ==================== LOGIN ================================
        if (param.equals("login")) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            String a = new LoginDAO().login(email, Encoding.encodeToMD5(password));
            System.out.println(a);
            if (a.equals("Success")) {
                HttpSession sessao = ((HttpServletRequest) request).getSession();
                sessao.setAttribute("loggedUser", LoggedUser.getEmail());
                System.out.println("Logged User: Id: " + LoggedUser.getId() + " Email: " + LoggedUser.getEmail());
                // redirecionando para User.jsp
                forwardPage("Menu.jsp", request, response);
            } else {
                request.setAttribute("msgLogin", "Error");
                request.setAttribute("ErrorMessage", a);
                forwardPage("Login.jsp", request, response);
            }
        }

        //ComboBox
        if (param.equals("comboUser")) {
            String param2 = request.getParameter("param");
            System.out.println("Valor do Select: " + param2);
        }

        //SearchBoxUser
        if (param.equals("SearchBox")) {
            String criteria = request.getParameter("criteria");
            String inactive = request.getParameter("checkboxcriteria");
            request.setAttribute("inactives", inactive);
            request.setAttribute("criteria", criteria);
            forwardPage("User.jsp", request, response);
        }
        //SearchBoxEquipment
        if (param.equals("SearchBoxEquipment")) {
            String criteria = request.getParameter("criteria");
            String inactive = request.getParameter("checkboxcriteria");
            request.setAttribute("criteria", criteria);
            request.setAttribute("inactives", inactive);
            forwardPage("Equipment.jsp", request, response);
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
