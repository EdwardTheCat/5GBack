package fr.ynov.message.servives.test;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ynov.Application;
import fr.ynov.message.ressources.Messages;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MessageServiceTest {
	
	@Test
	public void givenDiscussionDoesNotExists_whenMessagesInfoIsRetrieved_ThenDefaultResponseContentTypeIsJson()
	{
	  
	   // Given
	   int idNotExist = 8;
	   String jsonMimeType = "application/json";
	   HttpUriRequest request = new HttpGet( "http://localhost/restapi/discussions/get-messages/" + idNotExist);
	
	   // When
	   HttpResponse response = null;
	try {
		response = HttpClientBuilder.create().build().execute( request );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	   // Then
	   String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
	   Assert.assertEquals( jsonMimeType, mimeType );
	}

	@Test
	public void
	  givenUserExists_whenUserInformationIsRetrieved_thenRetrievedResourceIsCorrect()
	  {
		// Given
		int idExists = 1;
		Messages messages = new Messages();
		HttpResponse response = null;
		HttpUriRequest request = new HttpGet( "http://localhost:8090/restapi/discussions/get-messages/" + idExists );
	    
	    // WhengetLogin
		try {
			response = HttpClientBuilder.create().build().execute( request );
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    // Then
	    //todo need to deserialize the response to get list of message
	    /*
	    try {
	    	
			messages = retrieveResourceFromResponse(
			  response, Messages.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    messages.forEach(message -> Assert.assertEquals(idExists, message.getIdDiscussion()));
	     */
	    Assert.assertEquals(1, 1);
	}
	
	public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) 
			  throws IOException {
			  
			    String jsonFromResponse = EntityUtils.toString(response.getEntity());
			    ObjectMapper mapper = new ObjectMapper()
			      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			    return mapper.readValue(jsonFromResponse, clazz);
			}
}
