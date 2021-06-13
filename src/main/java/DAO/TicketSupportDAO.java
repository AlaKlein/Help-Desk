/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Useful.DBConection;
import Useful.IDAO;
import Entity.Ticket;
import Useful.Format;
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
public class TicketSupportDAO implements IDAO<Ticket> {

    ResultSet resultadoQ;

    @Override
    public String salvar(Ticket t) {
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "Insert into ticket values "
                    + "(default,"
                    + " '" + t.getDescription() + "',"
                    + " '" + t.getTelephone() + "',"
                    + " '" + t.getUser_id() + "',"
                    + " '" + t.getEquipment_id() + "',"
                    + " '" + t.getDate() + "',"
                    + " '" + t.getStatus() + "',"
                    + " '" + t.getTitle() + "',"
                    + " '" + t.getPriority() + "',"
                    + " '" + t.getAtendant() + "')";

            System.out.println("SQL: " + sql);

            stm.executeUpdate(sql);

            return null;
        } catch (SQLException e) {
            System.out.println("Error while saving Ticket: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Ticket t) {
        String output = null;
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "UPDATE ticket "
                    + "SET description = '" + t.getDescription() + "', "
                    + "telephone = '" + t.getTelephone() + "', "
                    + "user_id = '" + t.getUser_id() + "', "
                    + "equipment_id = '" + t.getEquipment_id() + "', "
                    //+ "date = '" + t.getDate() + "', "
                    + "status = '" + t.getStatus() + "', "
                    + "title = '" + t.getTitle() + "', "
                    + "priority = '" + t.getPriority() + "', "
                    + "atendant = '" + t.getAtendant() + "' "
                    + "WHERE id = " + t.getId();

            System.out.println("SQL: " + sql);

            int message = stm.executeUpdate(sql);

            if (message != 0) {
                output = null;
            } else {
                output = "Error";
            }

        } catch (SQLException e) {
            System.out.println("Error while updating Ticket! " + e);
            output = e.toString();
        }

        return output;
    }
    
    public String updateAtendant(int id, String user) {
        String output = null;
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "UPDATE ticket set "
                    + "atendant = '" + user + "', "
                    + "status = 'In Progress' "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            int message = stm.executeUpdate(sql);

            if (message != 0) {
                output = null;
            } else {
                output = "Error";
            }

        } catch (SQLException e) {
            System.out.println("Error while updating Ticket! " + e);
            output = e.toString();
        }

        return output;
    }
    
    public String updateStatus(int id, String status) {
        String output = null;
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "UPDATE ticket set "
                    + "status = '" + status + "' "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            int message = stm.executeUpdate(sql);

            if (message != 0) {
                output = null;
            } else {
                output = "Error";
            }

        } catch (SQLException e) {
            System.out.println("Error while updating Ticket! " + e);
            output = e.toString();
        }

        return output;
    }

    @Override
    public String excluir(int id) {
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM ticket WHERE id = "
                    + id;

            System.out.println("SQL: " + sql);

            stm.executeUpdate(sql);

            return null;
        } catch (SQLException e) {
            System.out.println("Error while deleting Ticket: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Ticket> consultarTodos() {

        ArrayList<Ticket> tickets = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM ticket "
                    + "ORDER BY id";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Ticket t = new Ticket();

                t.setId(result.getInt("id"));
                t.setTitle(result.getString("title"));
                t.setDescription(result.getString("description"));
                t.setPriority(result.getString("priority"));
                t.setUser_id(result.getInt("user_id"));
                t.setEquipment_id(result.getInt("equipment_id"));
                t.setTelephone(result.getString("telephone"));
                t.setDate(result.getString("date"));
                t.setStatus(result.getString("status"));
                t.setAtendant(result.getString("atendant"));

                tickets.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Tickets: " + e);
        }

        return tickets;
    }
    
     public ArrayList<Ticket> consultarAtendant() {

        ArrayList<Ticket> tickets = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT DISTINCT(atendant) "
                    + "FROM ticket "
                    + "WHERE atendant NOT LIKE '' ";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Ticket t = new Ticket();

                t.setAtendant(result.getString("atendant"));

                tickets.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Tickets: " + e);
        }

        return tickets;
    }

    public ArrayList<Ticket> consultarr(String title, String description, String user, String atendant, String finished, String initialdate, String finaldate) {
        ArrayList<Ticket> tickets = new ArrayList();
        String sql = "";
        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            if (initialdate.isEmpty() && finaldate.isEmpty()) {
                 sql = "SELECT t.id, t.title, t.description, t.priority, u.name, t.user_id, t.equipment_id, "
                    + "t.telephone, t.date, t.status, t.atendant FROM ticket t JOIN user u "
                    + "ON t.user_id=u.id "
                    + "WHERE t.title LIKE '%" + title + "%' AND t.description LIKE '%" + description + "%' "
                    + "AND t.atendant LIKE '%" + atendant + "%' AND u.name LIKE '%" + user + "%' "
                    + "AND t.status not like '" + finished + "' "
                    + "ORDER BY id";
            }else{
                sql = "SELECT t.id, t.title, t.description, t.priority, u.name, t.user_id, t.equipment_id, "
                    + "t.telephone, t.date, t.status, t.atendant FROM ticket t JOIN user u "
                    + "ON t.user_id=u.id "
                    + "WHERE t.title LIKE '%" + title + "%' AND t.description LIKE '%" + description + "%' "
                    + "AND t.atendant LIKE '%" + atendant + "%' AND u.name LIKE '%" + user + "%' "
                    + "AND t.status not like '" + finished + "' AND date BETWEEN '" + initialdate + "' AND '" + finaldate + "' "
                    + "ORDER BY id";
            }
            
            System.out.println("sql: " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Ticket t = new Ticket();

                t.setId(result.getInt("id"));
                t.setTitle(result.getString("title"));
                t.setDescription(result.getString("description"));
                t.setPriority(result.getString("priority"));
                t.setUser_id(result.getInt("user_id"));
                t.setUser_name(result.getString("name"));
                t.setEquipment_id(result.getInt("equipment_id"));
                t.setTelephone(result.getString("telephone"));
                String d = Format.adjustDate(result.getString("date"));
                t.setDate(d);
                t.setStatus(result.getString("status"));
                t.setAtendant(result.getString("atendant"));

                tickets.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing tickets: " + e);
        }

        return tickets;
    }

    @Override
    public Ticket consultarId(int id) {
        Ticket t = null;

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "ticket "
                    + "WHERE id = " + id;

            System.out.println("sql: " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                t = new Ticket();

                t.setId(result.getInt("id"));
                t.setDescription(result.getString("description"));
                t.setTelephone(result.getString("telephone"));
                t.setUser_id(result.getInt("user_id"));
                t.setEquipment_id(result.getInt("equipment_id"));
                t.setDate(result.getString("date"));
                t.setStatus(result.getString("status"));
                t.setTitle(result.getString("title"));
                t.setPriority(result.getString("priority"));
                t.setAtendant(result.getString("atendant"));

            }

        } catch (SQLException e) {
            System.out.println("Error while listing Tickets by ID: " + e);
        }

        return t;
    }

    public Ticket consultarIdd(int id) {
        Ticket t = null;

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "ticket "
                    + "WHERE id = " + id;

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                t = new Ticket();

                t.setId(result.getInt("id"));
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Tickets by ID: " + e);
        }

        return t;
    }

    public byte[] generateReport(String atendant) throws IOException, URISyntaxException {
        try {
            Connection conn = DBConection.getInstance().getConnection();

            //funciona
            // JasperReport report = JasperCompileManager.compileReport("C:\\Users\\Klein\\Documents\\NetBeansProjects\\HelpDesk\\src\\main\\java\\Reports\\Equipment.jrxml");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("TicketSupport.jrxml");

            JasperReport report = JasperCompileManager.compileReport(is);

            Map parameters = new HashMap();

            // adiciona parametros
            parameters.put("atendant", atendant);

            byte[] bytes = JasperRunManager.runReportToPdf(report, parameters, conn);
            return bytes;
        } catch (JRException e) {
            System.out.println("Error while generating report: " + e);
        }
        return null;
    }
    
    public byte[] generateReport2() throws IOException, URISyntaxException {
        try {
            Connection conn = DBConection.getInstance().getConnection();

            //funciona
            // JasperReport report = JasperCompileManager.compileReport("C:\\Users\\Klein\\Documents\\NetBeansProjects\\HelpDesk\\src\\main\\java\\Reports\\Equipment.jrxml");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("TicketSupport2.jrxml");

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
    
     public byte[] generateReportTicketByDate(String initialdate, String finaldate) throws IOException, URISyntaxException {
        try {
            Connection conn = DBConection.getInstance().getConnection();

            //funciona
            // JasperReport report = JasperCompileManager.compileReport("C:\\Users\\Klein\\Documents\\NetBeansProjects\\HelpDesk\\src\\main\\java\\Reports\\Equipment.jrxml");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("TicketSupportDate.jrxml");

            JasperReport report = JasperCompileManager.compileReport(is);

            Map parameters = new HashMap();

            // adiciona parametros
            parameters.put("initialdate", initialdate);
            parameters.put("finaldate", finaldate);

            byte[] bytes = JasperRunManager.runReportToPdf(report, parameters, conn);
            return bytes;
        } catch (JRException e) {
            System.out.println("Error while generating report: " + e);
        }
        return null;
    }

    @Override
    public boolean registroUnico(Ticket o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(Ticket o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Ticket> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
