package fr.ynov.message.providers;

import fr.ynov.message.ressources.Message;
import fr.ynov.message.ressources.Messages;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.*;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class MessageProviderTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet result;

    private MessageProvider messageProvider;

    private Message message;
    private LocalDateTime date;
    private Messages messages = new Messages();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);
        Mockito.when(connection.createStatement()).thenReturn(statement);
        messageProvider = new MessageProvider(connection);
        date = LocalDateTime.now();
        message = new Message(1,"test",1,1,date);
        messages.add(message);
    }

    @Test
    public void saveMessage() throws Exception  {
        int testValue;
        Mockito.when(preparedStatement.executeUpdate()).thenReturn(0).thenReturn(1);
        testValue = messageProvider.saveMessage(message) ;
        Assert.assertEquals(0,testValue);
        testValue = messageProvider.saveMessage(message);
        Assert.assertEquals(1,testValue);
    }

    @Test
    public void deleteMessage() throws Exception{
        int testValue;
        Mockito.when(statement.executeUpdate(Mockito.anyString())).thenReturn(0).thenReturn(1);
        testValue = messageProvider.deleteMessage(message) ;
        Assert.assertEquals(0,testValue);
        testValue = messageProvider.deleteMessage(message);
        Assert.assertEquals(1,testValue);
    }

    @Test
    public void getMessagesFromIdDisccusion() throws Exception{
        Mockito.when(preparedStatement.executeQuery()).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getInt("id_message")).thenReturn(1);
        Mockito.when(result.getString("content")).thenReturn("test");
        Mockito.when(result.getInt("id_author")).thenReturn(1);
        Mockito.when(result.getInt("id_discussion")).thenReturn(1);
        Mockito.when(result.getTimestamp("created_at")).thenReturn(Timestamp.valueOf(date));
        Messages  messagesTest = messageProvider.getMessagesFromIdDisccusion(1,1);
        Assert.assertEquals(messages.size(), messagesTest.size());
        Assert.assertEquals(messages.get(0).getIdMessage(),messagesTest.get(0).getIdMessage());
        Assert.assertEquals(messages.get(0).getContent(),messagesTest.get(0).getContent());
        Assert.assertEquals(messages.get(0).getIdAuthor(),messagesTest.get(0).getIdAuthor());
        Assert.assertEquals(messages.get(0).getIdDiscussion(),messagesTest.get(0).getIdDiscussion());
        Assert.assertEquals(messages.get(0).getCreatedAt(),messagesTest.get(0).getCreatedAt());

    }
}