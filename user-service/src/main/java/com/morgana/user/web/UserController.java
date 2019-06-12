package com.morgana.user.web;


import com.morgana.common.domain.user.AuthUser;
import com.morgana.common.exception.BaseException;
import com.morgana.common.util.ResponseBo;
import com.morgana.user.domain.User;
import com.morgana.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;

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

    @PostMapping(value = "/save")
    public ResponseBo<?> save(@RequestBody AuthUser authUser){
        try {
            User user = userService.create(authUser);
            return ResponseBo.ok(user);

        } catch (BaseException e) {
            e.printStackTrace();
            return ResponseBo.ok(false).setMessage(e.getMessage());
        }
    }

}

