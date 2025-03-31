package org.project.Entities.Music;

import org.project.Entities.entity;
import org.project.Enums.reactions;

public class comment_reaction extends entity {
    private String commentId;
    private String userId;
    private reactions reaction;
    public comment_reaction() {}

    public comment_reaction(String commentId, String userId, reactions reaction) {
        super();
        this.commentId = commentId;
        this.userId = userId;
        this.reaction = reaction;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public reactions getReaction() {
        return reaction;
    }

    public void setReaction(reactions reaction) {
        this.reaction = reaction;
    }
}