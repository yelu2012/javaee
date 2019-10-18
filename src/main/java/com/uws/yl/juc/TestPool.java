package com.uws.yl.juc;

import java.util.concurrent.*;

/**
 * 测试线程池
 */
public class TestPool {
    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,4,4L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(4));
        for (int i = 1;i <5 ;i++){
            executor.execute(new TestThread1(i+""));
        }

        executor.shutdown();
    }

}

class TestThread1 implements Runnable{
    private String name;

    public TestThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread thread = new Thread(() ->  System.out.println(Thread.currentThread().getName()) ,name);
        thread.start();
    }
}
