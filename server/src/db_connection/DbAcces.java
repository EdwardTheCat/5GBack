package db_connection;

public class DbAcces {

	public final static String jdbcDriver = "com.mysql.jdbc.Driver";
	public final static String jdbc  = "jdbc:mysql://localhost:3306/5g";
	public final static String dbUser = "apo";
	public final static String dbPass = "1239";
	public final static String connectionString ="\"jdbc:mysql://localhost:3306/5g\",\"apo\",\"1239\"";


	public String getConnectionString () {
		return jdbc + "," + dbUser + "," + dbPass;
	}

	
	
//    private static final Logger logger = Logger.getLogger(DbAcces.class.getName());
//
//    private static String driver = "com.mysql.jdbc.Driver";
//    private static String url = "jdbc:mysql://localhost:3306/5g";
//    private static String pwd = "1239";
//    private static String user = "apo";
//    private static Connection connect;
//
//    public DbAcces() {
//    }
//
//    public static Connection getConnection(){
//        try {
//            if(connect == null) {
//                Class.forName(driver);
//                connect = DriverManager.getConnection(url, user, pwd);
//            }
//        } catch (SQLException e) {
//            logger.log(Level.SEVERE, "", e);
//        } catch (ClassNotFoundException e) {
//            logger.log(Level.SEVERE, "", e);
//        }
//        return connect;
//    }
}











