package com.hznu.web_work.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hznu.web_work.domain.User;
import com.hznu.web_work.service.impl.UserServiceImpl;
import com.hznu.web_work.utils.JsonData;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor
{
    private static final ObjectMapper objectMapper = new ObjectMapper();

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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("=====login preHandle=====");

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }

        if(!StringUtils.isEmpty(token)){
            User user = UserServiceImpl.sessionMap.get(token);
            if(user!=null){
                return true;
            }else{
                JsonData jsonData = JsonData.buildError("（拦截器）登录失败，token无效",-2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(response,jsonStr);
                return false;
            }
        }else{
            JsonData jsonData = JsonData.buildError("未登录",-3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(response,jsonStr);
            return false;
        }
    }
}
