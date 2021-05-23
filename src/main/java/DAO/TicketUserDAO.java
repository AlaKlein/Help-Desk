/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Useful.DBConection;
import Useful.IDAO;
import Entity.Ticket;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Klein
 */
public class TicketUserDAO implements IDAO<Ticket> {

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

    public ArrayList<Ticket> consultarr(String criteria, String inactive) {
        ArrayList<Ticket> tickets = new ArrayList();
        String sql = "";
        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            if (inactive.equals("finished")) {

                sql = "SELECT t.id, t.title, t.description, t.priority, u.name, t.user_id, t.equipment_id, "
                        + "t.telephone, t.date, t.status, t.atendant FROM ticket t JOIN user u "
                        + "ON t.user_id=u.id "
                        + "WHERE status LIKE '%" + criteria + "%'"
                        + "order by id";
            } else {
                sql = "SELECT t.id, t.title, t.description, t.priority, u.name, t.user_id, t.equipment_id, "
                        + "t.telephone, t.date, t.status, t.atendant FROM ticket t JOIN user u "
                        + "ON t.user_id=u.id "
                        + "WHERE title LIKE '%" + criteria + "%' and t.status not like 'finished' "
                        + "order by id";
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
                t.setDate(result.getString("date"));
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

//    public byte[] generateReport() {
//        try {
//            Connection conn = DBConection.getInstance().getConnection();
//            
//            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Reports/Equipment.jrxml"));
//            
//            Map parameters = new HashMap();
//
//            byte[] bytes = JasperRunManager.runReportToPdf(report, parameters, conn);
//            return bytes;
//        } catch (JRException e) {
//            System.out.println("Error while generating report: " + e);
//        }
//        return null;
//    }
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
