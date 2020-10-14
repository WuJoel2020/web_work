package com.hznu.web_work.mapper;

import com.hznu.web_work.domain.Hello;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HelloMapper
{
    private static final Map<Integer, Hello> helloMap = new HashMap<>();

    static
    {
        helloMap.put(1, new Hello(1, "hello", "hello,hello"));
        helloMap.put(2, new Hello(2, "world", ""));
    }

    public List<Hello> listHello()
    {
        return new ArrayList<>(helloMap.values());
    }
}
