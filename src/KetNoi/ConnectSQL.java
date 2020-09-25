package KetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL {

    public static Connection connection;
    private static String computer = "TTTV-02\\SQLEXPRESS01";
    // login SQL with full parameter

    public ConnectSQL(String computer, String database, String user, String pass) {
        connection = null;
        String url = String.format("jdbc:sqlserver:%s:1433; databasename=%s; username=%s; password=",
                computer, database, user, pass);
        try {
            Class.forName(
                    "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi kết nối sql: " + e.getMessage());
        }
    }
    // Login SQL without user and password

    public ConnectSQL(String computer, String database) {
        connection = null;
        String url = String.format("jdbc:sqlserver://%s:1433;"
                + "databaseName=%s;"
                + "integratedSecurity=true;",
                computer, database);
        try {
            Class.forName(
                    "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi kết nối sql: " + e.getMessage());
        }
    }

    public ConnectSQL() {
        connection = null;
        String url = String.format("jdbc:sqlserver://%s:1433;"
                + "databaseName=%s;"
                + "integratedSecurity=true;",
                computer, "ThiTracNghiem");

        try {
            Class.forName(
                    "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi kết nối sql: " + e.getMessage());
        }
    }

    /*	TEST CODE*/
    public static void main(String[] args) {
        ConnectSQL connectSQL;
        connectSQL = new ConnectSQL(computer, "ThiTracNghiem");
        if (connection == null) {
            System.out.println("Kết nối thất bại!");
        } else {
            System.out.println("Kết nối thành công!");
        }
    }

}
