package com.ml.tron.demo;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.ml.tron.common.WalletApi;
import com.ml.tron.demo.bo.AddressBo;
import com.ml.tron.demo.bo.TransactionsBo;
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
        String addr_1 = "TCVgk7V8hhfaERXA7Sx6XSTTDJK3VeTfBM";
        System.out.println("addr_1 = " + WalletApi.base58checkToHexString(addr_1));
    }




}
