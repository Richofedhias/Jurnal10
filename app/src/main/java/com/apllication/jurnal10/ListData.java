package com.apllication.jurnal10;

import java.time.LocalDateTime;

public class ListData {
    private int id;
    private String sender;
    private String subject;
    private String content;
    private LocalDateTime datetime;
    private boolean isStarred;

    public ListData(int id, String sender, String subject, String content, LocalDateTime datetime, boolean isStarred) {
        this.id = id;
        this.sender = sender;
        this.subject = subject;
        this.content = content;
        this.datetime = datetime;
        this.isStarred = isStarred;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public boolean isStarred() {
        return isStarred;
    }

    public void setStarred(boolean starred) {
        isStarred = starred;
    }
}
