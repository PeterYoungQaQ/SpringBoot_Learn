package com.example.demo.controller;
/*
 * @Author: Haoran
 * @Date: 2021/1/25 0:53
 * @Description:
 */

import com.example.demo.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @RequestMapping("save")
    public JsonData setOrder(){
        return JsonData.buildSuccess("下单成功");
    }
}
