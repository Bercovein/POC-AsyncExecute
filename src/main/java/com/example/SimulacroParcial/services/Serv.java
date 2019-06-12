package com.example.SimulacroParcial.services;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Serv {

    @Async("executor")// le indica que bean utilizar
    public CompletableFuture<Integer> metodo1(){
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(10);
    }


    @Async("executor")
    public CompletableFuture<Integer> metodo2(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(5);
    }

}
