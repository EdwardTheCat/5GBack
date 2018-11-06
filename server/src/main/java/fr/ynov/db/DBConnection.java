package fr.ynov.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.ynov.db_connection.DbAcces;

public class DBConnection {

	private static Connection instance;

	//Ajout sur l'url de paramètres permettant au driver de dialoguer avec le server quelque soit la timezone.
	private String url = "jdbc:mysql://localhost:3306/5g?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	private DBConnection() {
		try {
			Class.forName(DbAcces.jdbcDriver);
			this.instance = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found : createMessage ");
		} catch (SQLException e) {
			System.out.println("SQL error : createMessage");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("error : createMessage");
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if(instance==null) {
			new DBConnection();
		}
		
		return instance;
	}

	public void close() throws SQLException {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/5g?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");	
		try {
			if (!connect.isClosed()) connect.close();
		} catch (SQLException e) {
			System.out.println("=== AccesBdD : Probleme close connection");
			e.printStackTrace();
		}
	}

}
