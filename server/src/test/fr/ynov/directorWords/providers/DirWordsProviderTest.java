package fr.ynov.directorWords.providers;

import fr.ynov.directorWords.ressources.DirWord;
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
public class DirWordsProviderTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet result;

    private DirWordsProvider dirWordsProvider;
    private DirWord dirWord;
    private LocalDateTime date;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);
        Mockito.when(connection.createStatement()).thenReturn(statement);
        dirWordsProvider = new DirWordsProvider(connection);
        date = LocalDateTime.now();
        dirWord = new DirWord(1,"test",date,1);
    }

    @Test
    public void createDirWord() throws Exception  {
        int testValue;
        Mockito.when(preparedStatement.executeUpdate()).thenReturn(0).thenReturn(1);
        testValue = dirWordsProvider.createDirWord(dirWord);
        assertEquals(0,testValue);
        testValue = dirWordsProvider.createDirWord(dirWord);
        assertEquals(1,testValue);
    }

    @Test
    public void getDirWord() throws Exception {
        DirWord dirWordTest;
        Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(result);
        Mockito.when(result.first()).thenReturn(true).thenReturn(false);
        Mockito.when(result.getInt("dirword_id")).thenReturn(1);
        Mockito.when(result.getString("dirword_sentence")).thenReturn("test");
        Mockito.when(result.getTimestamp("dirword_date")).thenReturn(Timestamp.valueOf(date));
        Mockito.when(result.getInt("dirword_user_id")).thenReturn(1);

        dirWordTest = dirWordsProvider.getDirWord();
        assertEquals(dirWord.getId(),dirWordTest.getId());
        assertEquals(dirWord.getSentence(),dirWordTest.getSentence());
        assertEquals(dirWord.getPostDate(),dirWordTest.getPostDate());
        assertEquals(dirWord.getUserId() ,dirWordTest.getUserId());

        dirWordTest = dirWordsProvider.getDirWord();
        assertEquals(null,dirWordTest);
    }
}