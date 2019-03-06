package com.ml.tron.common;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

public class WalletApi {

//    private static byte addressPreFixByte = Parameter.CommonConstant.ADD_PRE_FIX_BYTE_TESTNET;

    public static String base58checkToHexString(String base58check) {
        return ByteArray.toHexString(WalletApi.decodeFromBase58Check(base58check));
    }

    public static byte[] decodeFromBase58Check(String addressBase58) {
        if (StringUtils.isEmpty(addressBase58)) {
            return null;
        }
        byte[] address = decode58Check(addressBase58);
        if (!addressValid(address)) {
            return null;
        }
        return address;
    }

    private static byte[] decode58Check(String input) {
        byte[] decodeCheck = Base58.decode(input);
        if (decodeCheck.length <= 4) {
            return null;
        }
        byte[] decodeData = new byte[decodeCheck.length - 4];
        System.arraycopy(decodeCheck, 0, decodeData, 0, decodeData.length);
        byte[] hash0 = Sha256Hash.hash(decodeData);
        byte[] hash1 = Sha256Hash.hash(hash0);
        if (hash1[0] == decodeCheck[decodeData.length] &&
                hash1[1] == decodeCheck[decodeData.length + 1] &&
                hash1[2] == decodeCheck[decodeData.length + 2] &&
                hash1[3] == decodeCheck[decodeData.length + 3]) {
            return decodeData;
        }
        return null;
    }

    public static boolean addressValid(byte[] address) {
        if (ArrayUtils.isEmpty(address)) {
            return false;
        }
        if (address.length != Parameter.CommonConstant.ADDRESS_SIZE) {
            return false;
        }
//        byte preFixbyte = address[0];
//        if (preFixbyte != WalletApi.getAddressPreFixByte()) {
//            return false;
//        }
        return true;
    }


//    public static byte getAddressPreFixByte() {
//        return addressPreFixByte;
//    }
}
