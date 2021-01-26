package com.example.demo.controller;
/*
 * @Author: Haoran
 * @Date: 2021/1/26 14:41
 * @Description:
 */

import com.example.demo.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("templates")
public class TemplatesController {

    @Autowired
    private WXConfig wxConfig;


    @GetMapping("freemarker/test")
    public String index(ModelMap modelMap){

        modelMap.addAttribute("settings",wxConfig);

        // 不用加后缀，因为配置文件里面已经指定了后缀
        return "fm/user/index";
    }

    @GetMapping("thymeleaf/test")
    public String index2(ModelMap modelMap){

        modelMap.addAttribute("settings",wxConfig);

        // 不用加后缀，因为配置文件里面已经指定了后缀
        return "tl/index";
    }

}
