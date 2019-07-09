package com.bookex.eBookExchange.Api;


import com.bookex.eBookExchange.Model.Message;
import com.bookex.eBookExchange.Service.Impl.MessageServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/message")
public class MessageApiController {

    private MessageServiceImpl messageService;

    public MessageApiController(MessageServiceImpl messageService) { this.messageService = messageService; }

    @GetMapping
    public List<Message> getAllMessages(){ return messageService.getAllMessages(); }

    @PostMapping
    public Message addNewMessage(@Valid @RequestBody Message message){ return messageService.addNewMessage(message); }

    @DeleteMapping("/{id}")
    public Message deleteMessageById(@PathVariable("id") Long id){ return messageService.deleteMessageById(id); }
}
