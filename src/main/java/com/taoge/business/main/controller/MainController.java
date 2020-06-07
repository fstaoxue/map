package com.taoge.business.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author taoxuefeng
 * @date 2019/06/06
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
