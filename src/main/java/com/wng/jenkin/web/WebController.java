package com.wng.jenkin.web;

import com.wng.jenkin.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    MessageService messageService;

    public WebController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("appName", "message app");
        return "home";
    }
}
