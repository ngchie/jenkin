package com.wng.jenkin.controller;

import com.wng.jenkin.datamodel.Message;
import com.wng.jenkin.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messageapp")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }




    @GetMapping(value = "/topic/{topicid}/message")
    public ResponseEntity<List<Message>> findMessageByTopic(@PathVariable("topicid") Long topicid) {

        return ResponseEntity.ok(this.messageService.getMessagesByTopicId(topicid));
    }
}
