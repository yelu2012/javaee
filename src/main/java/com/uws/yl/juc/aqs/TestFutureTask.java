package com.uws.yl.juc.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * FutureTask  同时实现了Runnable, Future<V>, RunnableFuture<V> 接口
 */
@Slf4j
public class TestFutureTask {

    public static void main(String[] args) throws Exception {

        

        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask<>(()-> {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "done";
        });

        executorService.execute(futureTask);

        log.info("do something main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("{}",result);
        executorService.shutdown();
    }
}