package com.example.product.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * User: wangjinshuai
 * Time: 2022-05-01 5:53 PM
 * Email: jinshuaiwang@126.com
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor productThreadPoolExecutor() {
        return new ThreadPoolExecutor(8, 8, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10000),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
