package com.yinlingweilai.siqibackend.Service.ServiceImpl;

import com.yinlingweilai.siqibackend.DAO.UserDAO;
import com.yinlingweilai.siqibackend.DO.User;
import com.yinlingweilai.siqibackend.DTO.UserDTO;
import com.yinlingweilai.siqibackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-02 23:15
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public UserDTO updateUserInfo(User user) {
        int id = user.getId();
        String nickname = user.getNickname();

        UserDTO currentUser = userDAO.queryUserByID(id);
        if (currentUser != null) {
            String oldNickname = currentUser.getNickname();
            if (oldNickname == nickname) {
                return currentUser;
            }
            else {
                userDAO.updateUserInfo(id, nickname);
                UserDTO newUser = userDAO.queryUserByID(id);
                return newUser;
            }
        }
        else {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public UserDTO updateUserFace(User user) {
        int id = user.getId();
        String facePath = user.getFaceImage();

        UserDTO currentUser = userDAO.queryUserByID(id);
        if (currentUser != null) {
            userDAO.updateUserFace(id, facePath);
            UserDTO newUser = userDAO.queryUserByID(id);
            return newUser;
        }
        else {
            return null;
        }
    }
}
