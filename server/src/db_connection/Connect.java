//package db_connection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class Connect {
//
//
//	public static void main (String[] args) { 
//
//		final String DB_DRIVER ="com.mysql.jdbc.Driver";
//		
//		Connection conn = null;
//		
//
//
//
//
//
//		try {
//			Class.forName(DB_DRIVER);
//			conn = DriverManager.getConnection("jdbc:mysql://localhost/5g","apo","1239");
//
//		} catch (Exception e){
//
//			System.out.println("Echec !");
//			e.printStackTrace();
//		}
//		if (conn !=null){
//			System.out.println("Connexion OK");
//		}
//
//
//
//	}
//	
//
//
//}
