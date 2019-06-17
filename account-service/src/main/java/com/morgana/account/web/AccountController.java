package com.morgana.account.web;

import com.morgana.account.service.AccountService;
import com.morgana.common.domain.account.AccountDTO;
import com.morgana.common.util.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/create")
    public ResponseBo<Boolean> create(@RequestBody AccountDTO accountDTO, HttpServletRequest request){
        log.info("TraceId={}, SpanId={}",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        try {
            accountService.create(accountDTO);
            return ResponseBo.ok(true);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseBo.getInstance(false).setCode(500);
        }
    }

}
