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

    private String topic;




}
