package fr.ynov.directorWords.ressources;

import java.time.LocalDate;

/**
 * Class that represents a DirectorWord object
 *
 * @author Audrey
 * @since v0
 */
public class DirWord {

	/**
	 * id of DirectorWord
	 */
	private int id;
	/**
	 * sentence of DirectorWord
	 */
	private String sentence;
	/**
	 * date when the sentence is posted
	 */
	private LocalDate postDate;
	/**
	 * Constructor.
	 * @param id of DirWord
	 * @param sentence of DirWord
	 * @param postDate of DirWord
	 */
	private int userId;
	
	public DirWord (int id, String sentence, LocalDate postDate, int userId) {
		this.id = id;
		this.sentence = sentence;
		this.postDate = postDate;
		this.setUserId(userId);
	}


	/**
	 * Getter for id property
	 * @return id
	 */    
	public int getId() {
		return id;
	}
	/**
	 * Setter for id property
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter for sentence property
	 * @return sentence
	 */
	public String getSentence() {
		return sentence;
	}
	/**
	 * Setter for sentence property
	 * @param sentence
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	/**
	 * Getter for postDate property
	 * @return postDate
	 */
	public LocalDate getPostDate() {
		return postDate;
	}
    /**
     * Setter for postDate property
     * @param postDate
     */
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	/**
	 * Getter for userId property
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}

    /**
     * Setter for userId property
     * @param userId
     */
	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "DirWord [id=" + id + ", sentence=" + sentence + ", postDate=" + postDate + ", userId=" + userId + "]";
	}

}

