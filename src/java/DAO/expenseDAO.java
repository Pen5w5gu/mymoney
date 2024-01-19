/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import context.DBContext;
import entity.Expense;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class expenseDAO {
     Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Expense> getExpenseByUserid(int userid) {
        List<Expense> list = new ArrayList<>();
        String query = "select * from Expense\n"
                + "where [UserID] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            while (true) {
                list.add(new Expense(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getNString(5)));
            }
        } catch (Exception e) {
        }
        return list;
}

public boolean insertExpense(int userid, Date date, int value, String detail) {
        String query = "Insert into Expense(UserID, Date, Value,Detail)\n"
                + "Values (?,?,?,?);";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userid);
            ps.setDate(2, date);
            ps.setInt(3, value);
            ps.setString(4, detail);
            rs = ps.executeQuery();
            
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;
        } catch (Exception e) {
        }
        return false;
    }
}