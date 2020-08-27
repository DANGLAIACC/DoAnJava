package KetNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class run {
	public static Connection connection;
	// login SQL with full parameter
	public run(String computer,String database, String user, String pass) {
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
			System.out.println("Lỗi: "+e.getMessage());
		}
	}
	// Login SQL without user and password
	public run(String computer,String database)
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
//			System.out.println("Lỗi: "+e.getMessage());
		}
	}
	
	public run()
	{
		connection = null;
		String url = "jdbc:sqlserver://DANG_LAI\\NTTU:1433;"
				+ "databaseName=ThiTracNghiem;integratedSecurity=true;";
		try {
			Class.forName(
			"com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
//			System.out.println("Lỗi: "+e.getMessage());
		}
	}
	
/*	TEST CODE
	public static void main(String[] args)
	{
		new run("DANG_LAI\\NTTU", "ThiTracNghiem");
		if (connection==null)
			System.out.println("Kết nối thất bại!");
		else
			System.out.println("Kết nối thành công!");
		
	}*/
	
}
