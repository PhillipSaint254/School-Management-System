/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

/**
 *
 * @author ABC
 */
public class department extends school {
    private String departmentName;
    private String departmentCode;
    private int depNumberOfStudents;

    public department(String departmentName, String departmentCode, int depNumberOfStudents, String name, String code, int numberOfStudents) {
        super(name, code, numberOfStudents);
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.depNumberOfStudents = depNumberOfStudents;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public int getDepNumberOfStudents() {
        return depNumberOfStudents;
    }

    public void setDepNumberOfStudents(int depNumberOfStudents) {
        this.depNumberOfStudents = depNumberOfStudents;
    }

    
}
