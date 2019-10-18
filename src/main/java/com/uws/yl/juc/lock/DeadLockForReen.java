package com.uws.yl.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockForReen implements Runnable{
    private int flag = 0;
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        DeadLockForReen td1 = new DeadLockForReen();
        DeadLockForReen td2 = new DeadLockForReen();
        td1.flag = 1;
        td2.flag = 0;
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        //td2的run()可能在td1的run()之前运行
        new Thread(td1).start();
        new Thread(td2).start();
    }

    @Override
    public void run() {
        if(flag==0){
            lock1.lock();
            try{
                Thread.sleep(500);
                System.out.println("1");
                lock2.lock();
                lock2.unlock();
            }catch (Exception e){

            }finally {
                lock1.unlock();
            }
        }
        if(flag==1){
            lock2.lock();
            try{
                Thread.sleep(500);
                System.out.println("2");
                lock1.lock();
                lock1.unlock();
            }catch (Exception e){

            }finally {
                lock2.unlock();
            }
        }
    }
}