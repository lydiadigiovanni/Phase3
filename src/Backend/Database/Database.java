package Backend.Database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Backend.Grade.Grade;

/**
 * WARNING:
 * YOU MUST HAVE "DummyUser" IN THE student_information DATABASE TABLE IN THE COLLUMN "studentUsername" IN ORDER FOR THE CODE TO WORK.
 */
public class Database {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/mydb";

    /**
     * simple helper method to save time
     * @return
     */
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

    /**
     * unfortunately never used
     */
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
     */
    public static String getCurrentUserGrade() {
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT studentGrade FROM student_information WHERE studentUserName = 'DummyUser'");
        while(rs.next()) {
            return rs.getString("studentGrade");
        }
        return "grade failed";        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method logs in the user, so this is meant to be called for the login button.
     * This set's the current users username in DummyUsers testVariable, and the current users grade in the DummyUsers grade
     */
    public static boolean loginUser(String username, String password) {
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;        
    }

    /**
     * Used along side login user to set the current user's username and grade to DummyUser
     */
    public static void modifyDummyUser(String username, String grade) {
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate("UPDATE student_information SET studentTestVariable = '" + username + "' WHERE studentUserName = 'DummyUser'");
            st.executeUpdate("UPDATE student_information SET studentGrade = '" + grade + "' WHERE studentUserName = 'DummyUser'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * This creates the user, maded  for the create account button, establishes all of that information to the database
     */
    public static void createUser(String userName, String grade, String password, String securityAnswerOne, String securityAnswerTwo) { 
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Made for the switch grade for the grade button in profile page
     */
    public static void updateUserGrade(String grade) {
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate("UPDATE student_information SET studentGrade = '" + grade + "' WHERE studentUserName = 'DummyUser'");
            st.executeUpdate("UPDATE student_information SET studentGrade = '" + grade + "' WHERE studentUserName = '" + getCurrentUsername() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

    /**
     * Get's current username from DummyUser, basically a helper method
     */
    public static String getCurrentUsername() {
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT studentTestVariable from student_information WHERE studentUserName = 'DummyUser'");
            rs.next();
            return rs.getString("studentTestVariable");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This is the map progress, or the check marks for the map if they're completed it or not.
     * this returns the entire map progress as a boolean since when loading 
     */
    public static Boolean[] getMapProgress(String map)  {
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    /**
     * set's the respective map progress to true if it's true
     */
    public static void setCheckmarkBoolean(int checkmarkindex, String mapName)  {
        connection = getConnection();
        Statement st;
        try {
            st = connection.createStatement();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    /**
     * An easy way to get the exact grade child we need. 
     * uses reflection to create the grade object
     * @return
     */
    public static Grade getCurrentUserGradeClass() {
        Class<?> clazz;
        Grade grade = null;
        try {
            clazz = Class.forName("Backend.Grade.Grade" + Database.getCurrentUserGrade());
            grade = (Grade) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return grade;
    }

    /**
     * Set's the user's assignment grade based on the paramaters
     */
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

    /**
     * Get's the assignment grade, for checking if the user got a better grade or not during the test 
     */
    public static int getAssignmentGrade(String firstLetters, String lastLetter) { 
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT " + getCurrentUserGrade() + firstLetters.toLowerCase() + lastLetter.toLowerCase() + " FROM student_information WHERE studentUserName = '" + getCurrentUsername() + "'");
            rs.next();
            return rs.getInt(getCurrentUserGrade() + firstLetters.toLowerCase() + lastLetter.toLowerCase());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Get's all of the users grades to display on the profile screen
     * @return
     */
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

    /**
     * self explanitory, sets avatar in database
     * @param id
     */
    public static void setAvatar(String id) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE student_information SET avatarProfile = '" + id + "' WHERE studentUserName = '" + getCurrentUsername() + "'");
        } catch (SQLException e) {
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
            e.printStackTrace();
        }
        return null;
    }   


    /**
     * Gets username, used for the reset password
     * @param username
     * @return
     */
    public static String getUsername(String username) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_information WHERE studentUserName = '" + username + "'");
            while(rs.next()) {
                return rs.getString("studentUserName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get's the security answer, used for reset password
     * @param username
     * @return
     */
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

    
    /**
     * used in reset password
     */
    public static void setPassword(String username, String password) {
        connection = getConnection();
        try {
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE student_information SET studentPassword = '" + password + "' WHERE studentUserName = '" + username + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
