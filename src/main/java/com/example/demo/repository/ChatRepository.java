package com.example.demo.repository;

import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  ChatRepository extends CrudRepository<Chat,Integer> {
@Query("SELECT ch FROM Chat ch WHERE ch.participant1=: user OR ch.participant2=: user")
List<Chat> getChatsByUser(User user);

@Query("SELECT m FROM Message m WHERE m.chat.participant1=: participant1 AND m.chat.participant2=: participant2 ORDER BY m.whenSent")
List<Message> getChatMessages(User participant1, User participant2);

@Query("SELECT m FROM Message m WHERE m.chat=: chat ORDER BY m.whenSent DESC LIMIT 1")
Message getLastMessage(Chat chat);

}
