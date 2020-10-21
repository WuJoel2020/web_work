package com.hznu.web_work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WebWorkApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(WebWorkApplication.class, args);
    }

}
