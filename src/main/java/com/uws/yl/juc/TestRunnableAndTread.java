package com.uws.yl.juc;

/**
 * Thread 是类，而Runnable是接口；Thread本身是实现了Runnable接口的类。我们知道“一个类只能有一个父类，但是却能实现多个接口”，
 * 因此Runnable具有更好的扩展性。
 * 此外，Runnable还可以用于“资源的共享”。即，多个线程都是基于某一个Runnable对象建立的，它们会共享Runnable对象上的资源。
 * 通常，建议通过“Runnable”实现多线程！
 */
public class TestRunnableAndTread {

    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
       /* MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        t1.start();
        t2.start();
        t3.start();*/



        MyRunnable mt=new MyRunnable();
        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        Thread t4=new Thread(mt);
        Thread t5=new Thread(mt);
        Thread t6=new Thread(mt);
        t4.start();
        t5.start();
        t6.start();
    }
}


/**
 *
 */
class MyThread extends Thread{
    private int ticket=10;

    @Override
    public void run() {
        for (int i = 0 ; i < 20;i++){
            if(this.ticket>0){
                System.out.println(this.getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    }
}


class MyRunnable implements Runnable{
    private int ticket=10;
    @Override
    public void run() {
        for (int i = 0 ; i < 20;i++){
            if(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    }
}