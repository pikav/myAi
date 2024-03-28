package com.luowei.pikavai.service;

/**
 * AI服务接口层
 *
 * @author luowei
 * @data 2024-03-01
 */
public interface AIService {

    /**
     * 根据提问生成文字内容
     *
     * @param question 聊天内容
     * @return String 聊天回复
     * @author luowei
     * @data 2024-03-01
     */
    String generateAnswer(String question);

    /**
     * 根据用户描述生成图片
     *
     * @param description 图片描述
     * @return String 图片地址
     * @author luowei
     * @data 2024-03-01
     */
    String generateImg(String description);
}
