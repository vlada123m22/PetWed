package com.alibou.websocket.chat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {

//    private MessageType type;
    private String content;
    private String sender;

}
