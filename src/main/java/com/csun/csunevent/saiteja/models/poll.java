package com.csun.csunevent.saiteja.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class poll {
    @Id
    @GeneratedValue
    int pollId;
    String pollName;



    String pollStatement;
    int TotalVoteCount;
    int UpVoteCount;
    int downVoteCount;
    @ManyToOne
    User postedBy;

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public poll() {
    }

    public String getPollStatement() {
        return pollStatement;
    }

    public void setPollStatement(String pollStatement) {
        this.pollStatement = pollStatement;
    }

    public poll(int pollId, String pollName, String pollStatement, int totalVoteCount, int upVoteCount, int downVoteCount) {
        this.pollId = pollId;
        this.pollName = pollName;
        this.pollStatement = pollStatement;
        TotalVoteCount = totalVoteCount;
        UpVoteCount = upVoteCount;
        this.downVoteCount = downVoteCount;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public String getPollName() {
        return pollName;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public int getTotalVoteCount() {
        return TotalVoteCount;
    }

    public void setTotalVoteCount(int totalVoteCount) {
        TotalVoteCount = totalVoteCount;
    }

    public int getUpVoteCount() {
        return UpVoteCount;
    }

    public void setUpVoteCount(int upVoteCount) {
        UpVoteCount = upVoteCount;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }
}
