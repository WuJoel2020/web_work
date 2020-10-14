package com.hznu.web_work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thl")
public class TemplateController
{
    @GetMapping("list")
    public String index(ModelMap modelMap)
    {
        modelMap.addAttribute("hello", "world");  // 在html中通过hello获取world
        return "index";
    }
}
