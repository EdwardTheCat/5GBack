package fr.ynov.user.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.user.ressources.User;
import fr.ynov.user.ressources.Users;

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
 * Class in shape of DAO to extract users informations from the database
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

	public UserProvider(Connection conn) {
		this.conn = conn;
	}

	/**
     * Method which add a user in database
     * @param user
     * @throws SQLException
     */
    public int createUser (User user) throws SQLException {
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

        int value = ps.executeUpdate();

        System.out.println(user);

        ps.close();
        return value;
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
			if(rs.first()) {
				String password = rs.getString("user_password");
				
				user = new User ( 	rs.getInt("user_id"), 
									rs.getString("user_name"), 
									rs.getString("user_first_name"), 
									rs.getString("user_mail"), 
									rs.getString("user_password"),
									LocalDateTime.parse(rs.getString("user_creation")) );
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
			if (rs.first()) {
				String	name						= rs.getString("user_name");
				String firstname 					= rs.getString("user_first_name");
				String mail							= rs.getString("user_mail");
				String login						= rs.getString("user_login");
				String password						= rs.getString("user_password");
				Boolean isActive					= rs.getBoolean("user_active");
				Boolean isAdmin						= rs.getBoolean("user_admin");
				Timestamp ts1 						= rs.getTimestamp("user_last_connection");
				LocalDateTime lastConnectionDate	= ts1.toLocalDateTime();
				LocalDateTime creationDate			= LocalDateTime.parse(rs.getString("user_creation"));
				String status						= rs.getString("user_status");
				String token						= rs.getString("user_token");

				user = new User (	id, 
									name, 
									firstname,
									mail,
									password,
									isActive,
									isAdmin,
									lastConnectionDate,
									creationDate,
									status,
									login,
									token);
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
	public int deleteUser (User user){
		
		try {
			int id = user.getId();

			String sql = "DELETE FROM USER WHERE user_id =" + id;
			return conn.createStatement().executeUpdate(sql);

		}catch (SQLException e) {
			System.out.println("Mauvaise connexion");
			e.printStackTrace();
		}
		return 0;
	}
	
    /**
     * Method which select all users from database
     * @return users
     */
	public Users selectAllUsers(){

		Users users = new Users();

		try {
			String sql = ("select * from 5g.user");
			ResultSet rs = conn.createStatement().executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String firstname = rs.getString("user_first_name");
				String password = rs.getString("user_password");
				String mail = rs.getString("user_mail");
				boolean isActive = rs.getBoolean("user_active");
				boolean isAdmin = rs.getBoolean("user_admin");
				Timestamp ts1 = rs.getTimestamp("user_last_connection");
				LocalDateTime lastConnectionDate = ts1.toLocalDateTime();
				LocalDateTime creationDate = LocalDateTime.parse(rs.getString("user_creation"));
				String status = rs.getString("user_status");
				String token = rs.getString("user_token");
				String login = rs.getString("user_login");

				User user = new User(id, name, firstname, mail, password, isActive, isAdmin, lastConnectionDate, creationDate, status, login, token);
				users.add(user);
			}
			System.out.println("liste users : "+ users);
		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
		}
		return users;
	}

	public Users selectAllConnectedUsers(){

		Users users = new Users();

		try {
			String sql = ("select * from 5g.user");
			ResultSet rs = conn.createStatement().executeQuery(sql);

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
				LocalDateTime creationDate					= LocalDateTime.parse(rs.getString("user_creation"));
				String status								= rs.getString("user_status");
				String token								= rs.getString("user_token");
				String login								= rs.getString("user_login");

				User user = new User (id, name, firstname, mail, password, isActive, isAdmin, lastConnectionDate, creationDate, status, login, token);
				users.add(user);
			}
			System.out.println("liste users : "+ users);
		} catch (SQLException e) {
			System.out.println("Mauvaise connexion");
		}
		return users;
	}
}
