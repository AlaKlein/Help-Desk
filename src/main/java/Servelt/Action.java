/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelt;

import DAO.EquipmentDAO;
import DAO.LoginDAO;
import DAO.TicketItemDAO;
import DAO.TicketSupportDAO;
import DAO.TicketUserDAO;
import DAO.UserDAO;
import Entity.Equipment;
import Entity.LoggedUser;
import Entity.Ticket;
import Entity.TicketItem;
import Entity.User;
import Useful.Encoding;
import Useful.Format;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        // ================= TicketUser ======================================
        if (param.equals("edTicketUser")) {
            String id = request.getParameter("id");
            System.out.println("ID to edit: " + id);
            Ticket ticketUser = new TicketUserDAO().consultarId(Integer.parseInt(id));

            if (ticketUser != null) {
                request.setAttribute("objTicket", ticketUser);
                forwardPage("TicketUser.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
        } else if (param.equals("exTicketUser")) {
            String id = request.getParameter("id");
            Ticket tk = new TicketUserDAO().consultarIdd(Integer.parseInt(id));
            System.out.println("ID to delete: " + id);
            if (tk != null) {
                new TicketUserDAO().excluir(Integer.parseInt(id));
                forwardPage("TicketUser.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
        }

        // ================= TicketSupport ======================================
        if (param.equals("edTicketSupport")) {
            String id = request.getParameter("id");
            System.out.println("TicketID to edit: " + id);
            Integer ticket_id = Integer.parseInt(id);

            if (id != null) {
                request.setAttribute("ticketId", ticket_id);

                forwardPage("ListTicketItem.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
        }

        // ================= TicketItem ======================================
        if (param.equals("edTicketItem")) {
            String id = request.getParameter("id");
            System.out.println("TicketItemID to edit: " + id);
            Integer ticket_id = Integer.parseInt(id);

            TicketItem ticketItemTicketID = new TicketItemDAO().consultarTicketItemId(Integer.parseInt(id));

            if (id != null) {
                request.setAttribute("objTicketItem", ticketItemTicketID);
                request.setAttribute("ticketId", ticket_id);

                forwardPage("TicketItem2.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
            } else if (param.equals("exTicketItem")) {
            String id = request.getParameter("id");
            String tkid = request.getParameter("tkid");
            TicketItem tk = new TicketItemDAO().consultarTicketItemId(Integer.parseInt(id));
            System.out.println("ID to delete: " + id);
            if (tk != null) {
                request.setAttribute("ticketId", tkid);
                new TicketItemDAO().excluir(Integer.parseInt(id));
                forwardPage("ListTicketItem.jsp", request, response);
            } else {
                forwardPage("Error.jsp", request, response);
            }
        }


            // ================= Logout ======================================
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
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
                String pw = new UserDAO().seachPassword(id);
                if (!pw.equals("") && pw.equals(request.getParameter("password"))) {
                    u.setPassword(pw);
                } else {
                    u.setPassword(password);
                }
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
                String ipAddress = request.getParameter("ipAddress");
                int user_id = Integer.parseInt(request.getParameter("user_id"));

                Equipment eq = new Equipment();

                eq.setId(id);
                eq.setName(name);
                eq.setModel(model);
                eq.setType(type);
                eq.setVendor(vendor);
                eq.setSerialNumber(serialNumber);
                eq.setStatus(status);
                eq.setIp(ipAddress);
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

            // ================= Ticket ======================================
            if (param.equals("saveTicketUser")) {

                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String telephone = request.getParameter("telephone");
                int user_id = LoggedUser.getId();
                int equipment_id = Integer.parseInt(request.getParameter("equipment_id"));
                //String date = String.request.getParameter("date");
                String date = Format.getDateTime();
                //String status = request.getParameter("status");
                String status = "Open";
                String priority = request.getParameter("priority");
                String atendant = request.getParameter("atendant");

                Ticket t = new Ticket();

                t.setId(id);
                t.setTitle(title);
                t.setDescription(description.trim());
                t.setPriority(priority);
                t.setTelephone(telephone);
                //t.setUser_id(user_id);
                t.setUser_id(1);
                t.setEquipment_id(equipment_id);
                t.setDate(date);
                t.setStatus(status);
                t.setAtendant(atendant);

                //call save method and wait return
                String ret = null;
                if (id == 0) {
                    ret = new TicketUserDAO().salvar(t);
                } else {
                    ret = new TicketUserDAO().atualizar(t);
                }

                if (ret == null) {
                    // OK
                    request.setAttribute("registerType", "Ticket");
                    request.setAttribute("returnPage", "Ticket.jsp");

                    forwardPage("TicketUser.jsp", request, response);
                } else {
                    // Error
                    forwardPage("Error.jsp", request, response);
                }
            }

            // ================= TicketItem ======================================
            if (param.equals("saveTicketItem")) {

                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("O ID é: " + id);
                String description = request.getParameter("descriptionItem");
                String date = Format.getDateTime();
                String atendant = request.getParameter("atendant");
                int ticket_id = Integer.parseInt(request.getParameter("ticket_id"));

                TicketItem t = new TicketItem();

                t.setId(id);
                t.setDescription_item(description.trim());
                t.setDate(date);
                //t.setAtendant(atendant);
                t.setAtendant("Alã");
                t.setTicket_id(ticket_id);

                //call save method and wait return
                String ret = null;
                if (id == 0) {
                    ret = new TicketItemDAO().salvar(t);
                } else {
                    ret = new TicketItemDAO().atualizar(t);
                }

                if (ret == null) {
                    // OK
                    request.setAttribute("objTicketItem", t);
                    request.setAttribute("ticketId", ticket_id);

                    request.setAttribute("registerType", "Ticket");
                    request.setAttribute("returnPage", "Ticket.jsp");

                    forwardPage("ListTicketItem.jsp", request, response);
                } else {
                    // Error
                    forwardPage("Error.jsp", request, response);
                }
            }

//            if (param.equals("saveTicketItem2")) {
//
//                int id = Integer.parseInt(request.getParameter("id"));
//                String description = request.getParameter("description_item");
//                String date = Format.getDateTime();
//                String atendant = request.getParameter("atendant");
//                int ticket_id = Integer.parseInt(request.getParameter("ticket_id"));
//
//                TicketItem t = new TicketItem();
//
//                t.setId(id);
//                t.setDescription_item(description.trim());
//                t.setDate(date);
//                //t.setAtendant(atendant);
//                t.setAtendant("Alã");
//                t.setTicket_id(ticket_id);
//
//                //call save method and wait return
//                String ret = null;
//                if (id == 0) {
//                    ret = new TicketItemDAO().salvar(t);
//                } else {
//                    ret = new TicketItemDAO().atualizar(t);
//                }
//
//                if (ret == null) {
//                    // OK
//                    request.setAttribute("objTicketItem2", t);
//                    request.setAttribute("ticketId", ticket_id);
//
//                    request.setAttribute("registerType", "Ticket");
//                    request.setAttribute("returnPage", "Ticket.jsp");
//
//                    forwardPage("ListTicketItem.jsp", request, response);
//                } else {
//                    // Error
//                    forwardPage("Error.jsp", request, response);
//                }
//            }

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
            //SearchBoxTicketUser
            if (param.equals("SearchBoxTicketUser")) {
                String criteria = request.getParameter("criteria");
                String finished = request.getParameter("checkboxcriteria");
                request.setAttribute("criteria", criteria);
                request.setAttribute("finished", finished);
                forwardPage("TicketUser.jsp", request, response);
            }

            if (param.equals("SearchBoxTicketSupport")) {
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                String user = request.getParameter("user");
                String atendant = request.getParameter("atendant");
                String finished = request.getParameter("checkboxcriteria");
                request.setAttribute("title", title);
                request.setAttribute("description", description);
                request.setAttribute("user", user);
                request.setAttribute("atendant", atendant);
                request.setAttribute("finished", finished);
                forwardPage("TicketSupport.jsp", request, response);
            }
            
            if (param.equals("ReportEquipment")) {
                String vendor = request.getParameter("vendor");
                request.setAttribute("vendor", vendor);
                forwardPage("EquipmentReport.jsp", request, response);
            }
            if (param.equals("TicketReport")) {
                String vendor = request.getParameter("atendant");
                request.setAttribute("atendant", vendor);
                forwardPage("TicketReport.jsp", request, response);
            }

            if (param.equals("ListUsers")) {
                forwardPage("UserReport.jsp", request, response);
            }
            
             if (param.equals("TicketItemreport")) {
                String ticket = request.getParameter("ticket");
                request.setAttribute("ticket", ticket);
                 System.out.println("aqui jas minha paciencia " + ticket);
                forwardPage("TicketItemReport.jsp", request, response);
            }
              if (param.equals("ListTickets")) {
                String ticket = request.getParameter("ticket");
                request.setAttribute("ticket", ticket);
                 System.out.println("aqui jas minha paciencia " + ticket);
                forwardPage("TicketReport2.jsp", request, response);
            }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
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
