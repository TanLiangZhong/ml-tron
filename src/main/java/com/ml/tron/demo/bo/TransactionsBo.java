package com.ml.tron.demo.bo;

import lombok.Data;

/**
 * 交易 - Bo
 *
 * @author liangzhong
 * @date 2019/3/6 16:38
 */
@Data
public class TransactionsBo<T> {

    /**
     * 账号
     */
    private T account;
    /**
     * 起始
     */
    private Long offset;
    /**
     * 限量
     */
    private Long limit;

    public TransactionsBo() {
    }

    public TransactionsBo(T account) {
        this.account = account;
        this.offset = 0L;
        this.limit = 10L;
    }
}
