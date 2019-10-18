package com.uws.yl.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin {

    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0L, 1000000000L);
        Future<Long> longFuture = forkJoinPool.submit(countTask);
        System.out.println(longFuture.get());
    }
}


class CountTask extends RecursiveTask<Long>{

    private static final long serialVersionUID = 8613432294235787970L;

    private Long start ;

    private Long end;

    private final static Long threshold=1000L;

    public CountTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum = 0L;
        boolean canCompute = (end - start) <= threshold;
        if(canCompute){
            for(Long i = start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
            Long middle = (start + end)/2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle+1, end);
            leftTask.fork();
            rightTask.fork();
            Long leftResult = leftTask.join();
            Long rightResult = rightTask.join();
            sum  = leftResult+rightResult;
            return sum;
        }
    }
}