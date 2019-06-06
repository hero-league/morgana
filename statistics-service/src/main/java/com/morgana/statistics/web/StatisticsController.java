package com.morgana.statistics.web;

import com.morgana.statistics.client.AccountClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/statistics")
public class StatisticsController {

    @Autowired
    private AccountClient accountClient;

    @GetMapping(value = "/account")
    public String getModel(@RequestParam("id") String id){
        log.info("account id = " + id);
        return accountClient.getModel(id);
    }

    @GetMapping(value = "/token")
    public String token(){
        return accountClient.token();
    }


}
