package com.yinlingweilai.siqibackend.Common;

import lombok.Data;

/**
 * @param: none
 * @description:
 * @author: KingJ
 * @create: 2019-04-05 11:16
 **/
@Data
public class JsonResult {

    /** 定义相应返回状态码 */
    private Integer status;

    /** 定义相应返回信息 */
    private String msg;

    /** 定义相应返回数据 */
    private Object data;

    public JsonResult() {}

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.status = 200;
        this.msg = "ok";
        this.data = data;
    }

    public static JsonResult build(Integer status, String msg, Object data) {
        return new JsonResult(status, msg, data);
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }

    public static JsonResult errorMsg(String msg) {
        return new JsonResult(500, msg, null);
    }

    public static JsonResult errorMsg(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult tokenErrorMsg(String msg) {
        return new JsonResult(502, msg, null);
    }

    public static JsonResult exceptionErrorMsg(String msg) {
        return new JsonResult(555, msg, null);
    }
}
