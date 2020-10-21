package com.hznu.web_work.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class UserRequestListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        System.out.println("=====request Initialized=====");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        System.out.println("=====request Destroyed=====");
    }
}
