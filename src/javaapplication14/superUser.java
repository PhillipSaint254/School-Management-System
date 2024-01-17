/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;
import java.sql.*;
import static javaapplication14.user.getConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class superUser extends user {
    private String superUserNo;

    public superUser(String superUserNo, String firstName, String lastName, String password) throws Exception {
        super(true, true, true, true, false, firstName, lastName, password);
        this.superUserNo = superUserNo;
        
        saveToDatabase(superUserNo, firstName, lastName);
    }
    
    public void saveToDatabase(String superUserNo, String firstName, String lastName) throws Exception{
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
            String values = "VALUES('" + superUserNo + "','" + userID + "')";
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO super_user(sup_code, userID) "
                    + values);
            pstmt.executeUpdate();
            System.out.println("Superuser object saved to database");
        } else if (flag > 1) JOptionPane.showMessageDialog(null, "User already exists!");
        else JOptionPane.showMessageDialog(null, "Error! This record may not exist");
        
    }

    public String getSuperUserNo() {
        return superUserNo;
    }

    public void setSuperUserNo(String superUserNo) {
        this.superUserNo = superUserNo;
    }
    
}
