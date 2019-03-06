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

//    Available Accounts
//==================
//
//        (0) TDgCULKmFwhFZ7yGqvwroJnCqxcEbYKZAp (10000 TRX)
//(1) TLCuBz7UndWDHxVzXqp8hKtwnknaprr62X (10000 TRX)
//(2) TJrWj1Yoh4VxEZYMPwsR5sKmeNfrb5DXfz (10000 TRX)
//(3) TTmgdqzcP2ZJsvgzXP8ZspUtnZaayFqxE3 (10000 TRX)
//(4) TDb9pyAz6HVNVvVvMUzmLkvbU6Zxm4GqED (10000 TRX)
//(5) TQLZCYTpUfCS5dRaA66UCikUv2wYUJtZWW (10000 TRX)
//(6) TFcn9ZysmMncoC9e5y9mT2pmDrKvA5BWN1 (10000 TRX)
//(7) THJd6f1kF4t6yGGqDqpNUBwo9yfd4ck1me (10000 TRX)
//(8) TAKUiv3K76rxpgKVsGouTnCZZDN2JGknRU (10000 TRX)
//(9) TViwJrWaPufBo9hycEYCYDfNjAzB83HcCX (10000 TRX)
//
//    Private Keys
//==================
//
//        (0) 4f4bc7fd7896c2fa5da7bf89467378afe43f9a3ce1ecbe229e75b27f9f10a348
//            (1) 5ba2aa3180f6d337dda95c85ecb95d1cd67503eca24a98a5815b6c5e19219c48
//            (2) c3bad22b41ec8cdc048f3adfa8139c283bf138fcf31d467bd9c6eec9c4a1928c
//(3) 5856a5d662c90f47204ac61e0f55af15a13d7874744b0eb52395e2c4feb4294b
//            (4) 5bc0a9b8866a4d73717632a7e0005c18a458a5ba5c0eacd0f44c9488056eb4de
//            (5) d2620ee2cc32a958c2f3dc37fadfbe8d8af5caf01311b146a859fe50c81fa4fe
//(6) 20cd41b253049277ec6a15631d7b27522a625c517f58ea0f3baf57cc5ede9909
//            (7) d58c6378671a2c59a77a928a1e5493ea90a331fe174748edb07034b5e2fe3433
//(8) 30bfd2feefebf750da2f12439e1e4adf65b24458f8f2bd60c1e5a7f113d9a583
//            (9) 37c42a7281985d06d78800e28210c4cb4e9a1afbfa87494fc568138a27d29719

//    (10) {"privateKey":"d95de6cc38cd4a6ad34fa0c880b7fcb800f784a541f735fa7548c8f01cd02d41","address":"TGnwycFfH2BiAbbM7hFaVzT1v9oLJZREph","hexAddress":"414ad82dba5a12a89eb4d39ab0af8b2b3f8881ec37"}


    public static void main(String[] args) throws UnirestException {
//        String base58check = "TGnwycFfH2BiAbbM7hFaVzT1v9oLJZREph";
//        String hexString = WalletApi.base58checkToHexString(base58check);
//        System.out.println("hexString : " + hexString);

        String fromAddress = WalletApi.base58checkToHexString("TGnwycFfH2BiAbbM7hFaVzT1v9oLJZREph");
//        String privateKey = "4f4bc7fd7896c2fa5da7bf89467378afe43f9a3ce1ecbe229e75b27f9f10a348";
//        String toAddress = WalletApi.base58checkToHexString("TGnwycFfH2BiAbbM7hFaVzT1v9oLJZREph");
        String privateKey = "d95de6cc38cd4a6ad34fa0c880b7fcb800f784a541f735fa7548c8f01cd02d41";
        String toAddress = WalletApi.base58checkToHexString("TDgCULKmFwhFZ7yGqvwroJnCqxcEbYKZAp");
        Long amount = 100000L;
        JSONObject param = new JSONObject();
        param.append("amount", amount);
        param.append("privateKey", privateKey);
        param.append("toAddress", toAddress);
        System.out.println("\n-------From地址---------\n\n\nparam = " + SolidityNodeApi.getAccount(new JSONObject().append("address", fromAddress)));
        System.out.println("\n-------To地址---------\n\n\nparam = " + SolidityNodeApi.getAccount(new JSONObject().append("address", toAddress)));
//        System.out.println("\n-------转账---------\n\n\nparam = " + FullNodeApi.easyTransferByPrivate(param));
    }

}
