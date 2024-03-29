/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication14;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication14.addCourse.populateDepartments;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */

public final class indexPage extends javax.swing.JFrame {

    /**
     * Creates new form indexPage
     */
    private static ArrayList<department> all_departments;
    
    private static ArrayList<school> all_schools;
    
    public indexPage() throws Exception {
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
        System.out.println(school_code);
        ResultSet res2 = st2.executeQuery("SELECT * FROM department WHERE school_code = '" + school_code + "';");
//        res2.last();
        int no_rows = 0;
        while (res2.next()){
            System.out.println(res2.getString("department_name"));
            no_rows ++;
        }
        String[] allDepartments = new String[no_rows];
        System.out.println(no_rows);
        int y = 0;
        while (departments.next()) {
            allDepartments[y] = (String) departments.getObject("department_name");
            y++;
        }
        departmentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allDepartments));
        departmentCombo.setSelectedIndex(0);
    }
    
    public static ArrayList<school> populateSchool() throws Exception{
        Connection con = getConnection();
        Statement st = con.createStatement();
        all_schools = new ArrayList<school>();
        ResultSet res = st.executeQuery("SELECT * FROM school");
        while (res.next()){
            school new_school = new school(res.getString("school_name"), res.getString("school_code"), res.getInt("no_of_student"));
            all_schools.add(new_school);
        }
        return all_schools;
    }
    
    public static ResultSet coursesQuery(String school_code, String department_code) throws Exception{
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet results = st.executeQuery("select * from course where school_code = '" + school_code + "' && department_code = '" + department_code + "';");
            return results;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
    public static ResultSet departmentsQuery(String school_code) throws Exception{
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet results = st.executeQuery("select * from department where school_code = '" + school_code + "';");
            return results;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
    public static ResultSet schoolsQuery() throws Exception{
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet results = st.executeQuery("select * from school");
            return results;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        courseSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResults = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        coursesTextArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        schoolsCombo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        departmentCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        jLabel1.setText("search for course");

        courseSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseSearchActionPerformed(evt);
            }
        });

        jButton1.setText("search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(courseSearch)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 270, 200));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Results will appear here");
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel2.setText("Results page");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Results will appear here");
        jScrollPane3.setViewportView(jTextArea2);

        searchResults.setColumns(20);
        searchResults.setRows(5);
        searchResults.setText("Results will appear here");
        jScrollPane1.setViewportView(searchResults);

        coursesTextArea.setColumns(20);
        coursesTextArea.setRows(5);
        jScrollPane7.setViewportView(coursesTextArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addGap(304, 304, 304)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane7)))
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 410, 540));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        jLabel5.setText("school");

        schoolsCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        schoolsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolsComboActionPerformed(evt);
            }
        });
        jScrollPane5.setViewportView(schoolsCombo);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 270, 120));

        jPanel2.setOpaque(false);

        jButton4.setBackground(new java.awt.Color(0, 0, 255));
        jButton4.setText("Contact");

        jButton2.setBackground(new java.awt.Color(0, 255, 0));
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setText("About");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 110));

        departmentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        departmentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboActionPerformed(evt);
            }
        });
        jScrollPane4.setViewportView(departmentCombo);

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        jLabel6.setText("department");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 270, 110));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication14/graduation-g025150f13_1920.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 660));

        jMenu1.setText("View");

        jMenuItem3.setText("View Courses");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("View Departments");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("View Lecturers");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Profile");

        jMenuItem1.setText("Login");
        jMenu3.add(jMenuItem1);

        jMenuItem6.setText("Exit");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void courseSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String search = courseSearch.getText();
            searchResults.setText("");
            ResultSet res = getConnection().createStatement().executeQuery("SELECT * FROM course WHERE course_name LIKE '%" + search + "%'");
            while (res.next()){
                ResultSet school = getConnection().createStatement().executeQuery("SELECT school_name FROM school WHERE school_code = '" + res.getString("school_code") + "'");
                ResultSet department = getConnection().createStatement().executeQuery("SELECT department_name FROM department WHERE department_code = '" + res.getString("department_code") + "' && school_code = '" + res.getString("school_code") + "'");
                school.next();
                department.next();
                System.out.println(res.getString("course_name"));
                searchResults.append(school.getString("school_name") + "\n");
                searchResults.append(department.getString("department_name") + "\n");
                searchResults.append(res.getString("course_name") + "\n\n");
            }
            searchResults.setFont(new Font("Serif", Font.BOLD, 16));
            searchResults.setEditable(false);
            searchResults.setBackground(new Color(204,204,204));
        } catch (Exception ex) {
            Logger.getLogger(indexPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new logIn().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void schoolsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolsComboActionPerformed
        try {
            Connection con = getConnection();
            int selectedIndex = schoolsCombo.getSelectedIndex();
            String school_code = populateSchool().get(selectedIndex).getCode();
            ResultSet departments = departmentsQuery(school_code);
            departments = departmentsQuery(school_code);
            Statement st2 = con.createStatement();
            System.out.println(school_code);
            ResultSet res2 = st2.executeQuery("SELECT * FROM department WHERE school_code = '" + school_code + "';");
            int no_rows = 0;
            while (res2.next()){
                System.out.println(res2.getString("department_name"));
                no_rows ++;
            }
            String[] allDepartments = new String[no_rows];
            System.out.println(no_rows);
            int y = 0;
            while (departments.next()) {
                allDepartments[y] = (String) departments.getObject("department_name");
                y++;
            }
            departmentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allDepartments));
            departmentCombo.setSelectedIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(indexPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_schoolsComboActionPerformed

    private void departmentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboActionPerformed
        try {
            int selectedIndex = departmentCombo.getSelectedIndex();
            String sc = populateSchool().get(schoolsCombo.getSelectedIndex()).getCode();
            String dc = populateDepartments(schoolsCombo.getSelectedIndex()).get(selectedIndex).getDepartmentCode();
            coursesTextArea.setText("");
            ResultSet results = getConnection().createStatement().executeQuery("SELECT * FROM course WHERE department_code = '" + dc + "' && school_code = '" + sc + "';");
            while (results.next()){
                coursesTextArea.append(results.getString("course_name") + "\n");
            }
            coursesTextArea.setFont(new Font("Serif", Font.BOLD, 16));
            coursesTextArea.setEditable(false);
            coursesTextArea.setBackground(new Color(204,204,204));
        } catch (Exception ex) {
            Logger.getLogger(indexPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_departmentComboActionPerformed
    
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
            java.util.logging.Logger.getLogger(indexPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(indexPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(indexPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(indexPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new indexPage().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(indexPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField courseSearch;
    private javax.swing.JTextArea coursesTextArea;
    private javax.swing.JComboBox<String> departmentCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JComboBox<String> schoolsCombo;
    private javax.swing.JTextArea searchResults;
    // End of variables declaration//GEN-END:variables
}
