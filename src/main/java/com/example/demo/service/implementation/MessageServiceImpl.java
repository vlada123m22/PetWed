package com.example.demo.service.implementation;

import com.example.demo.dto.MessageDTO;
import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.repository.MessageRepository;
import com.example.demo.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void saveMessage(MessageDTO messageDTO, User fromUser, Chat chat) {
        Message message=new Message();
        message.setMessage(messageDTO.getMessageText());
        message.setFromUser(fromUser);
        message.setChat(chat);
        messageRepository.save(message);
    }
}
