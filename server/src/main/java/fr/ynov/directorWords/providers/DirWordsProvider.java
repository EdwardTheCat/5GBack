package fr.ynov.directorWords.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.directorWords.ressources.DirWord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Class in shape of DAO to extract director words informations from the database
 * @author Audrey
 * since v0
 */
public class DirWordsProvider {

	private Connection conn;

	/**
	 * Constructor.
	 * Initialization Singleton of BDD Connection
	 * @return 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public  DirWordsProvider() throws SQLException, ClassNotFoundException {
		this.conn = DBConnection.getConnection();
	}

	public DirWordsProvider(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Method which add a director words in database
	 * @param dirWord
	 * @throws SQLException
	 */
	public int createDirWord(DirWord dirWord) throws SQLException {
		String sql = "insert into 5g.dirword values (?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);

		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/YY - hh:mm");
		String formattedString1 = currentTime.format(formatter1);

		ps.setInt		(1, dirWord.getId());
		ps.setString	(2, dirWord.getSentence());
		ps.setString	(3, formattedString1);
		ps.setInt		(4, dirWord.getUserId());

		int value = ps.executeUpdate();

		ps.close();
		return value;
	}

	public DirWord getDirWord() throws SQLException {
		ResultSet result = conn.createStatement().executeQuery("SELECT * FROM 5g.dirword LIMIT 1 ORDER BY dirword_date");
		if (result.first()){
			return new DirWord(result.getInt("dirword_id"),result.getString("dirword_sentence"),result.getTimestamp("dirword_date").toLocalDateTime(), result.getInt("dirword_user_id"));
		} else {
			return null;
		}
	}
	
	
	
	/**
	 * Method which update a director words in database
	 * @param dirWord
	 * @throws SQLException
	 */
	public void updateDirWords (DirWord dirWord) throws SQLException{

			int id = dirWord.getId();
			String sentence = dirWord.getSentence();
			int userId = dirWord.getUserId();
			
			String sql = "UPDATE 5g.dirword SET dir_word_sentence = '" + sentence + "', dir_word_date = current_timestamp, user_id=" + userId + " WHERE dir_word_id = " + id;
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} 
	
}
