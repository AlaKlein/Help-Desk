/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Klein
 */
public class LoggedUser {
    static int id;
    static String email;
    static String status;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        LoggedUser.email = email;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        LoggedUser.status = status;
    }
    
    
}
