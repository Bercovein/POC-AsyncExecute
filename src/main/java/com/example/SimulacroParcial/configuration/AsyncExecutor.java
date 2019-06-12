package com.example.SimulacroParcial.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncExecutor {

    @Bean("executor")
    public Executor getAsyncExecutor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(1); //arranca con 1 hilo
        executor.setMaxPoolSize(50); // cantidad de hilos
        executor.setQueueCapacity(100);// capacidad de la cola de metodos

        executor.initialize();

        return executor;

    }
}
