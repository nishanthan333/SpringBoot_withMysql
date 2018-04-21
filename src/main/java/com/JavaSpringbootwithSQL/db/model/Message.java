package com.JavaSpringbootwithSQL.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "messageId")
    Integer messageId;

    @JoinColumn(name = "userId")
    Integer userId;

    @JoinColumn(name = "threadId")
    Integer threadId;

    @Column(name = "message")
    String message;

    @Column(name = "lastEdited")
    String lastEdited;

    @Column(name = "lastEditedBy")
    String lastEditedBy;

    public Message(){}

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(String lastEdited) {
        this.lastEdited = lastEdited;
    }

    public String getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(String lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }
}
