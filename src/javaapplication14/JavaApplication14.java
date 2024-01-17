/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication14;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ABC
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    private static String face = "";
    private static superUserLogin super_user_form;
    private static adminLogin admin_form;
    private static staffLogin staff_form;
    private static lecturerLogin lec_form;
    private static studentLogin student_form;
    private static indexPage index_form;
    
    public static void main(String[] args) throws Exception  {
        setDisplay();
    }
    
    public static void setDisplay() throws Exception{
        user newUser = getUser();
        
        if (newUser.is_authenticated()){
            if (newUser.is_admin() && newUser.is_lecturer() && newUser.is_schoolStaff() && newUser.is_student()){
                superUserLogin UI = new superUserLogin();
                UI.setVisible(true);
                face = "superUser";
                super_user_form = UI;
            } else if (newUser.is_admin()){
                adminLogin UI = new adminLogin();
                UI.setVisible(true);
                face = "admin";
                admin_form = UI;
            } else if (newUser.is_schoolStaff()){
                staffLogin UI = new staffLogin();
                UI.setVisible(true);
                face = "schoolStaff";
                staff_form = UI;
            } else if (newUser.is_lecturer()){
                lecturerLogin UI = new lecturerLogin();
                UI.setVisible(true);
                face = "lecturer";
                lec_form = UI;
            } else if (newUser.is_student()){
                studentLogin UI = new studentLogin();
                UI.setVisible(true);
                face = "student";
                student_form = UI;
            }
           
            if (index_form != null){
                index_form.dispose();
            }
           
        } else{
            indexPage UI = new indexPage();
            UI.setVisible(true);
            face = "index";
            index_form = UI;
        }
    }
    
    public static void setDisplay(superUserLogin ui) throws Exception{
        user newUser = getUser();
        if (newUser.is_authenticated()){
            if (newUser.is_admin()){
                adminLogin UI = new adminLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "admin";
                admin_form = UI;
            } else if (newUser.is_schoolStaff()){
                staffLogin UI = new staffLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "schoolStaff";
                staff_form = UI;
            } else if (newUser.is_lecturer()){
                lecturerLogin UI = new lecturerLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "lecturer";
                lec_form = UI;
            } else if (newUser.is_student()){
                studentLogin UI = new studentLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "student";
                student_form = UI;
            }
        } else{
            indexPage UI = new indexPage();
            ui.dispose();
            UI.setVisible(true);
            face = "index";
            index_form = UI;
        }
    }
    
    public static void setDisplay(adminLogin ui) throws Exception{
        user newUser = getUser();
        if (newUser.is_authenticated()){
            if (newUser.is_admin() && newUser.is_lecturer() && newUser.is_schoolStaff() && newUser.is_student()){
                superUserLogin UI = new superUserLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "superUser";
                super_user_form = UI;
            } else if (newUser.is_schoolStaff()){
                staffLogin UI = new staffLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "schoolStaff";
                staff_form = UI;
            } else if (newUser.is_lecturer()){
                lecturerLogin UI = new lecturerLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "lecturer";
                lec_form = UI;
            } else if (newUser.is_student()){
                studentLogin UI = new studentLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "student";
                student_form = UI;
            }
        } else{
            indexPage UI = new indexPage();
            ui.dispose();
            UI.setVisible(true);
            face = "index";
            index_form = UI;
        }
    }
    
    public static void setDisplay(staffLogin ui) throws Exception{
        user newUser = getUser();
        if (newUser.is_authenticated()){
            if (newUser.is_admin() && newUser.is_lecturer() && newUser.is_schoolStaff() && newUser.is_student()){
                superUserLogin UI = new superUserLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "superUser";
                super_user_form = UI;
            } else if (newUser.is_admin()){
                adminLogin UI = new adminLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "admin";
                admin_form = UI;
            } else if (newUser.is_lecturer()){
                lecturerLogin UI = new lecturerLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "lecturer";
                lec_form = UI;
            } else if (newUser.is_student()){
                studentLogin UI = new studentLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "student";
                student_form = UI;
            }
        } else{
            indexPage UI = new indexPage();
            ui.dispose();
            UI.setVisible(true);
            face = "index";
            index_form = UI;
        }
    }
    
    public static void setDisplay(lecturerLogin ui) throws Exception{
        user newUser = getUser();
        if (newUser.is_authenticated()){
            if (newUser.is_admin() && newUser.is_lecturer() && newUser.is_schoolStaff() && newUser.is_student()){
                superUserLogin UI = new superUserLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "superUser";
                super_user_form = UI;
            } else if (newUser.is_admin()){
                adminLogin UI = new adminLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "admin";
                admin_form = UI;
            } else if (newUser.is_schoolStaff()){
                staffLogin UI = new staffLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "schoolStaff";
                staff_form = UI;
            } else if (newUser.is_student()){
                studentLogin UI = new studentLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "student";
                student_form = UI;
            }
        } else{
            indexPage UI = new indexPage();
            ui.dispose();
            UI.setVisible(true);
            face = "index";
            index_form = UI;
        }
    }
    
    public static void setDisplay(studentLogin ui) throws Exception{
        user newUser = getUser();
        if (newUser.is_authenticated()){
            if (newUser.is_admin() && newUser.is_lecturer() && newUser.is_schoolStaff() && newUser.is_student()){
                superUserLogin UI = new superUserLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "superUser";
                super_user_form = UI;
            } else if (newUser.is_admin()){
                adminLogin UI = new adminLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "admin";
                admin_form = UI;
            } else if (newUser.is_schoolStaff()){
                staffLogin UI = new staffLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "schoolStaff";
                staff_form = UI;
            } else if (newUser.is_lecturer()){
                lecturerLogin UI = new lecturerLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "lecturer";
                lec_form = UI;
            }
        } else{
            indexPage UI = new indexPage();
            ui.dispose();
            UI.setVisible(true);
            face = "index";
            index_form = UI;
        }
    }
    
    public static void setDisplay(indexPage ui) throws Exception{
        user newUser = getUser();
        if (newUser.is_authenticated()){
            if (newUser.is_admin() && newUser.is_lecturer() && newUser.is_schoolStaff() && newUser.is_student()){
                superUserLogin UI = new superUserLogin();
                ui.dispose();
                face = "superUser";
                super_user_form = UI;
                UI.setVisible(true);
            } else if (newUser.is_admin()){
                adminLogin UI = new adminLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "admin";
                admin_form = UI;
            } else if (newUser.is_schoolStaff()){
                staffLogin UI = new staffLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "schoolStaff";
                staff_form = UI;
            } else if (newUser.is_lecturer()){
                lecturerLogin UI = new lecturerLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "lecturer";
                lec_form = UI;
            } else if (newUser.is_student()){
                studentLogin UI = new studentLogin();
                ui.dispose();
                UI.setVisible(true);
                face = "student";
                student_form = UI;
            }
        }
    }
    
    public static user getUser(){
        user newUser = new user(false, false, false, false, false, "John", "Doe", "");
        try{
            boolean isStudent, isLecturer, isAdmin, isStaff, isSuper, isAuth;
            String fn, ln;
            int userID = 0;
            Connection con = getConnection();
            String search = "SELECT userID FROM authentication WHERE sessionID = 1;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(search);
            if (rs.next()){
                userID = rs.getInt("userID");
                String search2 = "SELECT * FROM user WHERE userID = " + userID + ";";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st.executeQuery(search2);
                if (rs2.next()){
                     isStudent = rs2.getBoolean("is_student");
                     isLecturer = rs2.getBoolean("is_lecturer");
                     isAdmin = rs2.getBoolean("is_admin");
                     isStaff = rs2.getBoolean("is_schoolstaff");
                     isAuth = rs2.getBoolean("is_authenticated");
                     fn = rs2.getString("firstname");
                     ln = rs2.getString("lastname");
                     newUser = new user(isStudent, isAdmin, isLecturer, isStaff, isAuth, fn, ln, "");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return newUser;
    }
    
    public static void logout(){
        user newUser = getUser();
        if (newUser.is_admin() && newUser.is_lecturer() && newUser.is_schoolStaff() && newUser.is_student()){
                face = "superUser";
            } else if (newUser.is_admin()){
                adminLogin UI = new adminLogin();
                face = "admin";
            } else if (newUser.is_schoolStaff()){
                face = "schoolStaff";
            } else if (newUser.is_lecturer()){
                face = "lecturer";
            } else if (newUser.is_student()){
                face = "student";
        }
        try{
            Connection con = getConnection();
            String query = "SELECT userID FROM authentication WHERE sessionID = 1";
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(query);
            int userID = 0;
            if (res.next()){
                userID = res.getInt("userID");
            }
            PreparedStatement stm = con.prepareStatement("UPDATE authentication SET is_authenticated = false where sessionID = 1;");
            stm.executeUpdate();
            PreparedStatement stm2 = con.prepareStatement("UPDATE user SET is_authenticated = false where userID = " + userID);
            stm2.executeUpdate();
            switch (face){
                case "student":
                    setDisplay(student_form);
                    break;
                case "lecturer":
                    setDisplay(lec_form);
                    break;
                case "schoolStaff":
                    setDisplay(staff_form);
                    break;
                case "admin":
                    setDisplay(admin_form);
                    break;
                case "superUser":
                    setDisplay(super_user_form);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "unrecorgnizable user " + face);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public boolean is_authenticated(){
        boolean state = false;
        try{
            Connection con = getConnection();
            String search = "SELECT is_authenricated FROM authentication WHERE sessionID = 1;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(search);
            if (rs.next()){
                state = rs.getBoolean("is_authenticated");
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return state;
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
    
}
