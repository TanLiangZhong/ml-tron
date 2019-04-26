package com.ml.tron.common;

import com.google.protobuf.ByteString;

import java.io.UnsupportedEncodingException;

/**
 * @author liangzhong
 * @date 2019/3/21 17:16
 */
public class Base64Utils {

    public static void main(String[] args) throws UnsupportedEncodingException {
        final String toAddress = "TMZr2xwFtRidpBWx6qk8oavSj7sbFTbeg8";
        final String toAddressHex = WalletApi.base58checkToHexString(toAddress);
        System.out.println("toAddressHex = " + toAddressHex);


        final String error = "6e6f20636f6e6e656374696f6e";
        ByteString byteString = ByteString.copyFrom(ByteArray.fromHexString(error));
        System.out.println("toS = " + ByteArray.bytesToString(byteString, "UTF-8"));
    }

}
