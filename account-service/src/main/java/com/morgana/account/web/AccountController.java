package com.morgana.account.web;

import com.morgana.account.service.AccountService;
import com.morgana.common.domain.account.AccountDTO;
import com.morgana.common.util.ResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/create")
    public ResponseBo<Boolean> create(@RequestBody AccountDTO accountDTO){
        try {
            accountService.create(accountDTO);
            int a = 1/0;
            return ResponseBo.ok(true);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseBo.getInstance(false).setCode(500);
        }
    }

}
