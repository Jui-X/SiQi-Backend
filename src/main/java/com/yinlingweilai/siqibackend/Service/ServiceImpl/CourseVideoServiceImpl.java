package com.yinlingweilai.siqibackend.Service.ServiceImpl;

import com.yinlingweilai.siqibackend.DAO.CourseVideoDAO;
import com.yinlingweilai.siqibackend.DO.CourseVideo;
import com.yinlingweilai.siqibackend.Service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-10 10:13
 **/
public class CourseVideoServiceImpl implements CourseVideoService {

    @Autowired
    private CourseVideoDAO courseVideoDAO;

    @Override
    public List<CourseVideo> listCourseVideo() {
        return courseVideoDAO.listCourseVideo();
    }
}
