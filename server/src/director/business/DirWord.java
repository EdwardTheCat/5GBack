package director.business;

import java.time.LocalDate;

public class DirWord {

	 private int dir_word_id;
	 private String dir_word_sentence;
	 private LocalDate dir_word_date;
	 
	 
	 
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
	
	
	@Override
	public String toString() {
		return "DirWord [dir_word_id=" + dir_word_id + ", dir_word_sentence=" + dir_word_sentence + ", dir_word_date="
				+ dir_word_date + "]";
	}
	
		
}
