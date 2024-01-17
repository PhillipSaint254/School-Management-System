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
public class student extends user {
    private String regNo;
    private String school;
    private String department;
    private String course;
    private int year;
    private int semester;

    public student(String school, String department, String course, String regNo, int year, int semester, String firstName, String lastName, String password) throws Exception {
        super(true, false, false, false, false, firstName, lastName, password);
        this.regNo = regNo;
        this.school = school;
        this.department = department;
        this.course = course;
        this.year = year;
        this.semester = semester;
        saveToDatabase(school, department, course, regNo, year, semester, firstName, lastName, password);
    }

    public void saveToDatabase(String school, String department, String course, String regNo, int year, int semester, String firstName, String lastName, String pass) throws Exception{
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
        if (flag == 1 && pass.isBlank()){
            String values = "VALUES('" + regNo + "', '" + school + "', '" + department + "', '" + course + "', '" + userID + "', '" + year + "','" + semester + "');";
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO student(reg_no, school, department, course, userID, year, semester) "
                    + values);
            pstmt.executeUpdate();
            System.out.println("Student object saved to database");
        } else if (flag > 1) JOptionPane.showMessageDialog(null, "User already exists!");
        else JOptionPane.showMessageDialog(null, "Error! This record may not exist");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
