package com.example.demo.service;

import com.example.demo.dto.MessageDTO;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;


public interface MessageService {
    Message saveMessage(MessageDTO messageRequest, User fromUser, User toUser);
}
