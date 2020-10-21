package com.hznu.web_work.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SessionListener implements HttpSessionListener
{
    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        System.out.println("=====session created=====");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        System.out.println("=====session destroyed=====");
    }
}
