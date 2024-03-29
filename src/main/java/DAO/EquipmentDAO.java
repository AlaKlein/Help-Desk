/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Useful.DBConection;
import Useful.IDAO;
import Entity.Equipment;
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
                    + " '" + eq.getStatus() + "',"
                    + " '" + eq.getUser_id() + "',"
                    + " '" + eq.getIp() + "')";

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
                    + "user_id = '" + eq.getUser_id() + "', "
                    + "status = '" + eq.getStatus() + "', "
                    + "ip = '" + eq.getIp() + "' "
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

    public String excluirNovo(int id) {
        String output = null;
        try {
            Statement stm = DBConection.getInstance().getConnection().createStatement();

            String sql = "UPDATE equipment "
                    + "SET status = 'inactive' "
                    + "WHERE id = " + id;
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

//        try {
//            Statement stm = DBConection.getInstance().getConnection().createStatement();
//
//            String sql = "DELETE FROM equipment WHERE id = "
//                    + id;
//
//            System.out.println("SQL: " + sql);
//
//            stm.executeUpdate(sql);
//
//            return null;
//        } catch (SQLException e) {
//            System.out.println("Error while deleting Equipment: " + e);
//            return e.toString();
//        }
        }
        return output;
    }

    @Override
    public ArrayList<Equipment> consultarTodos() {

        ArrayList<Equipment> equipments = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM Equipment "
                    + "WHERE status not like 'inactive' "
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
                eq.setIp(result.getString("ip"));

                equipments.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments: " + e);
        }

        return equipments;
    }

    public ArrayList<Equipment> consultarEquip(int tkID) {

        ArrayList<Equipment> equipments = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT t.id AS tkID, e.id, e.name, e.status "
                    + "FROM equipment e JOIN ticket t "
                    + "ON e.id=t.equipment_id "
                    + "WHERE e.status not like 'inactive' AND e.id = '" + tkID + "' "
                    + "ORDER BY id";

            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Equipment eq = new Equipment();

                eq.setId(result.getInt("id"));
                eq.setName(result.getString("name"));

                equipments.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments: " + e);
        }

        return equipments;
    }

    public ArrayList<Equipment> consultarVendor(int id) {

        ArrayList<Equipment> equipments = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM equipment "
                    + "WHERE status not like 'inactive' AND id= '" + id + "' "
                    + "ORDER BY id";

            System.out.println("Vendor cadastrado " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Equipment eq = new Equipment();

                eq.setId(result.getInt("id"));
                eq.setVendor(result.getString("vendor"));

                equipments.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments: " + e);
        }

        return equipments;
    }

    public ArrayList<Equipment> consultarVendors() {

        ArrayList<Equipment> equipments = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT DISTINCT(vendor) "
                    + "FROM equipment "
                    + "WHERE status not like 'inactive' ";

            System.out.println("Vendors " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Equipment eq = new Equipment();

                eq.setVendor(result.getString("vendor"));

                equipments.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Vendors: " + e);
        }

        return equipments;
    }

    public ArrayList<Equipment> consultarr(String id, String name, String vendor, String serial, String ip, String inactive) {
        ArrayList<Equipment> equipments = new ArrayList();
        String sql = "";
        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            sql = " SELECT * "
                    + "FROM equipment "
                    + "WHERE id LIKE '%" + id + "%' AND name LIKE '%" + name + "%' AND vendor LIKE '%" + vendor + "%' AND serial_number LIKE '%" + serial + "%'"
                    + "AND ip LIKE '%" + ip + "%' "
                    + "AND status NOT LIKE '%" + inactive + "%' "
                    + "ORDER BY id";

//            if (inactive.equals("inactives")) {
//
//                sql = "SELECT * "
//                        + "FROM equipment "
//                        + "WHERE name LIKE '%" + criteria + "%' "
//                        + "order by id";
//            } else {
//                sql = "SELECT * "
//                        + "FROM equipment "
//                        + "WHERE name LIKE '%" + criteria + "%' and status not like 'inactive' "
//                        + "order by id";
//            }
            System.out.println("sql: " + sql);

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
                eq.setIp(result.getString("ip"));
                eq.setUser_id(result.getInt("user_id"));

                equipments.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments: " + e);
        }

        return equipments;
    }

    public ArrayList<Equipment> consultarChart() {
        ArrayList<Equipment> equipments = new ArrayList();
        String sql = "";
        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            sql = "SELECT e.vendor "
                    + "FROM equipment e "
                    + "WHERE id=1 "
                    + "order by id";
            System.out.println("sql: " + sql);

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                Equipment eq = new Equipment();

                eq.setVendor(result.getString("vendor"));

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
                eq.setIp(result.getString("ip"));
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments by ID: " + e);
        }

        return eq;
    }

    public byte[] generateReport(String vendor) throws IOException, URISyntaxException {
        try {
            Connection conn = DBConection.getInstance().getConnection();

            //funciona
            // JasperReport report = JasperCompileManager.compileReport("C:\\Users\\Klein\\Documents\\NetBeansProjects\\HelpDesk\\src\\main\\java\\Reports\\Equipment.jrxml");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("Equipment.jrxml");

            JasperReport report = JasperCompileManager.compileReport(is);

            Map parameters = new HashMap();

            // adiciona parametros
            parameters.put("vendor", vendor);

            byte[] bytes = JasperRunManager.runReportToPdf(report, parameters, conn);
            return bytes;
        } catch (JRException e) {
            System.out.println("Error while generating report: " + e);
        }
        return null;
    }

    @Override
    public boolean registroUnico(Equipment o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(Equipment o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Equipment> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
