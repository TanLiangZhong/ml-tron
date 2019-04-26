package com.ml.tron.api;

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

    //    private static final String URL_PREFIX = "http://127.0.0.1:8090/wallet";

    private static final String URL_PREFIX = "http://47.244.157.65:8090/wallet";

    /**
     * 通过私钥转账
     * <p>
     * privateKey：私钥 <p>
     * toAddress：转入账户地址,hexString格式。<p>
     * amount：转账的drop数量。<p>
     * </p>
     *
     * @param param {"privateKey": "", "toAddress":"","amount":10000}'
     * @return Account对象
     * @throws UnirestException
     */
    public static JSONObject easyTransferByPrivate(JSONObject param) throws UnirestException {
        final String url = URL_PREFIX + "/easytransferbyprivate";
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
        final String url = URL_PREFIX + "/generateaddress";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").asJson();
        return response.getBody().getObject();
    }


    /**
     * 作用: 创建一个转账的Transaction , 如果转账的to地址不存在, 则在区块链上创建该账号
     * <p>
     * 参数说明：to_address是转账转入地址,需要转为hexString;owner_address是转账转出地址,需要转为hexString;amount是转账数量
     *
     * @param param {"to_address": "41e9d79cc47518930bc322d9bf7cddd260a0260a8d", "owner_address": "41D1E7A6BC354106CB410E65FF8B181C600FF14292", "amount": 1000 }
     * @return 转账合约
     * @throws UnirestException
     */
    public static JSONObject createTransaction(JSONObject param) throws UnirestException {
        final String url = URL_PREFIX + "/createtransaction";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").body(param).asJson();
        return response.getBody().getObject();
    }

    /**
     * 作用: 对交易签名, 该api有泄漏private key的风险, 请确保在安全的环境中调用该api
     * <p>
     * 参数说明：transaction是通过http api创建的合约,privateKey是用户private key
     *
     * @param param {"transaction" : {"txID":"454f156bf1256587ff6ccdbc56e64ad0c51e4f8efea5490dcbc720ee606bc7b8","raw_data":{"contract":[{"parameter":{"value":{"amount":1000,"owner_address":"41e552f6487585c2b58bc2c9bb4492bc1f17132cd0","to_address":"41d1e7a6bc354106cb410e65ff8b181c600ff14292"},"type_url":"type.googleapis.com/protocol.TransferContract"},"type":"TransferContract"}],"ref_block_bytes":"267e","ref_block_hash":"9a447d222e8de9f2","expiration":1530893064000,"timestamp":1530893006233}}, "privateKey": "your private key"}'
     * @return 签名之后的transaction
     * @throws UnirestException
     */
    public static JSONObject getTransactionSign(JSONObject param) throws UnirestException {
        final String url = URL_PREFIX + "/gettransactionsign";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").body(param).asJson();
        return response.getBody().getObject();
    }

    /**
     * 作用：对签名后的transaction进行广播
     * <p>
     * 参数说明：签名之后的Transaction
     *
     * @param param {"signature":["97c825b41c77de2a8bd65b3df55cd4c0df59c307c0187e42321dcc1cc455ddba583dd9502e17cfec5945b34cad0511985a6165999092a6dec84c2bdd97e649fc01"],"txID":"454f156bf1256587ff6ccdbc56e64ad0c51e4f8efea5490dcbc720ee606bc7b8","raw_data":{"contract":[{"parameter":{"value":{"amount":1000,"owner_address":"41e552f6487585c2b58bc2c9bb4492bc1f17132cd0","to_address":"41d1e7a6bc354106cb410e65ff8b181c600ff14292"},"type_url":"type.googleapis.com/protocol.TransferContract"},"type":"TransferContract"}],"ref_block_bytes":"267e","ref_block_hash":"9a447d222e8de9f2","expiration":1530893064000,"timestamp":1530893006233}}
     * @return 广播是否成功
     * @throws UnirestException
     */
    public static JSONObject broadcastTransaCtion(JSONObject param) throws UnirestException {
        final String url = URL_PREFIX + "/broadcasttransaction";
        HttpResponse<JsonNode> response = Unirest.post(url).header("Content-Type", "application/json").body(param).asJson();
        return response.getBody().getObject();
    }

}
