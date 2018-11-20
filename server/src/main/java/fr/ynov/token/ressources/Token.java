package fr.ynov.token.ressources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;
@XmlRootElement
/**
 * Class that represents a Token object
 *
 * @author Alexis
 * @since v0
 */
public class Token {

    /**
     * secret of JWT
     */
    private String secret = "Je suis le meilleur clé du monde!!!";

    /**
     * Method which verify JWT for header, body and sign
     * @param token is JWT
     * @param header of Response
     * @param body of Response
     */
    public boolean verifToken(String token, Map<String,String> header, Map<String,String> body) {
        return true;
    }

    /**
     * Method which generate JWT with header and body
     * @param header of Response
     * @param body of Response
     */
    public String generate(Map<String,String> header, Map<String,String> body){
        return "";
    }

    /**
     * Getter for secret property
     * @return secret
     */
    @XmlElement(name="token")
    public String getSecret() {
        return secret;
    }
}
