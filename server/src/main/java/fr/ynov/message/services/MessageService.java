package fr.ynov.message.services;

import fr.ynov.message.ressources.Message;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MessageService {
    private MessageProvider message;

    /**
     * Method which returns messages in Json shape from dynamic route (/discussions/get-messages/{discussionId}/{messageNumber}
     * It retrieves the messages or message object(s) from the DAO object
     * @param discussionId discussion
     * @param messageNumber of messages to return
     * @return messages objects auto-transformed in json shape by dependency @see pom.xml
     */
    @GetMapping("/restapi/discussions/get-messages/{discussionId}")
    public List<Message> getMessages(@PathVariable int discussionId , @RequestParam(value = "number", required = false) Integer messageNumber )throws SQLException,ClassNotFoundException {
        message = new MessageProvider();
        if (messageNumber == null){
            return message.getMessagesFromIdDisccusion(discussionId);
        }else{
            return message.getMessagesFromIdDisccusion(discussionId, messageNumber);
        }
    }
}
