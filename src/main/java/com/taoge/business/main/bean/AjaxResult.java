package com.taoge.business.main.bean;

import java.util.HashMap;

public class AjaxResult extends HashMap<String,Object> {

    public static AjaxResult success(Object data){
        AjaxResult result=new AjaxResult();
        result.put("code","200");
        result.put("data",data);
        result.put("msg","success");
        return result;
    }

    public static AjaxResult error(){
        AjaxResult result=new AjaxResult();
        result.put("code","500");
        result.put("msg","error");
        return result;
    }
    public  AjaxResult(){}

}
