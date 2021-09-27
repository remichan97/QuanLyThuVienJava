package Controller;

import java.sql.*;



public class Database {
    private String db = "jdbc:mysql://localhost:3306/quanlythuvien";
    private String user = "root";
    private String pw = "";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(db, user, pw);
    }
}
