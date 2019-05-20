package com.yinlingweilai.siqibackend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.yinlingweilai.siqibackend.Common.JsonResult;
import com.yinlingweilai.siqibackend.DO.Moment;
import com.yinlingweilai.siqibackend.DTO.MomentCoverDTO;
import com.yinlingweilai.siqibackend.DTO.MomentDTO;
import com.yinlingweilai.siqibackend.Service.MomentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-05-04 21:52
 **/
@RestController
@RequestMapping("/moment")
public class MomentController {

    @Autowired
    private MomentService momentService;

    @ApiOperation(value = "分享封面", notes = "获取所有分享内容的封面")
    @GetMapping("/momentCover")
    public List<MomentCoverDTO> listMomentCover() {
        List<MomentCoverDTO> momentCoverList = new ArrayList<>();

        List<MomentDTO> momentList = momentService.listMoments();

        for (MomentDTO moment : momentList) {
            MomentCoverDTO momentCover = new MomentCoverDTO();

            momentCover.setId(moment.getId());
            momentCover.setUsername(moment.getUsername());
            momentCover.setFaceImage(moment.getFaceImage());
            momentCover.setTitle(moment.getTitle());
            momentCover.setCoverUrl(moment.getMomentCover());

            momentCoverList.add(momentCover);
        }

        return momentCoverList;
    }

    @ApiOperation(value = "上传分享", notes = "用户上传分享内容的接口")
    @ApiImplicitParam()
    @PostMapping(value = "/post", headers = "content-type=multipart/form-data")
    public JsonResult postMoment(String nickName, String faceUrl, String title, String content,
                                 @ApiParam(value = "分享图片", required = true) MultipartFile[] imgFile) throws Exception {
        // 文件保存的命名空间
        String imgFileSpace = "C:/Users/50131/Documents/GitHub/SiQi-Backend/src/main/resources/imgs";
        String imgDBPath = "/" + content;

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        String imgFilePath = null;

        if (imgFile != null && imgFile.length > 0) {
            String fileName = imgFile[0].getOriginalFilename();

            if (StringUtils.isNotBlank(fileName)) {
                // 文件保存路径
                imgDBPath += "/" + fileName;
                imgFilePath = imgFileSpace + imgDBPath;


                File outputFile = new File(imgFilePath);

                if (outputFile.getParentFile() != null && !outputFile.getParentFile().isDirectory()) {
                    // 创建父文件夹
                    outputFile.getParentFile().mkdirs();
                }

                try {
                    fileOutputStream = new FileOutputStream(outputFile);
                    inputStream = imgFile[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                    return JsonResult.errorMsg("上传出现错误...");
                }
                finally {
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                }
            }
        }

        Moment moment = new Moment();
        moment.setUsername(nickName);
        moment.setFaceImage(faceUrl);
        moment.setTitle(title);
        moment.setContent(content);
        moment.setMomentCover(imgFilePath);
        moment.setMomentImage(imgFilePath);

        int momentId = momentService.saveMoment(moment);

        MomentCoverDTO momentCover = new MomentCoverDTO();
        momentCover.setId(momentId);
        momentCover.setUsername(nickName);
        momentCover.setFaceImage(faceUrl);
        momentCover.setTitle(title);
        momentCover.setCoverUrl(imgFilePath);

        return JsonResult.ok(momentCover);
    }
}
