package com.hznu.web_work.utils;

public class JsonData
{
    private int code;
    private Object data;
    private String msg;

    public JsonData(int code, Object data)
    {
        this.code = code;
        this.data = data;
    }

    public JsonData(int code, Object data, String msg)
    {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    // 将数据通过Json的格式返回
    public static JsonData buildSuccess(Object data)
    {
        return new JsonData(0, data,"这是通过Json返回的数据");
    }

    public static JsonData buildError(String msg)
    {
        return new JsonData(-1, "", msg);
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
