package com.wallet.example.result;

import com.alibaba.fastjson.JSONObject;

@Deprecated
public class ResultBody {

    protected int code;

    protected String info;

    protected Object data;

    public ResultBody() {
    }

    public ResultBody(int code, String info, Object data) {
        this.code = code;
        this.data = data;
        this.info = info;
    }

    public ResultBody(IBaseErrorInfo errorInfo) {
        this.code = errorInfo.getResultCode();
        this.info = errorInfo.getResultMsg();
    }

    public static ResultBody success(Object data) {
        return success((String)null, data);
    }

    public static ResultBody success(String info, Object data) {
        ResultBody rb = new ResultBody(ApiStatusEnum.HTTP_200.getResultCode(), null == info ? ApiStatusEnum.HTTP_200.getResultMsg() : info, data);
        return rb;
    }

    public static ResultBody success() {
        return success((String)null, (Object)null);
    }

    public static ResultBody success(String info) {
        return success(info, (Object)null);
    }

    public static ResultBody fail(String info) {
        ResultBody rb = new ResultBody(ApiStatusEnum.HTTP_500.getResultCode(), null == info ? ApiStatusEnum.HTTP_500.getResultMsg() : info, (Object)null);
        return rb;
    }

    public static ResultBody error(IBaseErrorInfo errorInfo) {
        ResultBody rb = new ResultBody(errorInfo.getResultCode(), errorInfo.getResultMsg(), (Object)null);
        return rb;
    }

    public static ResultBody error(int code, String message) {
        ResultBody rb = new ResultBody(code, message, (Object)null);
        return rb;
    }

    public static ResultBody error(String info) {
        ResultBody rb = new ResultBody(-1, info, (Object)null);
        return rb;
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public int getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public Object getData() {
        return this.data;
    }
}