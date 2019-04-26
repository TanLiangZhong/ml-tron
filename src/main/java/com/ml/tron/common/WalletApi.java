package com.ml.tron.common;

import org.apache.commons.lang.ArrayUtils;
import org.spongycastle.util.encoders.Hex;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class WalletApi {

    static String base58checkToHexString(String base58check) {
        return Hex.toHexString(Objects.requireNonNull(WalletApi.decodeFromBase58Check(base58check)));
    }

    private static byte[] decodeFromBase58Check(String addressBase58) {
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

    private static boolean addressValid(byte[] address) {
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
