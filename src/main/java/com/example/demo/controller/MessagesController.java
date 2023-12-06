package com.example.demo.controller;
import com.example.demo.entity.Message;
import com.example.demo.entity.Pet;
import com.example.demo.entity.User;
import com.example.demo.entity.Chat;
import com.example.demo.service.ChatService;
import com.example.demo.service.PetService;
import com.example.demo.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MessagesController {
    private final UserService userService;
    private final ChatService chatService;
    private final PetService petService;

    public MessagesController(UserService userService, ChatService chatService, PetService petService) {
        this.userService = userService;
        this.chatService = chatService;
        this.petService = petService;
    }

    @Secured("REGISTERED")
    @GetMapping("/chats")
    public String getChats(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user=userService.getUserByEmail(authentication.getName());
        List<Pet> personalPets=petService.getPetsByUserId(user.getId());
        List<Chat>  chats = chatService.getUserChats(user.getId());
        for (Chat chat:
             chats) {
            chatService.setLastMessage(chat);
        }
        //TODO chats to be added to the UI
        model.addAttribute("personalPets", personalPets);
        model.addAttribute("chats", chats);
        model.addAttribute("pageTitle", "Chats");
        model.addAttribute("pageContent", "chats");
        return "layout";
    }

    @Secured("REGISTERED")
    @GetMapping("/messages/{participantId2}")
    public String getMessages(Model model, @PathVariable Long participantId2){
        User participant2=userService.getUserById(participantId2);
        List<Message> chatMessages = chatService.getChatMessages(participant2);
        model.addAttribute("pageTitle", "Chats");
        model.addAttribute("pageContent", "messages");
        //TODO messages to be added to the UI
        //model.addAttribute("messages", chatMessages);
        //TODO add the chat to the UI

        return "layout";
    }




}
