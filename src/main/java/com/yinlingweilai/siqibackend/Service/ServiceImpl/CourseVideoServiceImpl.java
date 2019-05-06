package com.yinlingweilai.siqibackend.Service.ServiceImpl;

import com.yinlingweilai.siqibackend.DAO.CourseVideoDAO;
import com.yinlingweilai.siqibackend.DO.CourseVideo;
import com.yinlingweilai.siqibackend.Service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-10 10:13
 **/
@Service
public class CourseVideoServiceImpl implements CourseVideoService {

    @Autowired
    private CourseVideoDAO courseVideoDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<CourseVideo> listCourseVideo() {
        return courseVideoDAO.listCourseVideo();
    }
}
