package com.csun.csunevent.saiteja.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Component
@Entity
public class Comment {
    @Id
    @GeneratedValue
    public int comment_id;
    @OneToOne
    public User user;
    public String comment;



    public int getComment_id() {
        return comment_id;
    }

    public User getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
