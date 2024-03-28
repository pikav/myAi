package com.luowei.pikavai.controller;

import com.luowei.pikavai.service.AIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * AI服务控制层
 *
 * @author luowei
 * @data 2024-03-01
 */
@RestController
@RequestMapping("/ai")
public class AIController {
    @Resource
    private AIService aiService;

    /**
     * 返回用户聊天内容
     *
     * @param question 聊天内容
     * @return String 聊天回复
     * @author luowei
     * @data 2024-03-01
     */
    @GetMapping("/answer")
    public String generateAnswer(String question) {
        return aiService.generateAnswer(question);
    }

    /**
     * 根据用户描述生成图片
     *
     * @param description 图片描述
     * @return String 图片地址
     * @author luowei
     * @data 2024-03-01
     */
    @GetMapping("/image")
    public String generateImg(String description) {
        return aiService.generateImg(description);
    }
}
