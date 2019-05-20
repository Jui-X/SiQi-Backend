package com.yinlingweilai.siqibackend.Service.ServiceImpl;

import com.yinlingweilai.siqibackend.DAO.MomentDAO;
import com.yinlingweilai.siqibackend.DO.Moment;
import com.yinlingweilai.siqibackend.DTO.MomentDTO;
import com.yinlingweilai.siqibackend.Service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-05-04 21:52
 **/
@Service
public class MomentServiceImpl implements MomentService {

    @Autowired
    private MomentDAO momentDAO;

    @Override
    public List<MomentDTO> listMoments() {
        return momentDAO.listMoments();
    }

    @Override
    public int saveMoment(Moment moment) {
        String username = moment.getUsername();
        String face_image = moment.getFaceImage();
        String title = moment.getTitle();
        String content = moment.getContent();
        String moment_cover = moment.getMomentCover();
        String moment_image = moment.getMomentImage();

        momentDAO.saveMoment(username, face_image, title, content, moment_cover, moment_image);

        // TODO 根据用户名和时间戳去查
        int momentId = momentDAO.queryMomentByUserName(username);

        return momentId;
    }
}
