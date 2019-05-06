package com.yinlingweilai.siqibackend.DAO;

import com.yinlingweilai.siqibackend.DTO.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDAO {

    @Select("SELECT nickname FROM user WHERE id = #{id}")
    UserDTO queryUserByID(@Param("id") int id);

    @Update("UPDATE user SET nickname = #{nickname} WHERE id = #{id}")
    void updateUserInfo(@Param("id") int id, @Param("nickName") String nickname);

    @Update("UPDATE user SET face_image = #{facePath} WHERE id = #{id}")
    void updateUserFace(@Param("id") int id, @Param("facePath") String facePath);
}
