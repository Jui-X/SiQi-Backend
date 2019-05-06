package com.yinlingweilai.siqibackend.Service.ServiceImpl;

import com.yinlingweilai.siqibackend.DAO.MomentDAO;
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
}
