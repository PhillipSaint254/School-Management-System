/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication14;

/**
 *
 * @author ABC
 */
public class school {
    private String schoolName;
    private String schoolCode;
    private int schNumberOfStudents;

    public school(String name, String code, int numberOfStudents) {
        this.schoolName = name;
        this.schoolCode = code;
        this.schNumberOfStudents = numberOfStudents;
    }

    public String getName() {
        return schoolName;
    }

    public void setName(String name) {
        this.schoolName = name;
    }

    public String getCode() {
        return schoolCode;
    }

    public void setCode(String code) {
        this.schoolCode = code;
    }

    public int getNumberOfStudents() {
        return schNumberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.schNumberOfStudents = numberOfStudents;
    }
}
