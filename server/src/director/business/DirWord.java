package director.business;

import java.time.LocalDate;

public class DirWord {

	private int dir_word_id;
	private String dir_word_sentence;
	private LocalDate dir_word_date;
	private int user_id;

	public DirWord (int dir_word_id, String dir_word_sentence, LocalDate dir_word_date, int user_id) {
		this.dir_word_id = dir_word_id;
		this.dir_word_sentence= dir_word_sentence;
		this.dir_word_date = dir_word_date;
		this.user_id = user_id;		
	}

	public int getDir_word_id() {
		return dir_word_id;
	}
	public void setDir_word_id(int dir_word_id) {
		this.dir_word_id = dir_word_id;
	}
	public String getDir_word_sentence() {
		return dir_word_sentence;
	}
	public void setDir_word_sentence(String dir_word_sentence) {
		this.dir_word_sentence = dir_word_sentence;
	}
	public LocalDate getDir_word_date() {
		return dir_word_date;
	}
	public void setDir_word_date(LocalDate dir_word_date) {
		this.dir_word_date = dir_word_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	@Override
	public String toString() {
		return "DirWord [dir_word_id=" + dir_word_id + ", dir_word_sentence=" + dir_word_sentence + ", dir_word_date="
				+ dir_word_date + ", user_id=" + user_id + "]";
	}



}
