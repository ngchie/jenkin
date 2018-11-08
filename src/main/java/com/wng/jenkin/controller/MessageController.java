package com.wng.jenkin.controller;

import com.wng.jenkin.datamodel.Message;
import com.wng.jenkin.datamodel.Topic;
import com.wng.jenkin.ex.ResourceNotFoundException;
import com.wng.jenkin.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/messageapp")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/topic/{topicid}")
    public ResponseEntity<Topic> findTopic(@PathVariable("topicid") Long topicid) {
        return ResponseEntity.ok(this.messageService.getTopic(topicid));
    }


    @GetMapping(value = "/topic/{topicid}/message")
    public ResponseEntity<List<Message>> findMessageByTopic(@PathVariable("topicid") Long topicid) {

        return ResponseEntity.ok(this.messageService.getMessagesByTopicId(topicid));
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public void handleNotFoundException(ResourceNotFoundException ex) {

    }

}
