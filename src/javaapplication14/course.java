/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

/**
 *
 * @author ABC
 */
public class course extends department {
    private String courseName;
    private String courseCode;
    private int courseNumberOfStudents;

    public course(String courseName, String courseCode, int courseNumberOfStudents, String departmentName, String departmentCode, int depNumberOfStudents, String name, String code, int numberOfStudents) {
        super(departmentName, departmentCode, depNumberOfStudents, name, code, numberOfStudents);
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseNumberOfStudents = courseNumberOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseNumberOfStudents() {
        return courseNumberOfStudents;
    }

    public void setCourseNumberOfStudents(int courseNumberOfStudents) {
        this.courseNumberOfStudents = courseNumberOfStudents;
    }
}
