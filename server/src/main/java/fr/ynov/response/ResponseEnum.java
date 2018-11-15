package fr.ynov.response;

public enum ResponseEnum {

    //Response
    connected("authentification","T0001","Vous �tes maintenant connect�"),
    renewedSession("authentication","T0002","Votre bail a �t� renouvel�"),
    disconnected("authentication","T0003","Vous avez bien �t� d�connect�"),
    memberList("members","T0004","Liste des utilisateurs inscrits"),
    connectedMemberList("members","T0005","Liste des utilisateurs connect�s"),
    discussionRetrieved("discussion","T0006","R�cup�ration d'une discussion existante"),
    discussionCreated("discussion","T0007","Cr�ation d'une discussion"),
    memberAdded("discussion","T0008","Membre(s) ajout�(s) avec succ�s"),
    discussionDeleted("discussion","T0009","La discussion a �t� supprim�e, ainsi son historique"),
    discussionLeft("discussion","T0010","Vous avez quitt� la conversation"),
    discussionList("discussion","T0011","Liste des discussions auxquelles vous prenez part"),
    messageAdded("discussion", "T0012","Message enregistr� avec succ�s"),
    messagesRetrieved("discussion","T0012","R�cup�ration des messages d'une discussion"),
    //Error Response
    wrongCredentials("error","E0001","Mauvais login ou mot de passe"),
    expiredSession ("error","E0002","Session expir�e ou inexistante"),
    heartbeatError("error","E0003","Bail non renouvelable"),
    noMemberList("error","E0004","Une discussion doit d�crire des membres"),
    tooMuchPeople("error","E0005","Trop de members tuent les membres"),
    notDiscussionCreator("error","E0006","Vous n'avez pas le droit d'effectuer cette manipulation pour cette discussion"),
    mustForceDiscussionLeaving("error","E0007","Pour quitter une conversation dont vous �tes cr�ateur, il faut forcer sa suppression"),
    cantLeaveTheDiscussion("error","E0008","Vous ne pouvez quitter cette conversation car vous n'en faites par partie ou qu'elle n'existe pas"),
    discussionOperationNotAllowed("error","E0009","Vous ne pouvez pas r�aliser cette op�ration car la discussion n'existe pas ou que vous n'en faites pas partie");

    private String type;
    private String code;
    private String description;

    ResponseEnum(String type, String code, String description){
        this.type = type;
        this.code = code;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}