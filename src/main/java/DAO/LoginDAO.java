/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.LoggedUser;
import Useful.DBConection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Klein
 */
public class LoginDAO {

    public String login(String email, String password) {
        ResultSet resultadoQ = null;
        int userID = 0;
        String userEmail = "";
        String pw = "";
        int i = 0;
        String status = "";
        String output = "";

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();
            String sql = "SELECT id, email, password, status FROM user "
                    + "WHERE email = '" + email + "' "
                    + "AND password = '" + password + "' ";

            resultadoQ = st.executeQuery(sql);
            System.out.println(sql);

            while (resultadoQ.next()) {

                userID = resultadoQ.getInt("id");
                userEmail = resultadoQ.getString("email");
                pw = resultadoQ.getString("password");
                status = resultadoQ.getString("status");
                i++;
            }
            System.out.println(password);
            if (i == 1) {
                LoggedUser.setId(userID);
                LoggedUser.setEmail(email);
                LoggedUser.setStatus(status);
                if (userEmail.equals(email) && pw.equals(password) && status.equals("Active")) {
                    output = "Success";
                    return output;

                } else if (status.equals("Inactive")) {
                    output = "User Inactive";
                    return output;
                }
            }

        } catch (SQLException e) {
            return e.toString();
        }
        return output;
    }
}
