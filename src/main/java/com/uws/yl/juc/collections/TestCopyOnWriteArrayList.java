package com.uws.yl.juc.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList是“线程安全”的动态数组，而ArrayList是非线程安全的。
 *
 *    下面是“多个线程同时操作并且遍历list”的示例
 *    (01) 当list是CopyOnWriteArrayList对象时，程序能正常运行。
 *    (02) 当list是ArrayList对象时，程序会产生ConcurrentModificationException异常。
 */
public class TestCopyOnWriteArrayList {

    //private static List<String> list = new ArrayList<>();
    private static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    public static void printAll(){
        String value ;
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            value = (String)iterator.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                String val = Thread.currentThread().getName() + "-" + i;
                list.add(val);
                printAll();
            }
        }
    }
}