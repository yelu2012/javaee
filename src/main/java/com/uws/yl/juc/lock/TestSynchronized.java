package com.uws.yl.juc.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *  synchronized 锁 JVM层面的锁 JVM会自动释放锁
 *  synchronized 修饰static代码块或者方法  针对这个类的所有对象有效。
 *  synchronized 修饰非静态方法  作用域只是针对这个对象
 *
 *
 */
@Slf4j
public class TestSynchronized {

     // 线程总数

    private static final Integer ThreadCount = 5000;


    // 同时允许的最大并发线程数

    private static final Integer threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch downLatch = new CountDownLatch(ThreadCount);
        final Semaphore semaphore = new Semaphore(threadTotal);
        for(int i = 0; i< ThreadCount ; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.info("InterruptedException",e);
                }
                downLatch.countDown();
            });
        }
        downLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);

    }

    private synchronized static void add(){
        count++;
    }




}