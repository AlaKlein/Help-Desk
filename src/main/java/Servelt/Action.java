/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelt;

import DAO.UserDAO;
import Entidade.User;
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
                encaminharPagina("User.jsp", request, response);
            } else {
                encaminharPagina("Error.jsp", request, response);
            }
        } else if (param.equals("exUser")) {

        }

//        // ================= Equip ======================================        
//        if (param.equals("edCategoria")) {
//            String id = request.getParameter("id");
//
//            Categoria categ = new CategoriaDAO().consultarId(Integer.parseInt(id));
//
//            if (categ != null) {
//
//                request.setAttribute("objCategoria", categ);
//
//                encaminharPagina("categoria.jsp", request, response);
//            } else {
//                encaminharPagina("erro.jsp", request, response);
//            }
//        }
        // =================== LOGIN ===================================
//        if (param.equals("logout")) {
//            System.out.println("LOGOUTTTTTT");
//            HttpSession sessao = request.getSession();
//            sessao.invalidate();
//            response.sendRedirect("login.jsp");
//        }
//    }
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
            String password = request.getParameter("password");
            String status = request.getParameter("status");

            User u = new User();

            u.setId(id);
            u.setEmail(email);
            u.setName(UserName);
            u.setPassword(password);
            u.setStatus(status.charAt(0));

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

                encaminharPagina("User.jsp", request, response);
            } else {
                // Error
                encaminharPagina("Error.jsp", request, response);
            }
        }

        // ================= CATEGORIA ======================================
//        if (param.equals("salvarCategoria")) {
//            // capturar dados que vieram do REQUEST
//            int id = Integer.parseInt(request.getParameter("id"));
//            String descricao = request.getParameter("descricao");
//            String situacao = request.getParameter("situacao");
//
//            // validacoes dos campos - não farei
//            // criar OBJ do tipo que será salvo
//            Categoria c = new Categoria();
//            c.setId(id);
//            c.setDescricao(descricao);
//            c.setSituacao(situacao.charAt(0));
//
//            // chamar o salvar e aguardar o ret
//            String ret = null;
//            if (id == 0) {
//                ret = new CategoriaDAO().salvar(c);
//            } else {
//                ret = new CategoriaDAO().atualizar(c);
//            }
//
//            if (ret == null) {
//                // deu certo
//                request.setAttribute("tipoCadastro", "Categoria");
//                request.setAttribute("paginaRetorno", "categoria.jsp");
//
//                encaminharPagina("sucesso.jsp", request, response);
//            } else {
//                // deu errado
//                encaminharPagina("erro.jsp", request, response);
//            }
//
//        }
//        // ==================== LOGIN ================================
//        if (param.equals("login")) {
//            // ignorando autenticacao = demo
//            String usuario = request.getParameter("email");
//
//            if (usuario.equals("juca@bala.com.br")) {
//
//                // consulta no BD: verificar se credenciais estão ok
//                // ...
//                // após validar credenciais, adiciona user na Sessão
//                HttpSession sessao = ((HttpServletRequest) request).getSession();
//
//                sessao.setAttribute("usuarioLogado", "juca");
//
//                // redirecionando para menu.jsp
//                encaminharPagina("menu.jsp", request, response);
//            } else {
//                request.setAttribute("msgLogin", "erro");
//                encaminharPagina("login.jsp", request, response);
//            }
//        }
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

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
        }
    }
}
