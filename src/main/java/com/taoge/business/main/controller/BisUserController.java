package com.taoge.business.main.controller;

import com.alibaba.fastjson.JSONObject;
import com.taoge.business.main.entity.BisUser;
import com.taoge.business.main.service.BisUserService;
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
@RequestMapping("/user")
public class BisUserController {

    @Autowired
    private BisUserService bisUserService;

    @GetMapping("/index")
    public String index(){
        return "table";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(int limit,int offset,String account){
        if(StringUtils.isNotEmpty(account)){
            System.out.println("limit-->"+limit+",offset-->"+offset+",account-->"+account);
        }
        Pageable pageable= PageRequest.of(offset+1,limit, Sort.by(Sort.Order.desc("id")));
        Page<BisUser> page=bisUserService.listAllBisUsers(account,pageable);
        JSONObject result=new JSONObject();
        result.put("total",page.getTotalElements());
        result.put("rows",page.getContent());
        return result.toJSONString();
    }
}
