package com.morgana.user.api;

import com.morgana.common.domain.user.AuthUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rpc/user")
public class UserApiController {

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
}
