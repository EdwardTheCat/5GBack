package fr.ynov.services;

import fr.ynov.dao.DAOMessage;
import fr.ynov.db.DBConnection;
import fr.ynov.message.Message;
import fr.ynov.message.MessageTest;
import fr.ynov.message.Messages;
import fr.ynov.message.MessagesTest;
import fr.ynov.response.Response;
import fr.ynov.response.ResponseEnum;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller to render messages
 * @author edward
 * @since v0
 *
 */
@Controller
public class MessageService{
	
	/**
	 * Method which returns messages in Json shape from dynamic route (/discussions/get-messages/{discussionId}/{messageNumber}
	 * It retrieves the messages or message object(s) from the DAO object
	 * @param id discussion
	 * @param numbers of messages to return
	 * @return messages objects auto-transformed in json shape by dependency @see pom.xml
	 */
	
	@GetMapping( path="restapi/discussions/get-messages/{discussionId}", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response getMessages(@PathVariable int discussionId , @RequestParam (value= "number", defaultValue = "2") int number ) {
		
		DAOMessage message = new DAOMessage();
		Messages mess = message.getMessagesFromIdDisccusion(discussionId, number);
		
		Response resp = new Response(ResponseEnum.messagesRetrieved.getType(),ResponseEnum.messagesRetrieved.getCode(), ResponseEnum.messagesRetrieved.getDescription());
		resp.setPayload(mess);
		
		return resp;  
	}           
}
