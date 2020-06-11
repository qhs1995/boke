package com.hongshen.boke.response;

import java.io.Serializable;

/**
 * @Description: 结果响应-单个
 * @Package: com.shanghe.shop.common
 * @ClassName: ResultReponse
 * @Author: weige
 * @CreateDate: 2018年07月06 16:11
 * @Version: 1.0
 **/
public class ResultResponse<T> implements Serializable{

    /**返回状态 默认成功**/
    private boolean success = true;
    /**返回响应码，0：成功 默认成功**/
    private int code = 0;
    /**返回状态 默认成功**/
    private String msg = "success";
    /**总记录数**/
    private long count;
    private T data;

    private ResultResponse(){

    }

    public ResultResponse(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultResponse<T> create(){
        return new ResultResponse<T>();
    }
    public static <T> ResultResponse<T> successResponse(String message,T data){
        return new ResultResponse<T>(true,0,message,data);
    }

    public static <T> ResultResponse<T> failResponse(int code,String message,T data){
        return new ResultResponse<T>(false,code,message,data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
