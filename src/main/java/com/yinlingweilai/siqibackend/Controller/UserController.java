package com.yinlingweilai.siqibackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.yinlingweilai.siqibackend.DO.User;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import com.yinlingweilai.siqibackend.Common.JsonResult;
import com.yinlingweilai.siqibackend.DTO.UserDTO;
import com.yinlingweilai.siqibackend.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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

        User user = new User();
        user.setId(id);
        user.setNickname(nickname);

        UserDTO newUser = userService.updateUserInfo(user);
        if (newUser != null) {
            return JsonResult.ok(newUser);
        } else {
            return JsonResult.errorMsg("未找到当前用户！更新失败！");
        }
    }

    @ApiOperation(value = "用户上传头像", notes = "用户上传头像的接口")
    @ApiImplicitParam(name = "userID", value = "用户ID", required = true, dataType = "String", paramType = "query")
    @PostMapping("/uploadFace")
    public JsonResult uploadFace(String userID, @RequestParam("file") MultipartFile[] files) throws Exception{
        if (StringUtils.isBlank(userID)) {
            return JsonResult.errorMsg("用户ID不能为空！");
        }

//        // 文件保存的命名空间
//        String fileSpace = "C:/Users/50131/Documents/GitHub/SiQi-Backend/src/main/resources/face";
//        // 保存到数据库中的相对路径
//        String DBPath = "/" + userID;
//
//        FileOutputStream fileOutputStream = null;
//        InputStream inputStream = null;
//
//        if (files != null && files.length > 0) {
//            String fileName = files[0].getOriginalFilename();
//
//            if (StringUtils.isNotBlank(fileName)) {
//                // 文件保存路径
//                String filePath = fileSpace + DBPath + "/" + fileName;
//                DBPath += "/" + fileName;
//
//                File outputFile = new File(filePath);
//
//                if (outputFile.getParentFile() != null && !outputFile.getParentFile().isDirectory()) {
//                    // 创建父文件夹
//                    outputFile.getParentFile().mkdirs();
//                }
//
//                try {
//                    fileOutputStream = new FileOutputStream(outputFile);
//                    inputStream = files[0].getInputStream();
//                    IOUtils.copy(inputStream, fileOutputStream);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return JsonResult.errorMsg("上传出现错误...");
//                }
//                finally {
//                    if (fileOutputStream != null) {
//                        fileOutputStream.flush();
//                        fileOutputStream.close();
//                    }
//                }
//            }
//        }

//        User user = new User();
//        user.setId(Integer.parseInt(userID));
//        user.setFaceImage(DBPath);
//        userService.updateUserFace(user);


        return JsonResult.ok();
    }
}
