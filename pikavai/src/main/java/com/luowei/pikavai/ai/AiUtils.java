package com.luowei.pikavai.ai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luowei.pikavai.ai.param.request.ChatCompletionsBO;
import com.luowei.pikavai.ai.param.request.ImagesGenerationsBO;
import com.luowei.pikavai.ai.param.response.ChatCompletionsVO;
import com.luowei.pikavai.ai.param.response.ImagesGenerationsVO;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 调用AI接口工具类
 *
 * @author luowei
 * @data 2024-03-01
 */
public class AiUtils {

    private static final String BASE_URL = "https://api.openai.com";

    // 生成文字内容接口地址
    private static final String API_CHAT_COMPLETIONS = "/v1/chat/completions";

    // 生成图片接口地址
    private static final String API_IMAGES_GENERATIONS = "/v1/images/generations";

    // 接口调用密钥
    private static final String API_KEY = "需要到官网申请";

    private static String getChatCompletionsUrl() {
        return BASE_URL + API_CHAT_COMPLETIONS;
    }

    private static String getImagesGenerationsUrl() {
        return BASE_URL + API_IMAGES_GENERATIONS;
    }

    public static ChatCompletionsVO callChatCompletions(String question) {
        // 构建参数
        ChatCompletionsBO chatCompletionsBo = new ChatCompletionsBO(question);
        String jsonBody = JSONObject.toJSONString(chatCompletionsBo);
        String content = callOpenAI(getChatCompletionsUrl(), "application/json", jsonBody);
        // 转换结果
        ChatCompletionsVO chatCompletionsVo = JSON.parseObject(content, ChatCompletionsVO.class);
        return chatCompletionsVo;
    }

    public static ImagesGenerationsVO callImagesGenerations(String prompt) {
        // 构建参数
        ImagesGenerationsBO imagesGenerationsBo = new ImagesGenerationsBO(prompt);
        String jsonBody = JSONObject.toJSONString(imagesGenerationsBo);
        String imgContent = callOpenAI(getImagesGenerationsUrl(), "application/json", jsonBody);
        //解析json字符串
        ImagesGenerationsVO imagesGenerationsVo = JSON.parseObject(imgContent, ImagesGenerationsVO.class);
        return imagesGenerationsVo;
    }

    public static String callOpenAI(String openAiApiUrl, String contentType, String jsonBody) {
        try {
            // 创建请求client和设置超时时间
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody body = RequestBody.create(MediaType.parse(contentType), jsonBody);
            Request request = new Request.Builder()
                    .url(openAiApiUrl)
                    .post(body)
                    .addHeader("Content-Type", contentType)
                    .addHeader("Authorization", "Bearer " + API_KEY)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            // TODO 日志打印 + 抛出AI ERROR
            e.printStackTrace();
        }
        return null;
    }

}
