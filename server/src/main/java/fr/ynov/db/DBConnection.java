package fr.ynov.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.ynov.db.DBConnection;

/**
 * Class in shape of Singleton to manage a connection to the MySql database
 *
 * @author Audrey and Edward
 * @since v0
 */
public class DBConnection {

    public final static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    /**
     * Instance property : Connection
     */
	private static Connection instance;

    /**
     * Url property : String, (parameters added for Timezone issues between driver and server database)
     */

    public final static String url = "jdbc:mysql://localhost:3306/5g?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * User property : String
     */
    public final static String user = "root";

    /**
     * Password property : String
     */
    public final static String password = "root";

    /**
     * Method which returns a connection whether from instance property or from the connection if null
     * @return instance is java.sql.Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection(){
        try {
	    	if(DBConnection.instance == null) {
	            Class.forName(DBConnection.jdbcDriver);
	            DBConnection.instance = DriverManager.getConnection(url, user, password);
	        }
	    } catch (ClassNotFoundException e) {
			System.out.println("=== AccesBdD : class not found");
			e.printStackTrace();
		} 
        catch (SQLException e) {
			System.out.println("=== AccesBdD : Probleme close connection");
			e.printStackTrace();
		}
        return instance;
    }
	/**
	 * Method which close the connection
	 * 
	 */
	//todo throw an exception
	public void close() throws SQLException {
		try {
			if (!DBConnection.instance.isClosed()) DBConnection.instance.close();
		} catch (SQLException e) {
			System.out.println("=== AccesBdD : Probleme close connection");
			e.printStackTrace();
		}
	}
}

