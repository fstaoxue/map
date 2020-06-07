package com.taoge.business.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/openlayer")
public class OpenlayerController {

    @GetMapping("/interaction")
    public String interaction(){
        return "openlayer/interaction";
    }

    @GetMapping("/overlay")
    public String overlay(){
        return "openlayer/overlay";
    }

    @GetMapping("/heatmap")
    public String heatmap(){
        return "openlayer/heatmap";
    }
}
