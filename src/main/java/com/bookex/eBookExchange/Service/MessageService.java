package com.bookex.eBookExchange.Service;

import com.bookex.eBookExchange.Model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();

    Message addNewMessage(Message message);

    Message deleteMessageById(Long id);
}
