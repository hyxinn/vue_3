package org.example.springboot.controller;

import org.example.springboot.common.Result;
import org.example.springboot.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class WebController {
    @GetMapping("/hello")
    public Result hello() {
        return Result.success("hello dantaxin!");
    }

    @GetMapping("/weather")
    public Result weather() {
        return Result.success("20251005 Today is cloudy~");
    }

    @GetMapping("/count")
    public Result count() {
        throw new CustomException("400","错误！禁止请求！");
        //return Result.success(10);
    }

    @GetMapping("/world")
    public Result world() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","dantaxin");
        map.put("age",21);
        return Result.success(map);
    }

}
