/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.EquipmentChart;
import Useful.DBConection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Klein
 */
public class EquipmentChartDAO {

    public ArrayList<EquipmentChart> consultarTodos() {

        ArrayList<EquipmentChart> equipments = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "select vendor, Count(vendor) AS qtd from equipment group by vendor";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                EquipmentChart eq = new EquipmentChart();

                eq.setVendor(result.getString("vendor"));
                eq.setQtd(result.getInt("qtd"));

                equipments.add(eq);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Equipments: " + e);
        }
        return equipments;
    }
}
