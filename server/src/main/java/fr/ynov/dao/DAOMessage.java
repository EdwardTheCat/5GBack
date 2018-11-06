package fr.ynov.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.TimeZone;

import fr.ynov.db.DBConnection;
import fr.ynov.db_connection.DbAcces;
import fr.ynov.message.Message;
import fr.ynov.message.Messages;

public class DAOMessage {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void createMessage (Message message) throws SQLException {

		try {


			Connection conn = DBConnection.getInstance();

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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) { e.printStackTrace();}
			}
		}
	}



	public void deleteMessage (Message message){

		try {
			Connection conn = DBConnection.getInstance();

			int idMessage = message.getIdMessage();

			String query = "DELETE FROM message WHERE id =" + idMessage;

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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) { e.printStackTrace();}
			}
		}
	}



	public Messages getMessagesFromIdDisccusion (){
		return getMessagesFromIdDisccusion(2);
	}

	public Messages getMessagesFromIdDisccusion (int nombre){

		Messages messages = new Messages();

		try {
			Connection conn = DBConnection.getInstance();	

			String query = "SELECT * FROM message LIMIT " + nombre;

			if(conn==null) System.out.println("Connection null");
			PreparedStatement ps = conn.prepareStatement(query);	

			ResultSet rs = ps.executeQuery(query);

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
			System.out.println("SQL error : selectMessageFromIdDisccusion");
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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) { e.printStackTrace();}
			}
		}
			
		return messages;

		}


}
