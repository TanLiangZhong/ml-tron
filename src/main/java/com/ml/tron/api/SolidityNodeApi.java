package com.ml.tron.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

/**
 * solidity 节点接口
 *
 * @author liangzhong
 * @date 2019/3/6 17:34
 */
public class SolidityNodeApi {

    //    private static final String URL_PREFIX = "http://127.0.0.1:8091";

    private static final String URL_PREFIX = "https://api.trongrid.io/walletsolidity";
//    private static final String URL_PREFIX = "http://47.244.157.65:8091/walletsolidity";


    /**
     * 查询某个账号的出账交易记录
     *
     * @param param {"account" : {"address" : "41E552F6487585C2B58BC2C9BB4492BC1F17132CD0"}, "offset": 0, "limit": 10}
     * @return Transaction列表
     * @throws UnirestException
     */
    public static JSONObject getTransactionsFromThis(JSONObject param) throws UnirestException {
        final String url = URL_PREFIX + "/gettransactionsfromthis";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").body(param).asJson();
        return response.getBody().getObject();
    }

    /**
     * 查询某个账号的入账交易记录
     *
     * @param param {"account" : {"address" : "41E552F6487585C2B58BC2C9BB4492BC1F17132CD0"}, "offset": 0, "limit": 10}
     * @return Transaction列表
     * @throws UnirestException
     */
    public static JSONObject getTransactionsToThis(JSONObject param) throws UnirestException {
        final String url = URL_PREFIX + "/gettransactionstothis";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").body(param).asJson();
        return response.getBody().getObject();
    }

    /**
     * 查询一个账号的信息
     *
     * @param param {"address": "41E552F6487585C2B58BC2C9BB4492BC1F17132CD0"}
     * @return Account对象
     * @throws UnirestException
     */
    public static JSONObject getAccount(JSONObject param) throws UnirestException {
        final String url = URL_PREFIX + "/getaccount";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").body(param).asJson();
        return response.getBody().getObject();
    }

}
