package com.uws.yl.juc;


/**
 *
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();
        while (true){
            if(threadDemo.isFlag()){
                System.out.println("------------------");
                break;
            }
        }
    }


}


class  ThreadDemo implements Runnable{

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        flag = true;

        System.out.println("flag=" + isFlag());
    }


    public boolean isFlag() {
        return flag;
    }

    public ThreadDemo setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }
}