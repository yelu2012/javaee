package com.uws.yl.juc.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch  是等所有线程都执行完毕在执行后面的代码  也可以在等待多长时间后执行
 */
@Slf4j
public class TestCountDownLatch1 {
    private final static Integer threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        //
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch downLatch = new CountDownLatch(threadCount);
        for (int i = 0;i<threadCount;i++){
            final int threadNum = i;
            if(i%2==0){
                executor.execute(() -> {
                    try {
                        test1(threadNum);
                    } catch (InterruptedException e) {
                        log.error("InterruptedException",e);
                    }finally {
                        downLatch.countDown();
                    }
                });
            }else {
                executor.execute(() -> {
                    try {
                        test2(threadNum);
                    } catch (InterruptedException e) {
                        log.error("InterruptedException",e);
                    }finally {
                        downLatch.countDown();
                    }
                });
            }

        }
        downLatch.await();
        log.info("finish");
        executor.shutdown();
    }

    private static void test1(int threadNum) throws InterruptedException {
        Thread.sleep(10);
        log.info("10 mis {}",threadNum);
    }
    private static void test2(int threadNum) throws InterruptedException {
        Thread.sleep(20);
        log.info("20 mis {}",threadNum);
    }
}