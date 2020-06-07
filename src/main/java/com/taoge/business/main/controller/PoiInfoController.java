package com.taoge.business.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.taoge.business.main.entity.PoiInfo;
import com.taoge.business.main.service.PoiInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/poiinfo")
public class PoiInfoController {

    @Autowired
    private PoiInfoService poiInfoService;

    @GetMapping("/queryPoiInfo")
    @ResponseBody
    public String test(int page,int pageSize,String account){
        Pageable pageable= PageRequest.of(page,pageSize, Sort.by(Sort.Order.desc("id")));
        Page<PoiInfo> page2= poiInfoService.queryPoiInfo(pageable);
        JSONObject result=new JSONObject();
        result.put("total",page2.getTotalElements());
        result.put("rows",page2.getContent());
        return result.toJSONString();
    }
}
