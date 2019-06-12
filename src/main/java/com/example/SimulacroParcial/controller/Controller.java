package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.services.Serv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@RestController
@RequestMapping("")
public class Controller {

    @Autowired
    Serv suma;

    @GetMapping("/suma")
    public ResponseEntity<Integer>getSuma() {

        Integer sum = 0;

        try {
            CompletableFuture valor1 = suma.metodo1();
            CompletableFuture valor2 = suma.metodo2();

            sum = (int)valor1.join() + (int)valor2.join();

        }catch (CompletionException e){ //lo dispara el join
            e.printStackTrace();
        }
        return ResponseEntity.status(200).body(sum);
    }
}
