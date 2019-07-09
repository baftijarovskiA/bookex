package com.bookex.eBookExchange.Repository.Impl;

import com.bookex.eBookExchange.Model.Message;
import com.bookex.eBookExchange.Repository.JpaRepository.MessageJpaRepository;
import com.bookex.eBookExchange.Repository.MessageRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private MessageJpaRepository repository;

    public MessageRepositoryImpl(MessageJpaRepository repository) { this.repository = repository; }

    @Override
    public List<Message> getAllMessages() {
        return repository.getSortedMessages();
    }

    @Override
    public Message addNewMessage(Message message) {

        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localTime = LocalDateTime.now();
        String localTimeString = FOMATTER.format(localTime);

        message.setCreated_at(localTimeString);

        repository.save(message);
        return message;
    }

    @Override
    public Message deleteMessageById(Long id) {
        Message message = repository.findById(id).get();
        repository.delete(message);
        return message;
    }
}
