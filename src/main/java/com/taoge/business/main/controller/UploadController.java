package com.taoge.business.main.controller;

import com.taoge.business.main.bean.AjaxResult;
import com.taoge.business.parsexls.bean.LocInfo;
import com.taoge.business.parsexls.sheet.ParseSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private ParseSheet parseSheet;

    @GetMapping("/index")
    public String index() {
        return "upload";
    }

    @GetMapping("/index2")
    public String index2() {
        return "upload2";
    }

    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult upload(@RequestParam(name = "uploadFile") MultipartFile file, HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        System.out.println(fileName);
        System.out.println(contentType);
        try {
            List<LocInfo> locs = parseSheet.getListByStream(file.getInputStream(), fileName, LocInfo.class);
            return AjaxResult.success(locs);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return AjaxResult.error();
    }

    @GetMapping("/downloadTemplate")
    public void downloadTemplat(HttpServletResponse response) {

        InputStream fis = UploadController.class.getClassLoader().getResourceAsStream("template/phone.xlsx");
        try {
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fis);
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=template.xlsx");
            xssfWorkbook.write(response.getOutputStream());
            xssfWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
