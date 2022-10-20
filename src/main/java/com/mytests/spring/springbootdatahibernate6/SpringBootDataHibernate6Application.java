package com.mytests.spring.springbootdatahibernate6;

import com.mytests.spring.springbootdatahibernate6.services.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataHibernate6Application implements CommandLineRunner {

    @Autowired
    private DisplayService displayService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataHibernate6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        displayService.displayAll();
    }
}
