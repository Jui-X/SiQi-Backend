package com.yinlingweilai.siqibackend.Service;

import com.yinlingweilai.siqibackend.DO.User;
import com.yinlingweilai.siqibackend.DTO.UserDTO;

public interface UserService {

    UserDTO updateUserInfo(User user);

    UserDTO updateUserFace(User user);
}
