package fr.ynov.discussion.ressources;

import fr.ynov.user.ressources.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement
/**
 * Class that represents a Discussion object
 *
 * @author Ludovic
 * @since v0
 */
public class Discussion {
    /**
     * id of Discussion
     */
    private String id;
    /**
     * label of Discussion
     */
    private String label;
    /**
     * creator of Discussion
     */
    private User creator;
    /**
     * user list of Discussion
     */
    private  Map<Integer, User> users = new HashMap<Integer, User>();

    /**
     * Constructor
     * @param id of discussion
     * @param label of discussion
     * @param creator User of discussion
     */
    public Discussion(String id, String label, User creator) {
        this.id = id;
        this.label = label;
        this.creator = creator;
    }

    /**
     * Constructor
     * @param id of discussion
     * @param label of discussion
     */
    public Discussion(String id, String label) {
        this.id = id;
        this.label = label;
    }

    /**
     * Constructor
     * @param id of discussion
     * @param creator User of discussion
     */
    public Discussion(String id, User creator) {
        this.id = id;
        this.creator = creator;
    }

    /**
     * Constructor
     * @param id of discussion
     * @param creator User of discussion
     * @param users User list of discussion
     */
    public Discussion(String id, User creator, List<User> users) {
        this.id = id;
        this.creator = creator;
        for (User user : users){
            this.users.put(user.getId(),user);
        }
    }

    /**
     * Constructor
     * @param id of discussion
     * @param label of discussion
     * @param creator User of discussion
     * @param users User list of discussion
     */
    public Discussion(String id, String label, User creator, List<User> users) {
        this.id = id;
        this.label = label;
        this.creator = creator;
        for (User user : users){
            this.users.put(user.getId(),user);
        }
    }

    /**
     * Getter for label property
     * @return label
     */
    @XmlElement(name="label")
    public String getLabel() {
        return label;
    }

    /**
     * Setter for label property
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter for id property
     * @return id
     */
    @XmlElement(name="id")
    public String getId() {
        return id;
    }

    /**
     * Setter for label property
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for creator property
     * @return creator
     */
    @XmlElement(name="creator")
    public User getCreator() {
        return creator;
    }

    /**
     * Setter for label property
     * @param creator
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Getter for user list property
     * @return user list
     */
    @XmlElement(name="users")
    public List<User> getUsers() {
        return new ArrayList<User>(users.values());
    }

    /**
     * Method which add user in discussion
     * @param user
     */
    public void addUser(User user){
        //TODO: Verifier si le membre existe
        if(users.containsKey(user.getId())){

        } else {
            users.put(user.getId(), user);
        }
    }

    /**
     * Method which delete user in discussion
     * @param user
     */
    public void leaveUser(User user){
        //TODO: Verifier si le membre existe
        if(users.containsKey(user.getId())){

        } else {
            users.remove(user.getId());
        }
    }
}
