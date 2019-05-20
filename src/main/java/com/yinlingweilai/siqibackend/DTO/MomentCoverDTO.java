package com.yinlingweilai.siqibackend.DTO;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-05-11 23:09
 **/
@Data
public class MomentCoverDTO {

    /** moment id */
    private Integer id;

    /** 用户名 */
    private String username;

    /** 用户头像 */
    private String faceImage;

    /** 标题 */
    private String title;

    /** 封面 */
    private String coverUrl;
}
