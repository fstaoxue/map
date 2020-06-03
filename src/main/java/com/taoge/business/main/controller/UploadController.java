package com.taoge.business.main.controller;

import com.taoge.business.main.bean.AjaxResult;
import com.taoge.business.parsexls.bean.LocInfo;
import com.taoge.business.parsexls.sheet.ParseSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private ParseSheet parseSheet;

    @GetMapping("/index")
    public String index(){
        return "upload";
    }

    @GetMapping("/index2")
    public String index2(){
        return "upload2";
    }

    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult upload(@RequestParam(name="uploadFile") MultipartFile file, HttpServletRequest request) {
        String fileName=file.getOriginalFilename();
        String contentType=file.getContentType();
        System.out.println(fileName);
        System.out.println(contentType);
        String filePath="D:\\wuditaoge\\"+fileName;
        try{
            File newFile=new File(filePath);
            file.transferTo(newFile);
            List<LocInfo> locs=parseSheet.getListByFile(newFile,LocInfo.class);
            return AjaxResult.success(locs);
        }catch (Exception e){
            e.printStackTrace();
        }


        return AjaxResult.error();
    }
}
