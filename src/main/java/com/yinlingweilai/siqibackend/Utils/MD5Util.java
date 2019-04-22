package com.yinlingweilai.siqibackend.Utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-05 11:21
 **/
public class MD5Util implements TokenGenerator {

    public static String getMD5Str(String strValue) throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newStr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
        return newStr;
    }

    @Override
    public String tokenGenerate(String... strings) {
        long timestamp = System.currentTimeMillis();
        StringBuffer tokenMeta = new StringBuffer();
        for(String s: strings) {
            tokenMeta.append(s);
        }
        tokenMeta.append(timestamp);
        String token = DigestUtils.md5DigestAsHex(tokenMeta.toString().getBytes());
        return token;
    }
}
