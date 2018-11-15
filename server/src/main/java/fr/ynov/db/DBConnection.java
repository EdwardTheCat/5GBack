package fr.ynov.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.ynov.db.DBConnection;

/**
 * Class in shape of Singleton to manage a connection to the MySql database
 * 
 * @author edward
 * @ since v0
 *
 */
public class DBConnection {

	/**
	 * Instance property : Connection
	 *
	 */
	private static Connection instance;

	/**
	 * Url property : String, (parameters added for Timezone issues between driver and server database)
	 *
	 */

	private String url = "jdbc:mysql://localhost:3306/5g?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	/**
	 * User property : String
	 *
	 */
	private String user = "root";
	
	
	/**
	 * Password property : String
	 *
	 */
	private String password = "root";

	/**
	 * Constructor which creates a connection from the database and assign to instance property
	 */
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.instance = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found : ");
		} catch (SQLException e) {
			System.out.println("SQL error : ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("error : createMessage");
			e.printStackTrace();
		}
	}
	/**
	 * Method which returns a connection whether from instance property or from the constructor if null
	 * @return instance property : Connection
	 */
	public static Connection getInstance() {
		if(instance==null) {
			new DBConnection();
		}
		
		return instance;
	}
	/**
	 * Method which close the connection
	 * 
	 */
	//todo throw an exception
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
