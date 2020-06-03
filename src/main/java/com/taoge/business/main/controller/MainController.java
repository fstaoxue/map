package com.taoge.business.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 1001234
 * @date 2019/06/06
 */
@Controller
@RequestMapping("/main")
public class MainController {



    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "hello,world";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/map")
    public String map(){
        return "map";
    }

    @GetMapping("/map2")
    public String map2(){
        return "map2";
    }

    @GetMapping("/map3")
    public String map3(){
        return "map3";
    }

    @GetMapping("/map4")
    public String map4(){
        return "map4";
    }


}
