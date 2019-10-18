package com.uws.yl.juc;


/**
 * “仓库”类的生产方法produce()和消费方法consume()方法都是synchronized方法，进入synchronized方法体，意味着这个线程获取到了该“仓库”对象的同步锁。
 * 这也就是说，同一时间，生产者和消费者线程只能有一个能运行。通过同步锁，实现了对“残酷”的互斥访问
 *
 *
 * 第一条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 * 第二条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块。
 * 第三条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞
 *
 *
 *
 * 在判断的时候  用while是为了避免虚假唤醒的现象
 * wait最好放在while循环中，以避免“虚假唤醒”的情形。即线程由于某些特殊情况，不是被notify或者notifyAll所唤醒，所以还需要再次判断条件是否成立。
 * * 所以wait应该放到while循环中，而不是简单的使用if条件来判断。
 *
 *
 */
public class TestProducerAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Thread(new Producer(clerk),"生产者").start();
        new Thread(new Consumer(clerk),"消费者").start();
    }
}

/**
 * 仓库
 */
class Clerk {

    private int product = 0;

    /**
     * 添加产品  这个地方加的synchronized锁是Clerk对象的锁  在这里也就是说是 Clerk clerk = new Clerk(); clerk的锁
     * 一个对象只有一个锁  当线程执行到这  会拿到clerk的锁  然后下面的consume方法就会被阻塞
     *
     *
     */
    public synchronized void produce() {
        while (product >= 100) {
            try {
                System.out.println("产品已满 ：" + product);
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        notifyAll();
        product++;
        System.out.println( Thread.currentThread().getName()+ " : " + product);

    }

    /**
     * 消费产品
     */
    public synchronized void consume() {
        while (product <= 0) {
            try {
                System.out.println("缺货 ：" + product);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        notifyAll();
        product--;
        System.out.println( Thread.currentThread().getName()+ " : " + product);

    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            clerk.produce();
        }
    }
}


/**
 *消费者
 */
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            clerk.consume();
        }
    }
}