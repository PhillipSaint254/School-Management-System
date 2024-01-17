/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication14.indexPage.getConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class unit {
    String unitName;
    String unitCode;
    String courseCode;
    String departmentCode;
    String schoolCode;
    int lec_user_id;
    int year;
    int semester;

    public unit(String unitName, String unitCode, String courseCode, String departmentCode, String schoolCode, int lec_user_id, int year, int semester) {
        this.unitName = unitName;
        this.unitCode = unitCode;
        this.courseCode = courseCode;
        this.departmentCode = departmentCode;
        this.schoolCode = schoolCode;
        this.lec_user_id = lec_user_id;
        this.year = year;
        this.semester = semester;
        
        saveToDatabase(unitName, unitCode, courseCode, departmentCode, schoolCode, lec_user_id, year, semester);
    }
    
    public static void saveToDatabase(String unitName, String unitCode, String courseCode, String departmentCode, String schoolCode, int lec_user_id, int year, int semester){
        try{
            Connection con = getConnection();
            ResultSet currentUnit = con.createStatement().executeQuery("SELECT * FROM unit WHERE unit_name = '" + unitName + "' && unit_code = '" +
                    unitCode + "' && course_code = '" + courseCode + "' && department_code = '" + departmentCode + "' && school_code = '" + 
                    schoolCode + "';");
            if (currentUnit.next()){
                System.out.println("unit not saved as it already exists.");
            } else {
                PreparedStatement st = con.prepareStatement("INSERT INTO unit(unit_name, unit_code, course_code, department_code, school_code, lecUserID, year, semester) "
                        + "VALUES('" + unitName + "', '" + unitCode + "', '" + courseCode + "', '" 
                        + departmentCode + "', '" + schoolCode + "', '" + lec_user_id + "', '" + year + "', '" + semester + "');");
                st.executeUpdate();
            }
        } catch (Exception ex){
            Logger.getLogger(addUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getLec_user_id() {
        return lec_user_id;
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

    public unit(int lec_user_id) {
        this.lec_user_id = lec_user_id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }
    
}
