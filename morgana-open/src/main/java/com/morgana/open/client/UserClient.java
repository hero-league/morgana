package com.morgana.open.client;

import com.morgana.common.domain.user.AuthUser;
import com.morgana.common.util.ResponseBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")
@RequestMapping(value = "/user")
public interface UserClient {

    @PostMapping(value = "/save")
    ResponseBo<?> save(@RequestBody AuthUser authUser);

}
