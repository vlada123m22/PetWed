package com.example.demo.service.implementation;

import com.example.demo.dto.MessageDTO;
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
    public Message saveMessage(MessageDTO messageDTO, User fromUser, User toUser) {
        Message message=new Message();
        message.setMessage(messageDTO.getMessageText());
        message.setFromUser(fromUser);
        message.setToUser(toUser);


        return messageRepository.save(message);
    }
}
