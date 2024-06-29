package org.backstage.bvw.utils;

public class Result {
    private String code;  //返回的状态码。告诉前端这次请求成功还是失败
    private String msg;  //错误信息
    private Object data; //数据


    public Result() {
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private static final String SUCCESS_CODE = "200"; //成功
    private static final String ERROR_CODE = "500";

    public static Result success(Object data){
        return new Result(SUCCESS_CODE, "", data) ;
    }
    public static Result success(){
        return new Result(SUCCESS_CODE, "");
    }
    public static Result error(String msg) {
        return new Result(ERROR_CODE,msg);
    }
}
