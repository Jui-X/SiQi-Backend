package com.yinlingweilai.siqibackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.yinlingweilai.siqibackend.Common.JsonResult;
import com.yinlingweilai.siqibackend.DTO.UserDTO;
import com.yinlingweilai.siqibackend.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param: none
 * @description: 用户Controller
 * @author: KingJ
 * @create: 2019-04-02 23:13
 **/
@RestController
@RequestMapping("/user")
@Api(value = "用户接口", tags = "用户服务用到的Controller")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "编辑用户信息", notes = "编辑用户信息的接口")
    @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "int", paramType = "update")
    @PostMapping("/updateInfo")
    public JsonResult updateUserInfo(@RequestBody JSONObject userInfo) {
        int id = userInfo.getIntValue("id");
        String nickname = userInfo.getString("nickname");

        UserDTO user = userService.updateUserInfo(id, nickname);
        if (user != null) {
            return JsonResult.ok(user);
        }
        else {
            return JsonResult.errorMsg("未找到当前用户！更新失败！");
        }
    }
}
