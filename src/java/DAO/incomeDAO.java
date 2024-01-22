/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Income;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quann
 */
public class incomeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Income> getIncomeByUserid(int userid) {
        List<Income> list = new ArrayList<>();
        String query = "select * from Income\n"
                + "where [UserID] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            while (true) {
                list.add(new Income(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getNString(5), rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean insertIncome(int userid, Date date, int value, String detail, int CategoryID) {
        String query = "Insert into Income(UserID, Date, Value,Detail)\n"
                + "Values (?,?,?,?,?);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userid);
            ps.setDate(2, date);
            ps.setInt(3, value);
            ps.setString(4, detail);
            ps.setInt(5, CategoryID);
            rs = ps.executeQuery();
            
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;
        } catch (Exception e) {
        }
        return false;
    }
}
