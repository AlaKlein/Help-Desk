package Useful;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pretto
 */
import java.sql.*;
import java.util.*;

public class DBConection {

    private static DBConection instancia = null;
    private Connection conexao = null;

    public DBConection() {
        try {
            // Carrega informações do arquivo de propriedades
            String dbdriver = "org.mariadb.jdbc.Driver";
            String dburl = "jdbc:mariadb://localhost:3306/TicketSystem";
            String dbuser = "root";
            String dbsenha = "admin";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Retorna instância
    public static DBConection getInstance() {
        if (instancia == null) {
            instancia = new DBConection();
        }
        return instancia;
    }

    // Retorna conexão
    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    // Efetua fechamento da conexão
    public void shutDown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
