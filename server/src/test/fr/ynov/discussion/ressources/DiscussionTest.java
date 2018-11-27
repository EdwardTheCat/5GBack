package fr.ynov.discussion.ressources;

import fr.ynov.db.DBConnection;
import fr.ynov.discussion.providers.DiscussionProvider;
import fr.ynov.message.ressources.Messages;
import fr.ynov.user.providers.UserProvider;
import fr.ynov.user.ressources.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiscussionTest {

    Discussion discussion;

    @Before
    public void setUp() throws Exception {
        List<Integer> users = new ArrayList<Integer>();
        users.add(1);
        users.add(2);
        discussion = new Discussion(1,"test",new User(1,"toto"),users,new Messages());
    }

    @Test
    public void addUser() throws Exception {
        Assert.assertEquals(2,discussion.addUser(2));
        Assert.assertEquals(3,discussion.addUser(3));
    }

    @Test
    public void leaveUser() {
        Assert.assertEquals(2,discussion.leaveUser(3));
        Assert.assertEquals(1,discussion.leaveUser(2));
    }

}