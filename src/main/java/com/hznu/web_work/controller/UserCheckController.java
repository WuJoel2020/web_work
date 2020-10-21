package com.hznu.web_work.controller;

import com.hznu.web_work.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserCheckController
{
    @RequestMapping("check")
    public JsonData checkUser()
    {
        return JsonData.buildSuccess("检查通过");
    }
}
