/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Useful.DBConection;
import Useful.IDAO;
import Entity.User;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Klein
 */
public class UserDAO implements IDAO<User> {

    ResultSet resultadoQ;

    @Override
    public String salvar(User u) {
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "Insert into user values "
                    + "(default,"
                    + " '" + u.getEmail() + "',"
                    + " '" + u.getName() + "',"
                    + " '" + u.getPassword() + "',"
                    + " '" + u.getStatus() + "')";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (SQLException e) {
            System.out.println("Error while saving user: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(User u) {
        String output = null;
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "UPDATE user "
                    + "SET email = '" + u.getEmail() + "', "
                    + "name = '" + u.getName() + "', "
                    + "password = '" + u.getPassword() + "', "
                    + "status = '" + u.getStatus() + "' "
                    + "WHERE id = " + u.getId();

            System.out.println("SQL: " + sql);

            int message = stm.executeUpdate(sql);

            if (message != 0) {
                output = null;
            } else {
                output = "Error";
            }

        } catch (SQLException e) {
            System.out.println("Error while updating User! " + e);
            output = e.toString();
        }

        return output;
    }

    @Override
    public String excluir(int id) {
        String output = null;
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "UPDATE user "
                    + "SET status = 'Inactive' "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            int message = stm.executeUpdate(sql);

            if (message != 0) {
                output = null;
            } else {
                output = "Error";
            }

        } catch (SQLException e) {
            System.out.println("Error while inactivating User! " + e);
            output = e.toString();
        }
        return output;
    }

    @Override
    public ArrayList<User> consultarTodos() {

        ArrayList<User> users = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM user "
                    + "ORDER BY id";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                User u = new User();

                u.setId(result.getInt("id"));
                u.setEmail(result.getString("email"));
                u.setName(result.getString("name"));
                u.setPassword(result.getString("password"));
                u.setStatus(result.getString("status"));

                users.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Users: " + e);
        }

        return users;
    }

    public ArrayList<User> consultarr(String criteria, String inactive) {
        ArrayList<User> Users = new ArrayList();
        String sql = "";

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            if (inactive.equals("inactives")) {

                sql = "SELECT * "
                        + "FROM user "
                        + "WHERE email LIKE '%" + criteria + "%' "
                        + "order by id";

            } else {
                sql = "SELECT * "
                        + "FROM user "
                        + "WHERE email LIKE '%" + criteria + "%' and status not like 'inactive' "
                        + "order by id";

            }

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                User u = new User();

                u.setId(result.getInt("id"));
                u.setEmail(result.getString("email"));
                u.setName(result.getString("name"));
                u.setPassword(result.getString("password"));
                u.setStatus(result.getString("status"));

                Users.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing users: " + e);
        }

        return Users;
    }

    @Override
    public User consultarId(int id) {
        User u = null;

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "user "
                    + "WHERE id = " + id;

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                u = new User();

                u.setId(result.getInt("id"));
                u.setEmail(result.getString("email"));
                u.setName(result.getString("name"));
                u.setPassword(result.getString("password"));
                u.setStatus(result.getString("status"));
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Users by ID: " + e);
        }

        return u;
    }
    
    public String seachPassword(int id) {
        String password = "";

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT password "
                    + "FROM "
                    + "user "
                    + "WHERE id = " + id;

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                 password = result.getString("password");
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Users by ID: " + e);
        }

        return password;
    }
     public byte[] generateReport() throws IOException, URISyntaxException {
        try {
            Connection conn = DBConection.getInstance().getConnection();

            //funciona
            // JasperReport report = JasperCompileManager.compileReport("C:\\Users\\Klein\\Documents\\NetBeansProjects\\HelpDesk\\src\\main\\java\\Reports\\Equipment.jrxml");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            //InputStream is = classloader.getResourceAsStream("ListUser.jrxml");
            InputStream is = classloader.getResourceAsStream("/WEB-INF/classes/ListUser.jrxml");

            JasperReport report = JasperCompileManager.compileReport(is);

            Map parameters = new HashMap();
            
             // adiciona parametros

            byte[] bytes = JasperRunManager.runReportToPdf(report, parameters, conn);
            return bytes;
        } catch (JRException e) {
            System.out.println("Error while generating report: " + e);
        }
        return null;
    }
    

    @Override
    public boolean registroUnico(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
