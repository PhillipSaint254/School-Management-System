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
import static javaapplication14.studentForm.populateCourse;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class addUnit extends javax.swing.JFrame {

    /**
     * Creates new form addUnit
     */
    private static ArrayList<school> all_schools;
    private static ArrayList<department> all_departments;
    private static ArrayList<course> all_courses;
    private static ArrayList<lecturer> lecs;
    public addUnit() {
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
            String[] sem = {"1","2","3"};
            String[] year = {"1","2","3","4"};
            yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(year));
            semesterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(sem));
            
            ResultSet res4 = con.createStatement().executeQuery("select * from user where is_lecturer = true && is_admin = false");
            ResultSet lecturers = con.createStatement().executeQuery("select * from user where is_lecturer = true && is_admin = false");
            
            int a = 0;
            while (res4.next()) {
                a++;
            }
            String[] all_lecturers = new String[a];
            int index = 0;
            while (lecturers.next()){
                all_lecturers[index] = (String) lecturers.getObject("firstname") + " " + lecturers.getString("lastname");
                index++;
            }
            lecturerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(all_lecturers));
        } catch (Exception ex) {
            Logger.getLogger(addUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel7 = new javax.swing.JLabel();
        schoolsCombo = new javax.swing.JComboBox<>();
        departmentsCombo = new javax.swing.JComboBox<>();
        coursesCombo = new javax.swing.JComboBox<>();
        unit_name = new javax.swing.JTextField();
        unit_code = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        yearCombo = new javax.swing.JComboBox<>();
        semesterCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lecturerCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setText("add unit");

        jLabel2.setText("school");

        jLabel3.setText("department");

        jLabel4.setText("course");

        jLabel5.setText("unit name");

        jLabel7.setText("unit code");

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

        semesterCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("year");

        jLabel8.setText("semester");

        jLabel9.setText("lecturer");

        lecturerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(coursesCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departmentsCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(schoolsCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(semesterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(unit_name, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addComponent(unit_code, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lecturerCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(75, Short.MAX_VALUE))
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
                    .addComponent(jLabel3)
                    .addComponent(departmentsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(coursesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(semesterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lecturerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unit_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(unit_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_departmentsComboActionPerformed

    private void coursesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesComboActionPerformed

    }//GEN-LAST:event_coursesComboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            String un = unit_name.getText().trim().toLowerCase();
            String uc = unit_code.getText().trim().toLowerCase();
            
            String sch = populateSchool().get(schoolsCombo.getSelectedIndex()).getCode();
            department dep = populateDepartments(schoolsCombo.getSelectedIndex()).get(departmentsCombo.getSelectedIndex());
            String course_code = populateCourse(sch, dep).get(coursesCombo.getSelectedIndex()).getCourseCode();
            int lec_user_id = getLecturers().get(lecturerCombo.getSelectedIndex()).getLec_user_id();
            ArrayList<lecturer> lecs = getLecturers();
//            String lec_names = lecs.get(lecturerCombo.getSelectedIndex()).getFirstName() + lecs.get(lecturerCombo.getSelectedIndex()).getLastName();
            
//            System.out.println("Department " + dep.getDepartmentName());
//            System.out.println("School " + sch);
            
            int year = yearCombo.getSelectedIndex() + 1;
            int sem = semesterCombo.getSelectedIndex() + 1;
            
            new unit(un, uc, course_code, dep.getDepartmentCode(), sch, lec_user_id, year, sem);
            JOptionPane.showMessageDialog(null, "record succsessfully saved");
            unit_name.setText("");
            unit_code.setText("");
            
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static ArrayList<lecturer> getLecturers(){
        
        try {
            ResultSet usersQuery = getConnection().createStatement().executeQuery("select * from user where is_lecturer = true && is_admin = false");
            ResultSet lecQuery = getConnection().createStatement().executeQuery("select * from lecturer");
            lecs = new ArrayList<lecturer>();
            while(usersQuery.next()){
                lecQuery.next();
                lecturer lec = new lecturer(lecQuery.getString("lec_no"), usersQuery.getString("firstname"), usersQuery.getString("lastname"), "");
                lec.setLec_user_id(lecQuery.getInt("userID"));
                lecs.add(lec);
            }
            return lecs;
        } catch (Exception ex) {
            Logger.getLogger(addUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            java.util.logging.Logger.getLogger(addUnit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addUnit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addUnit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addUnit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addUnit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> coursesCombo;
    private javax.swing.JComboBox<String> departmentsCombo;
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
    private javax.swing.JComboBox<String> lecturerCombo;
    private javax.swing.JComboBox<String> schoolsCombo;
    private javax.swing.JComboBox<String> semesterCombo;
    private javax.swing.JTextField unit_code;
    private javax.swing.JTextField unit_name;
    private javax.swing.JComboBox<String> yearCombo;
    // End of variables declaration//GEN-END:variables
}
