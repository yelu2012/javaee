package com.uws.yl.service.impl;

import org.springframework.scheduling.annotation.Async;

public interface IAsyncTestService {
    @Async
    void testAsync();
}
