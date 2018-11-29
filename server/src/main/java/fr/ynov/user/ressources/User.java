package fr.ynov.user.ressources;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Class that represents a User object
 *
 * @author Audrey
 * @since v0
 */
public class User {

    /**
     * id of User
     */
    private int id;
    /**
     * name of User
     */
    private String name;
    /**
     * firstname of User
     */
    private String firstname;
    /**
     * mail of User
     */
    private String mail;
    /**
     * password of User
     */
    private String password;
    /**
     * isActive of User
     */
    private boolean isActive;
    /**
     * isAdmin of User
     */
    private boolean isAdmin;
    /**
     * lastConnectionDate of User
     */
    private LocalDateTime lastConnectionDate;
    /**
     * creationDate of User
     */
    private LocalDateTime creationDate;
    /**
     * status of User
     */
    private String status;
    /**
     * login of User
     */
    private String login;
    /**
     * token of User
     */
    private String token;
    /**
     * Constructor.
     */
    public User() {}

    /**
     * Constructor.
     * @param id of User
     * @param name of User
     * @param firstname of User
     * @param mail of User
     * @param password of User
     * @param isActive of User
     * @param isAdmin of User
     * @param lastConnectionDate of User
     * @param creationDate of User
     * @param status of User
     * @param login of User
     * @param token of User
     */
    public User (int id, String name, String firstname, String mail, String password, boolean isActive, boolean isAdmin,
                 LocalDateTime lastConnectionDate, LocalDateTime creationDate, String status, String login, String token) {
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

    /**
     * Constructor.
     * @param id of User
     * @param name of User
     * @param firstname of User
     * @param mail of User
     * @param password of User
     * @param creationDate of User
     */
    public User (int id, String name, String firstname, String mail, String password, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.password = password;
        this.creationDate = creationDate;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
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
     * Getter for name property
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name property
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for firstname property
     * @return firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Setter for firstname property
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Getter for mail property
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Setter for mail property
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Getter for password property
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password property
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for isActive property
     * @return isActive
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Setter for isActive property
     * @param isActive
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Getter for isAdmin property
     * @return isAdmin
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Setter for isAdmin property
     * @param isAdmin
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Getter for lastConnectionDate property
     * @return lastConnectionDate
     */
    public LocalDateTime getLastConnectionDate() {
        return lastConnectionDate;
    }

    /**
     * Setter for lastConnectionDate property
     * @param lastConnectionDate
     */
    public void setLastConnectionDate(LocalDateTime lastConnectionDate) {
        this.lastConnectionDate = lastConnectionDate;
    }

    /**
     * Getter for creationDate property
     * @return creationDate
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Setter for creationDate property
     * @param creationDate
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Getter for status property
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter for status property
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Getter for login property
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter for login property
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", firstname=" + firstname + ", mail=" + mail + ", password="
                + password + ", isActive=" + isActive + ", isAdmin=" + isAdmin + ", lastConnectionDate="
                + lastConnectionDate + ", creationDate=" + creationDate + ", status=" + status +", login=" + login + "]";
    }

}
