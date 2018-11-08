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

			String sql = "insert into 5g.user values (?,?,?,?,?,?,?,?,?,?,?,?)";


			PreparedStatement ps = connect.prepareStatement(sql);

			LocalDateTime currentTime2 = LocalDateTime.now();

			LocalDateTime currentTime = LocalDateTime.now();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm" );
			String formattedString = currentTime2.format(formatter);
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/YY");
			String formattedString2 = currentTime.format(formatter2);

			ps.setInt		(1, 0);
			ps.setString	(2, "titi");
			ps.setString	(3, "toto");
			ps.setString	(4, "toto@toto.com");
			ps.setString	(5, "logToto");
			ps.setString	(6, "123");
			ps.setBoolean	(7, true);
			ps.setBoolean	(8, false);
			ps.setString	(9, formattedString);
			ps.setString	(10,formattedString2);
			ps.setString	(11, "En ligne");
			ps.setString	(12, "123ABC");

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

			int user_id = 1;

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

				int id 										= rs.getInt("user_id");
				String name 								= rs.getString("user_name");
				String firstname							= rs.getString("user_first_name");
				String password 							= rs.getString("user_password");
				String mail									= rs.getString("user_mail");
				boolean isActive							= rs.getBoolean("user_active");
				boolean isAdmin								= rs.getBoolean("user_admin");
				Timestamp ts1 								= rs.getTimestamp("user_last_connection");
				LocalDateTime lastConnectionDate			= ts1.toLocalDateTime();
				DateTimeFormatter formatter2 				= DateTimeFormatter.ofPattern("dd/MM/yy");	
				LocalDate creationDate						= LocalDate.parse(rs.getString("user_creation"), formatter2);
				String status								= rs.getString("user_status");
				String token								= rs.getString("user_token");
				String login								= rs.getString("user_login");
				

				User user = new User (id, name, firstname, mail, password, isActive, isAdmin, lastConnectionDate, creationDate, status, token, login);

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









