package com.morgana.auth.client;

import com.morgana.common.domain.user.AuthUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")
@RequestMapping(value = "/user")
public interface UserClient {

    @GetMapping("/user/loadUserByUsername/{username}")
    AuthUser loadUserByUsername(@PathVariable(value = "username") String username);
}
