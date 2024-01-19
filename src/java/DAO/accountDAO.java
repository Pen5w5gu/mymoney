/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mybos
 */
public class accountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String username, String password) {
        String query = "select * from Account\n"
                + "where [username] = ?\n"
                + "and [password] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getString(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean checkDuplicateUsername(String username) {
        String query = "select * from Account\n"
                + "where [username] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    public boolean checkDuplicateEmail(String email) {
        String query = "select * from Account\n"
                + "where [email] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    public void signup(String username, String email, String password) {
        String query = "INSERT INTO Account (Username, Password, Name, Email)\n"
                + "VALUES (?,?,?,?);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, username);
            ps.setString(4, email);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

}
