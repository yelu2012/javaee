package com.uws.yl.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * BlockingQueue是一个阻塞式的队列  当放置的元素超过队列容量时将阻塞线程  当队列为空 也会阻塞线程
 */
public class TestProduceAndConsumerForQueue {

    private final static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0 ; i < 200 ; i ++){
                    queue.put(i);
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0 ; i < 200 ; i ++){
                    int e =  queue.take();
                    System.out.println(Thread.currentThread().getName()+":"+e);
                }
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }).start();
    }
}