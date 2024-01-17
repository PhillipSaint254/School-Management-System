/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication14.addCourse.populateDepartments;
import static javaapplication14.indexPage.coursesQuery;
import static javaapplication14.indexPage.departmentsQuery;
import static javaapplication14.indexPage.getConnection;
import static javaapplication14.indexPage.populateSchool;
import static javaapplication14.indexPage.schoolsQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class studentForm extends javax.swing.JFrame {

    /**
     * Creates new form studentForm
     */
    private static ArrayList<school> all_schools;
    private static ArrayList<department> all_departments;
    private static ArrayList<course> all_courses;
    public studentForm() {
        try {
            initComponents();
            all_schools = new ArrayList<school>();
            Connection con = getConnection();
            ResultSet schools = schoolsQuery();
            ResultSet departments;
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("select count(*) from school");
            res.next();
            String[] allSchools = new String[res.getInt(1)];
            int x = 0;
            while (schools.next()) {
                allSchools[x] = (String) schools.getObject("school_name");
                x++;
            }
            schoolsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allSchools));
            
            int selectedIndex = schoolsCombo.getSelectedIndex();
            String school_code = populateSchool().get(selectedIndex).getCode();
            departments = departmentsQuery(school_code);
            Statement st2 = con.createStatement();
            ResultSet res2 = st2.executeQuery("SELECT * FROM department WHERE school_code = '" + school_code + "';");
            int no_rows = 0;
            while (res2.next()){
                no_rows ++;
            }
            String[] allDepartments = new String[no_rows];
            int y = 0;
            while (departments.next()) {
                allDepartments[y] = (String) departments.getObject("department_name");
                y++;
            }
            departmentsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allDepartments));
            
            ResultSet courses; 
            int sch_si = schoolsCombo.getSelectedIndex();
            int dep_si = departmentsCombo.getSelectedIndex();
            department dep = populateDepartments(sch_si).get(dep_si);
            String sch_code = populateSchool().get(sch_si).getCode();
            String course_code = populateCourse(sch_code, dep).get(coursesCombo.getSelectedIndex()).getCourseCode();
            courses = coursesQuery(school_code, populateDepartments(sch_si).get(dep_si).getDepartmentCode());
            Statement st3 = con.createStatement();
            ResultSet res3 = st3.executeQuery("SELECT * FROM course WHERE school_code = '" + school_code + "' && department_code = '" 
                    + populateDepartments(sch_si).get(dep_si).getDepartmentCode() + "';");
            int no_rows3 = 0;
            String adm_init = "";
            while (res3.next()){
                adm_init = res3.getString("course_code");
                no_rows3 ++;
            }
            String[] allCourses = new String[no_rows3];
            int z = 0;
            while (courses.next()) {
                allCourses[z] = (String) courses.getObject("course_name");
                z++;
            }
            coursesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allCourses));
            reg_no.setText(generateAdmNo(adm_init));
            reg_no.setEditable(false);
            String[] sem = {"1","2","3"};
            String[] year = {"1","2","3","4"};
            yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(year));
            semesterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(sem));
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static ArrayList<course> populateCourse(String sch, department deps) throws Exception{
        Connection con = getConnection();
        Statement st = con.createStatement();
        all_courses = new ArrayList<course>();
        ResultSet res = st.executeQuery("SELECT * FROM course WHERE school_code = '" + sch + "' && department_code = '" + deps.getDepartmentCode() + "';");
        int y = 0;
        while (res.next()){
            course new_course = new course(res.getString("course_name"), res.getString("course_code"), res.getInt("no_of_student"), 
                    deps.getDepartmentName(), deps.getDepartmentCode(), deps.getDepNumberOfStudents(), deps.getName(), deps.getCode(), 
                    deps.getNumberOfStudents());
            all_courses.add(new_course);
        }
        return all_courses;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        schoolsCombo = new javax.swing.JComboBox<>();
        departmentsCombo = new javax.swing.JComboBox<>();
        coursesCombo = new javax.swing.JComboBox<>();
        first_name = new javax.swing.JTextField();
        last_name = new javax.swing.JTextField();
        reg_no = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        yearCombo = new javax.swing.JComboBox<>();
        semesterCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setText("add student");

        jLabel2.setText("school");

        jLabel3.setText("department");

        jLabel4.setText("course");

        jLabel5.setText("first name");

        jLabel6.setText("reg no");

        jLabel7.setText("last name");

        schoolsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        schoolsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolsComboActionPerformed(evt);
            }
        });

        departmentsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        departmentsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentsComboActionPerformed(evt);
            }
        });

        coursesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        coursesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesComboActionPerformed(evt);
            }
        });

        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        semesterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("semester");

        jLabel9.setText("year");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(semesterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(coursesCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departmentsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(schoolsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(reg_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(schoolsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(coursesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semesterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reg_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void schoolsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolsComboActionPerformed
        try {
            Connection con = getConnection();
            int selectedIndex = schoolsCombo.getSelectedIndex();
            String school_code = populateSchool().get(selectedIndex).getCode();
            ResultSet departments = departmentsQuery(school_code);
            departments = departmentsQuery(school_code);
            Statement st2 = con.createStatement();
            ResultSet res2 = st2.executeQuery("SELECT * FROM department WHERE school_code = '" + school_code + "';");
            //        res2.last();
            int no_rows = 0;
            while (res2.next()){
                no_rows ++;
            }
            String[] allDepartments = new String[no_rows];
            int y = 0;
            while (departments.next()) {
                allDepartments[y] = (String) departments.getObject("department_name");
                y++;
            }
            departmentsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allDepartments));
            
            ResultSet courses; 
            int sch_si = schoolsCombo.getSelectedIndex();
            int dep_si = departmentsCombo.getSelectedIndex();
            department dep = populateDepartments(sch_si).get(dep_si);
            String sch_code = populateSchool().get(sch_si).getCode();
            String course_code = populateCourse(sch_code, dep).get(coursesCombo.getSelectedIndex()).getCourseCode();
            courses = coursesQuery(school_code, populateDepartments(sch_si).get(dep_si).getDepartmentCode());
            Statement st3 = con.createStatement();
            ResultSet res3 = st3.executeQuery("SELECT * FROM course WHERE school_code = '" + school_code + "' && department_code = '" 
                    + populateDepartments(sch_si).get(dep_si).getDepartmentCode() + "';");
            int no_rows3 = 0;
            while (res3.next()){
                no_rows3 ++;
            }
            String[] allCourses = new String[no_rows3];
            int z = 0;
            while (courses.next()) {
                allCourses[z] = (String) courses.getObject("course_name");
                z++;
            }
            coursesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allCourses));
            coursesCombo.setSelectedIndex(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_schoolsComboActionPerformed

    private void departmentsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentsComboActionPerformed
        try { 
            Connection con = getConnection();
            ResultSet courses;
            int selectedIndex = schoolsCombo.getSelectedIndex();
            String school_code = populateSchool().get(selectedIndex).getCode();
            int sch_si = schoolsCombo.getSelectedIndex();
            int dep_si = departmentsCombo.getSelectedIndex();
            
            department dep = populateDepartments(sch_si).get(dep_si);
            String sch_code = populateSchool().get(sch_si).getCode();
            String course_code = populateCourse(sch_code, dep).get(coursesCombo.getSelectedIndex()).getCourseCode();
            courses = coursesQuery(school_code, populateDepartments(sch_si).get(dep_si).getDepartmentCode());
            Statement st3 = con.createStatement();
            
            ResultSet res3 = st3.executeQuery("SELECT * FROM course WHERE school_code = '" + school_code + "' && department_code = '" 
                    + populateDepartments(sch_si).get(dep_si).getDepartmentCode() + "';");
            
            int no_rows3 = 0;
            while (res3.next()){
                no_rows3 ++;
            }
            String[] allCourses = new String[no_rows3];
            int z = 0;
            while (courses.next()) {
                allCourses[z] = (String) courses.getObject("course_name");
                z++;
            }
            coursesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allCourses));
            coursesCombo.setSelectedIndex(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_departmentsComboActionPerformed

    private void coursesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesComboActionPerformed
        try{
            Statement st3 = getConnection().createStatement();
            int sch_si = schoolsCombo.getSelectedIndex();
            int dep_si = departmentsCombo.getSelectedIndex();
            department dep = populateDepartments(sch_si).get(dep_si);
            String sch_code = populateSchool().get(sch_si).getCode();
            String course_code = populateCourse(sch_code, dep).get(coursesCombo.getSelectedIndex()).getCourseCode();
            ResultSet res3 = st3.executeQuery("SELECT * FROM course WHERE school_code = '" + sch_code + "' && department_code = '" 
                        + populateDepartments(sch_si).get(dep_si).getDepartmentCode() + "' && course_code = '" + course_code + "';");
            int no_rows3 = 0;
            String adm_init = "";
            while (res3.next()){
                adm_init = res3.getString("course_code");
                no_rows3 ++;
            }
            reg_no.setText(generateAdmNo(adm_init));
            reg_no.setEditable(false);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_coursesComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            String fn = first_name.getText().trim().toLowerCase();
            String ln = last_name.getText().trim().toLowerCase();
            String rn = reg_no.getText().trim().toLowerCase();
            
    //        (String school, String department, String course, String regNo,String firstName, String lastName, String password)
            String sch = populateSchool().get(schoolsCombo.getSelectedIndex()).getCode();
            department dep = populateDepartments(schoolsCombo.getSelectedIndex()).get(departmentsCombo.getSelectedIndex());
            String course_code = populateCourse(sch, dep).get(coursesCombo.getSelectedIndex()).getCourseCode();
            int year = yearCombo.getSelectedIndex() + 1;
            int sem = semesterCombo.getSelectedIndex() + 1;
            System.out.println("here********");
            new student(sch, dep.getDepartmentCode(), course_code, rn, year, sem, fn, ln, rn.toUpperCase());
            JOptionPane.showMessageDialog(null, "record succsessfully saved");
            
            this.dispose();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        try {
            reg_no.setEditable(true);
            int sch_si = schoolsCombo.getSelectedIndex();
            int dep_si = departmentsCombo.getSelectedIndex();
            String sch_code = populateSchool().get(sch_si).getCode();
            ResultSet res3 = getConnection().createStatement().executeQuery("SELECT * FROM course WHERE school_code = '" + sch_code + "' && department_code = '"
                    + populateDepartments(sch_si).get(dep_si).getDepartmentCode() + "';");
            int no_rows3 = 0;
            String adm_init = "";
            if (res3.next()){
                adm_init = res3.getString("course_code");
                reg_no.setText(generateAdmNo(adm_init));
            }
        } catch (Exception ex) {
            Logger.getLogger(studentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_yearComboActionPerformed

    public String generateAdmNo(String init){
        String adm_no = "";
        String end = "/22";
        if (yearCombo.getSelectedIndex() == 1){
            end = "/21";
        } else if (yearCombo.getSelectedIndex() == 2){
            end = "/20";
        } else if (yearCombo.getSelectedIndex() == 3){
            end = "/19";
        }
        try{
            Connection con = getConnection();
            Statement query = con.createStatement();
            String search = "select reg_no from student where course = '" + init + "' && reg_no like '%" + end + "' order by reg_no Desc;";
            ResultSet res = query.executeQuery(search);
//            jtable
            if (res.next()){
                adm_no = res.getString("reg_no");
                int num = Integer.parseInt(adm_no.split("/")[1]) + 1;
                int x = num;
                int y = 0;
                while (x != 0){
                    x /= 10;
                    y ++;
                }
                String new_code = "";
                while (y < 5){
                    new_code += "0"; 
                    y++;
                }
                adm_no = init + '/' + new_code + num + end;
            } else {
                adm_no = init + "/00001" + end;
            }
        } catch (Exception e){
            adm_no = init + "/00001" + end;
        }
        return adm_no;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(studentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> coursesCombo;
    private javax.swing.JComboBox<String> departmentsCombo;
    private javax.swing.JTextField first_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField last_name;
    private javax.swing.JTextField reg_no;
    private javax.swing.JComboBox<String> schoolsCombo;
    private javax.swing.JComboBox<String> semesterCombo;
    private javax.swing.JComboBox<String> yearCombo;
    // End of variables declaration//GEN-END:variables
}
