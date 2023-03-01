package com.tianqe.v2raycontroller.msg.resultMsg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 前端结果消息返回封装类
 * </p>
 * 
 * 
 * @author 凌心
 * @since 20221-11-8
 * @version 1.1
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor // 生成无参构造函数
@AllArgsConstructor // 生成全参构造函数
@JsonInclude(Include.NON_EMPTY)
public class resultMsg {
    private Boolean status;
    private int code;
    private String Msg;
    private Object data;

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String ERROR = "error";

    private static final int SUCCESS_CODE = 200;
    private static final int FAIL_CODE = 400;
    private static final int ERROR_CODE = 500;

    public static resultMsg ok(){
        return ok(SUCCESS);
    }

    public static resultMsg ok(int code){
        return ok(code, SUCCESS);
    }

    public static resultMsg ok(String msg){
        return ok(msg, null);
    }

    public static resultMsg ok(Object data){
        return ok(SUCCESS, data);
    }

    public static resultMsg ok(int code, String msg){
        return ok(code, msg, null);
    }

    public static resultMsg ok(int code, Object data){
        return ok(code, SUCCESS, data);
    }

    public static resultMsg ok(String msg, Object data){
        return ok(SUCCESS_CODE, msg, data);
    }

    public static resultMsg ok(int code, String msg, Object data){
        return new resultMsg(true, code, msg, data);
    }

    public static resultMsg fail(){
        return fail(FAIL_CODE);
    }
    public static resultMsg fail(String msg){
        return fail(msg, null);
    }

    public static resultMsg fail(Object data){
        return fail(FAIL, data);
    }

    public static resultMsg fail(String msg, Object data){
        return new resultMsg(false, FAIL_CODE, msg, data);
    }

    public static resultMsg error(){
        return error(ERROR);
    }

    public static resultMsg error(String msg){
        return new resultMsg(false, ERROR_CODE, msg, null);
    }

    
}
