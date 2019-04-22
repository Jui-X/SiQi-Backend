package com.yinlingweilai.siqibackend.DO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @param: none
 * @description: 课程视频表
 * @author: KingJ
 * @create: 2019-04-02 23:31
 **/
@Data
@ApiModel(value = "课程视频", description = "这是课程视频")
public class CourseVideo {

    /**  */
    @ApiModelProperty(value = "视频id", name = "video_id", example = "123", required = true)
    @Id
    private int id;

    /**  */
    @ApiModelProperty(value = "用户id", name = "user_id", example = "juix", required = true)
    @Column(name = "user_id")
    private int userId;

    /**  */
    @ApiModelProperty(value = "音频id", name = "video_id", example = "111", required = true)
    @Column(name = "audio_id")
    private int audioId;

    /**  */
    @ApiModelProperty(value = "视频描述", name = "video_desc", required = true)
    @Column(name = "video_desc")
    private String videoDesc;

    /**  */
    @ApiModelProperty(value = "视频路径", name = "video_path", required = true)
    @Column(name = "video_path")
    private String videoPath;

    /**  */
    @ApiModelProperty(value = "视频喵叔", name = "video_seconds", required = true)
    @Column(name = "video_seconds")
    private float videoSeconds;

    /**  */
    @ApiModelProperty(value = "视频高度", name = "video_height", required = true)
    @Column(name = "video_height")
    private int videoHeight;

    /**  */
    @ApiModelProperty(value = "视频宽度", name = "video_path", required = true)
    @Column(name = "video_path")
    private int videoWidth;

    /**  */
    @ApiModelProperty(value = "封面图路径", name = "cover_path", example = "", required = true)
    @Column(name = "cover_path")
    private String coverPath;

    /**  */
    @ApiModelProperty(value = "获赞数", name = "like_counts", required = true)
    @Column(name = "like_counts")
    private int likeCounts;

    /**  */
    @ApiModelProperty(value = "视频状态", name = "status", required = true)
    @Column(name = "status")
    private int status;

    /**  */
    @ApiModelProperty(value = "创建时间", name = "create_time", required = true)
    @Column(name = "create_time")
    private Timestamp createTime;
}
