package fr.ynov.db_connection;


public class DbAcces {

	public final static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	public final static String jdbc  = "jdbc:mysql://localhost:3306/5g";
	public final static String dbUser = "root";
	public final static String dbPass = "root";
	public final static String connectionString ="\"jdbc:mysql://localhost:3306/5g\",\"root\",\"root\"";


	public String getConnectionString () {
		return jdbc + "," + dbUser + "," + dbPass;
	}


}