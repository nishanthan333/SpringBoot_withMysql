package com.JavaSpringbootwithSQL.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Threads {

    @Id
    @GeneratedValue
    @Column(name = "threadId")
    Integer threadId;
    @Column(name = "threadTitle")
    String threadTitle;
    @Column(name = "createdBy")
    String createdBy;
    @Column(name = "LastEditedDate")
    String LastEditedDate;

    public Threads(){}

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    public String getThreadTitle() {
        return threadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.threadTitle = threadTitle;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastEditedDate() {
        return LastEditedDate;
    }

    public void setLastEditedDate(String lastEditedDate) {
        LastEditedDate = lastEditedDate;
    }
}
