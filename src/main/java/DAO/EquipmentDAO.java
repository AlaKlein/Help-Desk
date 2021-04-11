/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Useful.DBConection;
import Useful.IDAO;
import Entity.Equipment;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Klein
 */
public class EquipmentDAO implements IDAO<Equipment> {

    ResultSet resultadoQ;

    @Override
    public String salvar(Equipment eq) {
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "Insert into equipment values "
                    + "(default,"
                    + " '" + eq.getName() + "',"
                    + " '" + eq.getModel() + "',"
                    + " '" + eq.getType() + "',"
                    + " '" + eq.getVendor() + "',"
                    + " '" + eq.getSerialNumber() + "',"
                    + " '" + eq.getStatus()+ "',"
                    + " '" + eq.getUser_id() + "')";

            System.out.println("SQL: " + sql);

            stm.executeUpdate(sql);

            return null;
        } catch (SQLException e) {
            System.out.println("Error while saving Equipment: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Equipment eq) {
        String output = null;
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "UPDATE equipment "
                    + "SET name = '" + eq.getName() + "', "
                    + "model = '" + eq.getModel() + "', "
                    + "type = '" + eq.getType() + "', "
                    + "vendor = '" + eq.getVendor() + "', "
                    + "serial_number = '" + eq.getSerialNumber() + "', "
                    + "user_id = '" + eq.getUser_id()+ "', "
                    + "status = '" + eq.getStatus() + "' "
                    + "WHERE id = " + eq.getId();

            System.out.println("SQL: " + sql);

            int message = stm.executeUpdate(sql);

            if (message != 0) {
                output = null;
            } else {
                output = "Error";
            }

        } catch (SQLException e) {
            System.out.println("Error while updating Equipment! " + e);
            output = e.toString();
        }

        return output;
    }

    @Override
    public String excluir(int id) {
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM equipment WHERE id = "
                    + id;

            System.out.println("SQL: " + sql);

            stm.executeUpdate(sql);

            return null;
        } catch (SQLException e) {
            System.out.println("Error while deleting Equipment: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Equipment> consultarTodos() {

        ArrayList<Equipment> equipments = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM Equipment "
                    + "ORDER BY id";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Equipment eq = new Equipment();

                eq.setId(result.getInt("id"));
                eq.setName(result.getString("name"));
                eq.setModel(result.getString("model"));
                eq.setType(result.getString("type"));
                eq.setVendor(result.getString("vendor"));
                eq.setSerialNumber(result.getString("serial_number"));
                eq.setStatus(result.getString("status"));

                equipments.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments: " + e);
        }

        return equipments;
    }

    @Override
    public ArrayList<Equipment> consultar(String criteria) {
        ArrayList<Equipment> equipments = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM equipment "
                    + "WHERE name LIKE '%" + criteria + "%' "
                    + "order by id";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Equipment eq = new Equipment();

                eq.setId(result.getInt("id"));
                eq.setName(result.getString("name"));
                eq.setModel(result.getString("model"));
                eq.setType(result.getString("type"));
                eq.setVendor(result.getString("vendor"));
                eq.setSerialNumber(result.getString("serial_number"));
                eq.setStatus(result.getString("status"));
                eq.setUser_id(result.getInt("user_id"));

                equipments.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments: " + e);
        }

        return equipments;
    }

    @Override
    public Equipment consultarId(int id) {
        Equipment eq = null;

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "equipment "
                    + "WHERE id = " + id;

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                eq = new Equipment();

                eq.setId(result.getInt("id"));
                eq.setName(result.getString("name"));
                eq.setModel(result.getString("model"));
                eq.setType(result.getString("type"));
                eq.setVendor(result.getString("vendor"));
                eq.setSerialNumber(result.getString("serial_number"));
                eq.setStatus(result.getString("status"));
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments by ID: " + e);
        }

        return eq;
    }

    @Override
    public boolean registroUnico(Equipment o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(Equipment o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
