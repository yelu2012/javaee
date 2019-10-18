package com.uws.yl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class AsyncTestService implements IAsyncTestService{
    private static final Logger logger = LoggerFactory.getLogger(AsyncTestService.class);

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Async
    @Override
    public void testAsync(){
        try {

            logger.info(taskExecutor.toString());
            Thread.sleep(5000);
            logger.info(Thread.currentThread().getName()+"---------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}