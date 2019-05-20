package com.yinlingweilai.siqibackend.DTO;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-05-04 21:43
 **/
@Data
public class MomentDTO {

    /** moment id */
    private Integer id;

    /** 用户名 */
    private String username;

    /** 用户头像 */
    private String faceImage;

    /** 标题 */
    private String title;

    /** 内容 */
    private String content;

    /** 封面 */
    private String momentCover;

    /** 图片 */
    private String momentImage;

    /** 视频 */
    private String momentVideo;
}
