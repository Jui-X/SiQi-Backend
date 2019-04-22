package com.yinlingweilai.siqibackend.Service;

import com.yinlingweilai.siqibackend.DTO.UserDTO;

public interface UserService {

    UserDTO updateUserInfo(int id, String nickname);
}
