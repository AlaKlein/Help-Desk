/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Useful.DBConection;
import Useful.IDAO;
import Entity.User;
import java.util.ArrayList;
import java.sql.*;

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
                output = "Erro";
            }

        } catch (SQLException e) {
            System.out.println("Error while updating User! " + e);
            output = e.toString();
        }

        return output;
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> consultarTodos() {

        ArrayList<User> users = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM user "
                    + "ORDER BY id";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                User u = new User();

                u.setId(resultado.getInt("id"));
                u.setEmail(resultado.getString("email"));
                u.setName(resultado.getString("name"));
                u.setPassword(resultado.getString("password"));
                u.setStatus(resultado.getString("status"));

                users.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Users: " + e);
        }

        return users;
    }

    @Override
    public ArrayList<User> consultar(String criteria) {
        ArrayList<User> Users = new ArrayList();

        try {
            Statement st = DBConection.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM user "
                    + "WHERE email ilike '%" + criteria + "%' "
                    + "order by descricao";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                User u = new User();

                u.setId(resultado.getInt("id"));
                u.setEmail(resultado.getString("email"));
                u.setName(resultado.getString("name"));
                u.setPassword(resultado.getString("password"));
                u.setStatus(resultado.getString("status"));

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

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                u = new User();

                u.setId(resultado.getInt("id"));
                u.setEmail(resultado.getString("email"));
                u.setName(resultado.getString("name"));
                u.setPassword(resultado.getString("password"));
                u.setStatus(resultado.getString("status"));
            }

        } catch (SQLException e) {
            System.out.println("Error while listing Users by ID: " + e);
        }

        return u;
    }

    @Override
    public boolean registroUnico(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
