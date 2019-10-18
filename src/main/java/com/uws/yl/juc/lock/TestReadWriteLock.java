package com.uws.yl.juc.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
 *
 * 　如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁。
 */
public class TestReadWriteLock {

    private ReadWriteLock lock =  new ReentrantReadWriteLock();

    public static void main(String[] args) {
        TestReadWriteLock testReadWriteLock = new TestReadWriteLock();
        new Thread(() -> testReadWriteLock.get(),"线程1").start();
        new Thread(() -> testReadWriteLock.insert(),"线程3").start();
        new Thread(() -> testReadWriteLock.get(),"线程2").start();
        new Thread(() -> testReadWriteLock.get(),"线程4").start();
        new Thread(() -> testReadWriteLock.get(),"线程5").start();
        new Thread(() -> testReadWriteLock.get(),"线程6").start();

    }

    public void get(){
        lock.readLock().lock();
        try {
            Long start  = System.currentTimeMillis();
            while (System.currentTimeMillis()-start <= 1){
                System.out.println(Thread.currentThread().getName()+"正在进行读操作");
            }
            System.out.println(Thread.currentThread().getName()+"读操作完毕");
        }catch (Exception e){

        }finally {
            lock.readLock().unlock();
        }
    }

    public void insert(){
        lock.writeLock().lock();
        try{
            Long start  = System.currentTimeMillis();
            while (System.currentTimeMillis()-start <= 1){
                System.out.println(Thread.currentThread().getName()+"正在进行写入操作");
            }
            System.out.println(Thread.currentThread().getName()+"写入操作完毕");

        }finally {
            lock.writeLock().unlock();
        }
    }
}