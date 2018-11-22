package fr.ynov.directorWords.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.directorWords.ressources.dirWord;
import fr.ynov.directorWords.ressources.dirWords;

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

import director.business.DirWord;


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
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public UserProvider() throws SQLException, ClassNotFoundException {
		this.conn = DBConnection.getConnection();
	}

	/**
	 * Method which add a director words in database
	 * @param dirWord
	 * @throws SQLException
	 */
	public void createDirWord(DirWord dirWord) throws SQLException {
		String sql = "insert into 5g.dirword values (?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);

		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/YY - hh:mm");
		String formattedString1 = currentTime.format(formatter1);

		ps.setInt		(1, dirWord.getId());
		ps.setString	(2, dirWord.getSentence());
		ps.setString	(3, formattedString1);
		ps.setInt		(4, dirWord.getUserId());

		ps.executeUpdate();

		ps.close();
	}
}
