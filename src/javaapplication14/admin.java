/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static javaapplication14.user.getConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class admin extends user {
    private String admin_no;

    public admin(String admin_no, String firstName, String lastName, String password) throws Exception {
        super(false, true, false, false, false, firstName, lastName, password);
        this.admin_no = admin_no;
        
        saveToDatabase(admin_no, firstName, lastName);
    }

    public void saveToDatabase(String admin_no, String firstName, String lastName) throws Exception{
        Connection con = getConnection();
        Statement query = con.createStatement();
        String str = "select userID from user where firstname = '" + firstName + "' && lastname = '" + lastName 
                + "';";
        ResultSet res = query.executeQuery(str);
        int userID = 0;
        int flag = 0;
        while (res.next()){
            userID = res.getInt("userID");
            flag += 1;
        }
        if (flag == 1){
            String values = "VALUES('" + admin_no + "','" + userID + "')";
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO admin(admin_no, userID) "
                    + values);
            pstmt.executeUpdate();
            System.out.println("Admin object saved to database");
        } else if (flag > 1) JOptionPane.showMessageDialog(null, "User already exists!");
        else JOptionPane.showMessageDialog(null, "Error! This record may not exist");
        
    }
    
    public String getAdmin_no() {
        return admin_no;
    }

    public void setAdmin_no(String admin_no) {
        this.admin_no = admin_no;
    }
    
}
