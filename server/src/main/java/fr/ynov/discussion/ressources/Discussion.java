package fr.ynov.discussion.ressources;

import fr.ynov.message.ressources.Message;
import fr.ynov.message.providers.MessageProvider;
import fr.ynov.user.providers.UserProvider;
import fr.ynov.user.ressources.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.SQLException;
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
    private int id;
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
    private  List<Integer> users = new ArrayList<Integer>();

    /**
     * last Messages of Discussion
     */
    private List<Message> lastMessages = new ArrayList<Message>();


    private MessageProvider messageProvider;
    private UserProvider userProvider;

    public Discussion(String label, List<Integer> users) {
        this.label = label;
        this.creator = creator;
        this.users = users;
    }

    public Discussion(int id, String label, User creator, List<Integer> users) throws Exception {
        this.id = id;
        this.label = label;
        this.creator = creator;
        this.users = users;
        messageProvider = new MessageProvider();
        this.lastMessages = messageProvider.getMessagesFromIdDisccusion(id,30);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public List<Message> getLastMessages() {
        return lastMessages;
    }

    public void setLastMessages(List<Message> lastMessages) {
        this.lastMessages = lastMessages;
    }


    /**
     * Method which add user in discussion
     * @param userId
     */
    public int addUser(int userId)throws Exception{
        userProvider = new UserProvider();
        if(!users.contains(userId)){
            users.add(userId);
        }
        return users.size();
    }

    /**
     * Method which delete user in discussion
     * @param userId
     */
    public int leaveUser(int userId) {
        if (!users.contains(userId)) {
            users.remove(userId);
        }
        return users.size();
    }
}
