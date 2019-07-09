package com.bookex.eBookExchange.Repository.JpaRepository;

import com.bookex.eBookExchange.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageJpaRepository extends JpaRepository<Message, Long> {

    @Query(value = "select m from Message m order by m.created_at desc")
    List<Message> getSortedMessages();
}
