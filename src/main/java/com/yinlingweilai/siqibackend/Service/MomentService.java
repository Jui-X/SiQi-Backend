package com.yinlingweilai.siqibackend.Service;

import com.yinlingweilai.siqibackend.DO.Moment;
import com.yinlingweilai.siqibackend.DTO.MomentDTO;

import java.util.List;

public interface MomentService {

    List<MomentDTO> listMoments();

    int saveMoment(Moment moment);
}
