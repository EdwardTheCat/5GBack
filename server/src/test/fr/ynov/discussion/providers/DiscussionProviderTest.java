package fr.ynov.discussion.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.discussion.ressources.Discussion;
import fr.ynov.message.providers.MessageProvider;
import fr.ynov.message.ressources.Messages;
import fr.ynov.user.providers.UserProvider;
import fr.ynov.user.ressources.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class DiscussionProviderTest {

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet result;

    @Mock
    private UserProvider userProvider;
    @Mock
    private MessageProvider messageProvider;

    private DiscussionProvider discussionProvider;

    private Discussion discussion;
    private User user;
    private Messages messages;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        discussionProvider = new DiscussionProvider(connection,userProvider,messageProvider);
        Mockito.when(connection.createStatement()).thenReturn(statement);
        Mockito.when(result.getInt("discussion_id")).thenReturn(1);
        Mockito.when(result.getString("discussion_name")).thenReturn("test");
        Mockito.when(result.getInt("discussion_creator")).thenReturn(1);
        Mockito.when(result.getString("discussion_users")).thenReturn("[]");

        user = new User(1,"toto");
        messages = new Messages();
        discussion  = new Discussion(1,"test",user,new ArrayList<Integer>(),messages);
        Mockito.when(userProvider.getUserById(Mockito.anyInt())).thenReturn(user);
        Mockito.when(messageProvider.getMessagesFromIdDisccusion(Mockito.anyInt(),Mockito.anyInt())).thenReturn(messages);
    }

    @Test
    public void addDiscussion() throws Exception {
        Discussion testDiscussion;

        Mockito.when(statement.executeUpdate(Mockito.anyString())).thenReturn(0).thenReturn(1);

        testDiscussion = discussionProvider.addDiscussion(discussion);
        Assert.assertEquals(null, testDiscussion);
        testDiscussion = discussionProvider.addDiscussion(discussion);
        Assert.assertEquals(discussion, testDiscussion);
    }

    @Test
    public void findDiscussionByName() throws Exception {
        Discussion testDiscussion;

        Mockito.when(statement.executeQuery(Mockito.anyString()) ).thenReturn(result);

        Mockito.when(result.first()).thenReturn(true).thenReturn(false);
        testDiscussion = discussionProvider.findDiscussionByName("test");
        Assert.assertEquals(discussion.getId(), testDiscussion.getId());
        Assert.assertEquals(discussion.getUsers(), testDiscussion.getUsers());
        Assert.assertEquals(discussion.getCreator(), testDiscussion.getCreator());
        Assert.assertEquals(discussion.getLabel(), testDiscussion.getLabel());
        testDiscussion = discussionProvider.findDiscussionByName("test");
        Assert.assertEquals(null, testDiscussion);
    }

    @Test
    public void findDiscussionByUsers() throws Exception{
        Discussion testDiscussion;

        Mockito.when(statement.executeQuery(Mockito.anyString()) ).thenReturn(result);
        Mockito.when(result.first()).thenReturn(true).thenReturn(false);

        testDiscussion = discussionProvider.findDiscussionByUsers(new ArrayList<Integer>()) ;
        Assert.assertEquals(discussion.getId(), testDiscussion.getId());
        Assert.assertEquals(discussion.getUsers(), testDiscussion.getUsers());
        Assert.assertEquals(discussion.getCreator(), testDiscussion.getCreator());
        Assert.assertEquals(discussion.getLabel(), testDiscussion.getLabel());

        testDiscussion = discussionProvider.findDiscussionByUsers(new ArrayList<Integer>());
        Assert.assertEquals(null, testDiscussion);
    }

    @Test
    public void findDiscussionById() throws Exception{
        Discussion testDiscussion;

        Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(result);
        Mockito.when(result.first()).thenReturn(true).thenReturn(false);

        testDiscussion = discussionProvider.findDiscussionById(1) ;
        Assert.assertEquals(discussion.getId(), testDiscussion.getId());
        Assert.assertEquals(discussion.getUsers(), testDiscussion.getUsers());
        Assert.assertEquals(discussion.getCreator(), testDiscussion.getCreator());
        Assert.assertEquals(discussion.getLabel(), testDiscussion.getLabel());

        testDiscussion = discussionProvider.findDiscussionById(1);
        Assert.assertEquals(null, testDiscussion);

    }

    @Test
    public void updateDiscussion() throws Exception {
        List<Integer> list = new ArrayList<Integer>();

        Mockito.when(statement.executeUpdate(Mockito.anyString())).thenReturn(0).thenReturn(1);
        list = discussionProvider.updateDiscussion(discussion);
        Assert.assertEquals(null, list);

        list = discussionProvider.updateDiscussion(discussion);
        Assert.assertEquals(new ArrayList<Integer>(), list);

    }

    @Test
    public void deleteDiscussion() throws Exception {
        int result;
        Mockito.when(statement.executeUpdate(Mockito.anyString())).thenReturn(0).thenReturn(1);
        result = discussionProvider.deleteDiscussion(1);
        Assert.assertEquals(0,result);

        result = discussionProvider.deleteDiscussion(1);
        Assert.assertEquals(1,result);
    }
}