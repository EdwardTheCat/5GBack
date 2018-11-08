package fr.ynov.discussion.ressources;

import fr.ynov.user.ressources.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class Discussion {
    private String id;
    private String label;
    private User creator;
    private  Map<Integer, User> users = new HashMap<Integer, User>();

    public Discussion(String id, String label, User creator) {
        this.id = id;
        this.label = label;
        this.creator = creator;
    }

    public Discussion(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public Discussion(String id, User creator) {
        this.id = id;
        this.creator = creator;
    }

    public Discussion(String id, User creator, List<User> users) {
        this.id = id;
        this.creator = creator;
        for (User user : users){
            this.users.put(user.getId(),user);
        }
    }

    public Discussion(String id, String label, User creator, List<User> users) {
        this.id = id;
        this.label = label;
        this.creator = creator;
        for (User user : users){
            this.users.put(user.getId(),user);
        }
    }
    @XmlElement(name="label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlElement(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name="creator")
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @XmlElement(name="users")
    public List<User> getUsers() {
        return new ArrayList<User>(users.values());
    }

    public void addUser(User user){
        //TODO: Verifier si le membre existe
        if(users.containsKey(user.getId())){

        } else {
            users.put(user.getId(), user);
        }
    }

    public void leaveUser(User user){
        //TODO: Verifier si le membre existe
        if(users.containsKey(user.getId())){

        } else {
            users.remove(user.getId());
        }
    }
}
