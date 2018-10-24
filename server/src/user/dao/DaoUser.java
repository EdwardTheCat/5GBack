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

			String sql = "insert into 5g.user values (?,?,?,?,?,?,?,?)";

			PreparedStatement ps = connect.prepareStatement(sql);

			LocalDateTime currentTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YY - hh:mm" );
			String formattedString = currentTime.format(formatter);

			ps.setInt		(1, user.getUser_id());
			ps.setString	(2, user.getUser_name());
			ps.setString	(3, user.getUser_first_name());
			ps.setString	(4, user.getUser_mail());
			ps.setString	(5, user.getUser_password());
			ps.setBoolean	(6, user.isUser_active());
			ps.setBoolean	(7, user.isUser_admin());
			ps.setBoolean	(8, user.isUser_online());
			ps.setString	(8,formattedString);

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




