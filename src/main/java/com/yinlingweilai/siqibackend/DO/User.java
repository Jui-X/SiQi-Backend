package com.yinlingweilai.siqibackend.DO;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @param: none
 * @description: 用户表
 * @author: KingJ
 * @create: 2019-04-02 23:13
 **/
@Data
@ApiModel(value = "用户对象", description = "这是用户对象")
public class User {

    /** uid */
    @ApiModelProperty(hidden = true)
    @Id
    private Integer id;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", name = "username", example = "juix", required = true)
    private String name;

    /** 用户密码 */
    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;

    /** 用户头像 */
    @ApiModelProperty(hidden = true)
    @Column(name = "face_image")
    private String faceImage;

    /** 用户昵称 */
    @ApiModelProperty(hidden = true)
    @Column(name = "nickname")
    private String nickname;

    /** 粉丝数 */
    @ApiModelProperty(hidden = true)
    @Column(name = "fans_count")
    private int fansCount;

    /** 关注数 */
    @ApiModelProperty(hidden = true)
    @Column(name = "follow_count")
    private int followCount;

    /** 收到的赞 */
    @ApiModelProperty(hidden = true)
    @Column(name = "receive_like_counts")
    private int receiveLikeCounts;
}
