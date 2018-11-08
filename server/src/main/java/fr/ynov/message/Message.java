package fr.ynov.message;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Class that represents a Message object
 * 
 * @author edward
 * @since v0 
 */
public class Message {

	/**
	 * Id stored in database
	 */
	private int idMessage;
	/**
	 * Content of the message
	 */
	private String content;
	/**
	 * Author of the message
	 */
	private int idAuthor;
	/**
	 * Id of the discussion which is linked to the message
	 */
	private int idDiscussion;
	/**
	 * Timestamp that represents the creation of the message
	 */
	private Timestamp createdAt;
	/*createdAt doit �tre au format "dd/MM/YY - hh:mm:sssss" */

	/**
	 * Constructor 
	 */
	public Message() {};

	/**
	 * Constructor 
	 * @param id message
	 * @param content
	 * @param id of the author
	 * @param id of the discussion
	 * @param timestamp creation
	 */
	public Message( int idMessage, String content, int idAuthor, int idDiscussion, Timestamp createdAt ) {

		this.idMessage = idMessage;
		this.content = content;
		this.idAuthor = idAuthor;
		this.idDiscussion = idDiscussion;
		this.createdAt = createdAt;

	}

	/**
	 * Method that override toString() method for a message object
	 * @return String concatenated with params message
	 */
	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage+ ", content=" + content + ", idAuthor=" + idAuthor
				+ ", idDiscussion=" + idDiscussion + ", createdAt=" + createdAt + "]";
	}

	/**
	 * Getter for idMessage property
	 * @return idMessage
	 */
	public int getIdMessage() {
		return idMessage;
	}

	/**
	 * Setter for idMessage property
	 * @param idMessage
	 */
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	/**
	 * Getter for content property
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * Setter for content property
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * Getter for idAuthor property
	 * @return idAuthor
	 */
	public int getIdAuthor() {
		return idAuthor;
	}
	/**
	 * Setter for idAuthor property
	 * @param idAuthor
	 */
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	/**
	 * Getter for idDiscussion property
	 * @return idDiscussion
	 */
	public int getIdDiscussion() {
		return idDiscussion;
	}
	/**
	 * Setter for idDiscussion property
	 * @param idDiscussuin
	 */
	public void setIdDiscussion(int idDiscussion) {
		this.idDiscussion = idDiscussion;
	}
	/**
	 * Getter for createdAt property
	 * @return createdAt
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	/**
	 * Setter for createdAt property
	 * @param createdAt
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


}
