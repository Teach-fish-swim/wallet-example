
package com.wallet.example.result;

public enum ApiStatusEnum implements IBaseErrorInfo {
    HTTP_200(200, "响应成功!"),
    HTTP_204(204, "响应成功!"),
    HTTP_400(400, "请求的语法错误，服务器无法理解。"),
    HTTP_401(401, "请求要求用户的身份认证。"),
    HTTP_402(402, "保留，将来使用。"),
    HTTP_403(403, "服务器拒绝执行此请求。"),
    HTTP_404(404, "请求的资源无法找到。"),
    HTTP_405(405, "请求中的方法被禁止。"),
    HTTP_406(406, "服务器无法根据请求的内容特性完成请求。"),
    HTTP_407(407, "请求要求代理的身份认证。"),
    HTTP_408(408, "服务器等待客户端发送的请求时间过长，超时。"),
    HTTP_409(409, "服务器处理请求时发生了冲突。"),
    HTTP_410(410, "请求的资源已经不存在。"),
    HTTP_411(411, "服务器无法处理客户端发送的不带Content-Length的请求信息。"),
    HTTP_412(412, "客户端请求信息的先决条件错误。"),
    HTTP_413(413, "由于请求的实体过大，服务器无法处理，因此拒绝请求。"),
    HTTP_414(414, "请求的URI过长。"),
    HTTP_415(415, "服务器无法处理请求发送的数据格式。"),
    HTTP_416(416, "客户端请求的范围无效。"),
    HTTP_417(417, "服务器无法满足Expect的请求头信息。"),
    HTTP_500(500, "服务器内部错误!"),
    HTTP_501(501, "服务器不支持请求的功能，无法完成请求。"),
    HTTP_502(502, "服务器作为网关或者代理工作尝试执行请求，从远程服务器接收到了一个无效的响应。"),
    HTTP_503(503, "由于超载或系统维护，服务器暂时无法处理客户端的请求。"),
    HTTP_504(504, "服务器充当网关或代理，未及时从远端服务器获取请求。"),
    HTTP_505(505, "服务器不支持请求的HTTP协议的版本，无法完成处理。"),
    ERROR(100, "失败。"),
    REQUEST_METHOD_ERROR(101, "请求方法错误。详情：{?}。"),
    REQUEST_PARAM_ERROR(102, "请求参数错误。详情：{?}。");

    private int resultCode;
    private String resultMsg;

    private ApiStatusEnum(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }
}
