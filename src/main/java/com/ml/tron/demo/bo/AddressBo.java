package com.ml.tron.demo.bo;

import lombok.Data;

/**
 * 地址 - Bo
 *
 * @author liangzhong
 * @date 2019/3/6 16:40
 */
@Data
public class AddressBo {

    /**
     * 地址
     */
    private String address;

    public AddressBo() {
    }

    public AddressBo(String address) {
        this.address = address;
    }
}
