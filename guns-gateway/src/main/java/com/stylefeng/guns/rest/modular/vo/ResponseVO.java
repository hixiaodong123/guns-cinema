package com.stylefeng.guns.rest.modular.vo;

/**
 * @description: 接口服务返回值
 * @author: LiTe
 * @create: 2019-08-29 12:24
 **/

public class ResponseVO<T>
{
    //返回状态
    //0成功
    //1-业务失败
    //999-系统异常失败
    private int status;
    //返回消息
    private String Msg;
    //返回的数据实体
    private T data;

    //私有化,不允许外部实例化
    private ResponseVO()
    {
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMsg()
    {
        return Msg;
    }

    public void setMsg(String msg)
    {
        Msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    //一般成功
    public static <T> ResponseVO success(T t)
    {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(t);
        return responseVO;
    }
    //注册成功
    public static <T> ResponseVO success(String message)
    {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setMsg(message);
        return responseVO;
    }

    //业务异常
    public static <T> ResponseVO serviceFail(String msg)
    {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg(msg);
        return responseVO;
    }

    //系统异常
    public static <T> ResponseVO systemFail(String msg)
    {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(999);
        responseVO.setMsg(msg);
        return responseVO;
    }


}
