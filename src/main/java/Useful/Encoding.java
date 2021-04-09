/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Useful;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Klein
 */
public class Encoding {

    public static String encodeToMD5(String val) {
        String result = "";

        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(val.getBytes(), 0, val.length());
            result = new BigInteger(1, m.digest()).toString(16);
        } catch (Exception e) {
            System.out.println("Error while coding String: " + e);
        }

        return result;
    }
}
