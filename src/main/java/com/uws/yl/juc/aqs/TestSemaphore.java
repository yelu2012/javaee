package com.uws.yl.juc.aqs;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * semaphore 线程信号量  可以保证同一时刻同时放多少个线程访问某一个资源
 */
@Slf4j
public class TestSemaphore {
    private final static Integer threadCount = 20;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        //允许最多多少个线程并发
        final Semaphore semaphore = new Semaphore(10);
        for(int i = 0; i < threadCount;i++){
            final int threadNum = i;
            executor.execute(() -> {
                semaphore2(semaphore,threadNum);
            });
        }
        executor.shutdown();
    }


    private static void test(int threadNum) throws Exception{
        log.info("{}" ,threadNum);
        Thread.sleep(1000);
    }


    /**
     *   得到一个  释放一个许可   允许10个线程访问某一个资源
     * @param semaphore
     * @param threadNum
     */
    public static void  semaphore1(Semaphore semaphore,int threadNum){
        try {
            //得到一个许可
            semaphore.acquire();
            test(threadNum);
            //释放一个许可
            semaphore.release();
        } catch (Exception e) {
            log.error("Exception", e);
        }

    }

    /**
     * 得到多个  释放多个许可   允许3个线程访问某一个资源
     * @param semaphore
     * @param threadNum
     */
    public static void semaphore2(Semaphore semaphore,int threadNum){
        try {
            //得到多个许可
            semaphore.acquire(5);
            test(threadNum);
            //释放多个许可
            semaphore.release(5);
        } catch (Exception e) {
            log.error("Exception", e);
        }
    }

    /**
     *   仅在调用时此信号量存在一个可用许可，才从信号量获取许可。
     * 获取一个许可（如果提供了一个）并立即返回，其值为 true，将可用的许可数减 1。
     *
     * 如果没有可用的许可，则此方法立即返回并且值为 false。
     *
     * 即使已将此信号量设置为使用公平排序策略，但是调用 tryAcquire() 也将 立即获取许可（如果有一个可用），而不管当前是否有正在等待的线程。在某些情况下，此“闯入”行为可能很有用，即使它会打破公平性也如此。如果希望遵守公平设置，则使用 tryAcquire(0, TimeUnit.SECONDS) ，它几乎是等效的（它也检测中断）。
     *
     *
     * 返回：
     * 如果获取了许可，则返回 true；否则返回 false。
     * @param semaphore
     * @param threadNum
     */
    public static void semaphore3(Semaphore semaphore,int threadNum){
        try {
            // 尝试获取一个许可
            if(semaphore.tryAcquire()){
                test(threadNum);
                semaphore.release();
            }else{
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            log.error("Exception", e);
        }
    }

    /**
     *  如果在给定的等待时间内，此信号量有可用的许可并且当前线程未被中断，则从此信号量获取一个许可。
     * @param semaphore
     * @param threadNum
     */
    public static void semaphore4(Semaphore semaphore,int threadNum){
        try {
            // 尝试获取一个许可
            if(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){
                test(threadNum);
                semaphore.release();
            }else{
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            log.error("Exception", e);
        }
    }

}