package com.luowei.pikavai.ai.param.response;

import lombok.Data;

import java.util.List;

@Data
public class ImagesGenerationsVO {

    private List<Data> data;

    @lombok.Data
    public class Data {

        private String url;

    }
}
