package com.morgana.account.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/account")
@RefreshScope
public class AccountController {

    @Value("${token:}")
    private String token;

    @GetMapping(value = "/model")
    public String getModel(@RequestParam("id") String id){
        log.info("model id = " + id);
        return "account : " + id;
    }

    @GetMapping(value = "/token")
    public String token(){
        log.info("token : " + token);
        return "token : " + token;
    }

}
