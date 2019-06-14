package com.morgana.open.web;

import com.morgana.common.domain.user.AuthUser;
import com.morgana.common.exception.BaseException;
import com.morgana.common.util.ResponseBo;
import com.morgana.open.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class OpenUserController {

    @Autowired
    private UserClient userClient;

    @PostMapping(value = "/create")
    public ResponseBo<?> create(@RequestBody AuthUser authUser){
        try {
            ResponseBo responseBo = userClient.create(authUser);
            return ResponseBo.ok(responseBo.getData());
        } catch (BaseException e) {
            e.printStackTrace();
            return ResponseBo.ok(false).setMessage(e.getMessage());
        }
    }


}
