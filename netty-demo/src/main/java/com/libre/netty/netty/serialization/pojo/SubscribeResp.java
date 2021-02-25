package com.libre.netty.netty.serialization.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhao.cheng
 * @date 2021/2/25 9:47
 */
@Data
public class SubscribeResp implements Serializable {

    private int subReqID;

    private int respCode;

    private String desc;
}
