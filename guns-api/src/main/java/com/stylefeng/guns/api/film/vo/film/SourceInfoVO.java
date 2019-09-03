package com.stylefeng.guns.api.film.vo.film;

import java.io.Serializable;

/**
 * @description: 封装source
 * @author: Lime
 * @create: 2019-08-30 23:24
 **/

public class SourceInfoVO implements Serializable
{

    private static final long serialVersionUID = -8721427188712163820L;
    private String sourceId;
    private String sourceName;
    private boolean isActive;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getSourceId()
    {
        return sourceId;
    }

    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
    }

    public String getSourceName()
    {
        return sourceName;
    }

    public void setSourceName(String sourceName)
    {
        this.sourceName = sourceName;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }
}
