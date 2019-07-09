package com.bookex.eBookExchange.Service.Impl;

import com.bookex.eBookExchange.Model.Message;
import com.bookex.eBookExchange.Repository.Impl.MessageRepositoryImpl;
import com.bookex.eBookExchange.Service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepositoryImpl repository;

    public MessageServiceImpl(MessageRepositoryImpl repository) { this.repository = repository; }

    @Override
    public List<Message> getAllMessages() {
        return repository.getAllMessages();
    }

    @Override
    public Message addNewMessage(Message message) {
        return repository.addNewMessage(message);
    }

    @Override
    public Message deleteMessageById(Long id) {
        return repository.deleteMessageById(id);
    }
}
