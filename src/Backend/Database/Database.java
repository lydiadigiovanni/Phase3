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

    public static void updateUserGrade(String userName, String grade) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate("UPDATE student_information SET studentGrade = '" + grade + "' WHERE studentUserName = '" + userName + "'");
    }

    public static void main(String[] args) {
        try {
            updateUserGrade("Testing1", "Ki");
            System.out.println(getCurrentUserGrade());
            //insertUser("Testing1", "Ki");
            updateUserGrade("Testing1", "FS");
            System.out.println(getCurrentUserGrade());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    
}
