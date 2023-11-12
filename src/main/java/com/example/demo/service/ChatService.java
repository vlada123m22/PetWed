package com.example.demo.service;

import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;

import java.util.List;

public interface ChatService {

//    void addMessage(Chat chat, User fromUser, Message message);

    List<Message> getChatMessages(User participant2);
    Message getLastMessage();
    Chat createChat(User participant1, User participant2);

}
