package com.yinlingweilai.siqibackend.DAO;

import com.yinlingweilai.siqibackend.DTO.MomentDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MomentDAO {

    @Select("SELECT * FROM moment")
    List<MomentDTO> listMoments();

}
