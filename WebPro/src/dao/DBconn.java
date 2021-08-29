package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBconn {
	public static Connection getConnection() {
//		oracle db 연결설정
//		Connection conn = null;
//		
//		try {
//			Context initContext = new InitialContext();
//			Context envContext  = (Context)initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
//			conn = ds.getConnection();
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		return conn;
		
//		pgadmin db 연결설정
		Connection conn = null;

		String url = "jdbc:postgresql://ec2-44-196-170-156.compute-1.amazonaws.com:5432/d53g6mtdshcd46?currentSchema=cocktail";
        String user = "mwwexoypoowvrt";
        String password = "b040606bcf3b82504f2dad280846c19f595bd8e31ec66b8271415381e062ebba";
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
			
		}catch(Exception ex) {}
	}
	
	public static void close(Connection conn,PreparedStatement ps) {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
			
		}catch(Exception ex) {}
	}
}
