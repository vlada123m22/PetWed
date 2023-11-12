package com.example.demo.service.implementation;

import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ChatService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public ChatServiceImpl(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }
//    @Override
//    public void addMessage(Chat chat, User fromUser, Message message) {
//        message.setChat(chat);
//        message.setFromUser(fromUser);
//    }

    @Override
    public List<Message> getChatMessages(User participant2) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User participant1=userRepository.getByEmail(authentication.getName());
        return chatRepository.getChatMessages(participant1, participant2);
    }

    @Override
    public Message getLastMessage() {
        return null;
    }

    @Override
    public Chat createChat(User participant1, User participant2) {
        Chat chat=new Chat(participant1,participant2);
        return chatRepository.save(chat);
    }
}
