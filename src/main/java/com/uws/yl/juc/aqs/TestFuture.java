package com.uws.yl.juc.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable 接口类似于 Runnable，两者都是为那些其实例可能被另一个线程执行的类设计的。但是 Runnable 不会返回结果，并且无法抛出经过检查的异常。
 *
 * Future 表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并获取计算的结果。计算完成后只能使用 get 方法来获取结果，如有必要，
 * 计算完成前可以阻塞此方法。取消则由 cancel 方法来执行。还提供了其他方法，以确定任务是正常完成还是被取消了。一旦计算完成，就不能再取消计算。
 * 如果为了可取消性而使用 Future 但又不提供可用的结果，则可以声明 Future<?> 形式类型、并返回 null 作为底层任务的结果。
 *
 *
 */
@Slf4j
public class TestFuture {


    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();

        //线程池  submit提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
        Future<String> future = executorService.submit(() -> {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "done";
        });

        log.info("do something main");
        Thread.sleep(1000);
        String result = future.get();
        log.info("{}",result);
        executorService.shutdown();

    }
}