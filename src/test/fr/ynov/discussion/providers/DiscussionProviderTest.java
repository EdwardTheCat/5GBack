package fr.ynov.discussion.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.discussion.ressources.Discussion;
import fr.ynov.user.providers.UserProvider;
import fr.ynov.user.ressources.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiscussionProviderTest {

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet result;

    private DiscussionProvider discussionProvider;
    private UserProvider userProvider;

    private Discussion discussion;
    private User user;

    @Before
    public void setUp() throws Exception {
        Mockito.when(DBConnection.getConnection()).thenReturn(this.connection);
        discussionProvider = new DiscussionProvider();
        userProvider = new UserProvider();
        user = new User(1,"toto");
        discussion  = new Discussion(1,"test",user,new ArrayList<Integer>());
    }

    @Test
    public void addDiscussion() throws Exception {
        Discussion testDiscussion;

        Mockito.when(connection.createStatement().executeUpdate("")).thenReturn(0);
        testDiscussion = discussionProvider.addDiscussion(discussion);
        Assert.assertEquals(null, testDiscussion);

        Mockito.when(connection.createStatement().executeUpdate("")).thenReturn(1);
        testDiscussion = discussionProvider.addDiscussion(discussion);
        Assert.assertEquals(discussion, testDiscussion);
    }

    @Test
    public void findDiscussionByName() throws Exception {
        Discussion testDiscussion;

        Mockito.when(connection.createStatement().executeQuery("") ).thenReturn(result);
        Mockito.when(result.getInt("discussion_id")).thenReturn(1);
        Mockito.when(result.getString("discussion_name")).thenReturn("test");
        Mockito.when(userProvider.getUserById(result.getInt("discussion_creator"))).thenReturn(user);
        Mockito.when(result.getString("discussion_users")).thenReturn("[]");

        Mockito.when(result.first()).thenReturn(true);
        testDiscussion = discussionProvider.findDiscussionByName("test");
        Assert.assertEquals(discussion, testDiscussion);

        Mockito.when(result.first()).thenReturn(false);
        testDiscussion = discussionProvider.findDiscussionByName("test");
        Assert.assertEquals(null, testDiscussion);
    }

    @Test
    public void findDiscussionByUsers() throws Exception{
        Discussion testDiscussion;

        Mockito.when(connection.createStatement().executeQuery("") ).thenReturn(result);
        Mockito.when(result.getInt("discussion_id")).thenReturn(1);
        Mockito.when(result.getString("discussion_name")).thenReturn("test");
        Mockito.when(userProvider.getUserById(result.getInt("discussion_creator"))).thenReturn(user);
        Mockito.when(result.getString("discussion_users")).thenReturn("[]");

        Mockito.when(result.first()).thenReturn(true);
        testDiscussion = discussionProvider.findDiscussionByUsers(new ArrayList<Integer>()) ;
        Assert.assertEquals(discussion, testDiscussion);

        Mockito.when(result.first()).thenReturn(false);
        testDiscussion = discussionProvider.findDiscussionByUsers(new ArrayList<Integer>());
        Assert.assertEquals(null, testDiscussion);
    }

    @Test
    public void findDiscussionById() throws Exception{
        Discussion testDiscussion;

        Mockito.when(connection.createStatement().executeQuery("") ).thenReturn(result);
        Mockito.when(result.getInt("discussion_id")).thenReturn(1);
        Mockito.when(result.getString("discussion_name")).thenReturn("test");
        Mockito.when(userProvider.getUserById(result.getInt("discussion_creator"))).thenReturn(user);
        Mockito.when(result.getString("discussion_users")).thenReturn("[]");

        Mockito.when(result.first()).thenReturn(true);
        testDiscussion = discussionProvider.findDiscussionById(1) ;
        Assert.assertEquals(discussion, testDiscussion);

        Mockito.when(result.first()).thenReturn(false);
        testDiscussion = discussionProvider.findDiscussionById(1);
        Assert.assertEquals(null, testDiscussion);

    }

    @Test
    public void updateDiscussion() throws Exception {
        List<Integer> list = new ArrayList<Integer>();

        Mockito.when(connection.createStatement().executeUpdate("")).thenReturn(0);
        list = discussionProvider.updateDiscussion(discussion);
        Assert.assertEquals(null, list);

        Mockito.when(connection.createStatement().executeUpdate("")).thenReturn(1);
        list = discussionProvider.updateDiscussion(discussion);
        Assert.assertEquals(new ArrayList<Integer>(), list);

    }

    @Test
    public void deleteDiscussion() throws Exception {
        int result;
        Mockito.when(connection.createStatement().executeUpdate("")).thenReturn(0);
        result = discussionProvider.deleteDiscussion(1);
        Assert.assertEquals(0,result);

        Mockito.when(connection.createStatement().executeUpdate("")).thenReturn(1);
        result = discussionProvider.deleteDiscussion(1);
        Assert.assertEquals(1,result);
    }
}