package com.luowei.pikavai.ai.param.request;

import lombok.Data;

@Data
public class ImagesGenerationsBO {

    private String prompt;

    private Integer n;

    private String size;

    public ImagesGenerationsBO(String prompt) {
        this.prompt = prompt;
        this.n = 1;
        this.size = "1024x1024";
    }
}
