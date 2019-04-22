package com.yinlingweilai.siqibackend.Service.ServiceImpl;

import com.yinlingweilai.siqibackend.DAO.UserDAO;
import com.yinlingweilai.siqibackend.DTO.UserDTO;
import com.yinlingweilai.siqibackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public UserDTO updateUserInfo(int id, String nickname) {
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
}
