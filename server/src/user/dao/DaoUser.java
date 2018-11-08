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


	public void deleteUser (User user){

		try {
			Class.forName(DbAcces.jdbcDriver);
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g","apo","1239");	

			int id = user.getId();

			String sql = "DELETE FROM USER WHERE user_id =" + id;

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


	public Users selectAllUsers (){

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

			System.out.println("liste users depuis methode select de daoUser : "+ users);

		}  catch (ClassNotFoundException e) {
			System.out.println("problème de valeur");

		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
		}
		return users;
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




