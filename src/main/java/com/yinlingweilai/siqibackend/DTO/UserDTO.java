package com.yinlingweilai.siqibackend.DTO;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-22 22:40
 **/
@Data
public class UserDTO {

    /** 用户名 */
    private String name;

    /** 用户头像 */
    private String faceImage;

    /** 用户昵称 */
    private String nickname;
}
