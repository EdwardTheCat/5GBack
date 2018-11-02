package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import db_connection.DbAcces;
import user.business.User;
import user.business.Users;




public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		createUserTest();
		deleteUserTest();
		selectAllUsersTest();


	}


	public static void createUserTest() {

		try {
			Class.forName(DbAcces.jdbcDriver);
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	

			String sql = "insert into 5g.user values (?,?,?,?,?,?,?,?,?,?)";


			PreparedStatement ps = connect.prepareStatement(sql);

			LocalDateTime currentTime2 = LocalDateTime.now();

			LocalDateTime currentTime = LocalDateTime.now();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm" );
			String formattedString = currentTime2.format(formatter);
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/YY");
			String formattedString2 = currentTime.format(formatter2);

			ps.setInt		(1, 0);
			ps.setString	(2, "toto");
			ps.setString	(3, "Paulo");
			ps.setString	(4, "coucou@123.fr");
			ps.setString	(5, "kkk");
			ps.setBoolean	(6, true);
			ps.setBoolean	(7, false);
			ps.setBoolean	(8, false);
			ps.setString 	(9, formattedString);
			ps.setString	(10,formattedString2);

			ps.executeUpdate();

			ps.close();
			connect.close();
			connect = null;

			System.out.println("test create user termine");

		} catch (ClassNotFoundException e) {
			System.out.println("problème de valeur");


		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
			e.printStackTrace();
		}

	}


	public static void deleteUserTest () {

		try {
			Class.forName(DbAcces.jdbcDriver);
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	

			int user_id = 3;

			String sql = "DELETE FROM USER WHERE user_id =" + user_id;

			Statement stmt = connect.createStatement();

			stmt.executeUpdate(sql);

			stmt.close();
			connect.close();
			connect = null;

		}  catch (ClassNotFoundException e) {
			System.out.println("problème de valeur");


		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
			e.printStackTrace();
		}

		System.out.println("test delete user termine");
	}




//TODO recuperer les booleens
	public static Users selectAllUsersTest(){


		Users users = new Users();

		try {
			Class.forName(DbAcces.jdbcDriver);
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	

			String sql = ("select * from 5g.user");

			Statement stmt = connect.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int user_id 					= rs.getInt("user_id");
				String user_name 				= rs.getString("user_name");
				String user_first_name			= rs.getString("user_first_name");
				String user_password 			= rs.getString("user_password");
				String user_mail				= rs.getString("user_mail");
				boolean user_active				= rs.getBoolean("user_active");
				boolean user_admin				= rs.getBoolean("user_admin");
				boolean user_online				= rs.getBoolean("user_online");
				Timestamp ts1 = rs.getTimestamp("user_last_connection");
				LocalDateTime user_last_connection		= ts1.toLocalDateTime();

				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yy");	
				LocalDate user_creation			= LocalDate.parse(rs.getString("user_creation"), formatter2);

				User user = new User (user_id, user_name, user_first_name, user_password, user_mail, user_active, user_admin, user_online, user_last_connection, user_creation);

				users.add(user);


			}

			System.out.println("liste users depuis methode selectTest de test : "+ users);


		}  catch (ClassNotFoundException e) {
			System.out.println("problème de valeur");


		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");

		}

		return users;

	}








}









