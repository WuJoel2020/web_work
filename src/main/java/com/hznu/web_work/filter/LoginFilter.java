package com.hznu.web_work.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hznu.web_work.domain.User;
import com.hznu.web_work.service.impl.UserServiceImpl;
import com.hznu.web_work.utils.JsonData;
import org.thymeleaf.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter
{
    private final ObjectMapper objectMapper = new ObjectMapper();

    private void renderJson(HttpServletResponse response, String json)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter writer = response.getWriter())
        {
            writer.print(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("======init filter======");
    }

    @Override
    public void destroy()
    {
        System.out.println("======destroy filter======");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("=========do filter==========");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String token = req.getHeader("token");
        if (StringUtils.isEmpty(token))
        {
            token = req.getParameter("token");
        }
        if (!StringUtils.isEmpty(token))
        {
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null)
            {
                filterChain.doFilter(servletRequest, servletResponse);  // 可以通过过滤器
            }
            else
            {
                JsonData jsonData = JsonData.buildError("登录失败，token无效", -2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(resp, jsonStr);
            }
        }
        else
        {
            JsonData jsonData = JsonData.buildError("未登陆", -3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(resp, jsonStr);
        }
    }

}
