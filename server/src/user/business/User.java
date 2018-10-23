package user.business;

import java.time.LocalDate;

public class User {
	
	private int user_id;
	private String user_name;
	private String user_first_name;
	private String user_mail;
	private String user_password;
	private boolean user_is_active;
	private boolean user_is_admin;
	private LocalDate user_last_connection;
	
		
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public boolean isUser_is_active() {
		return user_is_active;
	}
	public void setUser_is_active(boolean user_is_active) {
		this.user_is_active = user_is_active;
	}
	public boolean isUser_is_admin() {
		return user_is_admin;
	}
	public void setUser_is_admin(boolean user_is_admin) {
		this.user_is_admin = user_is_admin;
	}
	public LocalDate getUser_last_connection() {
		return user_last_connection;
	}
	public void setUser_last_connection(LocalDate user_last_connection) {
		this.user_last_connection = user_last_connection;
	}
	
	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_first_name=" + user_first_name
				+ ", user_mail=" + user_mail + ", user_password=" + user_password + ", user_is_active=" + user_is_active
				+ ", user_is_admin=" + user_is_admin + ", user_last_connection=" + user_last_connection + "]";
	}
	
	
	


}
