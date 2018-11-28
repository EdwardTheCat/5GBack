package fr.ynov.discussion.ressources;

import java.security.PrivateKey;
import java.util.List;

public class DiscussionRequest {

    private String token;
    private String discussionName;
    private int discussionId;
    private List<Integer> members;
    private boolean force;
    private List<Integer> newMembers;

    public DiscussionRequest(String token, String discussionName, int discussionId, List<Integer> members, boolean force, List<Integer> newMembers) {
        this.token = token;
        this.discussionName = discussionName;
        this.discussionId = discussionId;
        this.members = members;
        this.force = force;
        this.newMembers = newMembers;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDiscussionName() {
        return discussionName;
    }

    public void setDiscussionName(String discussionName) {
        this.discussionName = discussionName;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public List<Integer> getMembers() {
        return members;
    }

    public void setMembers(List<Integer> members) {
        this.members = members;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public List<Integer> getNewMembers() {
        return newMembers;
    }

    public void setNewMembers(List<Integer> newMembers) {
        this.newMembers = newMembers;
    }
}
