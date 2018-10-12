package com.wng.jenkin.datamodel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Topic extends BaseEntity{


    public Topic() {}
    public  Topic(Long id) {
        super.setId(id);
    }

    public Topic(Long id, String topic) {
        super.setId(id);
        this.topic = topic;
    }

    private String topic;


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
