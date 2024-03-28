package com.luowei.pikavai.ai.param.response;

import lombok.Data;

import java.util.List;

@Data
public class ChatCompletionsVO {

    private List<ChoicesPer> choices;

    @Data
    public class ChoicesPer {

        private Message message;

        @Data
        public class Message {

            private String content;

        }
    }

}
