package KetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL {
	public static Connection connection;
	// login SQL with full parameter
	public ConnectSQL(String computer,String database, String user, String pass) {
		connection = null;
		String url = "jdbc:sqlserver:"+computer+":1433;"
				+ "databasename="+database
				+ ";username="+user
				+ ";password="+pass;
		try {
			Class.forName(
			"com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Lỗi kết nối sql: "+e.getMessage());
		}
	}
	// Login SQL without user and password
	public ConnectSQL(String computer,String database)
	{
		connection = null;
		String url = "jdbc:sqlserver://"+computer+":1433;"
				+ "databaseName="+database
				+ ";integratedSecurity=true;";
		try {
			Class.forName(
			"com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println("Lỗi kết nối sql: "+e.getMessage());
		}
	}
	
	public ConnectSQL()
	{
		connection = null;
		String url = "jdbc:sqlserver://DANGLAI_PC\\DANGLAI_PC:1433;"
				+ "databaseName=ThiTracNghiem;integratedSecurity=true;";
		try {
			Class.forName(
			"com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println("Lỗi kết nối sql: "+e.getMessage());
		}
	}
	
/*	TEST CODE*/
        
	public static void main(String[] args)
	{
		new ConnectSQL("DANGLAI_PC\\DANGLAI_PC", "ThiTracNghiem");
		if (connection==null)
			System.out.println("Kết nối thất bại!");
		else
			System.out.println("Kết nối thành công!");
		
	}
	
}
