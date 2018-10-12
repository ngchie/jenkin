package com.wng.jenkin.service;

import com.wng.jenkin.datamodel.Message;
import com.wng.jenkin.datamodel.Topic;
import com.wng.jenkin.ex.ResourceNotFoundException;
import com.wng.jenkin.repository.MessageRepository;
import com.wng.jenkin.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {


    MessageRepository messageRepository;
    TopicRepository topicRepository;

    public MessageService(MessageRepository messageRepository, TopicRepository topicRepository) {
        this.messageRepository = messageRepository;
        this.topicRepository = topicRepository;
    }

    public Topic getTopic(Long id) {
        return this.topicRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found"));
    }

    public List<Message> getMessagesByTopicId(Long topicId) {
        return this.messageRepository.getMessageByTopic(topicId);
        //Topic topic = this.topicRepository.getReference(topicId);
        //return this.messageRepository.findMessageByTopicOrderById(topic);
    }


}
