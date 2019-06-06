package com.morgana.statistics.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account-service")
@RequestMapping(value = "/account")
public interface AccountClient {

    @GetMapping(value = "/model")
    String getModel(@RequestParam("id") String id);

    @GetMapping(value = "/token")
    public String token();

}
