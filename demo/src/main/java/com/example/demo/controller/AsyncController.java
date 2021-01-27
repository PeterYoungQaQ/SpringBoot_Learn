package com.example.demo.controller;
/*
* @Author: Haoran
* @Date: 2021/1/27 22:03
* @Description:
*/

import com.example.demo.task.AsyncTask;
import com.example.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1/pub/async")
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("test")
    public JsonData testAsync() throws InterruptedException, ExecutionException {

        long beginTaskTime = System.currentTimeMillis();
//        asyncTask.task1();
//        asyncTask.task2();
//        asyncTask.task3();

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();

        for (;;){
            if (task4.isDone() && task5.isDone()){
                String task4Result = task4.get();
                String task5Result = task5.get();
                System.out.println(task4Result);
                System.out.println(task5Result);
                break;
            }
        }

        long endTaskTime = System.currentTimeMillis();

        return JsonData.buildSuccess(endTaskTime - beginTaskTime);
    }
}
