package com.luowei.pikavai.service;

import com.luowei.pikavai.ai.AiUtils;
import com.luowei.pikavai.ai.param.response.ChatCompletionsVO;
import com.luowei.pikavai.ai.param.response.ImagesGenerationsVO;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * AI服务接口实现层
 *
 * @author luowei
 * @data 2024-03-01
 */
@Service
public class AIServiceImpl implements AIService {

    @Override
    public String generateAnswer(String question) {
        ChatCompletionsVO chatCompletionsVO = AiUtils.callChatCompletions(question);
        if (Objects.nonNull(chatCompletionsVO) && Objects.nonNull(chatCompletionsVO.getChoices())) {
            return chatCompletionsVO.getChoices().get(0).getMessage().getContent();
        }
        return "我现在脑子有点乱，等会再跟你沟通";
    }

    @Override
    public String generateImg(String description) {
        ImagesGenerationsVO imagesGenerationsVo = AiUtils.callImagesGenerations(description);
        if (Objects.nonNull(imagesGenerationsVo) && Objects.nonNull(imagesGenerationsVo.getData())) {
            return imagesGenerationsVo.getData().get(0).getUrl();
        }
        return "我现在脑子有点乱，等会再给你图片";
    }
}
