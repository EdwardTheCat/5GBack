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
	public DirWord (int id, String sentence, LocalDate postDate) {
		this.id = id;
		this.sentence = sentence;
		this.postDate = postDate;
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


	@Override
	public String toString() {
		return "DirWord [id=" + id + ", sentence=" + sentence + ", postDate=" + postDate + "]";
	}


}

