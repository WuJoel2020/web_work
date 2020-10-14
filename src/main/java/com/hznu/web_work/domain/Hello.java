package com.hznu.web_work.domain;

import java.util.Date;

// domain：数据映射时，用来暂时存储数据
public class Hello
{
    private int id;
    private String title;
    private String summary;
    private Date createTime;

    public Hello(int id, String title, String summary)
    {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.createTime = new Date();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return "Hello{" + "id=" + id + ", title='" + title + '\'' + ", summary='" + summary + '\'' + ", createTime=" + createTime + '}';
    }
}
