package fr.ynov.message;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Message {
	
	private int idMessage;
	private String content;
	private int idAuthor;
	private int idDiscussion;
	private Timestamp createdAt;
	/*createdAt doit �tre au format "dd/MM/YY - hh:mm:sssss" */
	
	
	public Message() {};
	
	public Message( int idMessage, String content, int idAuthor, int idDiscussion, Timestamp createdAt ) {
		
		this.idMessage = idMessage;
		this.content = content;
		this.idAuthor = idAuthor;
		this.idDiscussion = idDiscussion;
		this.createdAt = createdAt;
		
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public int getIdDiscussion() {
		return idDiscussion;
	}

	public void setIdDiscussion(int idDiscussion) {
		this.idDiscussion = idDiscussion;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage+ ", content=" + content + ", idAuthor=" + idAuthor
				+ ", idDiscussion=" + idDiscussion + ", createdAt=" + createdAt + "]";
}
}
