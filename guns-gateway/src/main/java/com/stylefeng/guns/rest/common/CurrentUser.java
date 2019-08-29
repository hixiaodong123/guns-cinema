package com.stylefeng.guns.rest.common;


/**
 * @description: 获取当前user对象
 * @author: Lime
 * @create: 2019-08-29 12:51
 **/

public class CurrentUser
{
    //线程绑定一个存储空间
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    //将用户id放入存储空间
    public static void saveUserId(String userId)
    {
        THREAD_LOCAL.set(userId);
    }

    //取出
    public static String getUserId()
    {
        return THREAD_LOCAL.get();
    }

}
