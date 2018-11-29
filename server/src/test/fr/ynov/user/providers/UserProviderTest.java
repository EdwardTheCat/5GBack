package fr.ynov.user.providers;

import fr.ynov.db.DBConnection;
import fr.ynov.user.ressources.User;
import fr.ynov.user.ressources.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class UserProviderTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet result;

    private UserProvider userProvider;

    private User user;
    private  LocalDateTime date;
    private Users users = new Users();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);
        Mockito.when(connection.createStatement()).thenReturn(statement);
        userProvider = new UserProvider(connection);
        date = LocalDateTime.now();
        user = new User(1,"Dubois","toto","toto@gmail.com","password",true,false,date,date,"Connected","ProDuDev","token");
        users.add(user);
    }

    @Test
    public void createUser() throws Exception {
        int testValue;
        Mockito.when(preparedStatement.executeUpdate()).thenReturn(0).thenReturn(1);
        testValue = userProvider.createUser(user);
        Assert.assertEquals(0,testValue);
        testValue = userProvider.createUser(user);
        Assert.assertEquals(1,testValue);
    }

    @Test
    public void getUserByLogin()throws Exception  {
        User userTest;
        Mockito.when(preparedStatement.executeQuery()).thenReturn(result);
        Mockito.when(result.first()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getInt("user_id")).thenReturn(1);
        Mockito.when(result.getString("user_name")).thenReturn("Dubois");
        Mockito.when(result.getString("user_first_name")).thenReturn("toto");
        Mockito.when(result.getString("user_mail")).thenReturn("toto@gmail.com");
        Mockito.when(result.getString("user_password")).thenReturn("password");
        Mockito.when(result.getString("user_creation_date")).thenReturn(date.toString());

        userTest = userProvider.getUserByLogin("ProDuDev");
        Assert.assertEquals(user.getId(),userTest.getId());
        Assert.assertEquals(user.getName(),userTest.getName());
        Assert.assertEquals(user.getMail(),userTest.getMail());
        Assert.assertEquals(user.getFirstname(),userTest.getFirstname());
        Assert.assertEquals(user.getPassword(),userTest.getPassword());

        userTest = userProvider.getUserByLogin("ProDuDev");
        Assert.assertEquals(null, userTest);
    }

    @Test
    public void getUserById() throws Exception{
        User userTest;
        Mockito.when(preparedStatement.executeQuery()).thenReturn(result);
        Mockito.when(result.first()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getInt("user_id")).thenReturn(1);
        Mockito.when(result.getString("user_name")).thenReturn("Dubois");
        Mockito.when(result.getString("user_first_name")).thenReturn("toto");
        Mockito.when(result.getString("user_mail")).thenReturn("toto@gmail.com");
        Mockito.when(result.getString("user_password")).thenReturn("password");
        Mockito.when(result.getBoolean("user_active")).thenReturn(true);
        Mockito.when(result.getBoolean("user_admin")).thenReturn(false);
        Mockito.when(result.getTimestamp("user_last_connection")).thenReturn(Timestamp.valueOf(date));
        Mockito.when(result.getString("user_creation_date")).thenReturn(date.toString());
        Mockito.when(result.getString("user_status")).thenReturn("Connected");
        Mockito.when(result.getString("user_token")).thenReturn("token");
        Mockito.when(result.getString("user_login")).thenReturn("ProDuDev");

        userTest = userProvider.getUserById(1);
        Assert.assertEquals(user.getId(),userTest.getId());
        Assert.assertEquals(user.getName(),userTest.getName());
        Assert.assertEquals(user.getMail(),userTest.getMail());
        Assert.assertEquals(user.getFirstname(),userTest.getFirstname());
        Assert.assertEquals(user.getPassword(),userTest.getPassword());

        userTest = userProvider.getUserById(1);
        Assert.assertEquals(null, userTest);

    }

    @Test
    public void deleteUser() throws Exception{
        int id = 1;
        int testValue;
        Mockito.when(statement.executeUpdate(Mockito.anyString())).thenReturn(0).thenReturn(1);
        testValue = userProvider.deleteUser(user);
        Assert.assertEquals(0,testValue);

        testValue = userProvider.deleteUser(user);
        Assert.assertEquals(1,testValue);
    }

    @Test
    public void selectAllUsers() throws Exception{
        Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getInt("user_id")).thenReturn(1);
        Mockito.when(result.getString("user_name")).thenReturn("Dubois");
        Mockito.when(result.getString("user_first_name")).thenReturn("toto");
        Mockito.when(result.getString("user_mail")).thenReturn("toto@gmail.com");
        Mockito.when(result.getString("user_password")).thenReturn("password");
        Mockito.when(result.getBoolean(Mockito.anyString())).thenReturn(true).thenReturn(false);
        Mockito.when(result.getTimestamp("user_last_connection")).thenReturn(Timestamp.valueOf(date));
        Mockito.when(result.getString("user_creation_date")).thenReturn(date.toString());
        Mockito.when(result.getString("user_status")).thenReturn("Connected");
        Mockito.when(result.getString("user_token")).thenReturn("token");
        Mockito.when(result.getString("user_login")).thenReturn("ProDuDev");
        Users usersTest = userProvider.selectAllUsers();
        Assert.assertEquals(users.size(), usersTest.size());
        Assert.assertEquals(users.get(0).getId(),usersTest.get(0).getId());
        Assert.assertEquals(users.get(0).getName(),usersTest.get(0).getName());
        Assert.assertEquals(users.get(0).getMail(),usersTest.get(0).getMail());
        Assert.assertEquals(users.get(0).getFirstname(),usersTest.get(0).getFirstname());
        Assert.assertEquals(users.get(0).getPassword(),usersTest.get(0).getPassword());
    }

    @Test
    public void selectAllConnectedUsers() throws Exception {
        Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getInt("user_id")).thenReturn(1);
        Mockito.when(result.getString("user_name")).thenReturn("Dubois");
        Mockito.when(result.getString("user_first_name")).thenReturn("toto");
        Mockito.when(result.getString("user_mail")).thenReturn("toto@gmail.com");
        Mockito.when(result.getString("user_password")).thenReturn("password");
        Mockito.when(result.getBoolean(Mockito.anyString())).thenReturn(true);
        Mockito.when(result.getTimestamp("user_last_connection")).thenReturn(Timestamp.valueOf(date));
        Mockito.when(result.getString("user_creation_date")).thenReturn(date.toString());
        Mockito.when(result.getString("user_status")).thenReturn("Connected");
        Mockito.when(result.getString("user_token")).thenReturn("token");
        Mockito.when(result.getString("user_login")).thenReturn("ProDuDev");
        Users usersTest = userProvider.selectAllUsers();
        Assert.assertEquals(users.size(), usersTest.size());
        Assert.assertEquals(users.get(0).getId(),usersTest.get(0).getId());
        Assert.assertEquals(users.get(0).getName(),usersTest.get(0).getName());
        Assert.assertEquals(users.get(0).getMail(),usersTest.get(0).getMail());
        Assert.assertEquals(users.get(0).getFirstname(),usersTest.get(0).getFirstname());
        Assert.assertEquals(users.get(0).getPassword(),usersTest.get(0).getPassword());
    }
}