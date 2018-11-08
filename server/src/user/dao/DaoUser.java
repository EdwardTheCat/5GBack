package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import db_connection.DbAcces;
import user.business.User;


public class DaoUser {


	public void createUser (User user) throws SQLException {

		try {
			Class.forName(DbAcces.jdbcDriver);
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	

			String sql = "insert into 5g.user values (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = connect.prepareStatement(sql);

			LocalDateTime currentTime = LocalDateTime.now();
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/YY - hh:mm");
			String formattedString1 = currentTime.format(formatter1);

			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/YY");
			String formattedString2 = currentTime.format(formatter2);


			ps.setInt		(1, user.getId());
			ps.setString	(2, user.getName());
			ps.setString	(3, user.getFirstname());
			ps.setString	(4, user.getMail());
			ps.setString	(5, user.getLogin());
			ps.setString	(6, user.getPassword());
			ps.setBoolean	(7, user.isActive());
			ps.setBoolean	(8, user.isAdmin());
			ps.setString	(9, formattedString1);
			ps.setString	(10,formattedString2);
			ps.setString	(11, user.getStatus());
			ps.setString	(12, user.getToken());
			
			ps.executeUpdate();

			System.out.println(user);

			ps.close();
			close();
			connect = null;

		}catch (ClassNotFoundException e) {
			System.out.println("problème de valeur");



		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
			e.printStackTrace();

		}


	}



//	public void deleteUser (User user){
//
//		try {
//			Class.forName(DbAcces.jdbcDriver);
//			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	
//
//			int user_id = user.getUser_id();
//
//			String sql = "DELETE FROM USER WHERE user_id =" + user_id;
//
//			Statement stmt = connect.createStatement();
//
//			stmt.executeUpdate(sql);
//
//			stmt.close();
//			close();
//			connect = null;
//
//		}  catch (ClassNotFoundException e) {
//			System.out.println("problème de valeur");
//
//
//		} catch (SQLException e) {
//			System.out.println("Mauvaise connexion");
//			e.printStackTrace();
//		}
//	}
//
//
//	public Users selectAllUsers (){
//
//
//		Users users = new Users();
//
//		try {
//			Class.forName(DbAcces.jdbcDriver);
//			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	
//
//			String sql = ("select * from 5g.user");
//
//			Statement stmt = connect.createStatement();
//
//			ResultSet rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//
//				int user_id 					= rs.getInt("user_id");
//				String user_name 				= rs.getString("user_name");
//				String user_first_name			= rs.getString("user_first_name");
//				String user_password 			= rs.getString("user_password");
//				String user_mail				= rs.getString("user_mail");
//				boolean user_active				= rs.getBoolean("user_active");
//				boolean user_admin				= rs.getBoolean("user_admin");
//				boolean user_online				= rs.getBoolean("user_online");
//				Timestamp ts1 = rs.getTimestamp("user_last_connection");
//				LocalDateTime user_last_connection		= ts1.toLocalDateTime();
//
//				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yy");	
//				LocalDate user_creation			= LocalDate.parse(rs.getString("user_creation"), formatter2);
//
//				User user = new User (user_id, user_name, user_first_name, user_password, user_mail, user_active, user_admin, user_online, user_last_connection, user_creation);
//
//				users.add(user);
//
//
//			}
//
//			System.out.println("liste users depuis methode select de daoUser : "+ users);
//
//
//		}  catch (ClassNotFoundException e) {
//			System.out.println("problème de valeur");
//
//
//		} catch (SQLException e) {
//			System.out.println("Mauvaise connexion");
//
//		}
//
//		return users;
//
//	}
//

//	public void updateUser (User user){
//
//		try {
//			Class.forName(DbAcces.jdbcDriver);
//			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");
//			
//			int user_id = user.getUser_id();
//			String user_name = user.getUser_name();
//			String user__first_name = user.getUser_first_name();
//			String user_mail = user.getUser_mail();
//			boolean user_active = user.isUser_active();
//			boolean user_admin = user.isUser_admin();
//
////			int refDoc = document.getRefDoc();
////			int refCat = document.getRefCat();
//
//			String sql = "UPDATE 5g.user SET user_name = '" + user_name +   "'WHERE user_id = '" + user_id + "'";
//			
//			
////			
////			CREATE TABLE user (
////				     user_id INT NOT NULL AUTO_INCREMENT,
////				     user_name VARCHAR(30) NOT NULL,
////				     user_first_name VARCHAR(30),
////				     user_mail VARCHAR(50) NOT NULL,
////				     user_password VARCHAR(10),
////				     user_active BOOLEAN DEFAULT 1,
////				     user_admin BOOLEAN DEFAULT 0,
////				     user_online BOOLEAN DEFAULT 0,
////				     user_last_connection TIMESTAMP,
////				     user_creation VARCHAR(30),
////					 PRIMARY KEY (user_id)
////				) ;
//
//			Statement stmt = connect.createStatement();
//
//			stmt.executeUpdate(sql);
//
//			stmt.close();
//			connect.close();
//			connect = null;
//
//		}  catch (ClassNotFoundException e) {
//			System.out.println("problème de valeur");
//
//
//		} catch (SQLException e) {
//			System.out.println("Mauvaise connexion");
//			e.printStackTrace();
//		}
//	}






	public void close() throws SQLException {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	
		try {
			if (!connect.isClosed()) connect.close();
		} catch (SQLException e) {
			System.out.println("=== AccesBdD : Probleme close connection");
			e.printStackTrace();
		}
	}

}




