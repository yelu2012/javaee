package com.uws.yl.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor {

    public static void main(String[] args) {
        ExecutorService executorService =  Executors.newCachedThreadPool() ;

        for (int i = 0 ; i < 10 ;i ++){
            int finalI = i;
            executorService.submit(() -> {

                    System.out.println(finalI+"====================");

            });
        }
        executorService.shutdown();
    }
}
