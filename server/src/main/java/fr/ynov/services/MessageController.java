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


@Controller
public class MessageController{
    
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/discussions/get-messages/{discussionId}")
    @ResponseBody
    public Messages getMessages(@PathVariable int discussionId) {
		
		DAOMessage message = new DAOMessage();
		
	    	return message.getMessagesFromIdDisccusion();
	} 
	
	@GetMapping("/discussions/get-messages/{discussionId}/{messageNumber}")
    @ResponseBody
    public Messages getMessages(@PathVariable int discussionId , @PathVariable int messageNumber ) {
		
		DAOMessage message = new DAOMessage();
		
		
			return message.getMessagesFromIdDisccusion(messageNumber);
	
	
	   

	}           
}
