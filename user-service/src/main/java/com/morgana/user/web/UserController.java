package com.morgana.user.web;


import com.morgana.common.domain.account.AccountDTO;
import com.morgana.common.domain.user.AuthUser;
import com.morgana.common.exception.BaseException;
import com.morgana.common.util.ResponseBo;
import com.morgana.user.amqp.provider.UserSender;
import com.morgana.user.client.AccountClinet;
import com.morgana.user.domain.User;
import com.morgana.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.soap.Addressing;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author gm
 * @since 2019-06-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSender userSender;

    @GetMapping("/loadUserByUsername/{username}")
    public AuthUser loadUserByUsername(@PathVariable(value = "username") String username){
        AuthUser authUser = new AuthUser();
        authUser.setCode("admin");
        authUser.setName("Admin");
        authUser.setId("0");
        authUser.setPwd("$2a$10$P6tWj/K71NNnfFvE8ickr.7Pk/VaUK3ia.ziEIMUScfj3JYmPBDCy");
        List<AuthUser.UserRole> roles = new ArrayList<>();
        authUser.setUserRoles(roles);
        return authUser;
    }

    @PostMapping(value = "/create")
    public ResponseBo<?> create(@RequestBody AuthUser authUser){
        try {
            userService.create(authUser);
            return ResponseBo.ok(true);
        } catch (BaseException e) {
            e.printStackTrace();
            return ResponseBo.ok(false).setMessage(e.getMessage());
        }
    }

    @GetMapping(value = "/queue/send")
    public ResponseBo<?> send(){
        try {
            userSender.transSend();
            return ResponseBo.ok(true);
        } catch (BaseException e) {
            e.printStackTrace();
            return ResponseBo.ok(false).setMessage(e.getMessage());
        }
    }


}

