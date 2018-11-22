//package fr.ynov.discussion.providers;
//
//import fr.ynov.db.DBConnection;
//import fr.ynov.user.ressources.Users;
//import org.json.*;
//
//import fr.ynov.discussion.ressources.Discussion;
//
//import fr.ynov.user.ressources.User;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * Class in shape of DAO to extrat discussion informations from the database
// * @author ludovic
// * since v0
// */
//public class DiscussionProvider {
//
//    /**
//     * Connection property
//     */
//    private Connection connection;
//    /**
//     * Provider of user property
//     */
//    private Users userProvider = new Users();
//
//    /**
//     * Constructor.
//     * Initialization Singleton of BDD Connection
//     * @throws SQLException
//     * @throws ClassNotFoundException
//     */
//    public DiscussionProvider() throws SQLException, ClassNotFoundException {
//        this.connection = DBConnection.getConnection();
//    }
//
//    /**
//     * Method which add a discussion from database
//     * @param name name of discussion
//     * @param users list of User in discussion
//     * @throws SQLException
//     */
//    public int addDiscussion(String name, List<User> users) throws SQLException {
//        User creator = new User();
//        java.lang.String query = "%1$s,%2$s";
//        JSONArray usersJson = new JSONArray();
//        for (User user:users ){
//            JSONObject userJson = new JSONObject();
//            userJson.put("id" , user.getMail());
//            usersJson.put(userJson);
//        }
//        return connection.createStatement().executeUpdate(query.format(query,name,creator.getMail(),usersJson.toString()));
//    }
//
//    /**
//     * Method which find a discussion by name from database
//     * @param name name of discussion
//     * @throws SQLException
//     */
//    public Discussion findDiscussionByName(String name) throws SQLException {
//
//        List<User> users = new ArrayList<User>();
//        java.lang.String query = "%1$s";
//        ResultSet result = connection.createStatement().executeQuery(query.format(query,name));
//        JSONArray usersJson = new JSONArray(result.getString("discussion_users"));
//        for (int i=0; i < usersJson.length(); i++) {
//            JSONObject user = usersJson.getJSONObject(i);
//            users.add(userProvider.getUserById( user.getInt("user_id") ) );
//        }
//        Discussion discussion = new Discussion(result.getString("discussion_id"),result.getString("discussion_name"),userProvider.findUserById(result.getInt("discussion_creator")),users);
//        return discussion;
//    }
//
//    /**
//     * Method which find a discussion by user list from database
//     * @param json json String with User id list
//     * @throws SQLException
//     */
//    public Discussion findDiscussionByUsers(String json) throws SQLException {
//        java.lang.String query = "%1$s";
//        List<User> users = new ArrayList<User>();
//        ResultSet result = connection.createStatement().executeQuery(query.format(query, json));
//        JSONArray usersJson = new JSONArray(json);
//        for (int i=0; i < usersJson.length(); i++) {
//            JSONObject user = usersJson.getJSONObject(i);
//            users.add(userProvider.findUserById(user.getInt("user_id")));
//        }
//        Discussion discussion = new Discussion(result.getString("discussion_id"),result.getString("discussion_name"),userProvider.findUserById(result.getInt("discussion_creator")),users );
//        return discussion;
//    }
//}
