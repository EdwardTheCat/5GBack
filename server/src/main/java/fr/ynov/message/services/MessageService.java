package fr.ynov.message.services;

import fr.ynov.message.ressources.Messages;
import fr.ynov.message.providers.MessageProvider;
import fr.ynov.message.ressources.Message;
import fr.ynov.response.Response;
import fr.ynov.response.ResponseEnum;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;



/**
 * Class with messages REST Services
 *
 * @author Edward
 * since v0
 */
@RestController
public class MessageService {

    /**
     * Provider of Message property
     */
    private MessageProvider messageProv;
    
    /**
     * Method which returns messages in Json shape from dynamic route (/discussions/get-messages/{discussionId}}
     * It retrieves the messages or message object(s) from the DAO object
     * @param discussionId discussion
     * @param number of messages to return
     * @return messages objects auto-transformed in json shape by dependency @see pom.xml
     */
    @GetMapping( path="restapi/discussions/get-messages/{idDiscussion}", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response getMessages(@PathVariable int idDiscussion , @RequestParam (value= "number", defaultValue = "2") int number ) {
		
    	System.out.println("ici");
    	Response response;
    	messageProv = new MessageProvider();
		Messages messages = messageProv.getMessagesFromIdDisccusion(idDiscussion, number);
		
		if(!messages.isEmpty()) {
			response = new Response(ResponseEnum.messagesRetrieved.getType(),
									ResponseEnum.messagesRetrieved.getCode(), 
									ResponseEnum.messagesRetrieved.getDescription()
									);
			response.setPayload(messages);
		}
		else{
			response = new Response(ResponseEnum.discussionOperationNotAllowed.getType(),
									ResponseEnum.discussionOperationNotAllowed.getCode(), 
									ResponseEnum.discussionOperationNotAllowed.getDescription()
									);
			}
		
		return response;  
	}      
    
    @PostMapping( path="restapi/discussions/post/get-messages/", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response getMessagesPost(@RequestBody  HolderGetMessage holder ) {
		
    	Response response;
    	messageProv = new MessageProvider();
    	System.out.println("ici "+  holder.getIdDiscussion() + holder.getNumber());
    	//we can do some verifs
    	
		Messages messages = messageProv.getMessagesFromIdDisccusion(holder.getIdDiscussion(), holder.getNumber());
		
		if(!messages.isEmpty()) {
			response = new Response(ResponseEnum.messagesRetrieved.getType(),
									ResponseEnum.messagesRetrieved.getCode(), 
									ResponseEnum.messagesRetrieved.getDescription()
									);
			response.setPayload(messages);
		}
		else{
			response = new Response(ResponseEnum.discussionOperationNotAllowed.getType(),
									ResponseEnum.discussionOperationNotAllowed.getCode(), 
									ResponseEnum.discussionOperationNotAllowed.getDescription()
									);
			}
		
		return response;  
	}   
    
    @PostMapping( path="restapi/discussions/post-message", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Response getMessagesPost(@RequestBody  Message message ) {
		
    	Response response;
    	int res = 0;
    	messageProv = new MessageProvider();
    	message.setCreatedAt(LocalDateTime.now());
    			
    	//we can do some verifs
    	System.out.println(message.toString());
		res = messageProv.saveMessage(message);
		
		if(res == 1) {
			response = new Response(ResponseEnum.messagePost.getType(),
									ResponseEnum.messagePost.getCode(), 
									ResponseEnum.messagePost.getDescription()
											);
		}
		else {
			response = new Response(ResponseEnum.discussionOperationNotAllowed.getType(),
									ResponseEnum.discussionOperationNotAllowed.getCode(), 
									ResponseEnum.discussionOperationNotAllowed.getDescription()
								);
		}
		return response;    
    }
}

class HolderGetMessage{
	@JsonProperty("idDiscussion")
	private int idDiscussion;
	
	public int getIdDiscussion() {
		return this.idDiscussion;
	}
		
	public void setIdDiscussion(int idDiscussion) {
		this.idDiscussion = idDiscussion;
	}
	@JsonProperty("number")
	private int number = 1;
	
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public HolderGetMessage() {}
	
	public HolderGetMessage(int idDiscussion, int number) {
		this.idDiscussion = idDiscussion;
		this.number = number;
	}
}	
	class HolderPostMessage{
		private int idDiscussion;
		
		public int getIdDiscussion() {
			return this.idDiscussion;
		}
			
		public void setIdDiscussion(int idDiscussion) {
			this.idDiscussion = idDiscussion;
		}

		private String content = "";
		
		public String getContent() {
			return this.content;
		}
		
		public void setContent(String content) {
			this.content = content;
		}
		
		public HolderPostMessage() {}
		
		public HolderPostMessage(int idDiscussion, String content) {
			this.idDiscussion = idDiscussion;
			this.content = content;
		}
}
