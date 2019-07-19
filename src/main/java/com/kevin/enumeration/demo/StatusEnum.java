package com.kevin.enumeration.demo;

/**
 * @author caonanqing
 * @version 1.0
 * @description     状态码枚举类
 *      code-message，如同一个常量map
 *      code对应key
 *      massage对应value
 *      通过code获取到对应的value
 * @createDate 2019/6/15
 */
public enum StatusEnum {

    /**
     *  状态码
     *  200：请求成功
     */
    SUCCESSFUL(200,"请求成功"),
    /**
     * 301：资源被永久转移到其它URL
     */
    TRANSFER(301,"资源被永久转移到其它URL"),
    /**
     * 404：资源不存在
     */
    NOT_FOUND(404,"资源不存在"),
    /**
     *  500：服务器失败
     */
    SERVER_ERROR(500,"服务器失败");

    /**
     * 执行代码
     */
    private int code;
    /**
     * 执行状态
     */
    private String message;

    StatusEnum(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage(){return message;}

    // 根据代码获取状态
    public static String codeMessage(int code){
        for (StatusEnum s : StatusEnum.values()) {
            if(s.getCode() == code)
                return s.getMessage();
        }
        return "";
    }
}
