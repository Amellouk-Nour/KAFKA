package org.integration_services.controller;

import org.integration_services.Service.MessageService;
import org.integration_services.entity.Entity1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public String sendMessage(@RequestParam Entity1 entity1) {
        messageService.sendEntityA(entity1);
        return "Message sent successfully";
    }
}