package com.uws.yl.controller;

import com.uws.yl.model.Users;
import com.uws.yl.service.impl.IAsyncTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class MyController {
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private IAsyncTestService asyncTestService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/log")
    @ResponseBody
    public String log(){
        logger.info("成功了====================");
        return "success";
    }

    @GetMapping("/initTestHttpMessageConverter")
    public String initTestHttpMessageConverter(){
        return "testHttpMessageConverter";
    }

    @PostMapping("/doTestHttpMessageConverter")
    @ResponseBody
    public String doTestHttpMessageConverter(Users user){
        logger.info(user+"====================");

        return "index";
    }


    @RequestMapping("/testFormat")
    @ResponseBody
    public String testFormat(@DateTimeFormat(pattern = "yyyy-MM-dd")Date date){
        System.out.println(date);
        return "success";
    }

    @RequestMapping("/uploadFilePath")
    @ResponseBody
    public Object uploadFilePath(@RequestParam("file") MultipartFile file){
        try{
            if(!file.isEmpty()){
                String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                String fileName = System.currentTimeMillis()+type;
                File filePath = new File("D:/image/",fileName);
                if(!filePath.getParentFile().exists()){
                    filePath.getParentFile().mkdirs();
                }

                OutputStream os = new FileOutputStream("D:/image/"+ File.separator+fileName);
                InputStream in = file.getInputStream();
                byte[] b = new byte[1024];
                int length = 0;
                while ((length = in.read(b))>0){
                    os.write(b,0,length);
                }
                os.flush();
                os.close();
                in.close();

                //file.transferTo(new File("D:/image/" + File.separator + fileName));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        Map<String,String> result = new HashMap<String, String>();
        result.put("state", "1");
        return result;
    }

    @RequestMapping("/testAsync")
    @ResponseBody
    public Object testAsync(){
        logger.info("Controller===================before");
        asyncTestService.testAsync();
        logger.info("Controller===================after");
        return "success";
    }
}
