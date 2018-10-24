package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import db_connection.DbAcces;
import user.business.User;

public class DaoUser {


	public void createUser (User user) throws SQLException {

		try {
			Class.forName(DbAcces.jdbcDriver);
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	

			String sql = "insert into 5g.user values (?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = connect.prepareStatement(sql);

			LocalDateTime currentTime = LocalDateTime.now();
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/YY - hh:mm");
			String formattedString1 = currentTime.format(formatter1);
			
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/YY");
			String formattedString2 = currentTime.format(formatter2);
				

			ps.setInt		(1, user.getUser_id());
			ps.setString	(2, user.getUser_name());
			ps.setString	(3, user.getUser_first_name());
			ps.setString	(4, user.getUser_mail());
			ps.setString	(5, user.getUser_password());
			ps.setBoolean	(6, user.isUser_active());
			ps.setBoolean	(7, user.isUser_admin());
			ps.setBoolean	(8, user.isUser_online());
			ps.setString	(9, formattedString1);
			ps.setString	(10,formattedString2);

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


	
	public void deleteUser (User user){

		try {
			Class.forName(DbAcces.jdbcDriver);
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	

			int user_id = user.getUser_id();

			String sql = "DELETE FROM USER WHERE user_id =" + user_id;

			Statement stmt = connect.createStatement();

			stmt.executeUpdate(sql);

			stmt.close();
			close();
			connect = null;

		}  catch (ClassNotFoundException e) {
			System.out.println("problème de valeur");


		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
			e.printStackTrace();
		}
	}




	
	
	
	
	
	
	
	
	
	
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




