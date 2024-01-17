/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ABC
 */
public class user {
    private String firstName;
    private String lastName;
    private String password;
    private boolean is_student;
    private boolean is_admin;
    private boolean is_lecturer;
    private boolean is_schoolStaff;
    private boolean is_authenticated;
    private boolean is_superuser;

    public user(boolean is_student, boolean is_admin, boolean is_lecturer, boolean is_schoolStaff, boolean is_authenticated, String firstName, String lastName, String password) {
        this.is_student = is_student;
        this.is_admin = is_admin;
        this.is_lecturer = is_lecturer;
        this.is_schoolStaff = is_schoolStaff;
        this.is_authenticated = is_authenticated;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        
        try{
            saveToDatabase(is_student, is_admin, is_lecturer, is_schoolStaff, firstName, lastName, password);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void saveToDatabase(boolean is_student, boolean is_admin, boolean is_lecturer, boolean is_schoolStaff, String firstName, String lastName, String password) throws Exception{
        Connection con = getConnection();
        int std_state = (is_student) ? 1 : 0;
        int stf_state = (is_schoolStaff) ? 1 : 0;
        int lec_state = (is_lecturer) ? 1 : 0;
        int adm_state = (is_admin) ? 1 : 0;
        if (!searchUserExistance(firstName, lastName) && !password.isEmpty()){
            String values = "VALUES('" + firstName + "','" + lastName + "', md5('" + password + "'),'" + std_state + "','" + stf_state + "','" + lec_state + "','" + adm_state + "')";
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO user(firstname,lastname,password,is_student,is_schoolstaff,is_lecturer,is_admin) "
                    + values);
            pstmt.executeUpdate();
        }
    }
    
    public boolean searchUserExistance(String firstName, String lastName) throws Exception{
        Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "select * from user where firstname = '" + firstName + "' && lastname = '" + lastName + "'";
        ResultSet res = st.executeQuery(query);
        boolean exists = false;
        if (res.next()){
            exists = true;
        }
        return exists;
    }
    
    public static Connection getConnection() throws Exception {
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/university";
            String username = "root";
            String password = "Jesus@number1";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        
        return null;
    }

    public boolean is_authenticated() {
        return is_authenticated;
    }

    public void setIs_authenticated(boolean is_authenticated) {
        this.is_authenticated = is_authenticated;
    }

    public boolean is_student() {
        return is_student;
    }

    public void setIs_student(boolean is_student) {
        this.is_student = is_student;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean is_lecturer() {
        return is_lecturer;
    }

    public void setIs_lecturer(boolean is_lecturer) {
        this.is_lecturer = is_lecturer;
    }

    public boolean is_schoolStaff() {
        return is_schoolStaff;
    }

    public void setIs_schoolStaff(boolean is_schoolStaff) {
        this.is_schoolStaff = is_schoolStaff;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
