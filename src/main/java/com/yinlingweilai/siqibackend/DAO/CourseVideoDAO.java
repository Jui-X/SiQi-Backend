package com.yinlingweilai.siqibackend.DAO;

import com.yinlingweilai.siqibackend.DO.CourseVideo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseVideoDAO {

    @Select("SELECT id,video_desc,video_seconds,video_height,video_width,cover_path FROM video WHERE status = 1")
    public List<CourseVideo> listCourseVideo();
}
