package com.libre.netty.netty.serialization.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhao.cheng
 * @date 2021/2/25 9:24
 */
@Data

public class SubscribeReq implements Serializable {

    private Integer SubReqID;

    private String username;

    private String productName;

    private String phoneNumber;

    private String address;

}
