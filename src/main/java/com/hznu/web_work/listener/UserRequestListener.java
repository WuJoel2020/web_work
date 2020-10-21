package com.hznu.web_work.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class UserRequestListener implements ServletRequestListener
{
    @Override
    public void requestInitialized(ServletRequestEvent sce)
    {
        System.out.println("=====request Initialized=====");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sce)
    {
        System.out.println("=====request Destroyed=====");
    }
}
