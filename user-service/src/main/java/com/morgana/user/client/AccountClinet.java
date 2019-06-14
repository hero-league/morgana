package com.morgana.user.client;

import com.morgana.common.domain.account.AccountDTO;
import com.morgana.common.util.ResponseBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
@RequestMapping(value = "/account")
public interface AccountClinet {

    @PostMapping(value = "/create")
    ResponseBo create(@RequestBody AccountDTO accountDTO);

}
