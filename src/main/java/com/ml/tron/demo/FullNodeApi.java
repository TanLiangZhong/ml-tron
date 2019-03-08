package com.ml.tron.demo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

/**
 * full 节点接口
 *
 * @author liangzhong
 * @date 2019/3/6 17:34
 */
public class FullNodeApi {

    private static final String URL_PREFIX = "http://127.0.0.1:8090";

    /**
     * 通过私钥转账
     * <p>
     * privateKey：私钥 <p>
     * toAddress：转入账户地址，hexString格式。<p>
     * amount：转账的drop数量。<p>
     * </p>
     *
     * @param param {"privateKey": "", "toAddress":"","amount":10000}'
     * @return Account对象
     * @throws UnirestException
     */
    public static JSONObject easyTransferByPrivate(JSONObject param) throws UnirestException {
        final String url = URL_PREFIX + "/wallet/easytransferbyprivate";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").body(param).asJson();
        return response.getBody().getObject();
    }

    /**
     * 生成私钥和地址
     *
     * @return 地址和私钥
     * @throws UnirestException
     */
    public static JSONObject generateAddress() throws UnirestException {
        final String url = URL_PREFIX + "/wallet/generateaddress";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").asJson();
        return response.getBody().getObject();
    }
}
