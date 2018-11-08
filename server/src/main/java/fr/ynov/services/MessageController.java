package fr.ynov.services;

import fr.ynov.dao.DAOMessage;
import fr.ynov.db.DBConnection;
import fr.ynov.message.Message;
import fr.ynov.message.Messages;


import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

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
public class MessageController{
    
	/**
	 * Spring boot property for controller
	 */
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * Method which returns messages in Json shape from dynamic route (/discussions/get-messages/{discussionId}
	 * It retrieves the messages or message object(s) from the DAO object
	 * @param id discussion
	 * @return messages objets auto-transformed in json shape by dependency @see pom.xml
	 */
	@GetMapping("/discussions/get-messages/{discussionId}")
    @ResponseBody
    public Messages getMessages(@PathVariable int discussionId) {
		
		DAOMessage message = new DAOMessage();
		
	    	return message.getMessagesFromIdDisccusion();
	} 
	
	/**
	 * Method which returns messages in Json shape from dynamic route (/discussions/get-messages/{discussionId}/{messageNumber}
	 * It retrieves the messages or message object(s) from the DAO object
	 * @param id discussion
	 * @param numbers of messages to return
	 * @return messages objects auto-transformed in json shape by dependency @see pom.xml
	 */
	@GetMapping("/discussions/get-messages/{discussionId}/{messageNumber}")
    @ResponseBody
    public Messages getMessages(@PathVariable int discussionId , @PathVariable int messageNumber ) {
		
		DAOMessage message = new DAOMessage();
		
		
			return message.getMessagesFromIdDisccusion(messageNumber);
	
	
	   

	}           
}
