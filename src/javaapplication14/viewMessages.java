/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication14;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ABC
 */
import static javaapplication14.indexPage.getConnection;
import static javaapplication14.studentLogin.getUser;
import static javax.swing.UIManager.getInt;
public class viewMessages extends javax.swing.JFrame {
private static ArrayList<messageBP> allMessages;
private static ArrayList<messageBP> unreadMessages;
private static ArrayList<user> allLecs;
    /**
     * Creates new form viewMessages
     */
    public viewMessages() {
        try {
            initComponents();
            String[] allMessageList = new String[allMessages.size()];
            String[] unreadMessageList = new String[unreadMessages.size()];
            int y = 0;
            for (int x = 0; x < allMessages.size(); x++){
                ResultSet User = getUserByID(allMessages.get(x).getFrom_user_id());
                allMessageList[x] = User.getObject("firstname") + " " + User.getObject("lastname");
                if (!allMessages.get(x).getRead_status()){
                    unreadMessageList[y] = User.getObject("firstname") + " " + User.getObject("lastname");
                    y++;
                }
            }
            allMesoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(allMessageList));
            replyMessage.setModel(new javax.swing.DefaultComboBoxModel<>(allMessageList));
            
            String[] receivers = new String[allLecs.size()];
            for (int x = 0; x < allLecs.size(); x++){
                receivers[x] = allLecs.get(x).getFirstName() + " " + allLecs.get(x).getLastName();
                System.out.println(allLecs.get(x).getFirstName());
            }
            unreadSender.setModel(new javax.swing.DefaultComboBoxModel<>(receivers));
        } catch (SQLException ex) {
            Logger.getLogger(viewMessages.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            String[] noMeso = {"No messages yet."};
            allMesoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(noMeso));
            unreadSender.setModel(new javax.swing.DefaultComboBoxModel<>(noMeso));
        }
    }
    
    public static ResultSet getUserByID(int ID){
        try {
            ResultSet User = getConnection().createStatement().executeQuery("SELECT * FROM user WHERE userID = '" + ID + "';");
            User.next();
            return User;
        } catch (Exception ex) {
            Logger.getLogger(viewMessages.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        unreadArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        unreadSender = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        allMesoCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        replyMessage = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        replyArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setText("view messages");

        unreadArea.setColumns(20);
        unreadArea.setRows(5);
        jScrollPane1.setViewportView(unreadArea);

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel2.setText("reply messages");

        unreadSender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        unreadSender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unreadSenderActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel3.setText("unread messages");

        jLabel4.setText("select sender");

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel5.setText("all messages");

        jLabel6.setText("select sender");

        allMesoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        allMesoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allMesoComboActionPerformed(evt);
            }
        });

        jLabel7.setText("select receiver");

        replyMessage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        replyMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replyMessageActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel8.setText("write reply");

        jButton1.setText("send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        replyArea.setColumns(20);
        replyArea.setRows(5);
        jScrollPane2.setViewportView(replyArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(unreadSender, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(allMesoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(replyMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(261, 261, 261))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(unreadSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(allMesoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(replyMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 919, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unreadSenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unreadSenderActionPerformed
        int index = unreadSender.getSelectedIndex();
        try{
            unreadArea.setText(unreadMessages.get(index).getMessage());
        } catch (Exception x){
            unreadArea.setText("No new messages");
        }
    }//GEN-LAST:event_unreadSenderActionPerformed

    private void allMesoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allMesoComboActionPerformed
        int index = unreadSender.getSelectedIndex();
        try{
            unreadArea.setText(unreadMessages.get(index).getMessage());
        } catch (Exception x){
            unreadArea.setText("No new messages");
        }
    }//GEN-LAST:event_allMesoComboActionPerformed

    private void replyMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replyMessageActionPerformed
        int index = replyMessage.getSelectedIndex();
        try{
            replyArea.setText(allMessages.get(index).getMessage());
        } catch (Exception x){
            replyArea.setText("No new messages");
        }
    }//GEN-LAST:event_replyMessageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<user> getAllLecs(){
        try{
            allLecs = new ArrayList<user>();
            ResultSet res = getConnection().createStatement().executeQuery("SELECT * FROM user WHERE is_lecturer = true && is_admin = false");
//            (boolean is_student, boolean is_admin, boolean is_lecturer, boolean is_schoolStaff, String firstName, String lastName, String password)
            while (res.next()){
                user lec = new user(false, false, true, false, false, res.getString("firstname"), res.getString("lastname"), "");
                allLecs.add(lec);
            }
            return allLecs;
        } catch (Exception ex){
            Logger.getLogger(viewMessages.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ArrayList<messageBP> getUnreadMessages(){
        try{
            unreadMessages = new ArrayList<messageBP>();
            ResultSet User = getUser();
            User.next();
            int id = User.getInt("userID");
            ResultSet messages = getConnection().createStatement().executeQuery("SELECT * FROM message WHERE read_status = false && to_user_id = '" + id + "' order by -messageID;");
            while (messages.next()){
                messageBP message = new messageBP(messages.getString("message"), messages.getBoolean("read_status"), messages.getInt("to_user_id"), messages.getInt("from_user_id"));
                unreadMessages.add(message);
            }
            return unreadMessages;
        } catch (Exception x){
            return null;
        }
    }
    
    public static ArrayList<messageBP> getAllMessages(){
        try{
            allMessages = new ArrayList<messageBP>();
            ResultSet User = getUser();
            User.next();
            int id = User.getInt("userID");
            ResultSet messages = getConnection().createStatement().executeQuery("SELECT * FROM message WHERE to_user_id = '" + id + "' order by -messageID;");
            while (messages.next()){
                messageBP message = new messageBP(messages.getString("message"), messages.getBoolean("read_status"), messages.getInt("to_user_id"), messages.getInt("from_user_id"));
                allMessages.add(message);
            }
            return allMessages;
        } catch (Exception e){
            return null;   
        }
    }
    
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
            java.util.logging.Logger.getLogger(viewMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewMessages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewMessages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> allMesoCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea replyArea;
    private javax.swing.JComboBox<String> replyMessage;
    private javax.swing.JTextArea unreadArea;
    private javax.swing.JComboBox<String> unreadSender;
    // End of variables declaration//GEN-END:variables
}
