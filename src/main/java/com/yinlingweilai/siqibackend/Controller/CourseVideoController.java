package com.yinlingweilai.siqibackend.Controller;

import com.yinlingweilai.siqibackend.Common.JsonResult;
import com.yinlingweilai.siqibackend.DO.CourseVideo;
import com.yinlingweilai.siqibackend.Service.CourseVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-10 10:11
 **/
@RestController
@Api(value="课程视频相关业务的接口", tags= {"课程视频相关业务的controller"})
@RequestMapping("/courseVideo")
public class CourseVideoController {

    @Autowired
    private CourseVideoService courseVideoService;

    @ApiOperation(value="查询所有课程视频", notes="查询所有课程视频的接口")
    @PostMapping("/list")
    public JsonResult listCourseVideo() {
        List<CourseVideo> courseVideoList = courseVideoService.listCourseVideo();

        if (courseVideoList != null) {
            return JsonResult.ok(courseVideoList);
        }
        else {
            return JsonResult.errorMsg("未找到视频~");
        }
    }
}
