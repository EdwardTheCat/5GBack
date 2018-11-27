package fr.ynov.directorWords.services;

import fr.ynov.directorWords.providers.DirWordsProvider;
import fr.ynov.directorWords.ressources.DirWord;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/restapi/dirword")
public class DirWordsService {

    DirWordsProvider dirWordsProvider;

    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DirWord getDirWord() throws Exception{
        dirWordsProvider = new DirWordsProvider();
        return dirWordsProvider.getDirWord();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDirWord(@RequestBody String json)throws Exception{
        JSONObject jsonObject = new JSONObject(json);
        dirWordsProvider = new DirWordsProvider();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YY - hh:mm");
        DirWord dirWord = new DirWord(jsonObject.getInt("id"),jsonObject.getString("sentence"), LocalDateTime.parse(jsonObject.getString("postDate"),formatter),jsonObject.getInt("userId"));
        dirWordsProvider.createDirWord(dirWord);
    }
}
