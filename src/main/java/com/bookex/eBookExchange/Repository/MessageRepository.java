package com.bookex.eBookExchange.Repository;

import com.bookex.eBookExchange.Model.Message;

import java.util.List;

public interface MessageRepository {

    List<Message> getAllMessages();

    Message addNewMessage(Message message);

    Message deleteMessageById(Long id);

}
