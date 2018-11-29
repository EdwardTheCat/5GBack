package fr.ynov.directorWords.services;

import fr.ynov.directorWords.providers.DirWordsProvider;
import fr.ynov.directorWords.ressources.DirWord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DirWordsProvider.class)
public class DirWordsServiceTest {

    @Autowired
    private DirWordsService service;

    private DirWordsProvider dirWordsProvider;

    private DirWord dirWord;
    private String expected;
    private LocalDateTime date;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        date = LocalDateTime.now();
        dirWord = new DirWord(1,"Test",date,1 );
        dirWordsProvider = Mockito.mock(DirWordsProvider.class);
        PowerM
        Mockito.when(dirWordsProvider.getDirWord()).thenReturn(dirWord);

    }

    @Test
    public void getDirWord()throws Exception {
        System.out.println(service.getDirWord());
    }

    @Test
    public void updateDirWord() {
    }
}