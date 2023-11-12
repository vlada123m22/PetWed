package com.example.demo.service;

import com.example.demo.dto.MessageDTO;
import com.example.demo.entity.Chat;
import com.example.demo.entity.User;


public interface MessageService {
    void saveMessage(MessageDTO messageRequest, User fromUser, Chat chat);
}
