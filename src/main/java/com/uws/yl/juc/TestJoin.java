package com.uws.yl.juc;

/**
 * 当我们调用某个线程的join方法时，这个方法会挂起调用线程，直到被调用线程结束执行，调用线程才会继续执行。
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"run....");
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1");

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"run....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"线程2");
        thread1.start();
        thread1.join();//主程序调用  所以挂起了主线程  直到thread1线程执行完毕   主线程才唤醒
        thread2.start();
        System.out.println("main-----------------");
    }
}