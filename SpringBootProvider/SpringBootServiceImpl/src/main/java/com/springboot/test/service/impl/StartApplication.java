package com.springboot.test.service.impl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.springboot.test.dao"})
public class StartApplication {

    public static void main(String[] args){
        SpringApplication.run(StartApplication.class,args);
    }

}
