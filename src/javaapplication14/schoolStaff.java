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
public class schoolStaff extends user {
    private String schoolStaffNo;

    public schoolStaff(String schoolStaffNo,String firstName, String lastName, String password) throws Exception {
        super(false, false, false, true, false, firstName, lastName, password);
        this.schoolStaffNo = schoolStaffNo;
        saveToDatabase(schoolStaffNo, firstName, lastName);
    }

    public void saveToDatabase(String schoolStaffNo, String firstName, String lastName) throws Exception{
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
            String values = "VALUES('" + schoolStaffNo + "','" + userID + "')";
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO school_staff(staff_no, userID) "
                    + values);
            pstmt.executeUpdate();
            System.out.println("School staff object saved to database");
        } else if (flag > 1) JOptionPane.showMessageDialog(null, "User already exists!");
        else JOptionPane.showMessageDialog(null, "Error! This record may not exist");
        
    }
    
    public String getSchoolStaffNo() {
        return schoolStaffNo;
    }

    public void setSchoolStaffNo(String schoolStaffNo) {
        this.schoolStaffNo = schoolStaffNo;
    }
    
}
