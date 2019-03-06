package com.ml.tron.demo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Map;

/**
 * http 请求工具类
 *
 * @author liangzhong
 * @date 2019/3/6 15:58
 */
public class HttpClientUtils {

    /**
     * 发送 get 请求
     *
     * @param url   请求地址
     * @param param 参数
     * @return 结果集
     * @throws UnirestException
     */
    public static JsonNode sendGet(String url, Map<String, Object> param) throws UnirestException {
        HttpResponse<JsonNode> basicResponse = Unirest.get(url).queryString(param).asJson();
        return basicResponse.getBody();
    }

    /**
     * 发送 post 请求
     *
     * @param url   请求地址
     * @param param 参数
     * @return 结果集
     * @throws UnirestException
     */
    public static JsonNode sendPost(String url, Map<String, Object> param) throws UnirestException {
        HttpResponse<JsonNode> basicResponse = Unirest.post(url).header("Content-Type", "application/json").body(param).asJson();
        return basicResponse.getBody();
    }

}
