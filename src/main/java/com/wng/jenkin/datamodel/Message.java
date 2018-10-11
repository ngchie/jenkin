package com.wng.jenkin.datamodel;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Message extends BaseEntity{



    @ManyToOne
    @JoinColumn(name = "topicid", nullable = false)
    @JsonIgnore
    private Topic topic;



    @Column(length = 500)
    private String message;

    @Column(length = 25)
    private String username;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
