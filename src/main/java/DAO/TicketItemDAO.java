/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Ticket;
import Entity.TicketItem;
import Useful.DBConection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Klein
 */
public class TicketItemDAO {

    public String salvar(TicketItem t) {
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "Insert into ticketitem values "
                    + "(default,"
                    + " '" + t.getDescription_item() + "',"
                    + " '" + t.getDate() + "',"
                    + " '" + t.getAtendant() + "',"
                    + " '" + t.getTicket_id() + "')";

            System.out.println("SQL: " + sql);

            stm.executeUpdate(sql);

            return null;
        } catch (SQLException e) {
            System.out.println("Error while saving TicketItem: " + e);
            return e.toString();
        }
    }

    public String atualizar(TicketItem t) {
        String output = null;
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

//            String sql = "UPDATE ticketitem "
//                    + "SET description_item = '" + t.getDescription_item() + "', "
//                    + "date = '" + t.getDate() + "', "
//                    + "atendant = '" + t.getAtendant() + "' "
//                    + "WHERE ticket_id = " + t.getTicket_id();
            
            String sql = "UPDATE ticketitem "
                    + "SET description_item = '" + t.getDescription_item() + "', "
                    + "date = '" + t.getDate() + "', "
                    + "atendant = '" + t.getAtendant() + "', "
                    + "ticket_id = '" + t.getTicket_id() + "' "
                    + "WHERE id = " + t.getId();

            System.out.println("SQL: " + sql);

            int message = stm.executeUpdate(sql);

            if (message != 0) {
                output = null;
            } else {
                output = "Error";
            }

        } catch (SQLException e) {
            System.out.println("Error while updating TicketItem! " + e);
            output = e.toString();
        }

        return output;
    }
    
        public String excluir(int id) {
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM ticketitem WHERE id = "
                    + id;

            System.out.println("SQL: " + sql);

            stm.executeUpdate(sql);

            return null;
        } catch (SQLException e) {
            System.out.println("Error while deleting TicketItem: " + e);
            return e.toString();
        }
    }
    
     public TicketItem consultarTicketItemId(int id) {
        TicketItem t = null;

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "ticketitem "
                    + "WHERE id = " + id;

            ResultSet result = st.executeQuery(sql);
            
            System.out.println("consultarTicketItemId sql: " + sql);

            while (result.next()) {
                 t = new TicketItem();

                t.setId(result.getInt("id"));
                t.setDescription_item(result.getString("description_item"));
                t.setDate(result.getString("date"));
                t.setAtendant(result.getString("atendant"));
                t.setTicket_id(result.getInt("ticket_id"));
            }

        } catch (SQLException e) {
            System.out.println("Error while listing TicketItems by ID: " + e);
        }

        return t;
    }

    public TicketItem consultarTicketId(int id) {
        TicketItem t = null;

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

//            String sql = "SELECT * "
//                    + "FROM "
//                    + "ticket t "
//                    + "JOIN "
//                    + "ticketitem ti "
//                    + "ON t.id=ti.ticket_id "
//                    + "WHERE ticket_id = " + id;
            String sql = "SELECT * "
                    + "FROM "
                    + "ticketitem "
                    + "WHERE ticket_id = " + id;

            System.out.println("consultarTicketId sql: " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                t = new TicketItem();

                t.setId(result.getInt("id"));
                t.setDescription_item(result.getString("description_item"));
                t.setDate(result.getString("date"));
                t.setAtendant(result.getString("atendant"));
                t.setTicket_id(result.getInt("ticket_id"));
            }

        } catch (SQLException e) {
            System.out.println("Error while listing TicketsItems by ID: " + e);
        }
        return t;
    }
    
    public TicketItem consultarId(int id) {
        TicketItem t = null;

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

//           
            String sql = "SELECT * "
                    + "FROM "
                    + "ticketitem "
                    + "WHERE id = " + id;

            System.out.println("sql: " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                t = new TicketItem();

                t.setId(result.getInt("id"));
                t.setDescription_item(result.getString("description_item"));
                t.setDate(result.getString("date"));
                t.setAtendant(result.getString("atendant"));
                t.setTicket_id(result.getInt("ticket_id"));
            }

        } catch (SQLException e) {
            System.out.println("Error while listing TicketsItems by ID: " + e);
        }
        return t;
    }

    public ArrayList<TicketItem> consultarr(int id) {
        ArrayList<TicketItem> items = new ArrayList();
        String sql = "";
        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            sql = "SELECT * "
                    + "FROM ticketitem "
                    + "WHERE ticket_id = " + id
                    + " ORDER BY id";
            System.out.println("consultarr sql: " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                TicketItem t = new TicketItem();

                t.setId(result.getInt("id"));
                t.setDescription_item(result.getString("description_item"));
                t.setDate(result.getString("date"));
                t.setAtendant(result.getString("atendant"));
                t.setTicket_id(result.getInt("ticket_id"));

                items.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Items: " + e);
        }

        return items;
    }

}
