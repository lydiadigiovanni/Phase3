package Backend.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/mydb";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = java.sql.DriverManager.getConnection(url, "root", "password");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getCurrentUserGrade() throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT studentGrade FROM student_information WHERE studentUserName = 'Testing1'");
        while(rs.next()) {
            return rs.getString("studentGrade");
        }
        return "grade failed";        
    }


    public static void insertUser(String userName, String grade) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO student_information (studentUserName, studentGrade) VALUES ('" + userName + "', '" + grade + "')");
    }

    public static void createUser(String userName, String grade, String password, String securityAnswerOne, String securityAnswerTwo) throws SQLException { 
        connection = getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO student_information (studentUserName, studentGrade, studentPassword, securityAnswerOne, securityAnswerTwo) VALUES ('" + userName + "', '" + grade + "', '" + password + "', '" + securityAnswerOne + "', '" + securityAnswerTwo + "')");
        st.executeUpdate("INSERT INTO ki_map1 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
        st.executeUpdate("INSERT INTO ki_map2 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
        st.executeUpdate("INSERT INTO ki_map3 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
        st.executeUpdate("INSERT INTO fs_map1 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
        st.executeUpdate("INSERT INTO fs_map2 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
        st.executeUpdate("INSERT INTO fs_map3 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
        st.executeUpdate("INSERT INTO tf_map1 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
        st.executeUpdate("INSERT INTO tf_map2 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
        st.executeUpdate("INSERT INTO tf_map3 (studentUserName, tutorialOneProgress, practiceOneProgress, tutorialTwoProgress, practiceTwoProgress, testProgress) VALUES('" + userName + "', '0', '0', '0', '0', '0')");
    }

    public static void updateUserGrade(String userName, String grade) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate("UPDATE student_information SET studentGrade = '" + grade + "' WHERE studentUserName = '" + userName + "'");
    }

    public static Boolean[] getMapProgress(String userName, String grade, String map) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM " + grade + "_" + map + " WHERE studentUserName = '" + userName + "'");
        while(rs.next()) {
            Boolean[] progress = new Boolean[5];
            progress[0] = rs.getBoolean("tutorialOneProgress");
            progress[1] = rs.getBoolean("practiceOneProgress");
            progress[2] = rs.getBoolean("tutorialTwoProgress");
            progress[3] = rs.getBoolean("practiceTwoProgress");
            progress[4] = rs.getBoolean("testProgress");
            return progress;
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            //createUser("TestUser1", "Ki", "Password", "Spaghetti", "Also Spaghetti");
            Boolean progress[] = getMapProgress("TestUser1", "ki", "map1");
            System.out.println(progress[0]);
            System.out.println(progress[1]);
            System.out.println(progress[2]);
            System.out.println(progress[3]);
            System.out.println(progress[4]);
            //updateUserGrade("Testing1", "Ki");
            //System.out.println(getCurrentUserGrade());
            //insertUser("Testing1", "Ki");
            //updateUserGrade("Testing1", "FS");
            //System.out.println(getCurrentUserGrade());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    
}
