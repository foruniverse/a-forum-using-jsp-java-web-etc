package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

	private static final String USER = "12563";
	private static final String PASSWORD = "";
	
	private static Connection connection = null;
	private static DbHelper helper = null;
	private static Statement statement = null;
	
	private static ResultSet rs = null;
	
	static {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	private DbHelper() throws Exception {
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		statement = connection.createStatement();
	}
	
	public static ResultSet executeQuery(String sql) throws Exception {
		
			//String password = rs.getString(1);
		if (statement != null) {
			rs = statement.executeQuery(sql);
			return rs;
		}
		return null;
	}
	
	public int executeUpdate(String sql) throws Exception {
		
		if (statement != null) {
			return statement.executeUpdate(sql);
		}
		return -1;
	}
	
	public static PreparedStatement prepareStatement(String sql) 
	
			throws Exception {
		PreparedStatement ps = null;
		
		if (connection != null && !connection.isClosed()) {
			ps = connection.prepareStatement(sql);
		}
		return ps;
	}
	
	public static void close()  {
		try {
			
			if (rs != null)
				rs.close();
		
			if (statement != null)
				statement.close();
	
			if (connection != null) 
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			helper = null;
		}
	}

	public static DbHelper getDbHelper() throws Exception {
		if (helper == null)
			helper = new DbHelper();
		return helper;
	}
}
