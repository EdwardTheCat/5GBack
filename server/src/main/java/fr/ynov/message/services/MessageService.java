package fr.ynov.message.services;

import fr.ynov.message.ressources.Messages;
import fr.ynov.message.providers.MessageProvider;
import fr.ynov.message.ressources.Message;
import fr.ynov.response.Response;
import fr.ynov.response.ResponseEnum;

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
     * @param number of messages to return
     * @return messages objects auto-transformed in json shape by dependency @see pom.xml
     */
    @GetMapping( path="restapi/discussions/get-messages/{discussionId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response getMessages(@PathVariable int discussionId , @RequestParam (value= "number", defaultValue = "2") int number ) {
		
    	message = new MessageProvider();
		Messages messages = message.getMessagesFromIdDisccusion(discussionId, number);
		
		Response response = new Response(ResponseEnum.messagesRetrieved.getType(),ResponseEnum.messagesRetrieved.getCode(), ResponseEnum.messagesRetrieved.getDescription());
		response.setPayload(messages);
		
		return response;  
	}      
}
