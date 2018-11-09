package fr.ynov.user.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.user.ressources.User;

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


/**
 * Class in shape of DAO to extrat users informations from the database
 * @author Audrey
 * since v0
 */
public class UserProvider {

    private Connection conn;


    /**
     * Constructor.
     * Initialization Singleton of BDD Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public UserProvider() throws SQLException, ClassNotFoundException {
        this.conn = DBConnection.getConnection();
    }

    /**
     * Method which add a user in database
     * @param user
     * @throws SQLException
     */
    public void createUser (User user) throws SQLException {
        String sql = "insert into 5g.user values (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/YY - hh:mm");
        String formattedString1 = currentTime.format(formatter1);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/YY");
        String formattedString2 = currentTime.format(formatter2);

        ps.setInt(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getFirstname());
        ps.setString(4, user.getMail());
        ps.setString(5, user.getLogin());
        ps.setString(6, user.getPassword());
        ps.setBoolean(7, user.isActive());
        ps.setBoolean(8, user.isAdmin());
        ps.setString(9, formattedString1);
        ps.setString(10, formattedString2);
        ps.setString(11, user.getStatus());;

        ps.executeUpdate();

        System.out.println(user);

        ps.close();
    }
    
    
    /**
     * Method which get a user's password from database by user's login
     * @param login
     * @return user (login, password)
     * @throws SQLException
     * @throws ClassNotFoundException
     */
	public User getUserByLogin (String login) throws ClassNotFoundException, SQLException{
		User user = null;
		try {
			String query = "SELECT * FROM 5g.user WHERE user_login = ? ";
			if(conn==null) System.out.println("Connection null");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String password = rs.getString("user_password");
				user = new User (login, password);
				System.out.println(user);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL error : selectuserByLogin");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
		}
		return user;
	}
	
    /**
     * Method which get a user from database by user's id
     * @param id
     * @return user
     * @throws SQLException
     * @throws ClassNotFoundException
     */
	public User getUserById (int id) throws ClassNotFoundException, SQLException{

		User user = null;
		try {
			String query = "SELECT * FROM 5g.user WHERE user_id = ? ";
			if(conn==null) System.out.println("Connection null");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String	name						= rs.getString("user_name");
				String firstname 					= rs.getString("user_first_name");
				String mail							= rs.getString("user_mail");
				String login						= rs.getString("user_login");
				String password						= rs.getString("user_password");
				Boolean isActive					= rs.getBoolean("user_active");
				Boolean isAdmin						= rs.getBoolean("user_admin");
				Timestamp ts1 						= rs.getTimestamp("user_last_connection");
				LocalDateTime lastConnectionDate	= ts1.toLocalDateTime();
				DateTimeFormatter formatter2 		= DateTimeFormatter.ofPattern("dd/MM/yy");	
				LocalDate creationDate				= LocalDate.parse(rs.getString("user_creation"), formatter2);
				String status						= rs.getString("user_status");
				String token						= rs.getString("user_token");

				user = new User (id, name, firstname,mail,password, isActive,isAdmin, lastConnectionDate, creationDate,
						status, token, login);
				System.out.println(user);
			}
			ps.close();

		} catch (SQLException e) {
			System.out.println("SQL error : selectuserById");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
		}
		System.out.println("getUserById : " + user);
		return user;
	}
	
	
    /**
     * Method which delete a user in database
     * @param user
     */
	public void deleteUser (User user){
		
		try {
			int id = user.getId();

			String sql = "DELETE FROM USER WHERE user_id =" + id;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();

		}  catch (ClassNotFoundException e) {
			System.out.println("problème de valeur");

		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
			e.printStackTrace();
		}
	}
	
    /**
     * Method which select all users from database
     * @return users
     */
	public Users selectAllUsers(){

		Users users = new Users();

		try {
			String sql = ("select * from 5g.user");
			Statement stmt = conn.createStatement();
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
			stmt.close();
			System.out.println("liste users : "+ users);
		}  catch (ClassNotFoundException e) {
			System.out.println("problème de valeur");
		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
		}
		return users;
	}
	
	
	
}
