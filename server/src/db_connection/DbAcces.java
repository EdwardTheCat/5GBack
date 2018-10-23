package db_connection;


public class DbAcces {

	public final static String jdbcDriver = "com.mysql.jdbc.Driver";
	public final static String jdbc  = "jdbc:mysql://localhost/5g";
	public final static String dbUser = "apo";
	public final static String dbPass = "1239";



	public String getConnectionString () {
		return jdbc + "," + dbUser + "," + dbPass;
	}


}








