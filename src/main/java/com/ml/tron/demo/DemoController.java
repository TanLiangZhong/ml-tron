package com.ml.tron.demo;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.ml.tron.common.WalletApi;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo - 控制类
 *
 * @author liangzhong
 * @date 2019/3/5 19:24
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    public static void main(String[] args) throws UnirestException {
        final String ownerAddress = "TN3Vtiqdga1xKsV4qAhwbbSetpV9Ybkb8S";
        final String toAddress = "TMZr2xwFtRidpBWx6qk8oavSj7sbFTbeg8";
        final long amount = 1000000L;
        final String ownerAddressHex = WalletApi.base58checkToHexString(ownerAddress);
        final String toAddressHex = WalletApi.base58checkToHexString(toAddress);

//        String param = "{\"to_address\": \"" + toAddressHex + "\", \"owner_address\": \"" + ownerAddressHex + "\", \"amount\": " + amount + " }";
//        JSONObject json = new JSONObject(param);
//
//        JSONObject result = FullNodeApi.createTransaction(json);
//
//        System.out.println("\n--------------------------------------\n");
//        System.out.println("创建一个转账的Transaction");
//        System.out.println("param = " + param);
//        System.out.println("result = " + result);

        String param = "{\"address\": \"" + ownerAddressHex + "\"}";
        JSONObject json = new JSONObject(param);
        System.out.println("json = " + json);
        JSONObject result = SolidityNodeApi.getAccount(json);
        System.out.println("result = " + result);

    }


}
