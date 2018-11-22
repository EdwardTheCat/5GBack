package fr.ynov.message.providers;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import fr.ynov.db.DBConnection;
import fr.ynov.message.ressources.Message;
import fr.ynov.message.ressources.Messages;

/**
 * Class in shape of DAO to extract message informations from the database
 * @author Edward
 * since v0
 */
public class MessageProvider {

    /**
     * Connection property
     */
    private Connection conn;
    /**
     * PreparedStatement property
     */
    PreparedStatement ps;

    /**
     * ResultSet property
     */
    ResultSet rs;

    /**
     * Constructor.
     * Initialization Singleton of BDD Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public MessageProvider(){
        this.conn = DBConnection.getConnection();
    }

    /**
     * Method which create a row in message table that represents a message
     * @param message
     * @throws SQLException
     */
    public int saveMessage (Message message) 
    { int res = 0;

    	if(conn == null) DBConnection.getConnection();
    	
        try {
            String query = "INSERT INTO message (content, id_author, id_discussion, created_at) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString	(1, message.getContent());
            ps.setInt		(2, message.getIdAuthor());
            ps.setInt		(3, message.getIdDiscussion());
            ps.setTimestamp (4, Timestamp.valueOf(message.getCreatedAt()));

            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL error : createMessage");
            e.printStackTrace();

        } finally  {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) { e.printStackTrace();}
            }
        }
        return res;
    }


    /**
     * Method which delete a message object in database
     * @param message
     */
    public void deleteMessage (Message message){

    	
        try {

            int idMessage = message.getIdMessage();

            String query = "DELETE FROM message WHERE id_message =" + idMessage;

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(query);

            stmt.close();
            conn.close();
            conn = null;


        } catch (SQLException e) {
            System.out.println("SQL error : deleteMessage");
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { e.printStackTrace();}
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) { e.printStackTrace();}
            }
        }
    }

    /**
     * Method which retrieve a numbers of messages from database
     * @param discussion id discussion
     * @param nombre
     * @return Messages
     */
    public Messages getMessagesFromIdDisccusion (int Discussion, int nombre){

		Messages messages = new Messages();

		try {

			String query = "SELECT * FROM message WHERE message.id_discussion = ? LIMIT " + nombre;

			if(conn==null) this.conn = DBConnection.getConnection();
			if(conn==null) System.out.println("connexion null");
			PreparedStatement ps = conn.prepareStatement(query);	

			ps.setInt(1, Discussion);

			ResultSet rs = ps.executeQuery();



			while (rs.next()) {

				int idMessage 					= rs.getInt("id_message");
				String content				= rs.getString("content");
				int idAuthor			= rs.getInt("id_author");
				int idDiscussion 			= rs.getInt("id_discussion");
				Timestamp createdAt 			= rs.getTimestamp("created_at");

				Message message = new Message (idMessage, content, idAuthor, idDiscussion, createdAt.toLocalDateTime());

				messages.add(message);

			}

		} catch (SQLException e) {
			System.out.println("SQL error : selectMessageFromIdDisccusion ");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();

		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) { /* ignoré */}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) { /* ignoré */}
			}
		}

		return messages;

	}
}

