package com.taoge.business.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/other")
public class OtherModuleController {

    @GetMapping("/upload")
    public String upload(){
        return "other/upload";
    }

    @GetMapping("/socket")
    public String socket(){
        return "other/socket";
    }

    @GetMapping("/table")
    public String table(){
        return "other/table";
    }
}
