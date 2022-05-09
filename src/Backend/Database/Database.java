package Backend.Database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Backend.Grade.Grade;

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

    /**
     * This gets the current user, which will be the "dummy data" user who we'll get the information of
     * @return
     * @throws SQLException
     */
    public static String getCurrentUserGrade() throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT studentGrade FROM student_information WHERE studentUserName = 'DummyUser'");
        while(rs.next()) {
            return rs.getString("studentGrade");
        }
        return "grade failed";        
    }

    public static boolean loginUser(String username, String password) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT studentPassword FROM student_information WHERE studentUserName = '" + username + "'");
        while(rs.next()) {
            String databasePassword = rs.getString("studentPassword"); 
            if (databasePassword.equalsIgnoreCase(password)) {
                ResultSet rs2 = st.executeQuery("SELECT studentGrade FROM student_information WHERE studentUserName = '" + username + "'");
                while(rs2.next()) {
                    modifyDummyUser(username, rs2.getString("studentGrade"));
                    return true;
                }
            }
        }
        return false;        
    }

    public static void modifyDummyUser(String username, String grade) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate("UPDATE student_information SET studentTestVariable = '" + username + "' WHERE studentUserName = 'DummyUser'");
        st.executeUpdate("UPDATE student_information SET studentGrade = '" + grade + "' WHERE studentUserName = 'DummyUser'");
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

    public static void updateUserGrade(String grade) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate("UPDATE student_information SET studentGrade = '" + grade + "' WHERE studentUserName = 'DummyUser'");
        st.executeUpdate("UPDATE student_information SET studentGrade = '" + grade + "' WHERE studentUserName = '" + getCurrentUsername() + "'");
    }

    public static String getCurrentUsername() throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT studentTestVariable from student_information WHERE studentUserName = 'DummyUser'");
        rs.next();
            return rs.getString("studentTestVariable");
    }

    public static Boolean[] getMapProgress(String map) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM " + getCurrentUserGrade().toLowerCase() + "_" + map.toLowerCase() + " WHERE studentUserName = '" + getCurrentUsername() + "'");
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

    public static void setCheckmarkBoolean(int checkmarkindex, String mapName) throws SQLException {
        connection = getConnection();
        Statement st = connection.createStatement();
        switch (checkmarkindex) {
            case 0:
                st.executeUpdate("UPDATE " + getCurrentUserGrade().toLowerCase() + "_" + mapName.toLowerCase() + " SET tutorialOneProgress = '1' WHERE studentUserName = '" + getCurrentUsername() + "'");
                break;
            case 1:
                st.executeUpdate("UPDATE " + getCurrentUserGrade().toLowerCase() + "_" + mapName.toLowerCase() + " SET practiceOneProgress = '1' WHERE studentUserName = '" + getCurrentUsername() + "'");
                break;
            case 2:
                st.executeUpdate("UPDATE " + getCurrentUserGrade().toLowerCase() + "_" + mapName.toLowerCase() + " SET tutorialTwoProgress = '1' WHERE studentUserName = '" + getCurrentUsername() + "'");
                break;
            case 3:
                st.executeUpdate("UPDATE " + getCurrentUserGrade().toLowerCase() + "_" + mapName.toLowerCase() + " SET practiceTwoProgress = '1' WHERE studentUserName = '" + getCurrentUsername() + "'");
                break;
            case 4:
                st.executeUpdate("UPDATE " + getCurrentUserGrade().toLowerCase() + "_" + mapName.toLowerCase() + " SET testProgress = '1' WHERE studentUserName = '" + getCurrentUsername() + "'");
                break;
            default:
                break;
        }
    }

    public static Grade getCurrentUserGradeClass() {
        Class<?> clazz;
        Grade grade = null;
        try {
            clazz = Class.forName("Backend.Grade.Grade" + Database.getCurrentUserGrade());
            grade = (Grade) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return grade;
    }

    public static void setAssigmentGrade(String firstLetters, String lastLetter, int assignmentGrade) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE student_information SET " + getCurrentUserGrade() + firstLetters.toLowerCase() + lastLetter.toLowerCase() + " = '" + assignmentGrade + "' WHERE studentUserName = '" + getCurrentUsername() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int[] getAssignmentGrades() {
        int[] grades = new int[9];
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_information WHERE studentUserName = '" + getCurrentUsername() + "'");
            while(rs.next()) {
                grades[0] = rs.getInt("kitest1");
                grades[1] = rs.getInt("kitest3");
                grades[2] = rs.getInt("kitest5");
                grades[3] = rs.getInt("fstest1");
                grades[4] = rs.getInt("fstest3");
                grades[5] = rs.getInt("fstest5");
                grades[6] = rs.getInt("tftest1");
                grades[7] = rs.getInt("tftest3");
                grades[8] = rs.getInt("tftest5");
            }

            return grades;
       } catch (SQLException e) {
        e.printStackTrace();
        }
        return grades;
    }

    public static void setAvatar(String id) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE student_information SET avatarProfile = '" + id + "' WHERE studentUserName = '" + getCurrentUsername() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getCurrentAvatar() {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_information WHERE studentUserName = '" + getCurrentUsername() + "'");
            while(rs.next()) {
                return rs.getString("avatarProfile");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }   


    public static String getUsername(String username) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_information WHERE studentUserName = '" + username + "'");
            while(rs.next()) {
                return rs.getString("studentUserName");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static String getSecurityAnswerOne(String username) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_information WHERE studentUserName = '" + username + "'");
            while(rs.next()) {
                return rs.getString("securityAnswerOne");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSecurityAnswerTwo(String username) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_information WHERE studentUserName = '" + username + "'");
            while(rs.next()) {
                return rs.getString("securityAnswerTwo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setPassword(String username, String password) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE student_information SET studentPassword = '" + password + "' WHERE studentUserName = '" + username + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
