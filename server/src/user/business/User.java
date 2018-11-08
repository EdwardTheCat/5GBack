package user.business;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

	private int id;
	private String name;
	private String firstname;
	private String mail;
	private String password;
	private boolean isActive;
	private boolean isAdmin;
	private LocalDateTime lastConnectionDate;
	private LocalDate creationDate;
	private String status;
	private String token;
	private String login;

	public User() {}

	public User (int id, String name, String firstname, String mail, String password, boolean isActive, boolean isAdmin,
			LocalDateTime lastConnectionDate, LocalDate creationDate, String status, String token, String login) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.mail = mail;
		this.password = password;
		this.isActive = isActive;
		this.isAdmin = isAdmin;
		this.lastConnectionDate = lastConnectionDate;
		this.creationDate = creationDate;
		this.status = status;
		this.token = token;
		this.login = login;
	}
	
	public User (int id, String name, String firstname, String mail, String password, LocalDate creationDate) {
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.mail = mail;
		this.password = password;
		this.creationDate = creationDate;
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public LocalDateTime getLastConnectionDate() {
		return lastConnectionDate;
	}


	public void setLastConnectionDate(LocalDateTime lastConnectionDate) {
		this.lastConnectionDate = lastConnectionDate;
	}


	public LocalDate getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", firstname=" + firstname + ", mail=" + mail + ", password="
				+ password + ", isActive=" + isActive + ", isAdmin=" + isAdmin + ", lastConnectionDate="
				+ lastConnectionDate + ", creationDate=" + creationDate + ", status=" + status + ", token=" + token
				+ ", login=" + login + "]";
	}



}
