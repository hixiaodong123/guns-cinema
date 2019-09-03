package com.stylefeng.guns.rest.modular.vo;

import com.stylefeng.guns.api.cinema.vo.CinemaVO;

import java.util.List;

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

    //影片模块用
    private String imgPre;
    private int nowPage;
    private int totalPage;

    public static<M> ResponseVO success(int nowPage,int totalPage,String imgPre,M m){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(m);
        responseVO.setImgPre(imgPre);
        responseVO.setTotalPage(totalPage);
        responseVO.setNowPage(nowPage);

        return responseVO;
    }

    public int getNowPage()
    {
        return nowPage;
    }

    public void setNowPage(int nowPage)
    {
        this.nowPage = nowPage;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public String getImgPre()
    {
        return imgPre;
    }

    public void setImgPre(String imgPre)
    {
        this.imgPre = imgPre;
    }

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

    //影片首页成功
    public static <T> ResponseVO success(String imgPre, T t)
    {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setImgPre(imgPre);
        responseVO.setData(t);
        return responseVO;
    }

    //影片条件查询成功
    public static <T> ResponseVO success(String imgPre, T t, int nowPage, int totalPage)
    {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setImgPre(imgPre);
        responseVO.setData(t);
        responseVO.setNowPage(nowPage);
        responseVO.setTotalPage(totalPage);
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
