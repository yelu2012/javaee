package com.uws.yl.juc.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Depot depot = new Depot(lock);
        new Thread(new Producer(depot),"生产者").start();
        new Thread(new Consumer(depot),"消费者").start();

    }
}

/**
 * 仓库
 */
class Depot{
    private int product = 0;
    private Lock lock;
    private Condition fullCondition;
    private Condition emptyCondition;


    public Depot(Lock lock ){
        this.lock = lock;
        fullCondition = this.lock.newCondition();
        emptyCondition = this.lock.newCondition();
    }

    public void produce(){
        lock.lock();
        try {
            while (product>=100){
                System.out.println("产品已满 ：" + product);
                fullCondition.await();
            }
            product++;
            System.out.println( Thread.currentThread().getName()+ " : " + product);
            emptyCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("缺货 ：" + product);
                emptyCondition.await();
            }
            product--;
            System.out.println( Thread.currentThread().getName()+ " : " + product);
            fullCondition.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


/**
 * 生产者
 */
class Producer implements Runnable {
    private Depot depot;

    public Producer(Depot clerk) {
        this.depot = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            depot.produce();
        }
    }
}


/**
 *消费者
 */
class Consumer implements Runnable{
    private Depot depot;

    public Consumer(Depot clerk){
        this.depot = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            depot.consume();
        }
    }
}