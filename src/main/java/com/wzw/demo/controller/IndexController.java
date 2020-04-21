package com.wzw.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 17:042020/4/21/021
 * @Modified By:
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return "welcome to robot!"+df.format(new Date());
    }

}
