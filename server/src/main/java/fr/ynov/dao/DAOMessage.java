package fr.ynov.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import fr.ynov.db.DBConnection;
import fr.ynov.message.Message;

import fr.ynov.message.Messages;


/**
 * Class in shaped of DAO to extrat message informations from the database
 * @author edward
 * since v0
 */
public class DAOMessage {

	/**
	 * Connection property
	 */
	Connection conn = null;
	/**
	 * PreparedStatement property
	 */
	PreparedStatement ps = null;

	/**
	 * ResultSet property
	 */
	ResultSet rs = null;
	
	public DAOMessage() {
		this.conn = DBConnection.getInstance();
	}
	/**
	 * Method which create a row in message table that represents a message
	 * @param message
	 * @throws SQLException
	 */
	public void createMessage (Message message) throws SQLException {

		try {

			String query = "INSERT INTO message (content, id_author, id_discussion, created_at) VALUES (?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);	

			ps.setString	(1, message.getContent());
			ps.setInt		(2, message.getIdAuthor());
			ps.setInt		(3, message.getIdDiscussion());
			ps.setTimestamp (4, message.getCreatedAt());

			ps.executeUpdate();

			System.out.println(message);

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
	}


	/**
	 * Method which delete a message object in database
	 * @param message
	 */
	public void deleteMessage (Message message){
		
		int id = message.getIdMessage();
		
		try {

			String query = "DELETE FROM message WHERE id =" + id;

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
	 * @param number id discussion
	 * @param number
	 * @return Messages
	 */
	public Messages getMessagesFromIdDisccusion (int Discussion, int nombre){

		Messages messages = new Messages();

		try {

			String query = "SELECT * FROM message WHERE message.id_discussion = ? LIMIT " + nombre;

			if(conn==null) System.out.println("Connection null");
			PreparedStatement ps = conn.prepareStatement(query);	

			ps.setInt(1, Discussion);

			ResultSet rs = ps.executeQuery();



			while (rs.next()) {

				int idMessage 					= rs.getInt("id");
				String content				= rs.getString("content");
				int idAuthor			= rs.getInt("id_author");
				int idDiscussion 			= rs.getInt("id_discussion");
				Timestamp createdAt 			= rs.getTimestamp("created_at");

				Message message = new Message (idMessage, content, idAuthor, idDiscussion, createdAt);

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
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) { /* ignoré */}
		}
	}


}
