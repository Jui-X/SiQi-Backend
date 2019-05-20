package com.yinlingweilai.siqibackend.DAO;

import com.yinlingweilai.siqibackend.DTO.MomentDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MomentDAO {

    /**
     * @return 分享页面封面
     */
    @Select("SELECT * FROM moment")
    List<MomentDTO> listMoments();

    @Insert("INSERT INTO moment(username, face_image, title, content, moment_cover, moment_image) " +
            "VALUES(#{username}, #{face_image}, #{title}, #{content}, #{moment_cover}, #{moment_image})")
    void saveMoment(@Param("username")String username, @Param("face_image")String face_image, @Param("title")String title,
                   @Param("content")String content, @Param("moment_cover")String moment_cover, @Param("moment_image")String moment_image);

    @Select("SELECT id FROM moment WHERE username = #{username}")
    int queryMomentByUserName(@Param("username")String username);
}
