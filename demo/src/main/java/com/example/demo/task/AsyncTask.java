package com.example.demo.task;
/*
 * @Author: Haoran
 * @Date: 2021/1/27 21:54
 * @Description:
 */

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AsyncTask {


    public void task1() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println(" task 1 ");
    }

    public void task2() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println(" task 2 ");
    }

    public void task3() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println(" task 3 ");
    }

    public Future<String> task4() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println(" task 4 ");

        return new AsyncResult<String>("任务4");
    }

    public Future<String> task5() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println(" task 5 ");
        return new AsyncResult<String>("任务5");
    }
}
