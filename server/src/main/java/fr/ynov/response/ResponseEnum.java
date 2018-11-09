package fr.ynov.response;
/**
 * Enum that represents a any Response value
 *
 * @author Ludovic
 * @since v0
 */
public enum ResponseEnum {

    /**
     * value of Response
     */
    connected("authentification","T0001","Vous êtes maintenant connecté"),
    renewedSession("authentication","T0002","Votre bail a été renouvelé"),
    disconnected("authentication","T0003","Vous avez bien été déconnecté"),
    memberList("members","T0004","Liste des utilisateurs inscrits"),
    connectedMemberList("members","T0005","Liste des utilisateurs connectés"),
    discussionRetrieved("discussion","T0006","Récupération d'une discussion existante"),
    discussionCreated("discussion","T0007","Création d'une discussion"),
    memberAdded("discussion","T0008","Membre(s) ajouté(s) avec succès"),
    discussionDeleted("discussion","T0009","La discussion a été supprimée, ainsi son historique"),
    discussionLeft("discussion","T0010","Vous avez quitté la conversation"),
    discussionList("discussion","T0011","Liste des discussions auxquelles vous prenez part"),
    messageAdded("discussion", "T0012","Message enregistré avec succès"),
    /**
     * error value of Response
     */
    wrongCredentials("error","E0001","Mauvais login ou mot de passe"),
    expiredSession ("error","E0002","Session expirée ou inexistante"),
    heartbeatError("error","E0003","Bail non renouvelable"),
    noMemberList("error","E0004","Une discussion doit décrire des membres"),
    tooMuchPeople("error","E0005","Trop de members tuent les membres"),
    notDiscussionCreator("error","E0006","Vous n'avez pas le droit d'effectuer cette manipulation pour cette discussion"),
    mustForceDiscussionLeaving("error","E0007","Pour quitter une conversation dont vous êtes créateur, il faut forcer sa suppression"),
    cantLeaveTheDiscussion("error","E0008","Vous ne pouvez quitter cette conversation car vous n'en faites par partie ou qu'elle n'existe pas"),
    discussionOperationNotAllowed("error","E0009","Vous ne pouvez pas réaliser cette opération car la discussion n'existe pas ou que vous n'en faites pas partie");

    /**
     * type of Response value
     */
    private String type;
    /**
     * code of Response value
     */
    private String code;
    /**
     * description of Response value
     */
    private String description;

    /**
     * Constructor.
     * @param type of Response value
     * @param code of Response value
     * @param description of Response value
     */
    ResponseEnum(String type, String code, String description){
        this.type = type;
        this.code = code;
        this.description = description;
    }

    /**
     * Getter for type value property
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for code value property
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter for description value property
     * @return description
     */
    public String getDescription() {
        return description;
    }

}