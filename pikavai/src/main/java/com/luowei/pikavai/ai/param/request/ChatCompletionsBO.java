package com.luowei.pikavai.ai.param.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatCompletionsBO {

    private String model;

    private List<Messages> messages;

    @Data
    public class Messages {

        private String role;

        private String content;


        public Messages(String content) {
            this.role = "user";
            this.content = content;
        }
    }

    public ChatCompletionsBO(String content) {
        this.model = "gpt-3.5-turbo";
        List<Messages> messagesList = new ArrayList<>();
        messagesList.add(new Messages(content));
        this.messages = messagesList;
    }
}
