
package fr.ynov.discussion.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.message.providers.MessageProvider;
import fr.ynov.user.providers.UserProvider;
import fr.ynov.user.ressources.Users;
import org.json.*;

import fr.ynov.discussion.ressources.Discussion;

import fr.ynov.user.ressources.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Class in shape of DAO to extrat discussion informations from the database
 * @author ludovic
 * since v0
 */
public class DiscussionProvider {

    /**
     * Connection property
     */
    private Connection connection;
    /**
     * Provider of user property
     */
    private UserProvider userProvider;
    private MessageProvider messageProvider;
    private Discussion discussion;

    /**
     * Constructor.
     * Initialization Singleton of BDD Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DiscussionProvider() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.getConnection();
        userProvider = new UserProvider(this.connection);
        messageProvider = new MessageProvider(this.connection);
    }

    public DiscussionProvider(Connection connection) throws SQLException, ClassNotFoundException {
        this.connection = connection;
        userProvider = new UserProvider(connection);
        messageProvider = new MessageProvider(connection);
    }

    public DiscussionProvider(Connection connection, UserProvider userProvider, MessageProvider messageProvider) {
        this.connection = connection;
        this.userProvider = userProvider;
        this.messageProvider = messageProvider;
    }

    /**
     * Method which add a discussion from database
     * @param discussion discussion entity
     * @throws SQLException
     */

    public Discussion addDiscussion(Discussion discussion) throws Exception {
        java.lang.String query = "INSERT INTO discussion (name_discussion,creator_discussion, users_discussion) values(%1$s,%2$d,%3$s)";
        JSONArray usersJson = new JSONArray(discussion.getUsers());
        int result = connection.createStatement().executeUpdate(query.format(query,discussion.getLabel(),discussion.getCreator(),usersJson.toString()));
        if (result == 0){
            return null;
        } else {
            return discussion;
        }
    }

    /**
     * Method which find a discussion by name from database
     * @param name name of discussion
     * @throws Exception
     */
    public Discussion findDiscussionByName(String name) throws Exception {
        java.lang.String query = "SELECT * FROM discussion WHERE name_discussion=%1$s";
        ResultSet result = connection.createStatement().executeQuery(query.format(query,name));
        if (result.first()) {
            return new Discussion(result.getInt("id_discussion"), result.getString("name_discussion"), userProvider.getUserById(result.getInt("creator_discussion")), ConvertToList(result.getString("users_discussion")),messageProvider.getMessagesFromIdDisccusion(result.getInt("id_discussion"),50));
        }
        return null;
    }

    /**
     * Method which find a discussion by user list from database
     * @param usersId User id list
     * @throws SQLException
     */
    public Discussion findDiscussionByUsers(List<Integer> usersId) throws Exception {
        java.lang.String query = "SELECT * FROM discussion WHERE users_discussion=%1$s";
        JSONArray usersJson = new JSONArray(usersId);
        ResultSet result = connection.createStatement().executeQuery(query.format(query, usersJson.toString()));
        if (result.first()) {
             return new Discussion(result.getInt("id_discussion"), result.getString("name_discussion"), userProvider.getUserById(result.getInt("creator_discussion")), usersId,messageProvider.getMessagesFromIdDisccusion(result.getInt("id_discussion"),50));
        }
        return null;
    }

    public Discussion findDiscussionById(int id) throws Exception {
        java.lang.String query = "SELECT * FROM discussion WHERE id_discussion=%1$s";
        ResultSet result = connection.createStatement().executeQuery(query.format(query, id));
        if (result.first()){
            return new Discussion(result.getInt("id_discussion"), result.getString("name_discussion"), userProvider.getUserById(result.getInt("creator_discussion")), ConvertToList(result.getString("users_discussion")),messageProvider.getMessagesFromIdDisccusion(result.getInt("id_discussion"),50));
        }
        return null;
    }


    public List<Integer> updateDiscussion(Discussion discussion)throws SQLException{
        java.lang.String query = "UPDATE discussion SET users_discussion='%2$s' WHERE id_discussion=%1$s";
        JSONArray usersJson = new JSONArray();
        for (int user: discussion.getUsers()) {
                usersJson.put(user);
        }
        int result = connection.createStatement().executeUpdate(query.format(query,discussion.getId(),usersJson.toString()));
        if (result == 0) {
            return null;
        } else {
            return discussion.getUsers();
        }
    }

    public int deleteDiscussion(int id)throws SQLException{
        java.lang.String query = "DELETE FROM discussion WHERE id_discussion=%1$s";
        return connection.createStatement().executeUpdate(query.format(query, id));
    }

    private List<Integer> ConvertToList(String userJson) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        JSONArray usersJson = new JSONArray(userJson);
        for (int i = 0; i < usersJson.length(); i++) {
            JSONObject user = usersJson.getJSONObject(i);
            list.add(user.getInt("user_id"));
        }
        return list;
    }
}
