package com.eja.prestamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EjaPrestamoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjaPrestamoServiceApplication.class, args);
    }

}
