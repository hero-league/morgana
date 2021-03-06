package com.morgana.account;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.morgana.common","com.morgana.account"})
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableDistributedTransaction
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}