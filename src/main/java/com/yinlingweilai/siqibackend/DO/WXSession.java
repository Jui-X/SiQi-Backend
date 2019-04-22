package com.yinlingweilai.siqibackend.DO;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-05 11:13
 **/
@Data
public class WXSession {

    private String openid;

    private String session_key;
}
