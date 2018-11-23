
package fr.ynov.discussion.providers;

import fr.ynov.db.DBConnection;
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
    private UserProvider userProvider = new UserProvider();
    private Discussion discussion;

    /**
     * Constructor.
     * Initialization Singleton of BDD Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DiscussionProvider() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Method which add a discussion from database
     * @param discussion discussion entity
     * @throws SQLException
     */

    public Discussion addDiscussion(Discussion discussion) throws Exception {
        java.lang.String query = "%1$s,%2$s";
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
        java.lang.String query = "%1$s";
        ResultSet result = connection.createStatement().executeQuery(query.format(query,name));
        if (result.first()) {
            return new Discussion(result.getInt("discussion_id"), result.getString("discussion_name"), userProvider.getUserById(result.getInt("discussion_creator")), ConvertToList(result.getString("discussion_users")));
        }
        return null;
    }

    /**
     * Method which find a discussion by user list from database
     * @param usersId User id list
     * @throws SQLException
     */
    public Discussion findDiscussionByUsers(List<Integer> usersId) throws Exception {
        java.lang.String query = "%1$s";
        JSONArray usersJson = new JSONArray(usersId);
        ResultSet result = connection.createStatement().executeQuery(query.format(query, usersJson.toString()));
        if (result.first()) {
             return new Discussion(Integer.parseInt(result.getString("discussion_id")), result.getString("discussion_name"), userProvider.getUserById(result.getInt("discussion_creator")), usersId);
        }
        return null;
    }

    public Discussion findDiscussionById(int id) throws Exception {
        java.lang.String query = "%1$s";
        ResultSet result = connection.createStatement().executeQuery(query.format(query, id));
        if (result.first()){
            return new Discussion(Integer.parseInt(result.getString("discussion_id")), result.getString("discussion_name"), userProvider.getUserById(result.getInt("discussion_creator")), ConvertToList(result.getString("discussion_users")));
        }
        return null;
    }


    public List<Integer> updateDiscussion(Discussion discussion)throws SQLException{
        java.lang.String query = "%1$s";
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
        java.lang.String query = "%1$s";
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
