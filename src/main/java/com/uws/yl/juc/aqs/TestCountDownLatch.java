package com.uws.yl.juc.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch  是等所有线程都执行完毕在执行后面的代码  也可以在等待多长时间后执行
 */
@Slf4j
public class TestCountDownLatch {


    private final static Integer threadCount = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0;i<threadCount;i++){
            final int threadNum = i;
            executor.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        // 指定时间  在100毫秒以后执行下面的代码  如果不指定  则是等所有线程执行完毕在执行下面代码
        countDownLatch.await(100, TimeUnit.MILLISECONDS);
        log.info("所有线程执行完毕后执行");
        executor.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        Thread.sleep(10);
        log.info("threadNum {}" ,threadNum);
    }
}