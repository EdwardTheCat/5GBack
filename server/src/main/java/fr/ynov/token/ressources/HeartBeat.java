package fr.ynov.token.ressources;

public class HeartBeat {

    private String token;

    public HeartBeat(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }
}
