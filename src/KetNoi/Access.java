package KetNoi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Access {

    public Connection connection;
    private final String pwd = "danglai"; //4JwP}h'x5+_BBh(g
    private File file;
    private final String resource = "/data/database.accdb";
    private String strPath = "";
    public Access() {
        URL res = getClass().getResource(resource);
        if (res.toString().startsWith("jar:")) {
            withJar();
        } else {
            nonJar();
        }
        
    }

    private void withJar() {
        try {
            InputStream input = getClass().getResourceAsStream(resource);
            file = File.createTempFile("lsdfjsdjkfl", ".accdb");
            strPath = file.getAbsolutePath();
            connection = DriverManager.getConnection("jdbc:ucanaccess://" + strPath);
            System.out.println("withJar: " + strPath);
            new Scanner(System.in).nextLine();
            input.close();
            file.deleteOnExit();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Access.withJar(): "+e.getMessage());
            e.printStackTrace();
        }
    }

    private void nonJar() { 
        try {
            strPath = getClass().getResource("/data/database.accdb").toString();
            strPath = strPath.substring(6, strPath.length());
            
            connection = DriverManager.getConnection("jdbc:ucanaccess://" + strPath);

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối cơ sở dữ liệu.");
            System.out.println("Access.Access(): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi chung chung: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("nonJar: " + strPath);
    }

    public static void main(String[] args) {
        Access access = new Access();
    }

}
