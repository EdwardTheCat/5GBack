package fr.ynov.token.services;

import fr.ynov.response.Response;
import fr.ynov.response.ResponseEnum;
import fr.ynov.security.JwtTokenAuthenticationFilter;
import fr.ynov.token.ressources.Token;
import fr.ynov.user.ressources.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Map;

@RestController
/**
 * Class with token REST Services
 * @author Alexis
 * since v0
 */
public class TokenService {

    /**
     * Method which returns token in Json shape from dynamic route (/login)
     * @param header header content
     * @param body body content
     * @return Response objects auto-transformed in json shape by dependency @see EnumResponse
     */
    @GetMapping("/login")
    public Response login(@RequestHeader Map<String, String> header, @RequestBody Map<String, String> body) {
        if (body.containsKey("login") && body.containsKey("password")) {
            String login = body.get("login");
            String motDePasse =body.get("password");
            User user  = null; //TODO: find user by Login
            if (user != null && user.getPassword() == motDePasse){
               //TODO: generate JWT
                JwtTokenAuthenticationFilter Jwt = new JwtTokenAuthenticationFilter();
                Token token = new Token();
                return new Response(ResponseEnum.connected.getType(),ResponseEnum.connected.getCode(),ResponseEnum.connected.getDescription(),token.getSecret());
            } else {
                return new Response(ResponseEnum.wrongCredentials.getType(),ResponseEnum.wrongCredentials.getCode(),ResponseEnum.wrongCredentials.getDescription());
            }
        } else {
            return new Response(ResponseEnum.wrongCredentials.getType(),ResponseEnum.wrongCredentials.getCode(),ResponseEnum.wrongCredentials.getDescription());
        }
    }



}
