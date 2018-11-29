package fr.ynov.message.ressources;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Class that represents a Message object
 *
 * @author Edward
 * @since v0
 */
public class Message {

    /**
     * Id stored in database
     */
	@JsonProperty("id")
    private int idMessage = 0;
    /**
     * Content of the message
     */
	@JsonProperty("content")
    private String content;
    /**
     * Author of the message
     */

	@JsonProperty("author")
    private int idAuthor;
    /**
     * Id of the discussion which is linked to the message
     */

	@JsonProperty("discussion")
    private int idDiscussion;
    /**
     * Timestamp that represents the creation of the message
     * Use a "dd/MM/YY - hh:mm:sssss" format
     */
	@JsonProperty("createdAt")
    private LocalDateTime createdAt;

    /**
     * Constructor
     * Empty constructor to do init stuff like store RequestBody data
     */
    public Message() {}
    /**
     * Constructor
     * @param idMessage message
     * @param content
     * @param idAuthor of the author
     * @param idDiscussion of the discussion
     * @param createdAt creation
     */
    public Message( int idMessage, String content, int idAuthor, int idDiscussion, LocalDateTime createdAt ) {

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
     * @param idDiscussion
     */
    public void setIdDiscussion(int idDiscussion) {
        this.idDiscussion = idDiscussion;
    }
    /**
     * Getter for createdAt property
     * @return createdAt
     */

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    /**
     * Setter for createdAt property
     * @param createdAt
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

