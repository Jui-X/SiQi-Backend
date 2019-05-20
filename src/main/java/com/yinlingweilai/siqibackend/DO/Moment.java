package com.yinlingweilai.siqibackend.DO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-05-04 21:36
 **/
@Data
@ApiModel(value = "社区分享", description = "这是用户的社区分享")
public class Moment {

    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "face_image")
    private String faceImage;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "moment_cover")
    private String momentCover;

    @Column(name = "moment_image")
    private String momentImage;

    @Column(name = "moment_video")
    private String momentVideo;
}
