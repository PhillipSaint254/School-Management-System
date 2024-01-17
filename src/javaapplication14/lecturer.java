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
public class lecturer extends user {
    private String lec_number;
    private int lec_user_id;
    
    public lecturer(String lec_number, String firstName, String lastName, String password) throws Exception {
        super(false, false, true, false, false, firstName, lastName, password);
        this.lec_number = lec_number;
        
        saveToDatabase(lec_number, firstName, lastName, password);
    }
    
    public void saveToDatabase(String lec_number, String firstName, String lastName, String password) throws Exception{
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
        if (flag == 1 && !password.isEmpty()){
            String values = "VALUES('" + lec_number + "','" + userID + "')";
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO lecturer(lec_no, userID) "
                    + values);
            pstmt.executeUpdate();
            System.out.println("Lecturer object saved to database");
        } else if (flag < 1) System.out.println("Error! This record may not exist");
        
    }
    
    public int getLec_user_id() {
        return lec_user_id;
    }

    public void setLec_user_id(int lec_user_id) {
        this.lec_user_id = lec_user_id;
    }
    
    public String getLec_number() {
        return lec_number;
    }

    public void setLec_number(String lec_number) {
        this.lec_number = lec_number;
    }
    
}
