package com.yinlingweilai.siqibackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.yinlingweilai.siqibackend.Common.JsonResult;
import com.yinlingweilai.siqibackend.Common.WXLogin;
import com.yinlingweilai.siqibackend.Constant.RedisConstant;
import com.yinlingweilai.siqibackend.DO.WXSession;
import com.yinlingweilai.siqibackend.Utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-05 11:13
 **/
@RestController
@RequestMapping("/wxLogin")
public class WXLoginController {

    @Autowired
    private RedisUtil redis;

    @PostMapping("/wxLogin")
    public JsonResult wxLogin(@RequestBody(required = true)JSONObject codeJson) {
        String code = codeJson.getString("code");

        WXLogin wxLogin = new WXLogin();

        WXSession session = wxLogin.WXLogin(code);
        System.out.println(session);


        redis.set("user-redis-session" + session.getOpenid(),
                session.getSession_key(),
                RedisConstant.EXPIRE_TIME);

        Map<String, String> result = new ConcurrentHashMap<>();
        result.put("code", code);

        return JsonResult.ok(result);
    }
}
