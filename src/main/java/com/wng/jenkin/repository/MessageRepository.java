package com.wng.jenkin.repository;

import com.wng.jenkin.datamodel.Message;
import com.wng.jenkin.datamodel.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends BaseRepository<Message, Long> {


    List<Message> findMessageByTopicOrderById(Topic topic);

    @Query("select m from Message m where m.topic.id = ?1")
    List<Message> getMessageByTopic(Long topicid);


}
