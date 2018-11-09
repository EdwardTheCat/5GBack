package fr.ynov.message.services;

import fr.ynov.message.providers.MessageProvider;
import fr.ynov.message.ressources.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController

/**
 * Class with messages REST Services
 *
 * @author Edward
 * since v0
 */
public class MessageService {

    /**
     * Provider of Message property
     */
    private MessageProvider message;

    /**
     * Method which returns messages in Json shape from dynamic route (/discussions/get-messages/{discussionId}}
     * It retrieves the messages or message object(s) from the DAO object
     * @param discussionId discussion
     * @param messageNumber of messages to return
     * @return messages objects auto-transformed in json shape by dependency @see pom.xml
     */
    @GetMapping(value = "/restapi/discussions/get-messages/{discussionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getMessages(@PathVariable int discussionId , @RequestParam(value = "number", required = false) Integer messageNumber )throws SQLException,ClassNotFoundException {
        message = new MessageProvider();
        if (messageNumber == null){
            return message.getMessagesFromIdDisccusion(discussionId);
        }else{
            return message.getMessagesFromIdDisccusion(discussionId, messageNumber);
        }
    }
}
