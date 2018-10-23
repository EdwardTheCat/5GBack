package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db_connection.DbAcces;
import user.business.User;

public class DaoUser {

	DbAcces dbAcces = new DbAcces();
	public void createUser (User user) throws SQLException {

		try {
			Class.forName(DbAcces.jdbcDriver);
			Connection connect = DriverManager.getConnection(dbAcces.getConnectionString());	

			//TODO : verifier si besoin de gerer ici l'auto-increment alors qu'il est deja gere en base
			String sql = "insert into 5g.user values (?,?,?,?)";


			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_first_name());
			ps.setString(3, user.getUser_mail());
			ps.setString(4, user.getUser_password());

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
		Connection connect = DriverManager.getConnection(dbAcces.getConnectionString());	
		try {
			if (!connect.isClosed()) connect.close();
		} catch (SQLException e) {
			System.out.println("=== AccesBdD : Probleme close connection");
			e.printStackTrace();
		}
	}
	
}




