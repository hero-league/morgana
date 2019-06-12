package com.morgana.account.web;

import com.morgana.account.service.AccountService;
import com.morgana.common.domain.account.AccountDTO;
import com.morgana.common.util.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/account")
@RefreshScope
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/save")
    public ResponseBo save(@RequestBody AccountDTO accountDTO){
        try {
            accountService.create(accountDTO);
            return ResponseBo.ok(true);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseBo.getInstance(false).setCode(500);
        }
    }

}
